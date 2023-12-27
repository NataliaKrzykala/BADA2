package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

public class Pojazd {

    private int id_pojazd;
    private String VIN;
    private String numer_rejestracyjny;
    private String stan;
    private String data_przegladu;
    private int przebieg;
    private String typ_paliwa;
    private String kolor;
    private int id_model;

    public Pojazd(int id_pojazd, String VIN, String numer_rejestracyjny, String stan, String data_przegladu, int przebieg, String typ_paliwa, String kolor, int id_model) {
        this.id_pojazd = id_pojazd;
        this.VIN = VIN;
        this.numer_rejestracyjny = numer_rejestracyjny;
        this.stan = stan;
        this.data_przegladu = data_przegladu;
        this.przebieg = przebieg;
        this.typ_paliwa = typ_paliwa;
        this.kolor = kolor;
        this.id_model = id_model;
    }

    public int getId_pojazd() {
        return id_pojazd;
    }

    public void setId_pojazd(int id_pojazd) {
        this.id_pojazd = id_pojazd;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getNumer_rejestracyjny() {
        return numer_rejestracyjny;
    }

    public void setNumer_rejestracyjny(String numer_rejestracyjny) {
        this.numer_rejestracyjny = numer_rejestracyjny;
    }

    public String getStan() {
        return stan;
    }

    public void setStan(String stan) {
        this.stan = stan;
    }

    public String getData_przegladu() {
        return data_przegladu;
    }

    public void setData_przegladu(String data_przegladu) {
        this.data_przegladu = data_przegladu;
    }

    public int getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(int przebieg) {
        this.przebieg = przebieg;
    }

    public String getTyp_paliwa() {
        return typ_paliwa;
    }

    public void setTyp_paliwa(String typ_paliwa) {
        this.typ_paliwa = typ_paliwa;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public int getId_model() {
        return id_model;
    }

    public void setId_model(int id_model) {
        this.id_model = id_model;
    }

    @Override
    public String toString() {
        return "Pojazd{" +
                "id_pojazd=" + id_pojazd +
                ", VIN='" + VIN + '\'' +
                ", numer_rejestracyjny='" + numer_rejestracyjny + '\'' +
                ", stan='" + stan + '\'' +
                ", data_przegladu='" + data_przegladu + '\'' +
                ", przebieg=" + przebieg +
                ", typ_paliwa='" + typ_paliwa + '\'' +
                ", kolor='" + kolor + '\'' +
                ", id_model=" + id_model +
                '}';
    }

    public Pojazd() {

    }
}
