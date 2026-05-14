package LogistikPro;

public interface LacakKargo {
    // Kontrak untuk memperbarui posisi paket saat ini.
    void updateStatus(String status);
    
    // Kontrak untuk mengecek di mana posisi terakhir paket tersebut.
    String cekLokasiTerakhir();
}