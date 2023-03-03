package com.assignment1.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class MortgageCalculator
 */
@Stateful()
@LocalBean
public class MortgageCalculator implements MortgageCalculatorRemote {

	private double amount;
	private double rate;
	private double term;
	public double mortgage;
    
	//default constructor
	public MortgageCalculator() {
		this.amount = 0.0;
		this.rate = 0.0;
		this.term = 0.0;
	}
	//parameterized constructor
	public MortgageCalculator(double amount, double rate, double term) {
		super();
		this.amount = amount;
		this.rate = rate;
		this.term = term;
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getTerm() {
		return term;
	}

	public void setTerm(double term) {
		this.term = term;
	}
	
    // method to calculate mortgage
	public double getMortgage() {
		
		//this.amount = amount;
		rate = (rate/100)/12;       //to calculate monthly rate
		//this.term = term;     // calculating term in terms of months
		//formula to calculate mortgage
		mortgage = amount * (  (rate * Math.pow(1+rate,term)) / (Math.pow(1+rate, term) - 1) );
		//return mortgage after rounding up to 2 decimal places
		return Math.round(mortgage*100)/100D;
	}

}
