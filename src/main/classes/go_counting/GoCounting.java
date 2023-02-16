package main.classes.go_counting;

import java.awt.*;
import java.util.*;
import java.util.List;

public class GoCounting {

    private List<List<String>> board = new ArrayList<>();

    private Map<Player, List<Set<Point>>> territories = new HashMap<>();

    public GoCounting(String input) {
        String[] rows = input.split("\n");
        for (int i = 0; i < rows.length; i++) {
            board.add(new ArrayList<>());
            for (String column : rows[i].split("")) {
                board.get(i).add(column);
            }
        }
        markTerritories();
    }

    private void markTerritories() {
        for (int row = 0; row < board.size(); row++) {
            for (int column = 0; column < board.get(0).size(); column++) {
                markTerritory(row, column);
            }
        }
    }

    private void markTerritory(int row, int column) {
        Queue<String> queue = new LinkedList<>();
        List<String> blackOrWhites = new ArrayList<>();
        List<String> open = new ArrayList<>();
        Set<String> currentMarked = new HashSet<>();
        queue.add(String.format("%d%d", row, column));
        while (!queue.isEmpty()) {
            String[] point = queue.remove().split("");
            int currentRow = Integer.valueOf(point[0]);
            int currentColumn = Integer.valueOf(point[1]);
            String inputSymbol = board.get(currentRow).get(currentColumn);
            if (inputSymbol.equals(" ")) {
                List<List<Integer>> adjecentPoints = getAdjecentPoints(currentRow, currentColumn);
                if (adjecentPoints.isEmpty()) {
                    open.add(" ");
                    currentMarked.add(String.format("%d%d", currentRow, currentColumn));
                }
                for (List<Integer> adjecentPoint : adjecentPoints) {
                    int adjRow = adjecentPoint.get(0);
                    int adjColumn = adjecentPoint.get(1);
                    String adjSymbol = board.get(adjRow).get(adjColumn);
                    if (adjSymbol.equals("B") || adjSymbol.equals("W")) {
                        blackOrWhites.add(adjSymbol);
                    } else if (adjSymbol.equals(" ") && !currentMarked.contains(String.format("%d%d", adjRow, adjColumn))) {
                        open.add(adjSymbol);
                        queue.add(String.format("%d%d", adjRow, adjColumn));
                    }
                    currentMarked.add(String.format("%d%d", currentRow, currentColumn));
                }
                currentMarked.add(String.format("%d%d", currentRow, currentColumn));
            }
        }
        if (!blackOrWhites.isEmpty() && blackOrWhites.stream().allMatch(item -> item.equals("W"))) {
            Set<Point> points = new HashSet<>();
            for (String markedPoint : currentMarked) {
                String[] point = markedPoint.split("");
                int currentRow = Integer.valueOf(point[0]);
                int currentColumn = Integer.valueOf(point[1]);
                Point pointz = new Point();
                pointz.x = currentColumn;
                pointz.y = currentRow;
                points.add(pointz);
                board.get(currentRow).set(currentColumn, "WT");
            }
            if (territories.get(Player.WHITE) == null && !points.isEmpty()) {
                List<Set<Point>> pointsList = new ArrayList<>();
                pointsList.add(points);
                territories.put(Player.WHITE, pointsList);
            } else if (!points.isEmpty()) {
                territories.get(Player.WHITE).add(points);
            }
        } else if (!blackOrWhites.isEmpty() && blackOrWhites.stream().allMatch(item -> item.equals("B"))) {
            Set<Point> points = new HashSet<>();
            for (String markedPoint : currentMarked) {
                String[] point = markedPoint.split("");
                int currentRow = Integer.valueOf(point[0]);
                int currentColumn = Integer.valueOf(point[1]);
                Point pointz = new Point();
                pointz.x = currentColumn;
                pointz.y = currentRow;
                points.add(pointz);
                board.get(currentRow).set(currentColumn, "BT");
            }
            if (territories.get(Player.BLACK) == null && !points.isEmpty()) {
                List<Set<Point>> pointsList = new ArrayList<>();
                pointsList.add(points);
                territories.put(Player.BLACK, pointsList);
            } else if (!points.isEmpty()) {
                territories.get(Player.BLACK).add(points);
            }
        } else if (!open.isEmpty() && open.stream().allMatch(item -> item.equals(" "))) {
            Set<Point> points = new HashSet<>();
            for (String markedPoint : currentMarked) {
                String[] point = markedPoint.split("");
                int currentRow = Integer.valueOf(point[0]);
                int currentColumn = Integer.valueOf(point[1]);
                Point pointz = new Point();
                pointz.x = currentColumn;
                pointz.y = currentRow;
                points.add(pointz);
                board.get(currentRow).set(currentColumn, " ");
            }
            if (territories.get(Player.NONE) == null && !points.isEmpty()) {
                List<Set<Point>> pointsList = new ArrayList<>();
                pointsList.add(points);
                territories.put(Player.NONE, pointsList);
            } else if (!points.isEmpty()) {
                territories.get(Player.NONE).add(points);
            }
        }
    }

