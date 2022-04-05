package model.services;

public class PaypalService implements InstallmentsService{
	
	public PaypalService() {
	}
	
	public double installments(double amount, int parcelNumber) {
		amount += amount * 0.01 * parcelNumber;
		amount += amount * 0.02;
		return amount;
	}
}
