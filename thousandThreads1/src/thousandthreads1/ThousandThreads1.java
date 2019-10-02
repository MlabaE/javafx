/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thousandthreads1;

/**
 *
 * @author mlaba
 */
public class ThousandThreads1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //int num1;
        //int timesTotal;
        //int sumTotal;
        
        task t1 = new task(0,1000,0);
        
        Thread th1 = new Thread(t1);
        
        Thread thread1 = new Thread(th1);
        
        thread1.start(); 
        
    }
    
}
class task implements Runnable {
    
private int number;
private final int times;
public int sum;

 public task (int num,int t,int s) {
  number = num;
  times = t;
  sum = s;
 }

 @Override 
 public void run() {         //running state cause run() is executing
   // System.out.println(printname);
   
   for(int i=number ; number<=times ; number++)
   {
      sum++;
      System.out.println(+sum);
      
   }
 }
 //finnished state cause run() is completed
} 