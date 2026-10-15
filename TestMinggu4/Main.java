public class Main {
    public static void main(String[] args) {
        int nomor = 1;
        Barang barang1 = new Barang("B01", "Laptop Asus");
        Barang barang2 = new Barang("B02", "Proyektor Epson");

        Lokasi lokasi1 = new Lokasi("Lab Komputer", "LB");
        Lokasi lokasi2 = new Lokasi("Ruang Teknisi", "RT");

        PencatatanInventaris pencatatan1 = new PencatatanInventaris("P" + nomor, barang1, lokasi1);
        nomor++;
        PencatatanInventaris pencatatan2 = new PencatatanInventaris("P" + nomor, barang2, lokasi2);

        System.out.println("==Sebelum Perubahan Status==\n");
        pencatatan1.cetakPencatatan();
        pencatatan2.cetakPencatatan();

        barang1.tandaiHilang();
        barang2.perbaiki();

        System.out.println("\n==Setelah Perubahan Status==");
        pencatatan1.cetakPencatatan();
        pencatatan2.cetakPencatatan();
    }

}
