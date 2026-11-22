public class Voucher implements MetodeBayar{
    private int nilai;

    public Voucher(int nilai){
        this.nilai = nilai;
    }

    @Override
    public String nama(){
        return "Voucher " + Buku.formatRupiah(nilai);
    }

//   Versi yang melanggar kontrak:
//   @Override
//    public int totalBayar(int totalBelanja) {
//        return totalBelanja - nilai;
//    }
//    Hasil : Voucher Rp100.000    : Rp-36.000

    @Override
    public int totalBayar(int totalBelanja){
        return Math.max(0, totalBelanja -nilai);
    }

}
