package LogistikPro;

public interface Asuransi {
    // Method untuk menghitung biaya premi berdasarkan nilai barangnya.
    double hitungPremi(double nilaiBarang);

    // Default method: Pesan ini akan sama untuk semua yang pakai asuransi,
    // jadi tidak perlu ditulis ulang di setiap kelas.
    default void cetakPolis() {
        System.out.println("Polis Asuransi aktif: Menanggung kehilangan dan kerusakan fisik sebesar 100% dari nilai barang.");
    }
}