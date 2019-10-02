/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxexercise1changeclr;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author mlaba
 */
public class FxExercise1ChangeClr extends Application {
    @Override
    public void start(Stage primaryStage) {
        //draw circle 
        Circle c = new Circle();
        
        //set position
        c.setCenterX(300.0f);
        c.setCenterY(135.0f);
        
        //set radius
        c.setRadius(50.0f);
        
        //set colour
        c.setFill(Color.WHITE);
        
        
        //Set stroke width
        c.setStrokeWidth(20);
        
        //create button
        Button red = new Button("RED");
        Button green = new Button("GREEN");
        Button yellow = new Button("YELLOW");
        Button pink = new Button("PINK");
        Button blue = new Button("BLUE");
        
        //text
        //Text txt = new Text("click on the above buttons to change circles color");
        
        //create label
        Label l = new Label("click on the above buttons to change circles color");
        l.setTranslateY(200);
        l.setTranslateX(300);
        
        
         EventHandler<ActionEvent> eventRed = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent a) 
            { 
                c.setFill(Color.RED);
            } 
        };
         
         EventHandler<ActionEvent> eventGreen = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent a) 
            { 
                c.setFill(Color.GREEN);
            } 
        };
         
         EventHandler<ActionEvent> eventYellow = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent a) 
            { 
                c.setFill(Color.YELLOW);
            } 
        };
        
         EventHandler<ActionEvent> eventPink = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent a) 
            { 
                c.setFill(Color.PINK);
            } 
        };
         
          EventHandler<ActionEvent> eventBlue = new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent a) 
            { 
                c.setFill(Color.CORNFLOWERBLUE);
            } 
        };
         
        //create hbox
        HBox h = new HBox();
        h.setSpacing(10);
        
        //Creating a Group object  
        Group g = new Group(c,h,l);
       
         //when button is pressed
        red.setOnAction(eventRed);
        green.setOnAction(eventGreen);
        yellow.setOnAction(eventYellow);
        pink.setOnAction(eventPink);
        blue.setOnAction(eventBlue);
        
        //add button
        h.getChildren().add(red);
        h.getChildren().add(green);
        h.getChildren().add(yellow);
        h.getChildren().add(pink);
        h.getChildren().add(blue);
        
        Scene scene = new Scene(g, 600, 300);
        
        primaryStage.setTitle("exercise 1");
        //adding scene to stage
        primaryStage.setScene(scene);
        //display content of stage
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
