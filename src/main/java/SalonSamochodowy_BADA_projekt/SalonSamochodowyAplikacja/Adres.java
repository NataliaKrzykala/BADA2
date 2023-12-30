package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

public class Adres {

    private int id_adres;
    private String miejscowosc;
    private String ulica;
    private String nr_lokalu;
    private int id_poczta;

    public Adres(int id_adres, String miejscowosc, String ulica, String nr_lokalu, int id_poczta) {
        this.id_adres = id_adres;
        this.miejscowosc = miejscowosc;
        this.ulica = ulica;
        this.nr_lokalu = nr_lokalu;
        this.id_poczta = id_poczta;
    }

    public int getId_adres() {
        return id_adres;
    }

    public void setId_adres(int id_adres) {
        this.id_adres = id_adres;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNr_lokalu() {
        return nr_lokalu;
    }

    public void setNr_lokalu(String nr_lokalu) {
        this.nr_lokalu = nr_lokalu;
    }

    public int getId_poczta() {
        return id_poczta;
    }

    public void setId_poczta(int id_poczta) {
        this.id_poczta = id_poczta;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "id_adres=" + id_adres +
                ", miejscowosc='" + miejscowosc + '\'' +
                ", ulica='" + ulica + '\'' +
                ", nr_lokalu='" + nr_lokalu + '\'' +
                ", id_poczta=" + id_poczta +
                '}';
    }

    public Adres(){

    }
}