package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

public class Stanowisko {

    private int id_stanowiska;
    private String nazwa_stanowiska;

    public Stanowisko(int id_stanowiska, String nazwa_stanowiska) {
        this.id_stanowiska = id_stanowiska;
        this.nazwa_stanowiska = nazwa_stanowiska;
    }

    public int getId_stanowiska() {
        return id_stanowiska;
    }

    public void setId_stanowiska(int id_stanowiska) {
        this.id_stanowiska = id_stanowiska;
    }

    public String getNazwa_stanowiska() {
        return nazwa_stanowiska;
    }

    public void setNazwa_stanowiska(String nazwa_stanowiska) {
        this.nazwa_stanowiska = nazwa_stanowiska;
    }

    @Override
    public String toString() {
        return "Stanowisko{" +
                "id_stanowiska=" + id_stanowiska +
                ", nazwa_stanowiska='" + nazwa_stanowiska + '\'' +
                '}';
    }

    public Stanowisko(){

    }

}
