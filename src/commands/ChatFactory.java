/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Kasper
 */
public class ChatFactory {

    private static ChatFactory instance = null;
    private Map<String,Command> commands;

    private ChatFactory() {
        commands = new HashMap<>();
        
//        commands.put("CONNECT", new)
    }

    public static ChatFactory getInstance() {
        if (instance == null) {
            instance = new ChatFactory();
        }
        return instance;
    }
    
        public Command findCommand(String key) {
        return commands.get(key);
    }
}
