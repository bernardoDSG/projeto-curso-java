package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

import model.entities.Product;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        String pathI = "C:\\Users\\12068496739\\Documents\\ioJava.csv";
        Product[] products = new Product[4];
        try (BufferedReader br = new BufferedReader(new FileReader(pathI))) {
            String line = br.readLine();
            int i = 0;
            while (line != null && i < 4) {
                String[] data = line.split(",");
                products[i] = new Product(data[0], Double.parseDouble(data[1]), Integer.parseInt(data[2]));
                i++;
                line = br.readLine();
            }

        } 
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        
            System.out.println("Directory created successfully!");
            String pathO = pathI + "\\out\\summary.csv";
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathO))) {
                for (Product product : products) {
                    bw.write(product.toString());
                    bw.newLine();
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
          

    }

}
