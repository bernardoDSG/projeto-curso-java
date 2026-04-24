package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

import model.entities.Product;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        String pathI = "C:\\Users\\12068496739\\Documents\\ioJava.csv";
        String pathO = "C:\\Users\\12068496739\\Documents\\out";
        new File(pathO).mkdir();
        Product[] products = new Product[4];
        try (BufferedReader br = new BufferedReader(new FileReader(pathI));
                BufferedWriter bw = new BufferedWriter(new FileWriter(pathO + "\\summary.csv"))) {
            products = fillArrayProducts(products, br);
            writeSummary(products, bw);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static Product[] fillArrayProducts(Product[] vetProducts, BufferedReader br) throws IOException {
        String line = br.readLine();
        for (int i = 0; line != null && i < vetProducts.length; i++) {
            String[] fields = line.split(",");
            String name = fields[0];
            double price = Double.parseDouble(fields[1]);
            int quantity = Integer.parseInt(fields[2]);
            vetProducts[i] = new Product(name, price, quantity);
            line = br.readLine();
        }
        return vetProducts;
    }
    public static void writeSummary(Product[] vetProducts, BufferedWriter bw) throws IOException {
        for (Product product : vetProducts) {
            bw.write(product.toString());
            bw.newLine();
        }
    }

}
