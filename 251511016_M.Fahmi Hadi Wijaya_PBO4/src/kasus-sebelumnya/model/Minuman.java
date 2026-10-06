package model;

public class Minuman extends MenuItem {
    private static final int TAMBAHAN_UKURAN_L = 3000;

    private String ukuran;

    public Minuman(String kode, String nama, int harga, String ukuran) {
        super(kode, nama, harga);
        this.ukuran = ukuran;
    }

    public String getUkuran() {
        return ukuran;
    }

    @Override
    public int getHargaJual() {
        int tambahan = ukuran.equals("L") ? TAMBAHAN_UKURAN_L : 0;
        return super.getHargaJual() + tambahan;
    }

    @Override
    public String getDeskripsi() {
        return super.getDeskripsi() + " (ukuran " + ukuran + ")";
    }
}