import java.io.FileWriter;
import java.io.IOException;

public class Pizza {
    private int basePrice;
    private boolean veg;

    private int extraCheesePrice = 100;
    private int extraToppingsPrice = 150;
    private int takeAwayPrice = 20;

    private boolean isExtraCheeseAdded = false;
    private boolean isExtraToppingsAdded = false;
    private boolean isTakeAwayOpted = false;

    public Pizza(boolean veg) {
        this.veg = veg;
        if (veg) {
            this.basePrice = 300; // Veg Pizza base price
        } else {
            this.basePrice = 400; // Non-Veg Pizza base price
        }
    }

    public void addExtraCheese() {
        isExtraCheeseAdded = true;
    }

    public void addExtraToppings() {
        isExtraToppingsAdded = true;
    }

    public void takeAway() {
        isTakeAwayOpted = true;
    }

    public int calculateTotal() {
        int total = basePrice;
        if (isExtraCheeseAdded) total += extraCheesePrice;
        if (isExtraToppingsAdded) total += extraToppingsPrice;
        if (isTakeAwayOpted) total += takeAwayPrice;
        return total;
    }

    public String getBill(int pizzaNumber) {
        StringBuilder bill = new StringBuilder();
        bill.append("Pizza " + pizzaNumber + " (" + (veg ? "Veg" : "Non-Veg") + ")\n");
        bill.append("Base Price: ₹" + basePrice + "\n");
        if (isExtraCheeseAdded) bill.append("Extra Cheese: ₹" + extraCheesePrice + "\n");
        if (isExtraToppingsAdded) bill.append("Extra Toppings: ₹" + extraToppingsPrice + "\n");
        if (isTakeAwayOpted) bill.append("Takeaway: ₹" + takeAwayPrice + "\n");
        bill.append("Subtotal: ₹" + calculateTotal() + "\n");
        bill.append("---------------------------------\n");
        return bill.toString();
    }

    public static void saveBillToFile(String fullBill) {
        try (FileWriter writer = new FileWriter("PizzaBill.txt", true)) {
            writer.write(fullBill + "\n\n");
            System.out.println("✅ Bill saved to PizzaBill.txt");
        } catch (IOException e) {
            System.out.println("⚠️ Error saving bill: " + e.getMessage());
        }
    }
}
