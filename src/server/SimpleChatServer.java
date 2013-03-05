/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicklas Hemmingsen
 */
public class SimpleChatServer {

    public static final int PORT = 1234;
    static ServerSocket serverSocket;

    
//    public String online(){
//        String online = "ONLINE#";
//        for(String user: clients.keySet()){
//            online += user+",";
//        }
//        return online;
//    }
    
        public static void main(String[] args) {
        System.out.println("Server is started");
//        clients = new HashMap<>();
          SimpleChatClientHandler ch;
        try {
            serverSocket = new ServerSocket(PORT); 
            while(true){     
                ch = new SimpleChatClientHandler();
                //Important: This is a blocking call.
                Socket socket = serverSocket.accept();
                ch.handleClient(socket);
                System.out.println("Got a new client");
//                clients.put("", socket);
            }
        } catch (IOException ex) {
            Logger.getLogger(SimpleChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
