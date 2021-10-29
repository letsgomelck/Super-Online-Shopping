import java.util.Scanner;

public class ItemToPurchase {

    //Attributes;
    private String itemName;
    private int itemPrice;
    private int itemQuantity;

    // Mutator
    public void setItemName(String name) {
        this.itemName = name;
    }
    // Accessor
    public String getItemName() {
        return itemName;
    }

    // Mutator
    public void setItemPrice(int price) {
        this.itemPrice = price;
    }
    // Accessor
    public int getItemPrice() {
        return itemPrice;
    }

    // Mutator
    public void setItemQuantity(int quantity) {
        this.itemQuantity = quantity;
    }
    // Accessor
    public int getItemQuantity() {
        return itemQuantity;
    }

    //No-argument Constructors
    public ItemToPurchase(){
        this.itemName= "none";
        this.itemPrice=0;
        this.itemQuantity=0;
    }

    // Constructors
    // if any of the parameter passed in is invalid, throw illegalArgumentException
    public ItemToPurchase(String name,int price,int quantity) {
        // Pre-Condition
        if(name == null)
            throw new IllegalArgumentException();
        if(price>=0){
            this.itemPrice=price;
        }
        if(quantity>=1){
            this.itemQuantity=quantity;
        }
    }

    // Public Method
    public int getTotalPrice(){
        return itemPrice*itemQuantity;
    }

    // Override
    public String toString(){
        return getItemName()+" "+getItemQuantity()+ " @ $"+ getItemPrice()+" = $"+getTotalPrice();
    }

}
