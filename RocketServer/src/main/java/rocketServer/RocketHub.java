package rocketServer;

import java.io.IOException;

import exceptions.RateException;
import netgame.common.Hub;
import rocketBase.RateBLL;
import rocketData.LoanRequest;
import rocketDomain.RateDomainModel;


public class RocketHub extends Hub {

	private RateBLL _RateBLL = new RateBLL();
	
	public RocketHub(int port) throws IOException {
		super(port);
	}

	@Override
	protected void messageReceived(int ClientID, Object message) {
		System.out.println("Message Received by Hub");
		
		if (message instanceof LoanRequest) {
			resetOutput();
			
			LoanRequest lq = (LoanRequest) message;
			
			try{
				//setting rate based on credit score
				lq.setdRate(RateBLL.getRate(lq.getiCreditScore()));
			} catch (RateException e){
				//sending a message if an exception is thrown
				sendToAll(e);
				System.out.println("Invalid credit score.");
			}
			//determining the payment
			lq.setdPayment(RateBLL.getPayment(lq.getdRate(), lq.getiTerm()* 12, lq.getdAmount()-lq.getiDownPayment(), 0.0, false));
			
			//Updates the loan request and sends the updated version back to the caller(s)
			sendToAll(lq);
		}
	}
}
