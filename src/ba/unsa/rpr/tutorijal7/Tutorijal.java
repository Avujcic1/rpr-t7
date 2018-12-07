package ba.unsa.rpr.tutorijal7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Tutorijal {

    static ArrayList<Grad> ucitajGradove(){

        Scanner input;
        try {
            input = new Scanner(new FileReader("Mjerenja.txt"));
        }catch(FileNotFoundException ex){
            System.out.println("Greska: " + ex);
            return null;
        }

        ArrayList<String> test = new ArrayList<String>();

        while(input.hasNext()){
            test.add(input.nextLine());
        }

        ArrayList<Grad> gradovi = new ArrayList<Grad>();
        for (String it : test) {
            Grad grad = new Grad();
            double[] temp = new double[1000];
            String[] nazivGrada = it.split(",");
            if (nazivGrada.length >= 1000) {
                System.out.println("Prekoracen limit niza temperatura!");
                return null;
            }

            grad.setNaziv(nazivGrada[0]);
            for (int i=1; i<nazivGrada.length; i++) {
                try {
                    temp[i-1] = Double.valueOf(nazivGrada[i]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    return null;
                }
            }

            grad.setTemperature(temp);
            gradovi.add(grad);
        }

        input.close();
        return gradovi;
    }

    static ArrayList<Drzava> ucitajXml() {

    }

    public static void main(String[] args) {
        ArrayList<Grad> gradovi = ucitajGradove();

        for (Grad g : gradovi) {
            System.out.print("Naziv grada: " + g.getNaziv() + ", Broj stanovnika: " + g.getBrojStanovnika() + ", Temperature: ");
            for (double x : g.getTemperature()) {
                if (x != 0) System.out.print(x + " ");
            }
            System.out.print("\n");
        }
    }
}
