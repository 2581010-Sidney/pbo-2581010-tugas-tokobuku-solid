public class StrukPrinter {
    private static final int LEBAR = 41;

    private static String header(String judul, char isi){
        String teks = " " + judul + " ";
        int sisa = LEBAR - teks.length();
        int kiri = sisa/2;
        int kanan = sisa - kiri;
        return String.valueOf(isi).repeat(kiri) + teks + String.valueOf(isi).repeat(kanan);
    }

    public static void cetakKeranjang(String judul, Keranjang keranjang){
        System.out.println(header(judul, '='));
        for (Buku b : keranjang.getIsi()){
            System.out.println(b.getJudul() + " (" + b.getPenulis() + ")");
            System.out.println("  harga       : " + Buku.formatRupiah(b.getHarga()));
            System.out.println("  Keterangan  : " + b.keterangan());
            System.out.println("  Harga akhir : " + b.formatRupiah(b.hargaAkhir()));
        }
        System.out.println("-".repeat(LEBAR));
        System.out.println("Total belanja : " + Buku.formatRupiah(keranjang.hitungTotal()));
    }

    public static void cetakPembayaran(int totalBelanja, MetodeBayar[] pilihan){
        System.out.println(header("PEMBAYARAN", '-'));
        for (MetodeBayar m: pilihan){
            System.out.printf("%-20s : %s%n", m.nama(), Buku.formatRupiah(m.totalBayar(totalBelanja)));        }
    }
}
