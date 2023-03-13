package processor;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
public class Product implements Serializable, Comparable<Product> {
    private int id;
    private String name;
    private String manufacturer;
    private double cost;
    private LocalDate term;
    private int count;
    private  static int uid = 0;
    public Product(String name, String manufacturer, double cost, LocalDate term, int count) {
        uid++;
        this.id = uid; this.name = name; this.manufacturer = manufacturer;
        this.cost = cost; this.term = term; this.count = count;
    }
    public Product() {}
    public void setID(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    public void setCost(double cost) { this.cost = cost; }
    public void setTerm(LocalDate term) { this.term = term; }
    public void setCount(int count) { this.count = count; }
    public int getId() { return id; }
    public String getName() { return name; }
    public String getManufacturer() { return manufacturer; }
    public double getCost() { return cost; }
    public LocalDate getTerm() { return term; }
    public int getCount() { return count; }
    @Override
    public String toString() {
        return  "\t[id|"+ id +
                "]\tНазва = \t'" + name + '\'' +
                "  \tВиробник = '" + manufacturer + '\'' +
                "   \t Цiна = " + cost +
                "  \tТермін = '" + term + '\'' +
                "  \tКількість = " + count;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return
                id == product.id &&
                cost == product.cost &&
                count == product.count &&
                Objects.equals(name, product.name);
    }
    @Override
    public int compareTo(Product o) { return Double.compare(cost, o.getCost()); }
}