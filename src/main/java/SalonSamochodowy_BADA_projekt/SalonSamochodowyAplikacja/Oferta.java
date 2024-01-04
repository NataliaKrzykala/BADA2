package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Oferta {
    private int id_oferta;
    private LocalDate data_utworzenia;
    private String typ_nabycia;

    private int cena;
    private int id_salon_samochodowy;
    private int id_pojazd;

    private Salon_samochodowy salon;
    public Salon_samochodowy getSalon() {
        return salon;
    }
    public void setSalon(Salon_samochodowy salon) {
        this.salon = salon;
    }

    private Pojazd pojazd;
    public Pojazd getPojazd() {
        return pojazd;
    }

    public void setPojazd(Pojazd pojazd) {
        this.pojazd = pojazd;
    }

    private Model model;
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Oferta(int id_oferta, LocalDate data_utworzenia, String typ_nabycia, int cena, int id_salon_samochodowy, int id_pojazd) {
        this.id_oferta = id_oferta;
        this.data_utworzenia = data_utworzenia;
        this.typ_nabycia = typ_nabycia;
        this.cena = cena;
        this.id_salon_samochodowy = id_salon_samochodowy;
        this.id_pojazd = id_pojazd;
    }

    public int getId_oferta() {
        return id_oferta;
    }

    public void setId_oferta(int id_oferta) {
        this.id_oferta = id_oferta;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getData_utworzenia() {
        return data_utworzenia;
    }

    public void setData_utworzenia(LocalDate data_utworzenia) {
        this.data_utworzenia = data_utworzenia;
    }

    public String getTyp_nabycia() {
        return typ_nabycia;
    }

    public void setTyp_nabycia(String typ_nabycia) {
        this.typ_nabycia = typ_nabycia;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getId_salon_samochodowy() {
        return id_salon_samochodowy;
    }

    public void setId_salon_samochodowy(int id_salon_samochodowy) {
        this.id_salon_samochodowy = id_salon_samochodowy;
    }

    public int getId_pojazd() {
        return id_pojazd;
    }

    public void setId_pojazd(int id_pojazd) {
        this.id_pojazd = id_pojazd;
    }

    @Override
    public String toString() {
        return "Oferta{" +
                "id_oferta=" + id_oferta +
                ", data_utworzenia='" + data_utworzenia + '\'' +
                ", typ_nabycia='" + typ_nabycia + '\'' +
                ", cena=" + cena +
                ", id_salon_samochodowy=" + id_salon_samochodowy +
                ", id_pojazd=" + id_pojazd +
                '}';
    }

    public Oferta() {

    }
}
