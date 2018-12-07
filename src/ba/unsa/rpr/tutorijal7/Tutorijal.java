package ba.unsa.rpr.tutorijal7;

import org.w3c.dom.*;

import javax.swing.text.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.beans.XMLEncoder;
import java.io.*;
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


    static UN ucitajXml(ArrayList<Grad> gradovi){

        UN drzave = new UN ();
        ArrayList<Drzava> listaDrzava = new ArrayList<Drzava>();
        Document doc = null;

        try {
            DocumentBuilder docReader = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            doc = docReader.parse(new File("drzave.xml"));
        } catch (Exception e) {
            System.out.println("drzave.xml nije validan XML dokument");
        }

        NodeList xmlDrzave = doc.getChildNodes();
        for(int i=0; i<xmlDrzave.getLength(); i++){
            Node temp = xmlDrzave.item(i);
            if(temp instanceof Element){

                String stanovnici = ((Element) temp).getAttribute("stanovnika");
                String nazivDrzave = ((Element) temp).getAttribute("naziv");
                String jedinicaPovrsine = ((Element) temp).getAttribute("jedinica");

                Grad glavni = new Grad();
                Drzava tempDrzave = new Drzava();

                tempDrzave.setBrojStanovnika(Integer.parseInt(String.valueOf(stanovnici)));
                tempDrzave.setNaziv(String.valueOf(nazivDrzave));
                tempDrzave.setGlavniGrad(glavni);
                tempDrzave.setJedinicaPovrsine(String.valueOf(jedinicaPovrsine));

                listaDrzava.add(tempDrzave);
            }
        }
        drzave.setDrzave(listaDrzava);
        return drzave;
    }


    static void zapisiXml(UN drzave){

        try {
            XMLEncoder temp = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("un.xml")));
            temp.writeObject(drzave);
            temp.close();
        } catch(Exception e) {
            System.out.println("Greška: " + e);
        }
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
