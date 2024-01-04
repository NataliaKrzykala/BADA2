package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Platnosc {

    private int id_platnosc;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_zlecenia;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_zaplaty;
    private float ile_do_oplacenia;
    private int id_umowa;
    private int id_typ_platnosci;

    public Platnosc(int id_platnosc, LocalDate data_zlecenia, LocalDate data_zaplaty, float ile_do_oplacenia, int id_umowa, int id_typ_platnosci) {
        this.id_platnosc = id_platnosc;
        this.data_zlecenia = data_zlecenia;
        this.data_zaplaty = data_zaplaty;
        this.ile_do_oplacenia = ile_do_oplacenia;
        this.id_umowa = id_umowa;
        this.id_typ_platnosci = id_typ_platnosci;
    }

    public int getId_platnosc() {
        return id_platnosc;
    }

    public void setId_platnosc(int id_platnosc) {
        this.id_platnosc = id_platnosc;
    }

    public LocalDate getData_zlecenia() {
        return data_zlecenia;
    }

    public void setData_zlecenia(LocalDate data_zlecenia) {
        this.data_zlecenia = data_zlecenia;
    }

    public LocalDate getData_zaplaty() {
        return data_zaplaty;
    }

    public void setData_zaplaty(LocalDate data_zaplaty) {
        this.data_zaplaty = data_zaplaty;
    }

    public float getIle_do_oplacenia() {
        return ile_do_oplacenia;
    }

    public void setIle_do_oplacenia(float ile_do_oplacenia) {
        this.ile_do_oplacenia = ile_do_oplacenia;
    }

    public int getId_umowa() {
        return id_umowa;
    }

    public void setId_umowa(int id_umowa) {
        this.id_umowa = id_umowa;
    }

    public int getId_typ_platnosci() {
        return id_typ_platnosci;
    }

    public void setId_typ_platnosci(int id_typ_platnosci) {
        this.id_typ_platnosci = id_typ_platnosci;
    }

    @Override
    public String toString() {
        return "Platnosc{" +
                "id_platnosc=" + id_platnosc +
                ", data_zlecenia='" + data_zlecenia + '\'' +
                ", data_zaplaty='" + data_zaplaty + '\'' +
                ", ile_do_oplacenia=" + ile_do_oplacenia +
                ", id_umowa=" + id_umowa +
                ", id_typ_platnosci=" + id_typ_platnosci +
                '}';
    }

}
