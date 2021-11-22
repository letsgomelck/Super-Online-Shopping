package assessment2;

public class ItemToPurchase {
    private String itemName;
    private int itemPrice;
    private int itemQuantity;

    public ItemToPurchase(){
        this.itemName = "none";
        this.itemQuantity = 0;
        this.itemPrice = 0;
    }
//    public ItemToPurchase(String name, int price, int quantity){
//        if (name == null || price < 0 || quantity < 1)
//            throw new IllegalArgumentException("invalid argument null");
//        this.itemName = name;
//        this.itemPrice = price;
//        this.itemQuantity = quantity;
//    }

    public void setName(String name){
        if (name == null )
            throw new IllegalArgumentException("invalid argument null");
        this.itemName = name;
    }

    public void setPrice(int price){
        if (price < 0 )
            throw new IllegalArgumentException("invalid argument null");
        this.itemPrice = price;
    }

    public void setQuantity(int quantity){
        if (quantity < 1)
            throw new IllegalArgumentException("invalid argument null");
        this.itemQuantity = quantity;
    }

    public String getName(){
        return this.itemName;
    }

    public int getPrice(){
        return this.itemPrice;
    }

    public int getQuantity(){
        return this.itemQuantity;
    }

    public int getTotalPrice(){
        return itemPrice * itemQuantity;
    }

    public String toString(){
        return this.itemName + " " + this.itemQuantity + " @ $" + this.itemPrice + " = $" + getTotalPrice();
    }

}
