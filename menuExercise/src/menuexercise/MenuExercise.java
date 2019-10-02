/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menuexercise;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author mlaba
 */
public class MenuExercise extends Application {
    Scene scene1;
    private String text = " ";
    @Override
    public void start(Stage primaryStage) {
       
        primaryStage.setTitle("menu");
        
        //create menu
        Menu menu1 = new Menu("Menu1");
        Menu menu2 = new Menu("Menu2");
        Menu menu3 = new Menu("Menu3");
        Menu menu4 = new Menu("Menu4");
        Menu menu5 = new Menu("Menu5");
        Menu menu6 = new Menu("Menu6");
        
        
        //adding menu items
        
        MenuItem menuItem1 = new MenuItem("CLICK ME");
        Menu subMenu = new Menu("item1");           //submenu
        
        subMenu.getItems().add(menuItem1);
        menu1.getItems().add(subMenu);
        
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
        
        Label l = new Label("hidden shape");
        l.setTranslateY(200);
        l.setTranslateX(300);
        l.setVisible(false);
        Label lblText = new Label("Programming is fun");
        l.setTranslateY(200);
        l.setTranslateX(300);
        
        StackPane sp = new StackPane();
        
        menuItem1.setOnAction(e -> {c.setFill(Color.RED);
        l.setVisible(true);});
        
        /*
        new Thread(new Runnable() {
 @Override
 public void run() {
 try {
 while (true) {
 if (lblText.getText().trim().length() == 0)
 lblText.setVisible(true);
 text = "Welcome";
 else
 text = "";

 Platform.runLater(new Runnable() { // Run from JavaFX GUI
 @Override
 public void run() {
 lblText.setText(text);
 }
 });

 Thread.sleep(200);
 }
 }
 catch (InterruptedException ex) {
 }
 }
 }).start();
        */
        
        MenuItem menuItem2 = new MenuItem("item2");
        MenuItem menuItem3 = new MenuItem("item3");
        MenuItem menuItem4 = new MenuItem("item4");
        MenuItem menuItem5 = new MenuItem("item5");
        MenuItem menuItem6 = new MenuItem("item6");
        
      
        menu1.getItems().add(menuItem2);
        menu1.getItems().add(menuItem3);
        menu1.getItems().add(menuItem4);
        menu1.getItems().add(menuItem5);
        menu1.getItems().add(menuItem6);
        
        MenuBar menuBar = new MenuBar();
        
        menuBar.getMenus().add(menu1);
        menuBar.getMenus().add(menu2);
        menuBar.getMenus().add(menu3);
        menuBar.getMenus().add(menu4);
        menuBar.getMenus().add(menu5);
        menuBar.getMenus().add(menu6);
        
        HBox v = new HBox(menuBar);
        Group g = new Group(c,sp,l,v);
        Scene scene = new Scene(g,960,600);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        };
        
        
        
        
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    }
