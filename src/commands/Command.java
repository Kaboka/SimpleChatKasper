/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.net.Socket;
import java.util.HashMap;

/**
 *
 * @author Kasper
 */
public interface Command {
    String execute(HashMap<String,Socket> users);
}
