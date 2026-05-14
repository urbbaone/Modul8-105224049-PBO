import EPayment.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Membuat list untuk menyimpan semua transaksi (Polimorfisme)
        ArrayList<Pembayaran> daftarTransaksi = new ArrayList<>();

        // Menambahkan data transaksi kartu kredit dan e-wallet
        daftarTransaksi.add(new KartuKredit("Bagas", 1500000, "4567-xxxx-xxxx"));
        daftarTransaksi.add(new Ewallet("Adit", 50000, "0859-2150-9140"));

        System.out.println("=== SISTEM PEMBAYARAN DIGITAL ===");

        // Melakukan perulangan untuk memproses setiap transaksi
        for (Pembayaran p : daftarTransaksi) {
            System.out.println("\n--- Detail Transaksi ---");
            p.tampilkanDetail();

            // Cek apakah objek ini mengimplementasikan interface Keamanan
            if (p instanceof Keamanan) {
                // Casting ke tipe Keamanan agar bisa panggil autentikasi()
                Keamanan k = (Keamanan) p;
                
                if (k.autentikasi()) {
                    // Jika aman, baru proses pembayarannya
                    p.prosesPembayaran();
                }
            }
            System.out.println("------------------------------");
        }
    }
}