package com.example.model;

import com.example.tax.BasicTax;

import java.util.ArrayList;
import java.util.List;

public class PurchasedProducts {

    private List<Product> products;
    private double total;
    private BasicTax basicTax;


    public PurchasedProducts(String productList) {
        products = new ArrayList<>();

        for (String pDetails : productList.split("\n")) {
            boolean isImported = pDetails.contains("imported");
            pDetails = pDetails.replace("imported", "").trim();
            String[] productDetails = pDetails.split(" ");
            products.add(new Product(productDetails[0], Double.parseDouble(productDetails[1]), isImported));

        }
        total = new Float(0);
        basicTax = new BasicTax();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotal() {
        double totalAll = 0;
        for (Product product : products) {
            totalAll += product.getPrice();
        }
        return totalAll + getTotalSalesTax();
    }

    public double getTotalSalesTax() {
        double totalAll = 0;
        for (Product product : products) {
            totalAll += basicTax.calculateBasicTax(product)+ basicTax.calculateImportedTax(product);;
        }
        return totalAll;
    }

}
