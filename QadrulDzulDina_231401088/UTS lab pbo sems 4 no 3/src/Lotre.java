import java.util.Random;

public class Lotre {
    char[][] board;
    boolean[][] revealed;
    int[][] data;
    int rows = 4;
    int cols = 5;

    public Lotre() {
        board = new char[rows][cols];
        revealed = new boolean[rows][cols];
        data = new int[rows][cols];
        generateBoard();
    }

    void generateBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = '*';
                data[i][j] = 0;
                revealed[i][j] = false;
            }
        }

        Random rand = new Random();
        int bombsPlaced = 0;
        while (bombsPlaced < 2) {
            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols);
            if (data[r][c] == 0) {
                data[r][c] = 1;
                bombsPlaced++;
            }
        }
    }

    void displayBoard() {
        System.out.print("   ");
        for (int c = 0; c < cols; c++) {
            System.out.print(c + " ");
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < cols; j++) {
                if (revealed[i][j]) {
                    if (data[i][j] == 1) {
                        System.out.print("X ");
                    } else {
                        System.out.print("O ");
                    }
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    boolean guess(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            System.out.println("Posisi tidak valid! Silakan coba lagi.");
            return true;
        }
        if (revealed[row][col]) {
            System.out.println("Kotak sudah dibuka! Silakan pilih kotak lain.");
            return true;
        }
        revealed[row][col] = true;
        if (data[row][col] == 1) {
            return false;
        }
        return true;
    }

    boolean isGameOver() {
        int revealedSafe = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (revealed[i][j] && data[i][j] == 0) {
                    revealedSafe++;
                }
            }
        }
        return revealedSafe == 18;
    }
}
