package nyat.proje;

import java.util.Random;

public class Algilayici extends SicaklikKontrolcu implements IAlgilayici {

    private Double value = null;
    private static Boolean kontrolcuDurum = false;

    @Override
    public void otoKontrolAktif(){
        if(kontrolcuDurumu())
            System.out.println("Oto uyarici zaten acik");
        else{
            System.out.println("Oto uyarici acildi");
            guncelleKontrolcuDurumu(true);
        }
    }

    @Override
    public void otoKontrolPasif(){
        if(!kontrolcuDurumu())
            System.out.println("Oto uyarici zaten kapali");
        else{
            System.out.println("Oto uyarici kapatildi");
            guncelleKontrolcuDurumu(false);
        }
    }

    @Override
    public void algila() throws InterruptedException {
        System.out.println("Sicaklik olculuyor.");
        Thread.sleep(300);
        System.out.println("Sicaklik olculuyor..");
        Thread.sleep(300);
        System.out.println("Sicaklik olculuyor...");
        Thread.sleep(300);
    }

    @Override
    public double olc(int secim) {
        Random rnd = new Random();
        int minOlcum = 10;
        int maxOlcum = 35;
        value = minOlcum + (maxOlcum - minOlcum) * rnd.nextDouble();
        if(secim == 1)
            return Hesaplayici.celciusOlc(value);
        else if(secim == 2)
            return Hesaplayici.fahrenhaitOlc(value);
        else
            return Hesaplayici.kelvinOlc(value);
    }

    @Override
    public Double degerGetir(){
        return value;
    }

    @Override
    public void yeniDeger(Double yeniDeger){
        value = yeniDeger;
    }

    @Override
    public void sicaklikOtoKontrol(){
        if(degerGetir() > 26)
            bilgilendirYuksekSicaklik();
        else if(degerGetir()<16)
            bilgilendirDusukSicaklik();
        else
            bilgilendirDengeliSicaklik();
    }

    @Override
    public boolean kontrolcuDurumu(){
        return kontrolcuDurum;
    }

    public void guncelleKontrolcuDurumu(Boolean yeniDurum){
        kontrolcuDurum = yeniDurum;
    }
}
