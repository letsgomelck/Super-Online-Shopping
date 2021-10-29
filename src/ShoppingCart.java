import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class ShoppingCart {
    // private fields
    private String customerName;
    private String currentDate;
    private ItemToPurchase[] cartItems;
//    private ItemToPurchase[] cartItems = new ItemToPurchase[CAPACITY];
    private static final int CAPACITY = 100;
    private int itemCount;
    // No-argument Constructor
    public ShoppingCart(){
        this.customerName="John Doe";
        this.currentDate="1 January 2021";
        this.cartItems=new ItemToPurchase[CAPACITY];
        this.itemCount=0;
    }
    // Constructor
    public ShoppingCart(String name,String date){
        this.customerName=name;
        this.currentDate=date;
        this.cartItems=new ItemToPurchase[CAPACITY];
        this.itemCount=0;
    }
    // Accessor
    public String getCustomerName(){
        return customerName;
    }
    // Mutator
    public void setCustomerName(String name){
        this.customerName=name;
    }

    // Accessor
    public String getDate(){
        return currentDate;
    }
    // Mutator
    public void setDate(String date){
        this.currentDate=date;
    }

    // Method to add items
    public boolean addItem(ItemToPurchase item){
        if(!(Objects.equals(item.getItemName(), Arrays.toString(cartItems)))) {
                cartItems[itemCount++]=item;
                return true;
            }else if(itemCount > CAPACITY){
                // else if shopping cart is full,
                // items cannot be added and print" SHOPPING CART IS FULL." and return false.
                System.out.println("SHOPPING CART IS FULL");
                return false;
            }else{
                // Otherwise,add item to shopping cart and returns true.
                System.out.println("ITEM ALREADY EXISTS.");
                return false;
            }
    }
    public int getNumItemsInCart() {
        int NumItems=0;
        for (int i=0;i<cartItems.length;i++){
//            ItemToPurchase item=cartItems.at(i);
//            NumItems += (cartItems.at(i)).getItemQuantity(i);
//            NumItems = NumItems+ cartItems[i].getItemQuantity();
        }
        return NumItems;
//        return cartItems[itemCount++].getItemQuantity();
    }
    
    // Method returns total cost of items in cart
    public int getCostOfCart(){
        int cost=0;
        for (int i=0;i<cartItems.length;i++){
            cost = cost+ cartItems[i].getItemQuantity()*cartItems[i].getItemPrice();
        }
        return cost;
//        return cartItems[itemCount++].getTotalPrice();
    }

    public void printTotal(){
        if(itemCount==0){
            System.out.println(customerName+" - "+currentDate);
            System.out.println("SHOPPING CART IS EMPTY.");
        }else {
            System.out.println(customerName + currentDate);
            System.out.println("Number of Items: "+getNumItemsInCart());
            System.out.println(cartItems[itemCount].toString());
            System.out.println("Total: $"+getCostOfCart());
        }
    }

//    public String removeItem(String itemName){
//        //Remove item if item's name equals itemName
//        if(cartItems[itemCount].getItemName().equals(itemName)){
//            System.out.println("item "+itemName+" is removed from shopping cart");
//        }
//        System.out.println("Item not found in cart. Nothing removed.");
//
//    }

//    public String modifyItem(String itemName){
//        //Modify item's quantity
//
//        for (int i=0;i<cartItems.length;i++){
//            if(cartItems[i].getItemName().equals(itemName)){
//                System.out.println("Please  enter the new quantity:");
//                //update quantity to the user entered
//            }
//            System.out.println("Item not found in cart. Nothing modified.");
//        }
//    }

    public void checkout(){
        printTotal();

    }




}
