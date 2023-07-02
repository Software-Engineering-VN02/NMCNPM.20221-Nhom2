package main.java.login;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import main.java.employee.dashboard.EmployeeDashboardController;

public class LoginController implements Initializable{
	
	protected HashMap<String, String> logInfo = new Credentials().getLoginInfo();
	
    @FXML
    public TextField usernameField;

    @FXML
    public Button loginButton;

    @FXML
    public StackPane afterLoginContent;

    @FXML
    public PasswordField passwordField;
    
    @FXML
    private Text invalidNoti;

    
    public void loadAfterLogin(FXMLLoader loader) {
    	
    	try {
	        Parent fxml = loader.load();
			
			afterLoginContent.getChildren().removeAll();
			
			afterLoginContent.getChildren().setAll(fxml);
			
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		

		loginButton.setOnMouseClicked(event -> {
			
			
			
			String userName = usernameField.getText();
			String password = passwordField.getText();

			if(logInfo.containsKey(userName)) {
								
				if (userName.equals("employee") && password.equals("123")) {
										
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/java/screen/EmployeeDashboardScreen.fxml"));    	
					
					EmployeeDashboardController employeeDashboardController = new EmployeeDashboardController();
					
					loader.setController(employeeDashboardController);
										
					loadAfterLogin(loader);
				}
				
			} else {
				
				invalidNoti.setText("The account is not in system !!");
				
			}
		});
	}
	    
    

}
