package processor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class ProductsList {
    private List<Product> products = new ArrayList<>();
    public void addProduct(Product product) { products.add(product); }
    public void deleteById(int id){ products.removeIf(product -> (product.getId() == id)); }
    public List<Product> getProducts() { return products; }
    public void formatProductsList(List<Product> tempProducts){ products = tempProducts; }
    public List<Product> printProductWithCost(String name, Double cost) {
        List<Product> productsByName = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equals(name)) {
                if (product.getCost() <= cost) {
                    productsByName.add(product);
                }
            }
        }
        return productsByName;
    }
    public List<Product> printProductWithTerm(LocalDate date) {
        List<Product> productsByName = new ArrayList<>();
        for (Product product : products) {
            if (product.getTerm().isAfter(date)) {
                    productsByName.add(product);
                }
            }
        return productsByName;
    }
    public void sortByTerm() { products.sort(Comparator.comparing(Product::getTerm).reversed()); }
    public void sortByCost() { products.sort(Comparator.comparing(Product::getCost)); }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Product product : products) {
            sb.append(product).append("\n");
        }
        return sb.toString();
    }
}