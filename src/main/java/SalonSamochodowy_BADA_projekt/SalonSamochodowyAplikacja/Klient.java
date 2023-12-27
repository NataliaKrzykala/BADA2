package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

public class Klient {

    private int id_klient;
    private String imie;
    private String nazwisko;
    private String nr_telefonu;
    private String email;
    private int id_adres;

    public Klient(int id_klient, String imie, String nazwisko, String nr_telefonu, String email, int id_adres) {
        this.id_klient = id_klient;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nr_telefonu = nr_telefonu;
        this.email = email;
        this.id_adres = id_adres;
    }

    public int getId_klient() {
        return id_klient;
    }

    public void setId_klient(int id_klient) {
        this.id_klient = id_klient;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNr_telefonu() {
        return nr_telefonu;
    }

    public void setNr_telefonu(String nr_telefonu) {
        this.nr_telefonu = nr_telefonu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_adres() {
        return id_adres;
    }

    public void setId_adres(int id_adres) {
        this.id_adres = id_adres;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "id_klient=" + id_klient +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", nr_telefonu='" + nr_telefonu + '\'' +
                ", email='" + email + '\'' +
                ", id_adres=" + id_adres +
                '}';
    }

    public Klient(){

    }
}
