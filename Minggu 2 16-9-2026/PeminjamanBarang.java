import java.time.LocalDate;
import java.util.ArrayList;

class Mahasiswa{
    private String namaMahasiswa;
    private String nim;
    private String noTelepon;
    private String status;
    private String prodi; 

    public Mahasiswa(String namaMahasiswa, String nim, String noTelepon, String status, String prodi){
        this.namaMahasiswa = namaMahasiswa;
        this.nim = nim;
        this.noTelepon = noTelepon;
        this.status = status;
        this.prodi = prodi;
    }

    public String getNamaMahasiswa() {return namaMahasiswa;}
    public String getNim() {return nim;}
    public String getnoTelepon() {return noTelepon;}
    public String getStatus() {return status;}
    public String getProdi() {return prodi;} 

    public void setStatus(String status){
        this.status = status;
    }

    public boolean mahasiswaAktif(){
        return this.status != null && this.status.equalsIgnoreCase("aktif");
    }

    public boolean ProdiDiizinkan(){
        return this.prodi != null && (this.prodi.equalsIgnoreCase("D3 Teknik Informatika") || this.prodi.equalsIgnoreCase("D4 Teknik Informatika"));
    }

    public void tampilkanInfo(){
        System.out.println("Mahasiswa: " + namaMahasiswa + "\nNIM:" + nim + "\nNo Telepon: " + noTelepon + "\nStatus: " + status + "\nProdi: " + prodi);
    }

}

class Alat{
    private String namaAlat;
    private String kodeAlat;
    private String statusAlat;
    private String kondisiAlat;

    public Alat(String namaAlat, String kodeAlat, String statusAlat, String kondisiAlat){
        this.namaAlat = namaAlat;
        this.kodeAlat = kodeAlat;
        this.statusAlat = statusAlat;
        this.kondisiAlat = kondisiAlat;
    }

    public String getNamaAlat() {return namaAlat;}
    public String getKodeAlat() {return kodeAlat;}
    public String getStatusAlat() {return statusAlat;}
    public String getKondisiAlat() {return kondisiAlat;}

    public void setStatusAlat(String statusAlat){
        this.statusAlat = statusAlat;
    }

    public void setKondisiAlat(String kondisiAlat){
        this.kondisiAlat = kondisiAlat;
    }

    public boolean tersedia(){
        return statusAlat != null && statusAlat.equalsIgnoreCase("Tersedia");
    }

    public boolean rusak(){
        return kondisiAlat != null && kondisiAlat.equalsIgnoreCase("Baik");
    }

    public void tampilkanInfo(){
        System.out.println(kodeAlat + " - " + namaAlat + " | Status: " + statusAlat + " | Kondisi: " + kondisiAlat);
    }
}

class Peminjaman{
    private Mahasiswa mahasiswa;
    private Alat alat;
    private boolean berhasil;
    private LocalDate tanggalPinjam;
    private LocalDate tanggalKembali;

    public Peminjaman(Mahasiswa mahasiswa, Alat alat){
        this.mahasiswa = mahasiswa;
        this.alat = alat;
        this.berhasil = false;
        this.tanggalPinjam = null;
        this.tanggalKembali = null;
    }

    public boolean isBerhasil() {return berhasil;}
    public LocalDate getTanggalPinjam() {return tanggalPinjam;}
    public LocalDate getTanggalKembali() {return tanggalKembali;}

    public void proses(){
        System.out.println("\n--- Peminjaman Barang: " + mahasiswa.getNamaMahasiswa() + " meminjam alat: " +alat.getNamaAlat() + "---");

        if (!mahasiswa.mahasiswaAktif()) {
            System.out.println("Gagal: Status mahasiswa tidak aktif");
            berhasil = false;
            return;
        }

        if (!mahasiswa.ProdiDiizinkan()) {
            System.out.println("Gagal: Prodi " + mahasiswa.getProdi() + "tidak diizinkan meminjam di JTK");
            berhasil = false;
            return;
        }

        if(!alat.tersedia()){
            System.out.println("Gagal: Alat " + alat.getNamaAlat() + " sedang " + alat.getStatusAlat());
            berhasil = false;
            return;
        }

        if(!alat.rusak()){
            System.out.println("Gagal: Alat " + alat.getNamaAlat() + " sedang " + alat.getKondisiAlat());
            berhasil = false;
            return;
        }

        alat.setStatusAlat("Dipinjam");
        berhasil = true;
        System.out.println("Berhasil: " + alat.getNamaAlat() + " Dipinjam oleh " + mahasiswa.getNamaMahasiswa() + " pada tanggal " + tanggalPinjam);
    }

    public void kembalikan(){
        if(!berhasil){
            System.out.println("Tidak ada peminjaman untuk dikembalikan");
            return;
        }
        alat.setStatusAlat("Tersedia");
        System.out.println(mahasiswa.getNamaMahasiswa() + " Mengembalikan " + alat.getNamaAlat() + " pada tanggal " + tanggalKembali);
    }
}

public class PeminjamanBarang {
    public static void main(String[] args){
        ArrayList<Alat> daftarAlat = new ArrayList<>();
        daftarAlat.add(new Alat("Projector", "01", "Tersedia", "Baik"));
        daftarAlat.add(new Alat("Projector", "02", "Dipinjam", "Baik"));
        daftarAlat.add(new Alat("Projector", "03", "Tersedia", "Baik"));
        daftarAlat.add(new Alat("Projector", "04", "Tersedia", "Baik"));
        daftarAlat.add(new Alat("Terminal", "05", "Tersedia", "Rusak"));
        System.out.println("=== Daftar Alat di JTK ===");
        for(Alat alat : daftarAlat){
            alat.tampilkanInfo();
        } 

        Mahasiswa mhs1 = new Mahasiswa("Haikal", "251511018", "6282286461234", "aktif", "D3 Teknik Informatika");
        Mahasiswa mhs2 = new Mahasiswa("Alvin", "251511001", "6282286464531", "aktif", "D4 Teknik Informatika");
        Mahasiswa mhs3 = new Mahasiswa("Arga", "211511008", "6282286463133", "tidak aktif", "D3 Teknik Informatika");
        Mahasiswa mhs4 = new Mahasiswa("Ezra", "251511014", "6282286462254", "aktif", "D3 Teknik Telekomunikasi");
        Mahasiswa mhs5 = new Mahasiswa("Nofal", "251511098", "6282286469802", "aktif", "D3 Teknik Informatika");
        
        System.out.println("\n=== Data Peminjam");
        mhs1.tampilkanInfo();
        System.out.println();
        mhs2.tampilkanInfo();
        System.out.println();
        mhs3.tampilkanInfo();
        System.out.println();
        mhs4.tampilkanInfo();
        System.out.println();
        mhs5.tampilkanInfo();

        Peminjaman pinjam1 = new Peminjaman(mhs1, daftarAlat.get(0));
        pinjam1.proses();
        Peminjaman pinjam2 = new Peminjaman(mhs2, daftarAlat.get(1));
        pinjam2.proses();
        Peminjaman pinjam3 = new Peminjaman(mhs3, daftarAlat.get(2));
        pinjam3.proses();
        Peminjaman pinjam4 = new Peminjaman(mhs4, daftarAlat.get(3));
        pinjam4.proses();
        Peminjaman pinjam5 = new Peminjaman(mhs5, daftarAlat.get(4));
        pinjam5.proses();

        pinjam1.kembalikan();;
        System.out.println("\n=== Status Akhir Alat ===");
        for(Alat alat : daftarAlat){
            alat.tampilkanInfo();
        }
    }
}
