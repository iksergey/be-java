package org.demo.summary04_20240614.code.warehouse;

import java.util.ArrayList;
import java.util.HashSet;

class Warehouse implements WarehousePrintable {
    private HashSet<Integer> productIds; // для уникальных идентификаторов
    private ArrayList<Product> products; // для хранения самих товаров
    private Printable printer; // агрегация Printable для вывода информации

    public Warehouse(Printable printer) {
        productIds = new HashSet<>();
        products = new ArrayList<>();
        this.printer = printer;
    }

    public void addProduct(Product product) {
        if (productIds.contains(product.getId())) {
            printer.print("Товар с таким идентификатором уже существует.");
        } else {
            productIds.add(product.getId());
            products.add(product);
            printer.print("Товар успешно добавлен на склад.");
        }
    }

    public void removeProduct(int productId) {
        Product productToRemove = null;
        for (Product product : products) {
            if (product.getId() == productId) {
                productToRemove = product;
                break;
            }
        }
        if (productToRemove != null) {
            products.remove(productToRemove);
            productIds.remove(productId);
            printer.print("Товар успешно удален со склада.");
        } else {
            printer.print("Товар с указанным идентификатором не найден на складе.");
        }
    }

    public Product findProduct(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        printer.print("Товар с указанным идентификатором не найден на складе.");
        return null;
    }

    @Override
    public void printProducts() {
        for (Product product : products) {
            printer.print(product.toString());
        }
    }
}
