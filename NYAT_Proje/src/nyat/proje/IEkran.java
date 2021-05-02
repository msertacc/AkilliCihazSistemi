package nyat.proje;

interface IEkran {
    void menu(String username);
    void girisMesaj();
    void girisYuklenme() throws InterruptedException;
    void cikisYuklenme() throws InterruptedException;
    void sicaklikSecenek();
    void olculenDeger(int secim, double deger);
    void anaMenuyeDonusMesaj() throws InterruptedException;
}
