/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calc;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class Calc {

   
    public static void main(String[] args) {
       calculator c = new calculator();
       c.setSize(400, 400);
       c.setVisible(true);
       c.setResizable(false);
       c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

class calculator extends JFrame
{
public calculator(){
cPanel panel = new cPanel();
add(panel);
pack();

}
}

class cPanel extends JPanel
{
    public cPanel(){
setLayout(new BorderLayout());
result = 0;
lastCommand = "=";
Start = true;

display = new JButton("0");
display.setEnabled(false);
add(display, BorderLayout.NORTH);

ActionListener insert = new insertAction();
ActionListener command = new commandAction();
panel = new JPanel();
panel.setLayout(new GridLayout(4,4)); 

addButton("7", insert);
addButton("8", insert);
addButton("9", insert);
addButton("/", command);

addButton("4", insert);
addButton("5", insert);
addButton("6", insert);
addButton("*", command);

addButton("1", insert);
addButton("2", insert);
addButton("3", insert);
addButton("-", command);

addButton("0", insert);
addButton(".", insert);
addButton("=", command);
addButton("+", command);

add(panel, BorderLayout.CENTER);
}     
    
    
private void addButton(String label, ActionListener list)
{
JButton button = new JButton(label);
button.addActionListener(list);
panel.add(button);

}



private class insertAction implements ActionListener{
    public void actionPerformed(ActionEvent e)
    {
    String input = e.getActionCommand();
    if(Start)
    {
    display.setText(" ");
    Start = false;    }
    display.setText(display.getText() + input);
    }
      
}

private class commandAction implements ActionListener

{
public void actionPerformed(ActionEvent e)
{
String command = e.getActionCommand();
if(Start)
{
if(command.equals("-"))
{
display.setText(command);
Start = false;
}
else lastCommand = command;
}
else calculate(Double.parseDouble(display.getText()));
lastCommand = command;
Start = true;
}
}

private void calculate(double r)
{
if(lastCommand.equals("+")) result+=r;
else if (lastCommand.equals("-")) result-=r;
else if (lastCommand.equals("*")) result*=r;
else if (lastCommand.equals("/")) result/=r;
else if (lastCommand.equals("=")) result =  r;
display.setText(" " + result);
}


    private JPanel panel;
    private JButton display;
    private double result;
    private String lastCommand;
    private boolean Start;
}