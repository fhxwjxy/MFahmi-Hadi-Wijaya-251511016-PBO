package model;

public class Pesanan {
    private static int nextNumber = 1;

    private int nomor;
    private Mahasiswa pemesan;
    private MenuItem item;
    private int jumlah;

    public Pesanan(Mahasiswa pemesan, MenuItem item, int jumlah) {
        this.nomor = nextNumber++;
        this.pemesan = pemesan;
        this.item = item;
        this.jumlah = jumlah;
    }

    public int getNomor() {
        return nomor;
    }

    public int hitungTotal() {
        return item.getHargaJual() * jumlah;
    }

    public boolean dapatDiproses() {
        return jumlah > 0 && item.isTersedia();
    }

    public String getStatus() {
        return dapatDiproses() ? "Siap dibuat" : "Tidak dapat diproses";
    }

    public String ringkasan() {
        return "Pesanan #" + nomor + " - " + pemesan.getNama()
                + " memesan " + item.getNama() + " x" + jumlah;
    }

    public static int getJumlahPesananDibuat() {
        return nextNumber - 1;
    }
}