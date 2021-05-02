package nyat.proje;

import java.sql.*;

public class AkilliCihazSistemi {

    public static void main(String[] args) throws SQLException, InterruptedException {
        AkilliCihaz akilliCihaz = new AkilliCihaz(
                new Ekran(),
                new Algilayici(),
                new SogutucuA.SogutucuBuilder("Sogutucu A", "MSY Sogutma").sogutucuGarantiSuresi(2).sogutucuOrijinalMi("Evet").build(),
                new Observer(),
                new PostgresSQLSurucu());

        akilliCihaz.basla();
    }
}