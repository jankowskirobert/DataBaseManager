package studentManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Console;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class mainManager extends JFrame  {
	private JTextArea textArea = new JTextArea();
	public static final connectData test = new connectData("127.0.0.1",3306,"root","","students");
	public mainManager(){
		validate();
		pack();
	}
	public static void main(String[] args) {	
		for(int i = 0; i<test.getIn("stud").size() ; i++){
			System.out.printf("%s[%s:%d]\t",test.getIn("stud").get(i).getColTitle(),test.getIn("stud").get(i).getColType(),test.getIn("stud").get(i).getColSize());	
		}
		
	}
}