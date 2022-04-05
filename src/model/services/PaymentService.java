package model.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;

public class PaymentService {

	private Double totalValue;
	private int parcels;

	private InstallmentsService installmentsServices;

	public PaymentService() {
	}

	public PaymentService(Double totalValue, int parcels, InstallmentsService installmentsServices) {
		super();
		this.totalValue = totalValue;
		this.parcels = parcels;
		this.installmentsServices = installmentsServices;
	}

	public void processInstallments(Contract contract) throws ParseException {
		for (int i = 1; i <= parcels; i++) {
			Date dueDate = addMonths(contract.getContractDate(), i);

			double amount = installmentsServices.installments(totalValue / parcels, i);
			contract.getInstallments().add(new Installment(dueDate, amount));
		}
	}
	
	public Date addMonths(Date date, int N) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, N);
		return calendar.getTime();
	}

}
