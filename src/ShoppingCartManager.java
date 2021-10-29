import java.util.Scanner;

public class ShoppingCartManager {
    public static void userInput(ItemToPurchase item){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the item name:");
        String name=scanner.nextLine();
        System.out.println("Enter the item price:");
        int price=scanner.nextInt();
        System.out.println("Enter the item quantity:");
        int quantity=scanner.nextInt();
        item.setItemName(name);
        item.setItemPrice(price);
        item.setItemQuantity(quantity);
    }
    public static void stage1(ItemToPurchase item){
        item = new ItemToPurchase();
        userInput(item);
        System.out.println(item.toString());
    }
    public static void stage2(ShoppingCart cart){
        // Prompt user for a name and a date
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the customer name:");
        String customerName=scanner.nextLine();
        System.out.println("Enter the current date:");
        String currentDate=scanner.nextLine();
        // first-time calling printTotal()
        cart.setCustomerName(customerName);
        cart.setDate(currentDate);
        cart.printTotal();

        ItemToPurchase[] item=new ItemToPurchase[1];
        userInput(item[0]);
        scanner.nextLine();
        userInput(item[1]);

        // second-time calling printTotal()
        cart.printTotal();

    }

    public static void stage3(ShoppingCart cart){

    }

    public static void stage4(VIPShoppingCart cart){

    }

    public static void main(String[] args) {
        ItemToPurchase item = new ItemToPurchase();
        ShoppingCart cart = new ShoppingCart();
        VIPShoppingCart vipCart = new VIPShoppingCart();
        System.out.println("***************Stage 1***************");
        stage1(item);
        System.out.println("***************Stage 2***************");
        stage2(cart);
        System.out.println("***************Stage 3***************");
        stage3(cart);
        System.out.println("***************Stage 4***************");
        stage4(vipCart);
    }
}
