package io;
import processor.Product;
import processor.ProductsList;
import java.util.List;
public interface IO {
    void writeToTXT(ProductsList products, String fileName);
    List<Product> readFromTXT(String fileName);
    void writeToJson(ProductsList products, String fileName);
    List<Product> readFromJson(String fileName);
}