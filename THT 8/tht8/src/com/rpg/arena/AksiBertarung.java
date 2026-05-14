package com.rpg.arena;

public interface AksiBertarung {
    // Menghasilkan nilai damage untuk dikirim ke lawan
    int serang();
    
    // Mengubah status karakter menjadi bersiaga (bertahan)
    void bertahan();
    
    // Menggunakan barang habis pakai untuk pemulihan
    void gunakanItem();
}