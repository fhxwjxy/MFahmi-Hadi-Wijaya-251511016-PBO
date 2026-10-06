package model;

public class Makanan extends MenuItem {
    private int tingkatPedas;

    public Makanan(String kode, String nama, int harga, int tingkatPedas) {
        super(kode, nama, harga);
        this.tingkatPedas = tingkatPedas;
    }

    public int getTingkatPedas() {
        return tingkatPedas;
    }

    @Override
    public String getDeskripsi() {
        return super.getDeskripsi() + " (pedas level " + tingkatPedas + ")";
    }
}