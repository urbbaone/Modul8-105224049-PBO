package LogistikPro;

// PengirimanDarat mewarisi sifat LayananPengiriman dan bisa dilacak (LacakKargo).
public class PengirimanDarat extends LayananPengiriman implements LacakKargo {
    private String jenisTruk;
    private String statusSaatIni;

    public PengirimanDarat(String noResi, double berat, double jarak, String jenisTruk) {
        // Mengirim data ke konstruktor induk (LayananPengiriman).
        super(noResi, berat, jarak);
        this.jenisTruk = jenisTruk;
        // Status awal paket saat baru didaftarkan.
        this.statusSaatIni = "Menunggu Kurir";
    }

    @Override
    public double hitungOngkosKirim() {
        // Rumus biaya darat: (berat * 5000) + (jarak * 2000).
        double ongkir = (beratBarang * 5000) + (jarakTempuh * 2000);
        
        // Cek apakah pakai truk Tronton, kalau iya tambah biaya tetap 150rb.
        // Pakai equalsIgnoreCase agar tidak sensitif huruf besar/kecil.
        if (jenisTruk.equalsIgnoreCase("Tronton")) {
            ongkir += 150000;
        }
        return ongkir;
    }

    // Menjalankan tugas dari interface LacakKargo.
    @Override
    public void updateStatus(String status) {
        this.statusSaatIni = status;
    }

    @Override
    public String cekLokasiTerakhir() {
        return statusSaatIni;
    }
}