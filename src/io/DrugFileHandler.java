package io;

import entities.Drug;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DrugFileHandler {
    private static final String FILE_PATH = "data/drugs.txt";

    public static void saveDrug(Drug drug) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(drug.toString());
            writer.newLine();
            System.out.println("Drug saved to file.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static List<Drug> readDrugs() {
        List<Drug> drugs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                drugs.add(Drug.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return drugs;
    }
}
