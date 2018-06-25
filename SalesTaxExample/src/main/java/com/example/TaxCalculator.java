package com.example;

import com.example.model.PurchasedProducts;

public class TaxCalculator {

    public static void main(String[] args) {

        String case1 = "book 12.49\n" +
                "music 14.99\n" +
                "food 0.85";

        String case2 = "imported book 10.00\n" +
                "imported perfume 47.50\n";

        String case3 = "imported perfume 27.99\n" +
                "perfume 18.99\n" +
                "medical 9.75\n" +
                "imported food 11.25\n";

        PurchasedProducts purchasedProducts = new PurchasedProducts(case1);
        System.out.println(purchasedProducts.getTotal());
        purchasedProducts = new PurchasedProducts(case3);
        System.out.println(purchasedProducts.getTotal());
        System.out.println(purchasedProducts.getTotalSalesTax());

    }
}
