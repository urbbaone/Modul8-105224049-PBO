
import com.rpg.entitas.*;
import java.util.Scanner;

public class GameEngine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("=== RPG ARENA: SURVIVAL MODE ===");
        System.out.print("Masukkan Nama Pahlawan: ");
        String namaHero = input.nextLine();
        
        // Inisialisasi Pahlawan
        Pahlawan pahlawan = new Pahlawan(namaHero, 200, 20, 60, 1);

        // Survival Mode: Menghadapi Array berisi 3 Monster berbeda
        Monster[] daftarMonster = {
            new Monster("Slime Hijau", 60, 10, "Kecil"),
            new Monster("Orc Hutan", 100, 20, "Sedang"),
            new Monster("Naga Api", 180, 35, "Boss")
        };

        boolean menangDungeon = true;

        // Loop Luar: Menelusuri daftar monster satu per satu
        for (int i = 0; i < daftarMonster.length; i++) {
            Monster musuh = daftarMonster[i];
            System.out.println("\n>>> Musuh Muncul: " + musuh.getNama() + " <<<");

            // Loop Dalam (Battle Loop): Berjalan selama keduanya masih bernyawa
            while (pahlawan.getHp() > 0 && musuh.getHp() > 0) {
                System.out.println("\n------------------------------");
                pahlawan.tampilkanStatus();
                musuh.tampilkanStatus();
                
                System.out.println("Pilih Aksi: 1.Serang | 2.Skill (Mana: 20) | 3.Bertahan & Heal");
                System.out.print("Pilihan: ");
                int aksi = input.nextInt();

                // Langkah 1: Giliran Pahlawan menyerang
                switch (aksi) {
                    case 1:
                        musuh.terimaDamage(pahlawan.serang());
                        break;
                    case 2:
                        musuh.terimaDamage(pahlawan.serang("Tebasan Cahaya", 20));
                        break;
                    case 3:
                        pahlawan.bertahan();
                        pahlawan.gunakanItem();
                        break;
                    default:
                        System.out.println("Aksi tidak valid! Pahlawan terdiam.");
                }

                // Langkah 2: Balasan dari Monster jika dia belum mati
                if (musuh.getHp() > 0) {
                    pahlawan.terimaDamage(musuh.serang());
                    System.out.println(musuh.getNama() + " menyerang balik!");
                }
            }

            // Cek kondisi setelah duel selesai
            if (pahlawan.getHp() <= 0) {
                menangDungeon = false;
                break; // Hentikan game jika pahlawan gugur
            } else {
                System.out.println("\n!!! " + musuh.getNama() + " Berhasil Dikalahkan !!!");
            }
        }

        // Penentuan Akhir Game
        System.out.println("\n==============================");
        if (menangDungeon) {
            System.out.println("SELAMAT! " + pahlawan.getNama() + " berhasil menamatkan Dungeon.");
        } else {
            System.out.println("GAME OVER... " + pahlawan.getNama() + " telah gugur.");
        }
        
        input.close();
    }
}