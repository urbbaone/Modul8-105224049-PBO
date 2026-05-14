package LogistikPro;

// Kelas ini punya kemampuan ganda: bisa dilacak DAN bisa diasuransikan.
public class PengirimanUdara extends LayananPengiriman implements LacakKargo, Asuransi {
    private String nomorPenerbangan;
    private String statusSaatIni;
    private double nilaiBarang;

    public PengirimanUdara(String resi, double b, double j, String n, double nilai) {
        super(resi, b, j);
        this.nomorPenerbangan = n;
        this.nilaiBarang = nilai;
        // Status awal khusus untuk armada udara.
        this.statusSaatIni = "Menunggu Jadwal Penerbangan";
    }

    @Override
    public double hitungOngkosKirim() {
        // Tarif udara jauh lebih mahal: (berat * 25rb) + (jarak * 5rb).
        return (beratBarang * 25000) + (jarakTempuh * 5000);
    }

    // Implementasi asuransi: Premi dipatok 3% dari total nilai barang.
    @Override
    public double hitungPremi(double nilaiBarang) {
        return nilaiBarang * 0.03;
    }

    // Implementasi pelacakan status kargo udara.
    @Override
    public void updateStatus(String status) {
        this.statusSaatIni = status;
    }

    @Override
    public String cekLokasiTerakhir() {
        return statusSaatIni;
    }
}