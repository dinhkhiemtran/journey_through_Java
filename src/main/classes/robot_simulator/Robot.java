package main.classes.robot_simulator;

public class Robot {

    private GridPosition initGP;

    private Orientation orientation;

    public Robot(GridPosition intGP, Orientation orientation) {
        this.initGP = intGP;
        this.orientation = orientation;
    }

    public GridPosition getGridPosition() {
        return initGP;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void simulate(String command) {
        for (char c : command.toCharArray()) {
            switch (c) {
                case 'R':
                    turnRight();
                    break;
                case 'A':
                    advance();
                    break;
                case 'L':
                    turnLeft();
                    break;
            }
        }
    }
    //Changes orientation only.

    public void turnRight() {
        if (orientation == Orientation.NORTH) {
            orientation = Orientation.EAST;
        } else if (orientation == Orientation.EAST) {
            orientation = Orientation.SOUTH;
        } else if (orientation == Orientation.SOUTH) {
            orientation = Orientation.WEST;
        } else if (orientation == Orientation.WEST) {
            orientation = Orientation.NORTH;
        }
    }
    //Changes orientation only.

    public void turnLeft() {
        if (orientation == Orientation.NORTH) {
            orientation = Orientation.WEST;
        } else if (orientation == Orientation.EAST) {
            orientation = Orientation.NORTH;
        } else if (orientation == Orientation.SOUTH) {
            orientation = Orientation.EAST;
        } else if (orientation == Orientation.WEST) {
            orientation = Orientation.SOUTH;
        }
    }
    //Changes grid position only.

    public void advance() {
        int row = initGP.x;
        int col = initGP.y;
        if (orientation == Orientation.NORTH) {
            initGP = new GridPosition(row, col + 1);
        } else if (orientation == Orientation.EAST) {
            initGP = new GridPosition(row + 1, col);
        } else if (orientation == Orientation.SOUTH) {
            initGP = new GridPosition(row, col - 1);
        } else if (orientation == Orientation.WEST) {
            initGP = new GridPosition(row - 1, col);
        }
    }
}
