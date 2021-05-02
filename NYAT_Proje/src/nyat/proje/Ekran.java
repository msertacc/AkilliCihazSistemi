package nyat.proje;

public class Ekran implements IEkran{

    @Override
    public void menu(String username) {
        System.out.println("\n***AKILLI CIHAZ SISTEMİ***");
        System.out.println("Kullanici: "+username);
        System.out.println("1- Sıcaklık Algila");
        System.out.println("2- Sogutucuyu Ac");
        System.out.println("3- Sogutucuyu Kapat");
        System.out.println("4- Sicaklik Degeri Uyaricisini Çalıştır (Observer)");
        System.out.println("5- Sicaklik Degeri Uyaricisini Kapat");
        System.out.println("6- Kullanilan Sogutucu Bilgileri");
        System.out.println("7- Cikis");
        System.out.print("Seciminizi giriniz : ");
    }

    @Override
    public void girisMesaj() {
        System.out.println("\n***AKILLI CIHAZ SISTEMİ***");
        System.out.println("Hosgeldiniz");
        System.out.println("Sisteme giris yapiniz...");
    }

    @Override
    public void girisYuklenme() throws InterruptedException {
        System.out.println("Dogrulama basarili...");
        System.out.println("Giris Yapiliyor.");
        Thread.sleep(300);
        System.out.println("Giris Yapiliyor..");
        Thread.sleep(300);
        System.out.println("Giris Yapiliyor...");
    }

    @Override
    public void cikisYuklenme() throws InterruptedException {
        System.out.println("Cikis Yapiliyor.");
        Thread.sleep(300);
        System.out.println("Cikis Yapiliyor..");
        Thread.sleep(300);
        System.out.println("Cikis Yapiliyor...");
    }

    @Override
    public void sicaklikSecenek() {
        System.out.println("1- Celcius Goruntule");
        System.out.println("2- Fahrenheit Goruntule");
        System.out.println("3- Kelvin Goruntule");
        System.out.print("Bir secim giriniz");
    }

    @Override
    public void olculenDeger(int secim, double deger){

        if(secim == 1)
            System.out.printf("Olculen deger %.2f Celcius\n",deger);
        else if(secim == 2)
            System.out.printf("Olculen deger %.2f Fahrenheit\n",deger);
        else if(secim == 3)
            System.out.printf("Olculen deger %.2f Kelvin\n",deger);
        else
            System.out.println("Hatali giris yapildi...");
    }

    @Override
    public void anaMenuyeDonusMesaj() throws InterruptedException {
        Thread.sleep(300);
        System.out.println("Hatali giris yaptiniz, ana menüye döndürülüyorsunuz.");
        Thread.sleep(300);
        System.out.println("Hatali giris yaptiniz, ana menüye döndürülüyorsunuz..");
        Thread.sleep(300);
        System.out.println("Hatali giris yaptiniz, ana menüye döndürülüyorsunuz...");
    }
}
