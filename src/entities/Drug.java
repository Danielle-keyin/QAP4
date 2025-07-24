package entities;

public class Drug {
    private int drugId;
    private String drugName;
    private double drugCost;
    private String dosage;

    public Drug(int drugId, String drugName, double drugCost, String dosage) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.drugCost = drugCost;
        this.dosage = dosage;
    }

    public int getDrugId() { return drugId; }
    public String getDrugName() { return drugName; }
    public double getDrugCost() { return drugCost; }
    public String getDosage() { return dosage; }

    @Override
    public String toString() {
        return drugId + "," + drugName + "," + drugCost + "," + dosage;
    }

    // Static method to parse from a CSV line
    public static Drug fromString(String line) {
        String[] parts = line.split(",");
        return new Drug(
            Integer.parseInt(parts[0]),
            parts[1],
            Double.parseDouble(parts[2]),
            parts[3]
        );
    }
}
