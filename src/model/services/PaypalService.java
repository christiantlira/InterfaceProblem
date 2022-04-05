package model.services;

public class PaypalService implements InstallmentsService{
	
	private static final double PAYMENT_FEE = 0.02;
	private static final double MONTLHY_INTEREST = 0.01;
	
	public PaypalService() {
	}
	
	@Override
	public double installments(double amount, int parcelNumber) {
		amount += amount * MONTLHY_INTEREST * parcelNumber;
		amount += amount * PAYMENT_FEE;
		return amount;
	}
}
