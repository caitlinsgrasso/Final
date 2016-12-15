package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.RateException;

public class rate_test {

	//Test to make sure the credit score results in the correct interest rate (within 0.1)
	@Test
	public void rateTest() {
		try{
			assertEquals(RateBLL.getRate(600), 5, 0.1);
		} catch (RateException e){
			e.toString();
		}
	}
	
	//Test to make sure exception is properly thrown
	@Test(expected = RateException.class)
	public void exceptionTest() throws RateException{
		assertTrue(RateBLL.getRate(600)==7);
	}
}
