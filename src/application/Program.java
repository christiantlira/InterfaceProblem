package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import model.services.PaymentService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter contract data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Date(dd/MM/yyyy): ");
		Date contractDate = sdf.parse(sc.nextLine());
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();
		System.out.print("Enter number of installments: ");
		int parcels = sc.nextInt();

		Contract contract = new Contract(number, contractDate, totalValue);

		PaymentService paymentService = new PaymentService(totalValue, parcels, new PaypalService());
		paymentService.processInstallments(contract);

		System.out.println("Installments:");
		for (Installment i : contract.getInstallments()) {
			System.out.println(sdf.format(i.getDueDate()) + " - " + i.getAmount());
		}

	}

}
