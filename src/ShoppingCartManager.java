package assessment2;

import java.util.Scanner;

public class ShoppingCartManager {
    public static void getItemToPurchaseFromUser(ItemToPurchase item){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the item name:");
        item.setName(scanner.nextLine());
        System.out.println("Enter the item price:");
        item.setPrice(scanner.nextInt());
        System.out.println("Enter the item quantity:");
        item.setQuantity(scanner.nextInt());
    }
    public static void stage1(ItemToPurchase item){
        getItemToPurchaseFromUser(item);
        System.out.println(item);
    }
    public static void stage2(ShoppingCart cart){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the customer name:");
        cart.setCustomerName(scanner.nextLine());
        System.out.println("Enter the current date:");
        cart.setCurrentDate(scanner.nextLine());
        cart.printTotal();
        ItemToPurchase item1 = new ItemToPurchase();
        getItemToPurchaseFromUser(item1);
        ItemToPurchase item2 = new ItemToPurchase();
        getItemToPurchaseFromUser(item2);
        cart.addItem(item1);
        cart.addItem(item2);
        cart.printTotal();
    }

    public static void stage3(ShoppingCart cart){
        String ans;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to remove an item from shopping cart? Y/N");
        ans = scanner.nextLine();
        if (ans.equals("Y")){
            System.out.println("Enter the name of the item that you wish to remove:");
            ans = scanner.nextLine();
            cart.removeItem(ans);
            cart.printTotal();
        }
        System.out.println("Do you want to modify an item from shopping cart? Y/N");
        ans = scanner.nextLine();
        if (ans.equals("Y")){
            System.out.println("Enter the name of the item that you wish to modify:");
            ans = scanner.nextLine();
            cart.modifyItem(ans);
            cart.printTotal();
        }
        System.out.println("Do you want to check-out? Y/N");
        ans = scanner.nextLine();
        if (ans.equals("Y")){
            cart.checkout();
        }
    }

    public static void stage4(VIPShoppingCart cart){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the customer name:");
        cart.setCustomerName(scanner.nextLine());
        System.out.println("Enter the current date:");
        cart.setCurrentDate(scanner.nextLine());
        System.out.println("Enter the points that the customer has:");
        cart.setPoints(scanner.nextInt());
        ItemToPurchase item = new ItemToPurchase();
        getItemToPurchaseFromUser(item);
        cart.addItem(item);
        cart.checkout();
    }

    public static void main(String[] args) {
        ItemToPurchase item = new ItemToPurchase();
        ShoppingCart cart = new ShoppingCart();
        VIPShoppingCart vipCart = new VIPShoppingCart();
//        System.out.println("***************Stage 1***************");
//        stage1(item);
//        System.out.println("***************Stage 2***************");
//        stage2(cart);
//        System.out.println("***************Stage 3***************");
//        stage3(cart);
        System.out.println("***************Stage 4***************");
        stage4(vipCart);
    }
}
