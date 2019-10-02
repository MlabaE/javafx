/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loanserver;

import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author mlaba
 */
public class LoanServer extends Application {
           
       private TextField tfannualRate = new TextField();
       private TextField tfnumOfYears = new TextField();
       private TextField tfloanAmount = new TextField();
        
        private Button btSubmit = new Button("submit");
        
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.add(new Label("annual interest rate: "),0,0);
        pane.add(tfannualRate,1,0);
        pane.add(new Label("number of years: "),0,0);
        pane.add(tfnumOfYears,1,0);
        pane.add(new Label("loan amount: "),0,0);
        pane.add(tfloanAmount,1,0);
        
        btSubmit.setOnAction(new ButtonListener());
        
        Scene scene = new Scene(pane, 450, 200);
        
        primaryStage.setTitle("client");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class ButtonListener implements EventHandler<ActionEvent>{
      @Override
      public void handle(ActionEvent e){
        try{
            Socket socket = new Socket("localhost", 8000);
            
        }catch(IOException ex){
        ex.printStackTrace();
        }
      }
    }
    
}
