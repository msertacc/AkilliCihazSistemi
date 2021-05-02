package nyat.proje;

public class Observer implements IObserver{

    @Override
    public void kullanicilariBilgilendir(String mesaj) {
        System.out.println(mesaj);
    }
}
