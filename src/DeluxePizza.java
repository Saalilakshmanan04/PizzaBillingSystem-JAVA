public class DeluxePizza extends Pizza {
    public DeluxePizza(boolean veg) {
        super(veg);
        addExtraCheese();
        addExtraToppings();
    }
}
