
public class PencatatanInventaris {
    private String kodePencatatan;
    private Barang barang;
    private Lokasi lokasi;

    public PencatatanInventaris(String kodePencatatan, Barang barang, Lokasi lokasi) {
        this.kodePencatatan = kodePencatatan;
        this.barang = barang;
        this.lokasi = lokasi;
    }

    public void cetakPencatatan() {
        System.out.println("Kode Pencatatan: " + kodePencatatan);
        System.out.println("Kode Barang: " + barang.getKodeBarang());
        System.out.println("Nama Barang: " + barang.getNamaBarang());
        System.out.println("Status: " + barang.getStatus());
        System.out.println("Lokasi: " + lokasi.getNamaLokasi());
        System.out.println("====================================");
    }

}
