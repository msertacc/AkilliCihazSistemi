package nyat.proje;

abstract class KontrolcuMesajcisi {
    static String yuksekSicaklikUyari(){
        return "Sicaklik cok yüksek, sogutucuyu calistirin.";
    }
    static String dusukSicaklikUyari(){
        return "Sicaklik cok düsük...";
    }
    static String dengeliSicaklikUyari() {
        return "Sicaklik dengeli...";
    }
}
