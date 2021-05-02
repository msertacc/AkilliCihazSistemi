package nyat.proje;

import java.sql.SQLException;
import java.util.Scanner;

public class AkilliCihaz {

    private final IEkran ekran;
    private final ISogutucu sogutucu;
    private final IObserver izleyici;
    private final IAlgilayici algilayici;
    private final IVeritabaniSurucu veritabaniSurucu;

    private final VeritabaniIslemleri veritabaniIslemleri;

    private static final int SICAKLIK_GORUNTULE = 1;
    private static final int SOGUTUCUYU_AC = 2;
    private static final int SOGUTUCUYU_KAPAT = 3;
    private static final int OTO_SICAKLIK_KONTROL_ACIK = 4;
    private static final int OTO_SICAKLIK_KONTROL_KAPALI = 5;
    private static final int SOGUTUCU_BILGILERI = 6;
    private static final int CIKIS = 7;

    public AkilliCihaz(IEkran ekran, IAlgilayici algilayici, ISogutucu sogutucu, IObserver izleyici, IVeritabaniSurucu veritabaniSurucu){
        this.ekran = ekran;
        this.algilayici = algilayici;
        this.sogutucu = sogutucu;
        this.izleyici = izleyici;
        this.veritabaniSurucu = veritabaniSurucu;
        veritabaniIslemleri = new VeritabaniIslemleri(veritabaniSurucu);
        algilayici.addObserver(izleyici);
    }

    public void basla() throws InterruptedException, SQLException {
        ekran.girisMesaj();
        Scanner input = new Scanner(System.in);
        int sayac = 2;
        while(sayac>-1){
            System.out.print("Kullanıcı Adı Giriniz : ");
            String kullaniciAdi = input.nextLine();
            System.out.print("Şifre Giriniz : ");
            String kullaniciSifre = input.nextLine();
            veritabaniIslemleri.baglanDB();
            if(veritabaniIslemleri.girisKontrol(kullaniciAdi,kullaniciSifre)){
                ekran.girisYuklenme();
                int secim;
                do{
                    ekran.menu(kullaniciAdi);
                    secim = input.nextInt();
                    if(veritabaniIslemleri.yetkiKontrol(kullaniciAdi,kullaniciSifre) || secim == CIKIS || secim == SOGUTUCU_BILGILERI){
                        switch (secim) {
                            case SICAKLIK_GORUNTULE:
                                ekran.sicaklikSecenek();
                                int secenekSicak = input.nextInt();
                                if(secenekSicak >= 1 && secenekSicak <= 3){
                                    algilayici.algila();
                                    double olcum = algilayici.olc(secenekSicak);
                                    if(algilayici.kontrolcuDurumu()){
                                        ekran.olculenDeger(secenekSicak,olcum);
                                        algilayici.sicaklikOtoKontrol();
                                    }
                                    else
                                        ekran.olculenDeger(secenekSicak,olcum);
                                }
                                else
                                    ekran.anaMenuyeDonusMesaj();
                                break;
                            case SOGUTUCUYU_AC:
                                sogutucu.sogutucuAc(algilayici);
                                break;
                            case SOGUTUCUYU_KAPAT:
                                if(sogutucu.sogutucuDurum())
                                    sogutucu.sogutucuKapat();
                                else
                                    System.out.println("Sogutucu zaten kapali...");
                                break;
                            case OTO_SICAKLIK_KONTROL_ACIK:
                                algilayici.otoKontrolAktif();
                                break;
                            case OTO_SICAKLIK_KONTROL_KAPALI:
                                 algilayici.otoKontrolPasif();
                                 break;
                            case SOGUTUCU_BILGILERI:
                                sogutucu.sogutucuOzellikleri();
                                break;
                            case CIKIS:
                                veritabaniIslemleri.baglantiSonlandir();
                                ekran.cikisYuklenme();
                                System.exit(0);
                                break;
                            default:
                                System.out.println("1-7 arasında bir sayı girmelisiniz");
                        }
                    }
                    else
                        System.out.println("Bu kullanicinin yetkisi yoktur...");

                }while(true);
            }
            else
            {
                System.out.println("Girilen bilgilere ait kullanici bulunmamaktadır.");
                if(sayac != 0)
                    System.out.println("Kalan deneme hakkiniz "+sayac);
                else
                    System.out.println("Deneme hakkiniz kalmadi...");
                sayac--;
            }
        }
    }
}
