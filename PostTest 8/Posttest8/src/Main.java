import LogistikPro.*;

public class Main {
    public static void main(String[] args) {
        // Inisialisasi objek armada sesuai dengan data studi kasus di soal.
        PengirimanDarat kargoDarat = new PengirimanDarat("DRT-001", 50, 100, "Tronton");
        PengirimanUdara kargoUdara = new PengirimanUdara("UDR-999", 10, 800, "GA-123", 5000000);

        // Simulasi perubahan posisi paket di lapangan.
        kargoDarat.updateStatus("Sedang di jalan tol Cipali");
        kargoUdara.updateStatus("Transit di Bandara Soekarno-Hatta");

        // Konsep Polymorphism: Menyimpan objek beda tipe dalam satu array bertipe induk.
        LayananPengiriman[] listAntrean = {kargoDarat, kargoUdara};

        System.out.println("=== LOGISTIK-PRO: SISTEM MANAJEMEN KARGO ===\n");

        for (LayananPengiriman armada : listAntrean) {
            // Memanggil informasi dasar paket.
            armada.cetakResi();
            
            // Mengambil biaya ongkir dasar sesuai armada masing-masing.
            double totalTagihan = armada.hitungOngkosKirim();

            // Pengecekan apakah armada ini mendukung fitur pelacakan (LacakKargo).
            if (armada instanceof LacakKargo l) {
                // Downcasting ke interface LacakKargo untuk mengambil lokasi.
                System.out.println("Update Lokasi : " + l.cekLokasiTerakhir());
            }

            // Pengecekan fitur asuransi menggunakan operator instanceof.
            if (armada instanceof Asuransi a) {
                // Cetak informasi polis asuransi (Default Method).
                a.cetakPolis();
                
                // Menghitung premi udara (disini diasumsikan barangnya bernilai 5jt).
                double biayaPremi = a.hitungPremi(5000000);
                System.out.println("Biaya Premi   : Rp" + biayaPremi);
                
                // Premi ditambahkan ke ongkos kirim dasar untuk tagihan akhir.
                totalTagihan += biayaPremi;
            }

            // Hasil akhir perhitungan untuk setiap armada.
            System.out.println("TOTAL TAGIHAN : Rp" + totalTagihan);
            System.out.println("-------------------------------------------");
        }
    }
}