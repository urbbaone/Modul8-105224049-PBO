package com.rpg.arena;

public abstract class Karakter implements AksiBertarung {
    // Atribut dilindungi (protected) supaya kelas anak bisa memodifikasi nilainya
    protected String nama;
    protected int hp, baseDamage;
    protected boolean isDefending;

    // Konstruktor untuk setting awal identitas karakter
    public Karakter(String nama, int hp, int baseDamage) {
        this.nama = nama;
        this.hp = hp;
        this.baseDamage = baseDamage;
        this.isDefending = false; // Awalnya tidak dalam posisi bertahan
    }

    // Logika perhitungan pengurangan HP saat dipukul lawan
    public void terimaDamage(int damage) {
        // Kalau isDefending aktif, damage yang diterima cuma setengah (50%)
        if (isDefending) {
            damage /= 2;
            isDefending = false; // Setelah menahan sekali, status pertahanan reset
        }
        
        this.hp -= damage;
        
        // Proteksi agar HP tidak pernah bernilai negatif (mentok di nol)
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    // Getter dan Setter untuk akses data yang terenkapsulasi
    public String getNama() { return nama; }
    public int getHp() { return hp; }
    public void setHp(int hp) { this.hp = hp; }

    // Method abstrak yang format tampilannya akan ditentukan oleh tiap jenis karakter
    public abstract void tampilkanStatus();
}