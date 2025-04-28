import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean lanjut = true;
        int totalKendaraan = 0;
        double totalBiayaSemua = 0;

        while (lanjut) {
            System.out.println("=== Sistem Parkir ParkirChan ===");
            System.out.print("Masukkan jenis kendaraan (Motor/Mobil/Truk): ");
            String jenis = sc.nextLine();

            Kendaraan kendaraan = new Kendaraan(jenis);

            System.out.println("Pilih metode input durasi parkir:");
            System.out.println("1. Input jumlah jam langsung");
            System.out.println("2. Input jam masuk dan jam keluar");
            System.out.print("Pilihan (1/2): ");
            int pilihan = sc.nextInt();

            if (pilihan == 1) {
                System.out.print("Masukkan lama parkir (jam): ");
                int lama = sc.nextInt();
                kendaraan.hitungBiaya(lama);
            } else if (pilihan == 2) {
                System.out.print("Masukkan jam masuk (Contoh: 12,13,14)(tidak pakai menit): ");
                int jamMasuk = sc.nextInt();
                System.out.print("Masukkan jam keluar: ");
                int jamKeluar = sc.nextInt();
                kendaraan.hitungBiaya(jamMasuk, jamKeluar);
            } else {
                System.out.println("Pilihan tidak valid. Lewatkan kendaraan ini.");
                sc.nextLine(); // bersihkan buffer
                continue;
            }

            kendaraan.tampilRingkasan();
            totalKendaraan++;
            totalBiayaSemua += kendaraan.getTotalBiaya();

            System.out.print("Tambah kendaraan lagi? (y/n): ");
            sc.nextLine(); // bersihkan buffer
            String jawab = sc.nextLine();
            if (jawab.equalsIgnoreCase("n")) {
                lanjut = false;
            }
        }

        System.out.println("\n=== Ringkasan Akhir ===");
        System.out.println("Total kendaraan: " + totalKendaraan);
        System.out.println("Total semua biaya parkir: Rp" + (int)totalBiayaSemua);
        System.out.println("Terima kasih telah menggunakan ParkirChan!");
    }
}
