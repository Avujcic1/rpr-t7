package ba.unsa.rpr.tutorijal7;

public class Drzava {

    private int brojStanovnika;
    private String naziv = new String();
    private double povrsina;
    private String jedinicaPovrsine = new String();
    private Grad glavniGrad = new Grad();

    public Drzava() {}

    public Grad getGlavniGrad() {
        return glavniGrad;
    }

    public String getJedinicaPovrsine() {
        return jedinicaPovrsine;
    }

    public void setGlavniGrad(Grad glavniGrad) {
        this.glavniGrad = glavniGrad;
    }

    public void setJedinicaPovrsine(String jedinicaPovrsine) {
        this.jedinicaPovrsine = jedinicaPovrsine;
    }

    public double getPovrsina() {
        return povrsina;
    }

    public void setPovrsina(double povrsina) {
        this.povrsina = povrsina;
    }

    public int getBrojStanovnika() {
        return brojStanovnika;
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
