public class Kendaraan {
    private String jenisKendaraan;
    private int lamaParkir;
    private double biayaPerJam;

    public Kendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
        setBiayaPerJam();
    }

    private void setBiayaPerJam() {
        switch (jenisKendaraan.toLowerCase()) {
            case "motor":
                biayaPerJam = 2000;
                break;
            case "mobil":
                biayaPerJam = 5000;
                break;
            case "truk":
                biayaPerJam = 8000;
                break;
            default:
                biayaPerJam = 0;
                break;
        }
    }

    // Overload 1: input manual durasi
    public double hitungBiaya(int lamaParkir) {
        this.lamaParkir = lamaParkir;
        return hitungTotalBiaya();
    }

    // Overload 2: input jam masuk dan keluar
    public double hitungBiaya(int jamMasuk, int jamKeluar) {
        this.lamaParkir = jamKeluar - jamMasuk;
        if (this.lamaParkir < 0) {
            System.out.println("Jam keluar tidak boleh lebih kecil dari jam masuk!");
            this.lamaParkir = 0;
        }
        return hitungTotalBiaya();
    }

    private double hitungTotalBiaya() {
        double total = biayaPerJam * lamaParkir;
        if (lamaParkir > 5) {
            total = total * 0.9; // diskon 10%
        }
        return total;
    }

    public void tampilRingkasan() {
        System.out.println("Jenis Kendaraan: " + jenisKendaraan);
        System.out.println("Lama Parkir: " + lamaParkir + " jam");
        System.out.println("Total Biaya Parkir: Rp" + (int)hitungTotalBiaya());
        System.out.println("-------------------------------------");
    }

    public double getTotalBiaya() {
        return hitungTotalBiaya();
    }
}
