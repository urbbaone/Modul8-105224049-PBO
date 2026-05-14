public class Main { 
    public static void main(String[] args) {
        Programmer pg = new Programmer("Bagas", 8000000);
        System.out.println("Nama: " + pg.nama);
        System.out.println("Gaji: " + pg.hitungGaji());
    }
}