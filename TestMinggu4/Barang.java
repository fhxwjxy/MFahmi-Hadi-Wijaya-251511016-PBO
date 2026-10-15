public class Barang {
    private String kodeBarang;
    private String namaBarang;
    private String status;

    public Barang(String kodeBarang, String namaBarang) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.status = "Bagus";
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public String getStatus() {
        return status;
    }

    public void tandaiRusak() {
        status = "Rusak";
    }

    public void tandaiHilang() {
        status = "Hilang";
    }

    public void perbaiki() {
        status = "Bagus";
    }

    public void infoBarang() {
        System.out.println("Kode Barang: " + kodeBarang);
        System.out.println("Nama Barang: " + namaBarang);
        System.out.println("Status: " + status);
    }

}