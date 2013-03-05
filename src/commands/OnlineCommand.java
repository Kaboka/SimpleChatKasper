/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kasper
 */
public class OnlineCommand implements Command{

    @Override
    public String execute(HashMap<String, Socket> users) {
        PrintWriter output = null;


        String online = "ONLINE#";
        for (String user : users.keySet()) {
            online += user + ",";
        }
        for(Socket socket : users.values()){
            try {
                output = new PrintWriter(socket.getOutputStream());
                output.println(online);
            } catch (IOException ex) {
                Logger.getLogger(OnlineCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return online;
    }
    
}
