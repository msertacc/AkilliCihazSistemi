package nyat.proje;

interface IAlgilayici {
    Double degerGetir();
    void yeniDeger(Double value);
    void algila() throws InterruptedException;
    double olc(int secim);
    void otoKontrolAktif();
    void otoKontrolPasif();
    void sicaklikOtoKontrol();
    boolean kontrolcuDurumu();
    void addObserver(IObserver izleyici);
}
