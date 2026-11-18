package org.example;

import java.util.Scanner;

public class Main {
    public static void main() {
        Product product = new Product();
        PrintProduct printProduct = new PrintProduct(product);

        product.promptForData();

        // Print out the report
        System.out.println("Product Sales Report - 2026");
        System.out.println("***************************************");

        printProduct.printTotalSales();
        printProduct.printAverageSales();
        printProduct.printMostPopularProduct();


    }
}
