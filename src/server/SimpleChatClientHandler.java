package server;

import commands.ChatFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimpleChatClientHandler extends Thread {

    private static Map<String, Socket> clients = new HashMap<>();
    PrintWriter output;
    Scanner input;

    public void handleClient(Socket socket) throws IOException {
        //Don't forget to turn on autoFlush
        output = new PrintWriter(socket.getOutputStream(), true);
        input = new Scanner(socket.getInputStream());
        start();
        //Important: This is a blocking call.
    }

    public void run() {
        String command = null;
        ChatFactory commands = ChatFactory.getInstance();
        while(command != "CLOSE"){
            String msg = input.nextLine();
            System.out.println(msg);
            while (input.hasNext()) {
                output.println(msg);
                msg = input.nextLine();
 //               commands.findCommand(msg.substring(0,msg.indexOf("#")));
                
            }
        }
    }
}
