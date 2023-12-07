package ba.etf.unsa.rpr.lab6zad1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField txt_result;
    private String op ="";
    private double number1;
    private double number2;
    @FXML
    protected void number(ActionEvent ae) {
        String no = ((Button)ae.getSource()).getText();
        txt_result.setText(txt_result.getText() + no);
    }

    @FXML
    protected void operation(ActionEvent ae) {
        String operation = ((Button)ae.getSource()).getText();
        if (!operation.equals("=")){
            if(!op.equals("")){
                return;
            }
            op = operation;
            number1 = Double.parseDouble(txt_result.getText());
            txt_result.setText("");
        }else {
            if(op.equals("")){
                return;
            }
            number2 = Double.parseDouble((txt_result.getText()));
            calculate(number1, number2, op);
            op="";
        }
    }
    protected void calculate (double n1, double n2, String op) {
        switch (op){
            case "+" :
                txt_result.setText(n1 + n2 + "");
                break;
            case "-" :
                txt_result.setText(n1 - n2 + "");
                break;
            case "*" :
                txt_result.setText(n1 * n2 + "");
                break;
            case "/" :
                if (n2 == 0){
                    txt_result.setText("besk.");
                    break;
                }
                txt_result.setText(n1 / n2 + "");
                break;
        }
    }
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}