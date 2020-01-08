package model.entities;

import model.excepitions.DomainExceptions;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public Double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		this.balance += amount;
	}

	public void withdraw(double amount) throws DomainExceptions {
		if (amount > withdrawLimit) {
			throw new DomainExceptions("The amount exceeds withdraw limit");
		}
		if (amount > balance) {
			throw new DomainExceptions("Not enough balance");
		}
		double updatedBalance = this.balance -= amount;
		System.out.println("New balance: $" + String.format("%.2f", updatedBalance));

	}

}
