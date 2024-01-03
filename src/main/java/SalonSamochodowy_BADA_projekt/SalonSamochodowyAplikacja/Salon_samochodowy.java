package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Salon_samochodowy {
    private int id_salon_samochodowy;
    private String wlasciciel;
    private LocalDate data_zalozenia;
    private String nazwa;
    private int id_adres;

    private Adres adres;

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public int getId_salon_samochodowy() {
        return id_salon_samochodowy;
    }

    public void setId_salon_samochodowy(int id_salon_samochodowy) {
        this.id_salon_samochodowy = id_salon_samochodowy;
    }

    public String getWlasciciel() {
        return wlasciciel;
    }

    public void setWlasciciel(String wlasciciel) {
        this.wlasciciel = wlasciciel;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getData_zalozenia() {
        return data_zalozenia;
    }

    public void setData_zalozenia(LocalDate data_zalozenia) {
        this.data_zalozenia = data_zalozenia;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getId_adres() {
        return id_adres;
    }

    public void setId_adres(int id_adres) {
        this.id_adres = id_adres;
    }

    @Override
    public String toString() {
        return "Salon_samochodowy{" +
                "id_salon_samochodowy=" + id_salon_samochodowy +
                ", wlasciciel='" + wlasciciel + '\'' +
                ", data_zalozenia=" + data_zalozenia +
                ", nazwa='" + nazwa + '\'' +
                ", id_adres=" + id_adres +
                ", adres=" + adres +
                '}';
    }

    public Salon_samochodowy(int id_salon_samochodowy, String wlasciciel, LocalDate data_zalozenia, String nazwa, int id_adres) {
        this.id_salon_samochodowy = id_salon_samochodowy;
        this.wlasciciel = wlasciciel;
        this.data_zalozenia = data_zalozenia;
        this.nazwa = nazwa;
        this.id_adres = id_adres;
    }

    public Salon_samochodowy() {

    }
}
