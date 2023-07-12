package com.mjc.stage2;

import java.util.List;
import java.util.stream.Collectors;

public class ShopStock {
    private final List<Product> productList;

    public ShopStock(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> executeFilteringStrategy(FilteringStrategy filteringStrategy) {
        List newList = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            newList.add(filteringStrategy.filter(productList.get(i)));
        }
        System.out.println(newList);
        return newList;
    }
}
