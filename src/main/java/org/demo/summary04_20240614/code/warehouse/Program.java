package org.demo.summary04_20240614.code.warehouse;

public class Program {
    public static void main(String[] args) {
        // Пример использования

        // Создаем склад и передаем консольный принтер
        Warehouse warehouse = new Warehouse(new ConsolePrinter());

        // Добавляем несколько товаров
        warehouse.addProduct(new Product(1, "Товар 1", 100.0));
        warehouse.addProduct(new Product(2, "Товар 2", 200.0));
        warehouse.addProduct(new Product(3, "Товар 3", 300.0));

        // Выводим все товары на складе
        warehouse.printProducts();

        // Поиск товара по идентификатору
        int productIdToFind = 2;
        Product foundProduct = warehouse.findProduct(productIdToFind);
        if (foundProduct != null) {
            System.out.println("Найден товар: " + foundProduct);
        }

        // Удаляем товар
        int productIdToRemove = 3;
        warehouse.removeProduct(productIdToRemove);

        // Выводим обновленный список товаров
        warehouse.printProducts();
    }
}
