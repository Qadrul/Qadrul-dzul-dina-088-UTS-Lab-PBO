import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lotre board = new Lotre();
        boolean running = true;

        System.out.println("Selamat datang di Lotre Gosok Bang Pawwry!");
        System.out.println("Pilih kotak berdasarkan baris dan kolom (contoh: 0 2).");

        while (running) {
            board.displayBoard();
            System.out.print("Masukkan baris dan kolom: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            boolean safe = board.guess(row, col);
            if (!safe) {
                System.out.println("BOOM! Kamu menemukan bom! Permainan berakhir.");
                board.displayBoard();
                break;
            } else if (board.isGameOver()) {
                System.out.println("Selamat! Kamu berhasil membuka semua kotak aman!");
                board.displayBoard();
                break;
            }
        }
        scanner.close();
    }
}
