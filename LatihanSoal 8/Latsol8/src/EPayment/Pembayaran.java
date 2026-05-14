package EPayment;

public abstract class Pembayaran {
    // Variabel protected supaya bisa diakses oleh kelas anak (KartuKredit & EWallet)
    protected String namaPembayar;
    protected double nominal;

    // Konstruktor untuk mencatat data awal setiap kali ada transaksi
    public Pembayaran(String namaPembayar, double nominal) {
        this.namaPembayar = namaPembayar;
        this.nominal = nominal;
    }

    // Method konkret: Semua jenis pembayaran pasti bisa nampilin detail ini
    public void tampilkanDetail() {
        System.out.println("Pembayar : " + namaPembayar);
        System.out.println("Nominal  : Rp" + nominal);
    }

    // Method abstract: Wajib diisi (override) oleh kelas anak sesuai aturan biayanya
    public abstract void prosesPembayaran();
}