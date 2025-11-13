import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {

    public void placeOrder() {
        Scanner sc = new Scanner(System.in);
        List<Pizza> pizzas = new ArrayList<>();

        System.out.println("🍕 Welcome to Java Pizza Billing System 🍕");
        System.out.print("Enter number of pizzas you want to order: ");
        int totalPizzas = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= totalPizzas; i++) {
            System.out.println("\n--- Pizza " + i + " Details ---");

            System.out.print("Veg or Non-Veg? (veg/nonveg): ");
            String type = sc.nextLine().toLowerCase();
            boolean veg = type.equals("veg");

            System.out.print("Do you want Deluxe Pizza? (yes/no): ");
            String deluxe = sc.nextLine().toLowerCase();

            Pizza pizza;
            if (deluxe.equals("yes")) {
                pizza = new DeluxePizza(veg);
            } else {
                pizza = new Pizza(veg);
            }

            System.out.print("Add Extra Cheese? (yes/no): ");
            if (sc.nextLine().equalsIgnoreCase("yes")) pizza.addExtraCheese();

            System.out.print("Add Extra Toppings? (yes/no): ");
            if (sc.nextLine().equalsIgnoreCase("yes")) pizza.addExtraToppings();

            System.out.print("Opt for Takeaway? (yes/no): ");
            if (sc.nextLine().equalsIgnoreCase("yes")) pizza.takeAway();

            pizzas.add(pizza);
        }

        // Generate final combined bill
        int grandTotal = 0;
        StringBuilder fullBill = new StringBuilder("\n=========== Final Bill ===========\n");

        for (int i = 0; i < pizzas.size(); i++) {
            fullBill.append(pizzas.get(i).getBill(i + 1));
            grandTotal += pizzas.get(i).calculateTotal();
        }

        fullBill.append("Grand Total: ₹" + grandTotal + "\n");
        fullBill.append("==================================\n");

        System.out.println(fullBill);
        Pizza.saveBillToFile(fullBill.toString());
    }
}

