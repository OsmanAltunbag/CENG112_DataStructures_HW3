package CENG112_HW3;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        try {
            FileIO.readCSV("CENG112_HW3/Resources/products1.csv", inventory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
// Osman Altunbağ-  Zübeyr Almaho - Yunus Emre Sapan