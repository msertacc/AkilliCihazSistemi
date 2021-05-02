package nyat.proje;

import java.util.ArrayList;

public class SicaklikKontrolcu{

    ArrayList<IObserver> observers;

    public SicaklikKontrolcu(){
        observers = new ArrayList<>();
    }

    public void addObserver(IObserver o) {
        observers.add(o);
    }

    public void bilgilendirYuksekSicaklik(){
        for(IObserver observer : observers){
            observer.kullanicilariBilgilendir(KontrolcuMesajcisi.yuksekSicaklikUyari());
        }
    }

    public void bilgilendirDusukSicaklik(){
        for(IObserver observer : observers){
            observer.kullanicilariBilgilendir(KontrolcuMesajcisi.dusukSicaklikUyari());
        }
    }

    public void bilgilendirDengeliSicaklik(){
        for(IObserver observer : observers){
            observer.kullanicilariBilgilendir(KontrolcuMesajcisi.dengeliSicaklikUyari());
        }
    }
}
