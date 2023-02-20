package main.numbers;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ForthEvaluator {
    private static final String REDEFINITION_PATTERN = ": (.+) ;";

    private final Map<String, Consumer<Deque<Integer>>> operations = Map.of(
            "+", this::add,
            "-", this::subtract,
            "*", this::multiply,
            "/", this::divide,
            "dup", this::duplicate,
            "drop", this::drop,
            "swap", this::swap,
            "over", this::over);

    public List<Integer> evaluateProgram(final List<String> input) {
        final Deque<Integer> eval = Stream.of(this.parseInput(input).split(" "))
                .collect(ArrayDeque::new,
                        (deque, item) -> this.operations.getOrDefault(item, a -> a.add(this.toInteger(item))).accept(deque),
                        ArrayDeque::addAll);
        return new ArrayList<>(eval);
    }

    private int toInteger(final String item) {
        try {
            return Integer.parseInt(item);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("No definition available for operator \"%s\"", item));
        }
    }

    private String parseInput(final List<String> input) {
        final Map<String, String> redefinitions = input.stream()
                .filter(param -> param.matches(REDEFINITION_PATTERN))
                .map(param -> param.toLowerCase().replaceAll(REDEFINITION_PATTERN, "$1").split(" ", 2))
                .collect(HashMap::new,
                        (map, r) -> map.merge(r[0], map.getOrDefault(r[1], this.applyRedefinitions(r[1], map)), (r1, r2) -> r2),
                        HashMap::putAll);
        if (this.containNumbers(redefinitions)) {
            throw new IllegalArgumentException("Cannot redefine numbers");
        }
        return this.applyRedefinitions(input.get(input.size() - 1).toLowerCase(), redefinitions);
    }

    private String applyRedefinitions(final String input, final Map<String, String> redefinitions) {
        return redefinitions.entrySet().stream()
                .reduce(input, (a, b) -> a.replace(b.getKey(), b.getValue()), String::concat);
    }

    private boolean containNumbers(final Map<String, String> redefinitions) {
        return redefinitions.keySet().stream()
                .anyMatch(key -> key.matches("\\d"));
    }

    private void add(final Deque<Integer> queue) {
        try {
            queue.add(queue.removeLast() + queue.removeLast());
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Addition requires that the stack contain at least 2 values");
        }
    }

    private void subtract(final Deque<Integer> queue) {
        try {
            int number = queue.removeLast();
            queue.add(queue.removeLast() - number);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Subtraction requires that the stack contain at least 2 values");
        }
    }

    private void multiply(final Deque<Integer> queue) {
        try {
            queue.add(queue.removeLast() * queue.removeLast());
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Multiplication requires that the stack contain at least 2 values");
        }
    }

    private void divide(final Deque<Integer> queue) {
        try {
            final int number = queue.removeLast();
            queue.add(queue.removeLast() / number);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Division requires that the stack contain at least 2 values");
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Division by 0 is not allowed");
        }
    }

    private void duplicate(final Deque<Integer> queue) {
        try {
            queue.add(queue.getLast());
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Duplicating requires that the stack contain at least 1 value");
        }
    }

    private void drop(final Deque<Integer> queue) {
        try {
            queue.removeLast();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Dropping requires that the stack contain at least 1 value");
        }
    }

    private void swap(final Deque<Integer> queue) {
        try {
            final int first = queue.removeLast();
            final int second = queue.removeLast();
            queue.add(first);
            queue.add(second);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Swapping requires that the stack contain at least 2 values");
        }
    }

    private void over(final Deque<Integer> queue) {
        try {
            final int first = queue.removeLast();
            final int second = queue.getLast();
            queue.add(first);
            queue.add(second);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Overing requires that the stack contain at least 2 values");
        }
    }
}
