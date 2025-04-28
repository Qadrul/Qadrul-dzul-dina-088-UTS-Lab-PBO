import java.util.*;
import java.io.*;

public class Perusahaan {
    private List<Karyawan> daftarKaryawan = new ArrayList<>();

    // Menambahkan karyawan baru
    public void tambahKaryawan(Karyawan karyawan) {
        // Validasi ID unik
        for (Karyawan k : daftarKaryawan) {
            if (k.getId().equals(karyawan.getId())) {
                System.out.println("Error: ID karyawan sudah ada.");
                return;
            }
        }
        daftarKaryawan.add(karyawan);
        System.out.println("Karyawan berhasil ditambahkan.");
    }

    // Menghapus karyawan berdasarkan ID
    public void hapusKaryawan(String id) {
        Iterator<Karyawan> iterator = daftarKaryawan.iterator();
        while (iterator.hasNext()) {
            Karyawan k = iterator.next();
            if (k.getId().equals(id)) {
                iterator.remove();
                System.out.println("Karyawan berhasil dihapus.");
                return;
            }
        }
        System.out.println("Error: ID karyawan tidak ditemukan.");
    }

    // Mengubah posisi karyawan berdasarkan ID
    public void ubahPosisi(String id, String posisiBaru) {
        for (Karyawan k : daftarKaryawan) {
            if (k.getId().equals(id)) {
                k.setPosisi(posisiBaru);
                System.out.println("Posisi karyawan berhasil diubah.");
                return;
            }
        }
        System.out.println("Error: ID karyawan tidak ditemukan.");
    }

    // Mengubah gaji karyawan berdasarkan ID
    public void ubahGaji(String id, double gajiBaru) {
        if (gajiBaru < 0) {
            System.out.println("Error: Gaji tidak boleh negatif.");
            return;
        }
        for (Karyawan k : daftarKaryawan) {
            if (k.getId().equals(id)) {
                k.setGaji(gajiBaru);
                System.out.println("Gaji karyawan berhasil diubah.");
                return;
            }
        }
        System.out.println("Error: ID karyawan tidak ditemukan.");
    }

    // Filter karyawan berdasarkan posisi
    public void filterBerdasarkanPosisi(String posisi) {
        System.out.println("Karyawan dengan posisi: " + posisi);
        for (Karyawan k : daftarKaryawan) {
            if (k.getPosisi().equalsIgnoreCase(posisi)) {
                System.out.println(k);
            }
        }
    }

    // Cari karyawan berdasarkan nama
    public void cariKaryawan(String nama) {
        System.out.println("Hasil pencarian untuk: " + nama);
        for (Karyawan k : daftarKaryawan) {
            if (k.getNama().toLowerCase().contains(nama.toLowerCase())) {
                System.out.println(k);
            }
        }
    }

    // Laporan total gaji
    public void laporanTotalGaji() {
        double total = 0;
        for (Karyawan k : daftarKaryawan) {
            total += k.getGaji();
        }
        System.out.println("Total Gaji Semua Karyawan: " + total);
    }

    // Menyimpan data ke file
    public void simpanDataKeFile(String namaFile) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(namaFile))) {
            for (Karyawan k : daftarKaryawan) {
                pw.println(k.getId() + "," + k.getNama() + "," + k.getPosisi() + "," + k.getGaji());
            }
            System.out.println("Data berhasil disimpan ke file.");
        } catch (IOException e) {
            System.out.println("Error menyimpan data: " + e.getMessage());
        }
    }

    // Membaca data dari file
    public void bacaDataDariFile(String namaFile) {
        try (Scanner scanner = new Scanner(new File(namaFile))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                if (data.length == 4) {
                    tambahKaryawan(new Karyawan(data[0], data[1], data[2], Double.parseDouble(data[3])));
                }
            }
            System.out.println("Data berhasil dibaca dari file.");
        } catch (IOException e) {
            System.out.println("Error membaca data: " + e.getMessage());
        }
    }
}
