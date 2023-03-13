package main;
import io.*;
import ui.*;
import processor.ProductsList;
import java.util.Scanner;
public class Main {
    public static final String fileNameTXT = "product.txt";
    public static final String fileNameJson = "product.json";
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
    private void run() {
        UI ui = new UIProducts();
        IO io = new IOProcessor();
        ProductsList products = new ProductsList();
        Scanner scanner = new Scanner(System.in);
        boolean status = true;
        menu();
        while (status) {
            int option = scanner.nextInt();
            switch (option) {
                case -1 -> menu();
                case 0 -> status = false;
                case 1 -> io.writeToTXT(products, fileNameTXT);
                case 2 -> products.formatProductsList(io.readFromTXT(fileNameTXT));
                case 3 -> io.writeToJson(products, fileNameJson);
                case 4 -> products.formatProductsList(io.readFromJson(fileNameJson));
                case 5 -> ui.fillProductArray(products);
                case 6 -> ui.addNewProduct(scanner,products);
                case 7 -> ui.delProductByID(scanner,products);
                case 8 -> ui.showProducts(products.getProducts());
                case 9 -> ui.printProductWithSortTerm(products);
                case 10 -> ui.printProductWithCost(scanner,products);
                case 11 -> ui.printProductWithTerm(scanner,products);
                case 12 -> ui.printProductWithSortCost(products);
            }
            System.out.print(": ");
        }
    }
    private void menu() {
        System.out.print("""
                            ======================== ========================
                            Выберите пункт из меню:
                            [0] - Завершити програму.
                            [1] - Зберігання даних у txt файл.      [2] - Зчитування з txt файлу.
                            [3] - Зберігання даних у json файл.     [4] - Зчитування з json файлу.
                            [5] - Зчитування з коду.
                            [6] - Додати новий продукт.             [7] - Вилучити по ID.
                            [8] - Вивести весь список продуктів.
                            [9] - Вивести список продуктів в порядку спадання терміну зберігання.
                            [10] - Вивести список продуктів для заданого найменування, ціна яких не перевищує задану.
                            [11] - Вивести список товарів, термін зберігання яких більше заданого.
                            [12] - Вивести список продуктів впорядкованих за зростанням вартості.
                         : """);
    }
}