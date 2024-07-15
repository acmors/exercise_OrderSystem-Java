package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entitites.enums.OrderStatus;

public class Program {
	
	public static void main(String args[]) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = scan.nextLine();
		System.out.print("Email: ");
		String email = scan.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(scan.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(scan.next());
		Order order = new Order(new Date(), status, client);
		
		System.out.println("How many items to this order? ");
		int N = scan.nextInt(); 
		for (int i = 0; i<N; i++) {
			
			System.out.println("Enter #" + i+1 + " item data: ");
			System.out.print("Product name: ");
			scan.nextLine();
			String productName = scan.nextLine();
			
			System.out.print("Product price: ");
			double productPrice = scan.nextDouble();
			
			Product product = new Product(productName, productPrice);
			
			System.out.print("Quantity: ");
			int quantity = scan.nextInt();
			
			OrderItem orderItem = new OrderItem(quantity, productPrice, product);
			order.addItem(orderItem);
		}
		System.out.println();
		System.out.println(order);
		
		scan.close();
	}
}
