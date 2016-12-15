package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {
	
	private RateDomainModel RateDomainModel;
	
	//Constructor passing in RateDomainModel
	public RateException(rocketDomain.RateDomainModel rateDomainModel) {
		super();
		RateDomainModel = rateDomainModel;
	}
	
	//Getter for RateDomainModel
	public RateDomainModel getRateDomainModel() {
		return RateDomainModel;
	}
}
