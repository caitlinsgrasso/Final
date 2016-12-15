package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import rocketDomain.RateDomainModel;

public class Rate_Test {

	
	//rateTest to make sure the interest rates have the correct value based on the data (within
	//plus or minus a value of 0.1)
	@Test
	public void RateTest() {

		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		System.out.println ("Rates size: " + rates.size());
		assert(rates.size() > 0);
		assertEquals(rates.get(1).getdInterestRate(),5, 0.1);
		assertEquals(rates.get(2).getdInterestRate(),4.5, 0.1);
		assertEquals(rates.get(3).getdInterestRate(),4, 0.1);
		assertEquals(rates.get(4).getdInterestRate(),3.75, 0.1);
		assertEquals(rates.get(5).getdInterestRate(),3.5, 0.1);
	}

}
