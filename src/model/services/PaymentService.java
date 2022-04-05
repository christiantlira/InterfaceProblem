package model.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		for (int i = 1; i <= parcels; i++) {
			int year = contract.getContractDate().getYear();
			int month = contract.getContractDate().getMonth() + i;
			int day = contract.getContractDate().getDay();
			String date = day + "/" + month + "/" + year;
			Date dueDate = sdf.parse(date);

			double amount = installmentsServices.installments(totalValue / parcels, i);
			contract.getInstallments().add(new Installment(dueDate, amount));
		}
	}

}
