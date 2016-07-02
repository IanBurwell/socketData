package serverData.resources;

import javax.swing.*;
import java.awt.*;

public class console {

    private JFrame frame;
    private JPanel panel;
    private JLabel prefix;
    private JTextField inputLine;
    private JTextArea history;//TODO make this do stuff
    private JScrollPane scrollV;
    private JScrollBar scrollVBar;
    
    public console(){
	createGui();

    }

    private void createGui(){

	//SynthLookAndFeel laf = new SynthLookAndFeel();
	//try { laf.load(console.class.getResourceAsStream("laf.xml"), console.class);}
	//catch(ParseException e1) {e1.printStackTrace();}

	//try { UIManager.setLookAndFeel(laf);} 
	//catch( UnsupportedLookAndFeelException e) {e.printStackTrace();}


	frame = new JFrame("Server");
	frame.setSize(600,400);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//TODO figure out how to make this also tell clients that tits shutting down

	SpringLayout layout = new SpringLayout();
	panel = new JPanel();
	panel.setBackground(Color.BLACK);
	panel.setLayout(layout);

	prefix = new JLabel();
	prefix.setText("Server> ");
	prefix.setForeground(Color.WHITE);
	prefix.setBackground(Color.BLACK);

	inputLine = new JTextField();
	inputLine.setText("");//.getText();
	inputLine.setColumns(1);
	inputLine.setBackground(Color.BLACK);
	inputLine.setForeground(Color.WHITE);
	inputLine.setBorder(BorderFactory.createEmptyBorder());

	history = new JTextArea();
	history.setEditable(false);
	//history.setText("TEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\nTEXTS\n");
	history.setText("");
	history.setForeground(Color.WHITE);
	history.setBackground(Color.BLACK);
	history.setColumns(50);
	history.setLineWrap(true);
	
	scrollV = new JScrollPane(history);
	scrollV.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	scrollV.setWheelScrollingEnabled(true);
	scrollV.setBorder(BorderFactory.createEmptyBorder());
	scrollV.setForeground(Color.WHITE);
	scrollV.setBackground(Color.BLACK);
	//scrollV.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	//TODO make
	
	//scrollVBar = scrollV.getVerticalScrollBar();
	//scrollVBar.setValue(scrollVBar.getMaximum());
	
	//Positioning of the scroll bar
	layout.putConstraint(SpringLayout.EAST, scrollV, 0, SpringLayout.EAST, panel);
	layout.putConstraint(SpringLayout.NORTH, scrollV, 0, SpringLayout.NORTH, panel);
	layout.putConstraint(SpringLayout.SOUTH, scrollV, -5, SpringLayout.NORTH, inputLine);

	//Positioning of the history area
	layout.putConstraint(SpringLayout.WEST, history, 1, SpringLayout.WEST, panel);
	layout.putConstraint(SpringLayout.EAST, history, -5, SpringLayout.WEST, scrollV);
	layout.putConstraint(SpringLayout.NORTH, history, 0, SpringLayout.NORTH, panel);
	layout.putConstraint(SpringLayout.SOUTH, history, -10, SpringLayout.NORTH, prefix);

	//Positioning of the prefix and input box
	layout.putConstraint(SpringLayout.WEST, inputLine, 2, SpringLayout.EAST, prefix);
	layout.putConstraint(SpringLayout.EAST, inputLine, -5, SpringLayout.EAST, panel);
	layout.putConstraint(SpringLayout.SOUTH, inputLine, -1, SpringLayout.SOUTH, panel);
	layout.putConstraint(SpringLayout.SOUTH, prefix, -1, SpringLayout.SOUTH, panel);

	panel.add(scrollV);
	panel.add(prefix);
	panel.add(inputLine);
	//panel.add(history);
	frame.add(panel);
	frame.setVisible(true);
    }



    public static void main(String[] args){
	new console();
    }



}