    private boolean isPointValid(int row, int column) {
        return column >= 0 && row >= 0 && row < board.size() && column < board.get(0).size();
    }

    private List<List<Integer>> getAdjecentPoints(int row, int column) {
        List<List<Integer>> validPoints = new ArrayList<>();
        int[][] candidatePoitns = {{row, column + 1}, {row, column - 1}, {row + 1, column}, {row - 1, column}};
        for (int i = 0; i < candidatePoitns.length; i++) {
            int candidateRow = candidatePoitns[i][0];
            int candidateColumn = candidatePoitns[i][1];
            if (isPointValid(candidateRow, candidateColumn)) {
                validPoints.add(new ArrayList<>());
                validPoints.get(validPoints.size() - 1).add(candidateRow);
                validPoints.get(validPoints.size() - 1).add(candidateColumn);
            }
        }
        return validPoints;
    }

    public Player getTerritoryOwner(int column, int row) {
        String symbol = board.get(row).get(column);
        switch (symbol) {
            case "BT":
                return Player.BLACK;
            case "WT":
                return Player.WHITE;
            default:
                return Player.NONE;
        }
    }

    public Set<Point> getTerritory(int column, int row) {
        if (column < 0 || row < 0 || row >= board.size() || column >= board.get(0).size()) {
            throw new IllegalArgumentException("Invalid coordinate");
        }
        List<Set<Point>> whiteSets = territories.get(Player.WHITE);
        for (Set<Point> whitePointSet : whiteSets) {
            for (Point whitePoint : whitePointSet) {
                if (whitePoint.x == column && whitePoint.y == row) {
                    return whitePointSet;
                }
            }
        }
        List<Set<Point>> blackSets = territories.get(Player.BLACK);
        for (Set<Point> blackPointSet : blackSets) {
            for (Point blackPoint : blackPointSet) {
                if (blackPoint.x == column && blackPoint.y == row) {
                    return blackPointSet;
                }
            }
        }
        List<Set<Point>> noneSets = territories.get(Player.NONE);
        for (Set<Point> nonePointSet : noneSets) {
            for (Point nonePoint : nonePointSet) {
                if (nonePoint.x == column && nonePoint.y == row) {
                    return nonePointSet;
                }
            }
        }
        return new HashSet<>();
    }

    public HashMap<Player, Set<Point>> getTerritories() {
        HashMap<Player, Set<Point>> allTerritories = new HashMap<>();
        for (Player player : Player.values()) {
            Set<Point> currentPoints = new HashSet<>();
            allTerritories.put(player, currentPoints);
            List<Set<Point>> currentTerritory = territories.get(player);
            if (currentTerritory != null && !currentTerritory.isEmpty()) {
                for (Set<Point> points : currentTerritory) {
                    points.forEach(point -> currentPoints.add(point));
                }
            }
        }
        return allTerritories;
    }
}
