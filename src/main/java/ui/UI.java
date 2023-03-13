package ui;
import processor.*;
import java.util.*;
public interface UI {
    void addNewProduct(Scanner scanner, ProductsList products);
    void delProductByID(Scanner scanner, ProductsList products);
    void fillProductArray(ProductsList products);
    void showProducts(List<Product> products);
    void printProductWithCost(Scanner scanner, ProductsList products);
    void printProductWithSortCost(ProductsList products);
    void printProductWithTerm(Scanner scanner, ProductsList products);
    void printProductWithSortTerm(ProductsList products);
}