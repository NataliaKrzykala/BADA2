package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

public class Poczta {

    private int id_poczta;
    private String kod_poczty;
    private String poczta;

    public Poczta(int id_poczta, String kod_poczty, String poczta) {
        this.id_poczta = id_poczta;
        this.kod_poczty = kod_poczty;
        this.poczta = poczta;
    }

    public int getId_poczta() {
        return id_poczta;
    }

    public void setId_poczta(int id_poczta) {
        this.id_poczta = id_poczta;
    }

    public String getKod_poczty() {
        return kod_poczty;
    }

    public void setKod_poczty(String kod_poczty) {
        this.kod_poczty = kod_poczty;
    }

    public String getPoczta() {
        return poczta;
    }

    public void setPoczta(String poczta) {
        this.poczta = poczta;
    }

    @Override
    public String toString() {
        return "Poczta{" +
                "id_poczta=" + id_poczta +
                ", kod_poczty='" + kod_poczty + '\'' +
                ", poczta='" + poczta + '\'' +
                '}';
    }

    public Poczta(){

    }
}
