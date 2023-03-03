package com.assignment1.ejb;

import javax.ejb.Remote;

@Remote
public interface MortgageCalculatorRemote {

	public double getMortgage(); 
	
}

