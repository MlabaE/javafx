/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server; 

import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 *
 * @author mlaba
 */
public class Server extends Application {

    private final TextArea ta = new TextArea();
// Number a client
    private int clientNo = 0;

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(new ScrollPane(ta), 450, 200);

        primaryStage.setTitle("Server");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(() -> {
            try {
                // Create a server socket
                ServerSocket serverSocket = new ServerSocket(8000);
                //ServerSocket serverSocket = new ServerSocket(55555);
               Platform.runLater(()->
                ta.appendText("server started at "+ new Date() + '\n'));

                while (true) {
                    // Listen for a connection request
                    Socket socket = serverSocket.accept();

                    clientNo++;

                    Platform.runLater(() -> {
                        // Display the client number
                        ta.appendText("Starting thread for client " + clientNo + " at " + new Date() + '\n');

                        // Find the client's host name, and IP address
                        InetAddress inetAddress = socket.getInetAddress();
                        ta.appendText("Client " + clientNo + "'s host name is " + inetAddress.getHostName() + "\n");
                        ta.appendText("Client " + clientNo + "'s IP Address is " + inetAddress.getHostAddress() + "\n");
                    });
                    // Create and start a new thread for the connection
                    new Thread(new HandleAClient(socket)).start();

                }
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }).start();

    }

    // Define the thread class for handling new connection
    class HandleAClient implements Runnable {

        private Socket socket; // A connected socket

        /**
         * Construct a thread
         */
        public HandleAClient(Socket socket) {
            this.socket = socket;
        }

        /**
         * Run a thread
         */
        public void run() {
            try {
                // Create data input and output streams
                DataInputStream inputFromClient = new DataInputStream(
                        socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(
                        socket.getOutputStream());

                // Continuously serve the client
                while (true) {
                    //receive message from client
                    String receiveMsg = inputFromClient.readUTF();

                    String sendServerMsg = receiveMsg;
                    
                    // Send message back to the client
                    outputToClient.writeUTF(sendServerMsg);
                    Platform.runLater(() -> {
                        ta.appendText("message received from client: " + receiveMsg + '\n');
                        ta.appendText("message sent from server: " + sendServerMsg + '\n');

                    });
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
