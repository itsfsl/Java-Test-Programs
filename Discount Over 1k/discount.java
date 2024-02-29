/* Program to generate a discount of 10% on a total purchase
of 1k where each quantityuantity is priced 200 rupees. */

import java.util.Scanner;

public class discount {
    public static void main(String[] args) {
        
        int itemPrice = 200;
        Scanner sc = new Scanner(System.in);
        System.out.println(String.format("Enter the quantity (%d/item):", itemPrice));
        int quantity = sc.nextInt();

        if ((quantity * itemPrice) > 1000) {
            double discount = (quantity * itemPrice) * 0.1;
            System.out.println("Your discount is " + discount);
            System.out.println("Your total is: " + ((quantity * itemPrice) - discount));
        } else {
            System.out.println("No discount for you!");
            System.out.println("Your total is: " + (quantity * itemPrice));
        }
        sc.close();
    }
}