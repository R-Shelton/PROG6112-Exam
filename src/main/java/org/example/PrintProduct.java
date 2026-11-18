package org.example;

public class PrintProduct {

    private final Product product;

    public PrintProduct(Product product) {
        this.product = product;
    }

    public void printTotalSales() {
        System.out.println("Total Product Sales: " + product.getTotalProductsSold());
    }

    public void printAverageSales() {
        System.out.println("Average Product Sales: " + product.getAverageProductSold());
    }

    public void printMostPopularProduct() {
        //System.out.println("Most Popular Product: " + companies[companyIndex] + "(" + max + ")");
        System.out.println("Most Popular Product: " + product.getMostPopularProduct());
    }
}
