package EPayment;

public class Ewallet extends Pembayaran implements Keamanan {
    private String nomorHP;

    public Ewallet(String namaPembayar, double nominal, String nomorHP) {
        super(namaPembayar, nominal);
        this.nomorHP = nomorHP;
    }

    @Override
    public boolean autentikasi() {
        // Simulasi verifikasi aplikasi e-wallet
        System.out.println("Sistem: Mengirim notifikasi ke aplikasi...");
        System.out.println("Autentikasi E-Wallet berhasil.");
        return true;
    }

    @Override
    public void prosesPembayaran() {
        // Nominal tetap sama karena tidak ada biaya admin
        System.out.println("Nomor HP       : " + nomorHP);
        System.out.println("Total Tagihan  : Rp" + nominal);
        System.out.println("Status         : Saldo E-Wallet Berhasil Dipotong.");
    }
}