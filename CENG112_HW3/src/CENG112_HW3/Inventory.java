package CENG112_HW3;



public class Inventory {
    private BinarySearchTree<Product> productTree;

    public Inventory() {
        productTree = new BinarySearchTree<>();
    }

    public void addProduct(String category, String name, int price) {
        Product product = new Product(category, name, price);
        productTree.add(product);
    }

    public Product searchProduct(String name) {
        Product dummyProduct = new Product(null, name, 0);
        return productTree.getEntry(dummyProduct);
    }

    public boolean containsProduct(String name) {
        Product dummyProduct = new Product(null, name, 0);
        return productTree.contains(dummyProduct);
    }

    public AList<Product> listProducts() {
        AList<Product> allProducts = productTree.getAllNodesInSortedOrder(); // Tüm ürünleri al

        // Ürünleri kategoriye göre, sonra isme göre sıralar
        insertionSort(allProducts);

        return allProducts;
    }

    //  AList içindeki ürünleri sıralayan metot
    private void insertionSort(AList<Product> list) {
        int n = list.getLength();
        for (int i = 2; i <= n; i++) { // Listeler 1'den başlıyor
            Product key = list.getEntry(i);
            int j = i - 1;

            // Ürünleri kategoriye göre, sonra isme göre karşılaştır
            while (j >= 1 && compareProducts(list.getEntry(j), key) > 0) {
                list.replace(j + 1, list.getEntry(j));
                j--;
            }
            list.replace(j + 1, key);
        }
    }

    // İki ürünü önce kategoriye göre, sonra isme göre karşılaştıran metot
    private int compareProducts(Product product1, Product product2) {
        int categoryComparison = product1.getCategory().compareToIgnoreCase(product2.getCategory());
        if (categoryComparison != 0) {
            return categoryComparison;
        }
        return product1.getName().compareToIgnoreCase(product2.getName());
    }
}
