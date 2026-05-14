package com.rpg.entitas;
import com.rpg.arena.Karakter;

public class Monster extends Karakter {
    private String jenisMonster;

    public Monster(String nama, int hp, int baseDamage, String jenisMonster) {
        super(nama, hp, baseDamage);
        this.jenisMonster = jenisMonster;
    }

    @Override
    public int serang() {
        // Monster serangannya konstan berdasarkan base damage
        return baseDamage;
    }

    @Override
    public void bertahan() {
        // Perilaku unik: Monster memulihkan diri sedikit saat posisi bertahan
        this.hp += 10;
        System.out.println(nama + " (" + jenisMonster + ") meraung dan memulihkan sedikit energi!");
    }

    @Override
    public void gunakanItem() {
        // Monster di game ini tidak bisa pakai item pahlawan
    }

    @Override
    public void tampilkanStatus() {
        System.out.println("[MONSTER] " + nama + " (" + jenisMonster + ") | HP: " + hp);
    }
}