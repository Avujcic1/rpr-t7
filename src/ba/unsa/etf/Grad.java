package ba.unsa.etf;

class Grad {

    private String naziv = new String();
    private int broj_stanovnika;
    private double[] temperature = new double[1000];

    public Grad() {}

    public double[] getTemperature() {
        return temperature;
    }

    public int getBroj_stanovnika() {
        return broj_stanovnika;
    }

    public void setTemperature(double[] temperature) {
        this.temperature = temperature;
    }

    public void setBroj_stanovnika(int broj_stanovnika) {
        this.broj_stanovnika = broj_stanovnika;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
