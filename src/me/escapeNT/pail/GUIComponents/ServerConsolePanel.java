package me.escapeNT.pail.GUIComponents;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import me.escapeNT.pail.util.ScrollableTextArea;
import me.escapeNT.pail.util.Util;
import org.bukkit.Bukkit;

import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;

/**
 * Panel containing the server console and input.
 * @author escapeNT
 */
public class ServerConsolePanel extends JPanel {

    private ScrollableTextArea consoleOutput;
    private JTextField consoleInput;
    private LinkedList<String> cmdHistory = new LinkedList<String>();
    private CommandRecallListener crl = new CommandRecallListener();
    
    public ServerConsolePanel() {
        consoleOutput = new ScrollableTextArea();
        consoleOutput.setAutoscrolls(true);
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.CENTER, consoleOutput.getScrollerPanel());

        consoleInput = new JTextField();
        consoleInput.addActionListener(new ConsoleCommandListener());
        consoleInput.addKeyListener(crl);
        this.add(BorderLayout.SOUTH, consoleInput);
    }

    /**
     * Returns the JTextArea responsible for displaying the console output.
     * @return the consoleOutput The console output area.
     */
    public ScrollableTextArea getConsoleOutput() {
        return consoleOutput;
    }

    /**
     * Listener class handling command input.
     */
    private class ConsoleCommandListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(consoleInput.getText().trim().isEmpty()) { // No reason to send empty commands
                consoleInput.setText(""); // Empty just in case
                return;
            }
            Server server = Bukkit.getServer();
            if(consoleInput.getText().equals("reload")) {
                Util.getPlugin().saveState();
            }
            server.dispatchCommand(new ConsoleCommandSender(server), consoleInput.getText());

            cmdHistory.addFirst(consoleInput.getText());
            if(cmdHistory.size() > 10) {
                cmdHistory.removeLast();
            }

            consoleInput.setText("");
            crl.setIndex(-1);
        }
    }

    /**
     * Listener for up and down arrow events to recall command history.
     */
    private class CommandRecallListener implements KeyListener {

        private int index = -1;
        private String prevText = "";

        public void keyTyped(KeyEvent e) {}
        public void keyReleased(KeyEvent e) {}

        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            
            if((isKeyDown(key) && index == -1)
                    || (isKeyUp(key) && cmdHistory.isEmpty())
                    || !(isKeyDown(key)||isKeyUp(key))) {
                return;
            }
            
            if(isKeyUp(key) && index < cmdHistory.size()-1) {
                if(index == -1 && !consoleInput.getText().isEmpty()) {
                    prevText = consoleInput.getText();
                }
                index++;
            } else if(isKeyDown(key)) {
                index--;
            }
            
            consoleInput.setText(index>-1?cmdHistory.get(index):prevText);
            
            if(!prevText.isEmpty() && index == -1) {
                prevText = "";
            }
        }

        private boolean isKeyUp(int key) {
            if(key == KeyEvent.VK_UP 
                    || key == KeyEvent.VK_KP_UP)
                return true;
            
            return false;
        }
        private Boolean isKeyDown(Integer key) {
            if(key == KeyEvent.VK_DOWN
                    || key == KeyEvent.VK_KP_DOWN)
                return true;
            
            return false;
        }
        
        private void setIndex(int i) {
            index = i;
            prevText = "";
        }
    }
}