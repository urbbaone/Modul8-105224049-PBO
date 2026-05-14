package LogistikPro;

// Kita pakai abstract karena tidak ada objek 'LayananPengiriman' secara umum.
// Objeknya harus spesifik, entah itu lewat darat atau lewat udara.
public abstract class LayananPengiriman {
    // Variabel dilindungi (protected) agar anak-anak kelasnya bisa akses langsung.
    protected String noResi;
    protected double beratBarang; // dalam satuan kg
    protected double jarakTempuh; // dalam satuan km

    // Konstruktor utama untuk memastikan setiap paket punya identitas sejak awal.
    public LayananPengiriman(String noResi, double beratBarang, double jarakTempuh) {
        this.noResi = noResi;
        this.beratBarang = beratBarang;
        this.jarakTempuh = jarakTempuh;
    }

    // Method konkret untuk menampilkan ringkasan data paket di layar.
    public void cetakResi() {
        System.out.println("No. Resi      : " + noResi);
        System.out.println("Berat Barang  : " + beratBarang + " kg");
        System.out.println("Jarak Tempuh  : " + jarakTempuh + " km");
    }

    // Method abstract: Tiap armada punya rumus biaya yang beda, jadi kita
    // paksa kelas anak untuk mengimplementasikan rumusnya masing-masing.
    public abstract double hitungOngkosKirim();
}