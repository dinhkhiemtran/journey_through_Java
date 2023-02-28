package main.multidimensional_array.connect;

public class Connect {

    private class Point {

        public int x;

        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private char[][] board;

    private Point op;

    private Point xp;

    public Connect(String[] board) {
        int rows = board.length;
        int columns = board[0].replaceAll("\\s+", "").length();
        this.board = new char[rows][columns];
        for (int i = 0; i < board.length; ++i) {
            board[i] = board[i].replaceAll("\\s+", "");
            for (int j = 0; j < board[i].length(); ++j) {
                this.board[i][j] = board[i].charAt(j);
            }
        }
        int o_x = -1;
        for (int i = 0; i < this.board[0].length; ++i) {
            if (this.board[0][i] == 'O') {
                o_x = i;
                break;
            }
        }
        int x_y = -1;
        for (int i = 0; i < this.board.length; ++i) {
            if (this.board[i][0] == 'X') {
                x_y = i;
                break;
            }
        }
        this.op = new Point(o_x, 0);
        this.xp = new Point(0, x_y);
    }

    private boolean getWin(char player, Point position) {
        if ((position.x < 0) ||
                (position.x >= this.board[0].length) ||
                (position.y < 0) ||
                (position.y >= this.board.length) ||
                (this.board[position.y][position.x] != player)) {
            return false;
        }
        if (((player == 'O') && (position.y == this.board.length - 1)) ||
                ((player == 'X') && (position.x == this.board[0].length - 1))) {
            return true;
        }
        this.board[position.y][position.x] = '.';
        boolean getu = getWin(player, new Point(position.x, position.y - 1));
        boolean getur = getWin(player, new Point(position.x + 1, position.y - 1));
        boolean getl = getWin(player, new Point(position.x - 1, position.y));
        boolean getr = getWin(player, new Point(position.x + 1, position.y));
        boolean getdl = getWin(player, new Point(position.x - 1, position.y + 1));
        boolean getd = getWin(player, new Point(position.x, position.y + 1));
        return getu || getur || getl || getr || getdl || getd;
    }

    public Winner computeWinner() {
        if (getWin('O', op)) {
            return Winner.PLAYER_O;
        } else if (getWin('X', xp)) {
            return Winner.PLAYER_X;
        }
        return Winner.NONE;
    }
}
