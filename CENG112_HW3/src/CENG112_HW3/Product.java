package CENG112_HW3;



public class Product implements Comparable<Product> {
    private String category;
    private String name;
    private int price;

    public Product(String category, String name, int price) {
        this.category = category != null ? category.trim() : null;
        this.name = name.trim();
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(Product other) {
        if (this.name.equalsIgnoreCase(other.name)) {
            return 0;
        }
        return this.name.compareToIgnoreCase(other.name);}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return name.equalsIgnoreCase(product.name);
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return name + " (" + category + "): " + price + "₺";
    }
}
