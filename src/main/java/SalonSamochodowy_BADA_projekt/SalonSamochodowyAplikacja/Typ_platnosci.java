package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

public class Typ_platnosci {

    private int id_typ_platnosci;
    private String platnosc_nazwa;

    public Typ_platnosci(int id_typ_platnosci, String platnosc_nazwa) {
        this.id_typ_platnosci = id_typ_platnosci;
        this.platnosc_nazwa = platnosc_nazwa;
    }

    public int getId_typ_platnosci() {
        return id_typ_platnosci;
    }

    public void setId_typ_platnosci(int id_typ_platnosci) {
        this.id_typ_platnosci = id_typ_platnosci;
    }

    public String getPlatnosc_nazwa() {
        return platnosc_nazwa;
    }

    public void setPlatnosc_nazwa(String platnosc_nazwa) {
        this.platnosc_nazwa = platnosc_nazwa;
    }
}
