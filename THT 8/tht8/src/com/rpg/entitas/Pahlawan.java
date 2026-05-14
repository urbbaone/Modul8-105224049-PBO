package com.rpg.entitas;
import com.rpg.arena.Karakter;

public class Pahlawan extends Karakter {
    private int mana, level;

    public Pahlawan(String nama, int hp, int baseDamage, int mana, int level) {
        super(nama, hp, baseDamage);
        this.mana = mana;
        this.level = level;
    }

    // Overriding: Damage pahlawan makin sakit seiring naik level
    @Override
    public int serang() {
        return baseDamage * level;
    }

    // Overloading: Serangan versi Skill yang butuh Mana (Damage 2x lipat)
    public int serang(String namaSkill, int manaCost) {
        if (this.mana >= manaCost) {
            this.mana -= manaCost;
            System.out.println(nama + " mengeluarkan " + namaSkill + "!");
            return baseDamage * level * 2;
        } else {
            System.out.println("Mana habis! Gagal menggunakan " + namaSkill);
            return 0;
        }
    }

    @Override
    public void bertahan() {
        this.isDefending = true;
        System.out.println(nama + " bersiaga dengan perisai (Damage selanjutnya berkurang 50%)!");
    }

    @Override
    public void gunakanItem() {
        this.hp += 30; // Healing standar dari item
        System.out.println(nama + " minum ramuan merah (HP bertambah 30).");
    }

    @Override
    public void tampilkanStatus() {
        System.out.println("[PAHLAWAN] " + nama + " | HP: " + hp + " | Mana: " + mana + " | Level: " + level);
    }
}