package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Umowa {

    private int id_umowa;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_zawarcia;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_rozwiazania;
    private float koszt;
    private int id_salon_samochodowy;
    private int id_klient;
    private int id_oferta;

    public Umowa(int id_umowa, LocalDate data_zawarcia, LocalDate data_rozwiazania, float koszt, int id_salon_samochodowy, int id_klient, int id_oferta) {
        this.id_umowa = id_umowa;
        this.data_zawarcia = data_zawarcia;
        this.data_rozwiazania = data_rozwiazania;
        this.koszt = koszt;
        this.id_salon_samochodowy = id_salon_samochodowy;
        this.id_klient = id_klient;
        this.id_oferta = id_oferta;
    }

    public int getId_umowa() {
        return id_umowa;
    }

    public void setId_umowa(int id_umowa) {
        this.id_umowa = id_umowa;
    }

    public LocalDate getData_zawarcia() {
        return data_zawarcia;
    }

    public void setData_zawarcia(LocalDate data_zawarcia) {
        this.data_zawarcia = data_zawarcia;
    }

    public LocalDate getData_rozwiazania() {
        return data_rozwiazania;
    }

    public void setData_rozwiazania(LocalDate data_rozwiazania) {
        this.data_rozwiazania = data_rozwiazania;
    }

    public float getKoszt() {
        return koszt;
    }

    public void setKoszt(float koszt) {
        this.koszt = koszt;
    }

    public int getId_salon_samochodowy() {
        return id_salon_samochodowy;
    }

    public void setId_salon_samochodowy(int id_salon_samochodowy) {
        this.id_salon_samochodowy = id_salon_samochodowy;
    }

    public int getId_klient() {
        return id_klient;
    }

    public void setId_klient(int id_klient) {
        this.id_klient = id_klient;
    }

    public int getId_oferta() {
        return id_oferta;
    }

    public void setId_oferta(int id_oferta) {
        this.id_oferta = id_oferta;
    }

    @Override
    public String toString() {
        return "Umowa{" +
                "id_umowa=" + id_umowa +
                ", data_zawarcia='" + data_zawarcia + '\'' +
                ", data_rozwiazania='" + data_rozwiazania + '\'' +
                ", koszt=" + koszt +
                ", id_salon_samochodowy=" + id_salon_samochodowy +
                ", id_klient=" + id_klient +
                ", id_oferta=" + id_oferta +
                '}';
    }

    public Umowa(){

    }
}
