package EPayment;

// Mewarisi Pembayaran dan menjalankan standar Keamanan
public class KartuKredit extends Pembayaran implements Keamanan {
    private String nomorKartu;

    public KartuKredit(String namaPembayar, double nominal, String nomorKartu) {
        // Memanggil konstruktor milik induk (Pembayaran)
        super(namaPembayar, nominal);
        this.nomorKartu = nomorKartu;
    }

    // Mengisi logika autentikasi sesuai kontrak interface Keamanan
    @Override
    public boolean autentikasi() {
        System.out.println("Sistem: Menghubungkan ke bank...");
        System.out.println("Autentikasi PIN Kartu Kredit berhasil.");
        return true;
    }

    // Mengisi logika pembayaran khusus kartu kredit (ada admin 2%)
    @Override
    public void prosesPembayaran() {
        double biayaAdmin = nominal * 0.02;
        double total = nominal + biayaAdmin;
        System.out.println("Nomor Kartu    : " + nomorKartu);
        System.out.println("Biaya Admin 2% : Rp" + biayaAdmin);
        System.out.println("Total Tagihan  : Rp" + total);
        System.out.println("Status         : Pembayaran Kartu Kredit Berhasil.");
    }
}