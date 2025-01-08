package CENG112_HW3;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FileIO {
    public static void readCSV(String filePath, Inventory inventory) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String command = parts[0].trim();

            switch (command) {
                case "add":
                    String category = parts[1].trim();
                    String name = parts[2].trim();
                    int price = Integer.parseInt(parts[3].trim());
                    inventory.addProduct(category, name, price);
                    System.out.println("Adding:\n	" + name + " (" + category + "): " + price + "₺");
                    break;
                case "search":
                    name = parts[1].trim();
                    Product foundProduct = inventory.searchProduct(name);
                    if (foundProduct != null) {
                        System.out.println("Searching:\n	"+"Found: " + foundProduct);
                    } else {
                        System.out.println("	Not Found: " + name);
                    }
                    break;
               
                case "list":
                    AList<Product> products = inventory.listProducts();
                    System.out.println("Listing:");
                    for (int i = 1; i <= products.getLength(); i++) {
                        System.out.println("	" + products.getEntry(i));
                    }
                    break;
                default:
                    System.out.println("Invalid command: " + command);
            }
        }
        reader.close();
    }
}
