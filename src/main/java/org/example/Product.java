package org.example;

import java.util.Scanner;

public class Product implements IProduct{

    private String[] companies = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
    private int[][] salesOverMonths = new int[3][3];
    private int totalSales = 0;
    private int companyIndex = 0;
    private int salesIndex = 0;
    private int max = 0;

    public void promptForData() {
        Scanner scanner = new Scanner(System.in);

        // loop over the 2-D array and prompt the user for sales input for each of the companies
        for (int i = 0; i < companies.length; i ++) {
            for (int j = 0; j < salesOverMonths.length; j++) {
                System.out.println("Enter the number of sales for month " + (j + 1) + " for " + companies[i] + " mattress:");
                int sales = scanner.nextInt();

                // simply assign the index of the company for each month in the array
                salesOverMonths[j][i] = sales;
            }
        }

        // close the scanner, saves stack/heap resources and prevents memory leaks.
        scanner.close();

        calculateValues();
    }

    public void calculateValues() {
        // Loop over the array and calulate our values, take note of the last company's index to determine the most popular product
        for (int i = 0; i < companies.length; i ++) {
            for (int j = 0; j < salesOverMonths.length; j++) {
                if (salesOverMonths[j][i] > max) {
                    companyIndex = i;
                    salesIndex = j;
                    max = salesOverMonths[j][i];
                }
                totalSales += salesOverMonths[j][i];
            }
        }
    }

    @Override
    public int getTotalProductsSold() {
        return totalSales;
    }

    @Override
    public double getAverageProductSold() {
        // Loop over the array and calulate our values, take note of the last company's index to determine the most popular product
        return (double) getTotalProductsSold() / (companies.length * salesOverMonths.length);
    }

    @Override
    public String getMostPopularProduct() {
        return companies[companyIndex] + "(" + salesOverMonths[salesIndex][companyIndex] + ")";
    }

    // Used for tests
    public void setCompanies(String[] companies) {
        this.companies = companies;
    }

    // used for tests
    public void setSalesOverMonths(int[][] salesOverMonths) {
        this.salesOverMonths = salesOverMonths;
    }
}
