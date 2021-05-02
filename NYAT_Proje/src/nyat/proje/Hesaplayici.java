package nyat.proje;

public abstract class Hesaplayici {
    public static double fahrenhaitOlc(double deger) { return deger * 1.8 + 32; }
    public static double kelvinOlc(double deger) {
        return deger + 273;
    }
    public static double celciusOlc(double deger) {
        return deger;
    }
}
