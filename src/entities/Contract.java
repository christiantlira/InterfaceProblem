package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	private int number;
	private Date contractDate;
	private double totalValue;

	private List<Installment> installments = new ArrayList<>();

	public Contract() {
	}

	public Contract(int accountNumber, Date contractDate, double contractValue) {
		this.number = accountNumber;
		this.contractDate = contractDate;
		this.totalValue = contractValue;
	}

	public int getNumber() {
		return number;
	}

	public Date getContractDate() {
		return contractDate;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public List<Installment> getInstallments() {
		return installments;
	}

	public void setInstallments(List<Installment> installments) {
		this.installments = installments;
	}
	
	
	
	

}
