package assessment2;

import java.util.Scanner;

public class VIPShoppingCart extends ShoppingCart{
    private int numPoints;
    public VIPShoppingCart(){
        super();
        numPoints = 0;
    }
//    public VIPShoppingCart(String name, String date, int points){
//        super(name, date);
//        numPoints = points;
//    }
    public void setPoints(int points){
        numPoints = points;
    }
    public int getDiscountedPrice(){
        if (getCostOfCart() > 100) {
            return (int) (0.95 * super.getCostOfCart());
        }else{
            return getCostOfCart();
        }
    }

    public void checkout(){
        if (getNumItems() > 0) {
            this.printTotal();
            System.out.println();
            int priceToPay = getDiscountedPrice();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you want to redeem points to pay? Y/N");
            if (scanner.nextLine().equals("Y")){
                System.out.println("How many points do you want to redeem? Enter -1 to quit redeeming points.");
                int points = scanner.nextInt();
                while (points % 50 != 0 || points > this.numPoints){
                    if (points % 50 != 0) {
                        System.out.println("You must enter a number that is multiples of 50! Please re-enter. Enter -1 to quit redeeming points.");
                    }else{
                        System.out.println("You don't have enough points. Please re-enter. Enter -1 to quit redeeming points.");
                    }
                    points = scanner.nextInt();
                }
                System.out.println("Redeeming " + points + " points.");
                this.numPoints -= points;
                priceToPay = getDiscountedPrice() - points / 50;

            }
            System.out.println("Total price paid: $" + priceToPay);
            System.out.println("Congratulations! You have collected " + priceToPay + " points.");
            for (int i = 0; i < getNumItems(); i++){
                getCartItems()[i] = null;
            }
            setNumItems(0);
            System.out.println("Thanks for shopping.");
            return;
        }
        System.out.println("SHOPPING CART IS EMPTY.");
    }

    public void printTotal(){
        super.printTotal();
        if (getNumItems() > 0) {
            System.out.println("Price after discount 5% off: $" + getDiscountedPrice());
        }
    }

}
