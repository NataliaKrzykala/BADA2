package SalonSamochodowy_BADA_projekt.SalonSamochodowyAplikacja;

public class Model {

    private int id_model;
    private String nazwa_modelu;
    private int liczba_drzwi;
    private int moc_silnika;
    private int spalanie_paliwa;
    private int pojemnosc_bagaznika;

    public Model(int id_model, String nazwa_modelu, int liczba_drzwi, int moc_silnika, int spalanie_paliwa, int pojemnosc_bagaznika) {
        this.id_model = id_model;
        this.nazwa_modelu = nazwa_modelu;
        this.liczba_drzwi = liczba_drzwi;
        this.moc_silnika = moc_silnika;
        this.spalanie_paliwa = spalanie_paliwa;
        this.pojemnosc_bagaznika = pojemnosc_bagaznika;
    }

    public int getId_model() {
        return id_model;
    }

    public void setId_model(int id_model) {
        this.id_model = id_model;
    }

    public String getNazwa_modelu() {
        return nazwa_modelu;
    }

    public void setNazwa_modelu(String nazwa_modelu) {
        this.nazwa_modelu = nazwa_modelu;
    }

    public int getLiczba_drzwi() {
        return liczba_drzwi;
    }

    public void setLiczba_drzwi(int liczba_drzwi) {
        this.liczba_drzwi = liczba_drzwi;
    }

    public int getMoc_silnika() {
        return moc_silnika;
    }

    public void setMoc_silnika(int moc_silnika) {
        this.moc_silnika = moc_silnika;
    }

    public int getSpalanie_paliwa() {
        return spalanie_paliwa;
    }

    public void setSpalanie_paliwa(int spalanie_paliwa) {
        this.spalanie_paliwa = spalanie_paliwa;
    }

    public int getPojemnosc_bagaznika() {
        return pojemnosc_bagaznika;
    }

    public void setPojemnosc_bagaznika(int pojemnosc_bagaznika) {
        this.pojemnosc_bagaznika = pojemnosc_bagaznika;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id_model=" + id_model +
                ", nazwa_modelu='" + nazwa_modelu + '\'' +
                ", liczba_drzwi=" + liczba_drzwi +
                ", moc_silnika=" + moc_silnika +
                ", spalanie_paliwa=" + spalanie_paliwa +
                ", pojemnosc_bagaznika=" + pojemnosc_bagaznika +
                '}';
    }

    public Model(){

    }
}
