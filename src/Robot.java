import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Robot {

    private static final Set<String> registeredNames  = new HashSet<>();

    private static Random random = new Random();

    private String name;

    public Robot() {
        reset();
    }

    public String getName() {
        return name;
    }

    public void reset() {
        registeredNames.remove(this.name);
        String name;

        while (registeredNames.contains(name = generateName())) {
            continue;
        }
        registeredNames.add(name);
        this.name = name;
    }

    public String randomString(char fromChar, char toChar, int len) {
        return random.ints(fromChar, toChar + 1 ).limit(len)
                .mapToObj(ch -> Character.toString(ch))
                .collect(Collectors.joining());
    }

    public String generateName() {
        return randomString('A', 'Z',2) + randomString('0', '9', 3);
    }

    public static void main(String[] args) {
        Robot robot1 = new Robot();
        System.out.println("Name of robot 1: " + robot1.generateName());
        Robot robot2 = new Robot();
        System.out.println("Name of robot 2: " + robot2.generateName());
        robot2.reset();
        System.out.println("Name of robot 2 after rested : " + robot2.generateName());
    }
}
