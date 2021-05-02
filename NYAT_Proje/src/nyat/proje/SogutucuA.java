package nyat.proje;

public class SogutucuA implements ISogutucu  {

    private String sogutucuAdi;
    private String sogutucuMarkasi;
    private Integer sogutucuGarantiSuresi;
    private String sogutucuOrijinalMi;

    private boolean sogutucuDurum = false;

    public SogutucuA(SogutucuBuilder sogutucuBuilder) {
        this.sogutucuAdi = sogutucuBuilder.sogutucuAdi;
        this.sogutucuMarkasi = sogutucuBuilder.sogutucuMarkasi;
        this.sogutucuGarantiSuresi = sogutucuBuilder.sogutucuGarantiSuresi;
        this.sogutucuOrijinalMi = sogutucuBuilder.sogutucuOrijinalMi;
    }

    @Override
    public boolean sogutucuDurum() {
        return sogutucuDurum;
    }

    @Override
    public void sogutucuKapat() {
        System.out.println("Sogutucu kapatildi ...");
        sogutucuDurum = false;
    }

    @Override
    public void sogutucuAc(IAlgilayici algilayici) {
        if(algilayici.degerGetir() == null)
            System.out.println("Henüz ölcüm yapilmamis, algiyaciyi calistirin..");
        else{
            if(algilayici.degerGetir() <15)
                System.out.println("Yeterli sogutma saglandi..");
            else{
                algilayici.yeniDeger(algilayici.degerGetir() - 5);
                System.out.printf("Sogutucu calistirildi.. Yeni sicaklik degeri %.2f Derece\n",algilayici.degerGetir());
                sogutucuDurum = true;
            }
        }

    }

    @Override
    public void sogutucuOzellikleri(){
        System.out.println("Sogutucu Adi :"+sogutucuAdi);
        System.out.println("Sogutu Markasi :"+sogutucuMarkasi);
        System.out.println("Sogutucu Garanti Suresi :"+sogutucuGarantiSuresi+" yil");
        System.out.println("Sogutucu Orijinal Mi :"+sogutucuOrijinalMi);
    }

    public static class SogutucuBuilder {

        private final String sogutucuAdi;
        private final String sogutucuMarkasi;
        private Integer sogutucuGarantiSuresi;
        private String sogutucuOrijinalMi;

        public SogutucuBuilder(String sogutucuAdi, String sogutucuMarkasi) {
            this.sogutucuAdi = sogutucuAdi;
            this.sogutucuMarkasi = sogutucuMarkasi;
        }

        public SogutucuBuilder sogutucuGarantiSuresi(Integer sogutucuGarantiSuresi){
            this.sogutucuGarantiSuresi = sogutucuGarantiSuresi;
            return this;
        }

        public SogutucuBuilder sogutucuOrijinalMi(String sogutucuOrijinalMi){
            this.sogutucuOrijinalMi = sogutucuOrijinalMi;
            return this;
        }

        public SogutucuA build(){
            SogutucuA sogutucuA = new SogutucuA(this);
            return sogutucuA;
        }
    }
}
