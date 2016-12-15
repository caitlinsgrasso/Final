package rocket.app.view;

import eNums.eAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import rocket.app.MainApp;
import rocketBase.RateBLL;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {

	private MainApp mainApp;
	
	@FXML
	private TextField txtIncome;
	
	@FXML
	private TextField txtExpenses;
	
	@FXML
	private TextField txtCreditScore;
	
	@FXML
	private TextField txtHouseCost;
	
	@FXML
	private ComboBox loanTerm;
	
	@FXML 
	private Button btnCalculatePayment;
	
	@FXML
	private TextField txtMortgagePayment;

	@FXML
	private TextField txtRate;


	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Object message = null;
		
		
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();

		lq.setdAmount(Double.parseDouble(txtHouseCost.getText()));
		lq.setIncome(Double.parseDouble(txtIncome.getText()));
		lq.setExpenses(Double.parseDouble(txtExpenses.getText()));
		lq.setiCreditScore(Integer.parseInt(txtCreditScore.getText()));

		a.setLoanRequest(lq);
		
		//	send lq as a message to RocketHub		
		mainApp.messageSend(lq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		
		double payment = lRequest.getdPayment();
		
		txtMortgagePayment.setText("Your payment is" + payment + ".");
		
		
	}
}
