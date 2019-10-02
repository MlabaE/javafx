/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadexample;

/**
 *
 * @author mlaba
 */
public class TaskTreadDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Create task
 
 String name1 = "evanne";
 String name2 = "samkelo";
 String name3 = "vuyani";
 
 task t1 = new task(name1);
 task t2 = new task(name2);
 task t3 = new task(name3);
 
 
 // Create threads
 Thread thread1 = new Thread(t1);   //new state cause thread is newly created
 Thread thread2 = new Thread(t2);   //new state
 Thread thread3 = new Thread(t3);   //new state
 
 // Start threads
 thread1.start();       //ready state cause start() method is called
 thread2.start();       //ready state
 thread3.start();       //ready state
 
    }
    
}

class task implements Runnable {
    
private String printname;

 public task (String n) {
  printname = n;
 }

 @Override 
 public void run() {         //running state cause run() is executing
    System.out.println(printname);
 }
 //finnished state cause run() is completed
} 