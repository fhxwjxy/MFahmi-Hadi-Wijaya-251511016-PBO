package app;

import model.Pesanan;

public class Kasir {
    public void proses(Pesanan pesanan) {
        if (pesanan.dapatDiproses()) {
            System.out.println("Pesanan Diproses");
        } else {
            System.out.println("Pesanan Ditolak");
        }
    }
}
