package ps.decoratorpattern07;

import java.util.function.Function;

public class BurgerShop {

    private Function<Burger, Burger> decoration;

    public BurgerShop(Function<Burger, Burger> decoration) {
        this.decoration = decoration;
    }

    public Burger use(Burger baseBurger) {
        System.out.println("Base Burger: " + baseBurger.burgerType);
        return decoration.apply(baseBurger);
    }
    public Burger orderBurger(Burger baseBurger) {
        System.out.println("Base Burger: " + baseBurger.getBurgerType());
        Burger decoratedBurger = decoration.apply(baseBurger);
        System.out.println("I get " + decoratedBurger.getBurgerType());
        return decoratedBurger;
    }

    public static void main(String[] args) {
        // Create a base burger
        Burger baseBurger = new Burger("burger");

       
        Function<Burger, Burger> addVeggies = burger -> {
            System.out.println("Adding veggies to the burger");
            
            Burger burg=new Burger(burger.getBurgerType() + " Veggie");
           
            return burg;
        };
        

        
        Function<Burger, Burger> addCheese = burger -> {
            System.out.println("Adding cheese to the burger");
            return new Burger(burger.getBurgerType() + " Cheese");
        };

        // Create a BurgerShop with addVeggies and addCheese decoration
        BurgerShop veggieCheeseBurgerShop = new BurgerShop(addVeggies.andThen(addCheese));
        
        veggieCheeseBurgerShop.orderBurger(baseBurger);
}
}