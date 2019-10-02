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
        
    @Override
    public void start(Stage primaryStage) {
      TextArea ta = new TextArea();
      
      Scene scene = new Scene(new ScrollPane(ta),450,200);
      primaryStage.setTitle("server");
      primaryStage.setScene(scene);
      primaryStage.show();
      
      new Thread(()->{
      try{
      ServerSocket serverSocket = new ServerSocket(8000);
      
      Platform.runLater(() -> ta.appendText("Server started at " + new Date() + '\n'));
      
      Socket socket = serverSocket.accept();
      
      DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
      DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
      
      while(true){
      double 
      }
      }
      });
      
    }

    
    
}
