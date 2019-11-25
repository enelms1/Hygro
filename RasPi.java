import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.lang.Integer;
import java.util.*;


public class RasPi implements ActionListener {

        JFrame frame = new JFrame("Java");
        JPanel panel = new JPanel(new GridLayout(10,10));
        JButton check = new JButton("check");
        JTextArea stuff = new JTextArea (30,60);
        JTextField textfield = new JTextField (25);


                public RasPi(){
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setSize(300, 300);

                        stuff.setEditable(false);
                        stuff.setPreferredSize(new Dimension (10,200));

                        panel.add(stuff);
                        panel.add(check);

                        check.addActionListener(this);

                        frame.setContentPane(panel);
                        frame.setVisible(true);
                }


                @Override
                public void actionPerformed(ActionEvent e) {
                        if(e.getSource()== check){
                                try{
                                FileInputStream input = new FileInputStream("test.txt");
                                BufferedReader buff = new BufferedReader(new InputStreamReader(input));
                                String check;

                                while((check = buff.readLine()) !=null){

                                        stuff.setText(check);
                                                }

                                }
                                catch(IOException ioe) {
                                        System.out.println("Error");
                                }

                        }

                }
                public static void main (String args[]){
                        new RasPi();
                }

}
