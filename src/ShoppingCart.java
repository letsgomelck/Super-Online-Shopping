package assessment2;

import java.util.Scanner;

public class ShoppingCart {
    private String customerName;
    private String currentDate;
    private static final int CAPACITY = 100;
    private ItemToPurchase[] cartItems;
    private int numItems;


//    public ShoppingCart(String name, String date){
//        this.customerName = name;
//        this.currentDate = date;
//        this.cartItems = new ItemToPurchase[CAPACITY];
//        this.numItems = 0;
//    }

    public ShoppingCart(){
        this.customerName = "John Doe";
        this.currentDate = "1 January 2021";
        this.cartItems = new ItemToPurchase[CAPACITY];
        this.numItems = 0;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCurrentDate(String date){
        this.currentDate = date;
    }

    public int getNumItems(){
        return numItems;
    }

    public void setNumItems(int count){
        numItems = count;
    }

    public ItemToPurchase[] getCartItems(){
        return cartItems;
    }

    public boolean addItem(ItemToPurchase item){
        if (numItems == CAPACITY){
            System.out.println("SHOPPING CART IS FULL.");
            return false;
        }else{
            for (int i = 0; i < numItems; i++){
                if (cartItems[i].getName().equals(item.getName())){
                    System.out.println("ITEM ALREADY EXISTS.");
                    return false;
                }
            }
            cartItems[numItems++] = item;
            return true;
        }
    }

    public int getNumItemsInCart(){
        int count = 0;
        for (int i = 0; i < numItems; i++){
            count += cartItems[i].getQuantity();
        }
        return count;
    }

    public int getCostOfCart(){
        int sum = 0;
        for (int i=0; i < numItems; i++){
            sum += cartItems[i].getTotalPrice();
        }
        return sum;
    }

    public void removeItem(String itemName){
        for (int i = 0; i < numItems; i++){
            if (cartItems[i].getName().equals(itemName)){
                for (int j = i; j < numItems - 1; j++){
                    cartItems[j] = cartItems[j+1];

                }
                numItems --;
                System.out.println("Item " + itemName + " is removed from shopping cart.");
                return;
            }
        }
        System.out.println("Item not found in cart. Nothing removed.");
    }

    public void modifyItem(String itemName){
        for (int i = 0; i < numItems; i++){
            if (cartItems[i].getName().equals(itemName)){
                System.out.println("Please enter the new quantity: ");
                Scanner scanner = new Scanner(System.in);
                int quantity = scanner.nextInt();
                cartItems[i].setQuantity(quantity);
                return;
            }
        }
        System.out.println("Item not found in cart. Nothing modified");
    }

    public void checkout(){
        if (numItems > 0) {
            this.printTotal();
            for (int i = 0; i < numItems; i++){
                cartItems[i] = null;
            }
            numItems = 0;
            System.out.println("Thanks for shopping.");
            return;
        }
        System.out.println("SHOPPING CART IS EMPTY.");

    }

    public void printTotal(){
        System.out.println(customerName + " - " + currentDate);
        if (numItems > 0) {
            System.out.println("Number of Items: " + getNumItemsInCart());
            for (int i = 0; i < numItems; i++) {
                System.out.println(cartItems[i]);
            }
            System.out.println("Total: $" + getCostOfCart());
        }else{
            System.out.println("SHOPPING CART IS EMPTY.");
        }
    }

}
