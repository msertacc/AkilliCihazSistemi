package nyat.proje;

import java.sql.SQLException;

public class VeritabaniIslemleri {

    private IVeritabaniSurucu veritabani;

    public VeritabaniIslemleri(IVeritabaniSurucu veritabani){
        this.veritabani =  veritabani;
    }

    public void baglanDB(){
        veritabani.baglan();
    }

    public boolean girisKontrol(String username, String password){
        return veritabani.sistemeGiris(username,password);
    }

    public boolean yetkiKontrol(String username, String password) throws SQLException {
        return veritabani.yetkiKontrol(username, password);
    }

    public void baglantiSonlandir() throws SQLException {
        veritabani.baglantiSonlandir();
    }

}
