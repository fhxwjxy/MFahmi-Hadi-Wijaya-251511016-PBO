package app;

import model.Mahasiswa;
import model.MenuItem;
import model.Pesanan;
import model.Makanan;
import model.Minuman;

public class Main {
    public static void main(String[] args) {
        Mahasiswa mhs1 = new Mahasiswa("241001", "Asep");
        Mahasiswa mhs2 = new Mahasiswa("241002", "Siti");

        MenuItem menu1 = new Makanan("M01", "Nasi Goreng", 18000, 3);
        MenuItem menu2 = new Minuman("M02", "Kopi Susu", 12000, "M");

        Pesanan p1 = new Pesanan(mhs1, menu1, 2);
        Pesanan p2 = new Pesanan(mhs2, menu2, 1);
        Pesanan p3 = new Pesanan(mhs1, menu2, 3);

        System.out.println(p1.ringkasan());
        System.out.println("Total P1: " + p1.hitungTotal());
        System.out.println("Status P1: " + p1.getStatus());
        Kasir kasir = new Kasir();
        kasir.proses(p1);

        System.out.println(p2.ringkasan());
        System.out.println("Status P2: " + p2.getStatus());
        kasir.proses(p2);

        System.out.println(p3.ringkasan());
        System.out.println("Jumlah pesanan dibuat: " + Pesanan.getJumlahPesananDibuat());

        System.out.println();
        System.out.println("=== Demo inheritance ===");
        MenuItem menu3 = new Minuman("M03", "Es Teh", 5000, "L");

        System.out.println(menu1.getDeskripsi() + " | harga jual " + menu1.getHargaJual());
        System.out.println(menu2.getDeskripsi() + " | harga jual " + menu2.getHargaJual());
        System.out.println(menu3.getDeskripsi() + " | harga jual " + menu3.getHargaJual());

        Pesanan p4 = new Pesanan(mhs2, menu3, 2);
        System.out.println(p4.ringkasan());
        System.out.println("Total P4: " + p4.hitungTotal());

        menu3.tandaiHabis();
        System.out.println("Status P4 setelah menu habis: " + p4.getStatus());
        kasir.proses(p4);
        System.out.println("Jumlah pesanan dibuat: " + Pesanan.getJumlahPesananDibuat());
    }
}