import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Perusahaan perusahaan = new Perusahaan();

        while (true) {
            String[] opsi = {"Tambah", "Hapus", "Ubah Posisi", "Ubah Gaji", "Filter Posisi", "Cari", "Total Gaji", "Simpan", "Baca", "Keluar"};
            String pilihan = (String) JOptionPane.showInputDialog(null, "Pilih Menu:", "Manajemen Karyawan",
                    JOptionPane.PLAIN_MESSAGE, null, opsi, opsi[0]);

            if (pilihan == null || pilihan.equals("Keluar")) {
                break;
            }

            switch (pilihan) {
                case "Tambah":
                    String id = JOptionPane.showInputDialog("ID:");
                    String nama = JOptionPane.showInputDialog("Nama:");
                    String posisi = JOptionPane.showInputDialog("Posisi:");
                    double gaji = Double.parseDouble(JOptionPane.showInputDialog("Gaji:"));
                    perusahaan.tambahKaryawan(new Karyawan(id, nama, posisi, gaji));
                    break;
                case "Hapus":
                    perusahaan.hapusKaryawan(JOptionPane.showInputDialog("Masukkan ID karyawan yang akan dihapus:"));
                    break;
                case "Ubah Posisi":
                    perusahaan.ubahPosisi(JOptionPane.showInputDialog("ID:"), JOptionPane.showInputDialog("Posisi Baru:"));
                    break;
                case "Ubah Gaji":
                    perusahaan.ubahGaji(JOptionPane.showInputDialog("ID:"), Double.parseDouble(JOptionPane.showInputDialog("Gaji Baru:")));
                    break;
                case "Filter Posisi":
                    perusahaan.filterBerdasarkanPosisi(JOptionPane.showInputDialog("Posisi yang ingin difilter:"));
                    break;
                case "Cari":
                    perusahaan.cariKaryawan(JOptionPane.showInputDialog("Nama yang ingin dicari:"));
                    break;
                case "Total Gaji":
                    perusahaan.laporanTotalGaji();
                    break;
                case "Simpan":
                    perusahaan.simpanDataKeFile(JOptionPane.showInputDialog("Nama file untuk menyimpan:"));
                    break;
                case "Baca":
                    perusahaan.bacaDataDariFile(JOptionPane.showInputDialog("Nama file untuk membaca:"));
                    break;
            }
        }
    }
}
