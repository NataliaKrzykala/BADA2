package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

public class Pracownik {

    private int id_pracownik;
    private String imie;
    private String nazwisko;
    private String pesel;
    private float wynagrodzenie;
    private String numer_telefonu;
    private String data_zatrudnienia;
    private String data_zwolnienia;
    private String email;
    private int id_salon_samochodowy;
    private int id_stanowiska;
    private int id_adres;

    public Pracownik(int id_pracownik, String imie, String nazwisko, String pesel, float wynagrodzenie, String numer_telefonu, String data_zatrudnienia, String data_zwolnienia, String email, int id_salon_samochodowy, int id_stanowiska, int id_adres) {
        this.id_pracownik = id_pracownik;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.wynagrodzenie = wynagrodzenie;
        this.numer_telefonu = numer_telefonu;
        this.data_zatrudnienia = data_zatrudnienia;
        this.data_zwolnienia = data_zwolnienia;
        this.email = email;
        this.id_salon_samochodowy = id_salon_samochodowy;
        this.id_stanowiska = id_stanowiska;
        this.id_adres = id_adres;
    }

    public int getId_pracownik() {
        return id_pracownik;
    }

    public void setId_pracownik(int id_pracownik) {
        this.id_pracownik = id_pracownik;
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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public float getWynagrodzenie() {
        return wynagrodzenie;
    }

    public void setWynagrodzenie(float wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }

    public String getNumer_telefonu() {
        return numer_telefonu;
    }

    public void setNumer_telefonu(String numer_telefonu) {
        this.numer_telefonu = numer_telefonu;
    }

    public String getData_zatrudnienia() {
        return data_zatrudnienia;
    }

    public void setData_zatrudnienia(String data_zatrudnienia) {
        this.data_zatrudnienia = data_zatrudnienia;
    }

    public String getData_zwolnienia() {
        return data_zwolnienia;
    }

    public void setData_zwolnienia(String data_zwolnienia) {
        this.data_zwolnienia = data_zwolnienia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_salon_samochodowy() {
        return id_salon_samochodowy;
    }

    public void setId_salon_samochodowy(int id_salon_samochodowy) {
        this.id_salon_samochodowy = id_salon_samochodowy;
    }

    public int getId_stanowiska() {
        return id_stanowiska;
    }

    public void setId_stanowiska(int id_stanowiska) {
        this.id_stanowiska = id_stanowiska;
    }

    public int getId_adres() {
        return id_adres;
    }

    public void setId_adres(int id_adres) {
        this.id_adres = id_adres;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "id_pracownik=" + id_pracownik +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel='" + pesel + '\'' +
                ", wynagrodzenie=" + wynagrodzenie +
                ", numer_telefonu='" + numer_telefonu + '\'' +
                ", data_zatrudnienia='" + data_zatrudnienia + '\'' +
                ", data_zwolnienia='" + data_zwolnienia + '\'' +
                ", email='" + email + '\'' +
                ", id_salon_samochodowy=" + id_salon_samochodowy +
                ", id_stanowiska=" + id_stanowiska +
                ", id_adres=" + id_adres +
                '}';
    }

}