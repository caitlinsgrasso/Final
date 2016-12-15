package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException{
		
		//Getting rates and putting them in an ArrayList
		ArrayList<RateDomainModel> rateList = RateDAL.getAllRates();
		//set interest rate and RateDomainModel to something that will throw an exception
		double interestRate = -1;
		RateDomainModel RateDomainModel = null;
		
		for (RateDomainModel rate: rateList){
			if (rate.getiMinCreditScore() <= GivenCreditScore){
				interestRate = rate.getdInterestRate();
			}
			//throws exception if rate is not possible or the RateDomainModel is null
			else if (interestRate<0 || RateDomainModel==null){
				throw new RateException(RateDomainModel);
			}
			
			else{
				return interestRate;
			}
		}
		return interestRate;
			
	}
	
	
	
	//	Calculating payment using a finance library
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
