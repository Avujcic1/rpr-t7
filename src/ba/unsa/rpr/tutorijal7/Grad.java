package ba.unsa.rpr.tutorijal7;

class Grad {

    private String naziv = new String();
    private int brojStanovnika;
    private double[] temperature = new double[1000];

    public Grad() {}

    public double[] getTemperature() {
        return temperature;
    }

    public int getBrojStanovnika() {
        return brojStanovnika;
    }

    public void setTemperature(double[] temperature) {
        this.temperature = temperature;
    }

    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika = brojStanovnika;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
