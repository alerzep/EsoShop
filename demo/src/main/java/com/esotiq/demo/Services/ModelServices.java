package com.esotiq.demo.Services;
import com.esotiq.demo.models.Model;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ModelServices {

    private File file;
    private Scanner scanner;
    private List<Model> models = new ArrayList<>();

    public ModelServices() throws FileNotFoundException {
        this.file = new File("C:\\Users\\48665\\Downloads\\demo\\demo\\src\\main\\java\\com\\esotiq\\demo\\plik.txt");
        this.scanner = new Scanner(file);
        getAllModels();
    }

    public List<Model> getAllModels() {

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
           // do {
                String example = line;
                if (example.startsWith("Indeks tow.Nazwa kat. indeksuSuma IloœciSuma Wart. C.S.N.Suma Wart. C.S.B.")) {
                    example = example.replaceAll("Indeks tow.Nazwa kat. indeksuSuma IloœciSuma Wart. C.S.N.Suma Wart. C.S.B.", "");
                }
                if (example.contains("Wydrukowano")) {
                    example = example.replaceAll("(Wydrukowano).*", "");
                }


                Model modelExample = new Model();

                String[] examples;
                examples = example.split("-");
                // model

                modelExample.setModel(examples[0]);
                //kolor

                modelExample.setColour(examples[1]);
                example = examples[2];
// rozmiar
                if (example.startsWith("S") || example.startsWith("M") || example.startsWith("L")) {
                    modelExample.setSize(example.substring(0, 1));
                    example = example.substring(1);
                }
                if (example.startsWith("XL")) {
                    modelExample.setSize(example.substring(0, 2));
                    example = example.substring(2);
                }
                if (example.startsWith("XXL")) {
                    modelExample.setSize(example.substring(0, 3));
                    example = example.substring(3);
                }
// pattern na rozmiar stanika
                Pattern patternSize = Pattern.compile("[6-9]{1}[05]{1}[A-H]{1}.*");
                Matcher matcher = patternSize.matcher(example);
                if (matcher.matches()) {
                    modelExample.setSize(example.substring(0, 3));
                    example = example.substring(3);
                }
                // kategoria
                examples = example.split(" ");

                modelExample.setCategory(examples[0]);
                // ceny ilosc
         /*   Pattern patternPrice = Pattern.compile(".*( )([A-Z]+)([0-9]+)[,]{1}[0]{2}[0-9]+[,]{1}[0-9]{2}[0-9]+[,]{1}[0-9]{2}");
            Matcher matcher1 = patternPrice.matcher(example);
            System.out.println("=================================================");
            System.out.println("matcher1");
            System.out.println(matcher1);
            System.out.println("=================================================");
*/

                examples = example.split(",");


// ustwienie ceny brutto
                String zloty = examples[examples.length - 2];
                String grosz = examples[examples.length - 1];
                zloty = zloty.substring(2);
                grosz = grosz.substring(0, 2);
                String price = zloty + "." + grosz;
                modelExample.setPriceBrutto(Double.valueOf(price));

                zloty = examples[examples.length - 3];
                grosz = examples[examples.length - 2];

                // cena netto
                zloty = zloty.substring(2);
                grosz = grosz.substring(0, 2);
                price = zloty + "." + grosz;
                modelExample.setPriceNetto(Double.valueOf(price));

                // ilosc
                examples = examples[0].split("[^0-9]+");
                String quantity = examples[examples.length - 1];
                modelExample.setQuantity(Integer.valueOf(quantity));
                models.add(modelExample);

         /*       String examplelines = example.substring(0, example.length() - 5);
                String[] lines = line.split(examplelines);
                line = lines[1];
            }
            while (!(line.isEmpty()));*/

        }

        return models;
    }

}
