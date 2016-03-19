
/*****************
 * Cartwright II,*
 * Steve         *    
 * CMPSC 221     *  
 * 4/23/2013     *
 ****************/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class Converter extends JFrame
{  private ActionListener listener = new KeyEvent();
   private JTextField decimal = new JTextField(5);
   private JTextField binary = new JTextField(5);
   private JTextField hexadecimal = new JTextField(5);
   private static String message = new String();
   private static String bin, hex, dec;
   private static final int A = 10;
   private static final int B = 11;
   private static final int C = 12;
   private static final int D = 13;
   private static final int E = 14;
   private static final int F = 15;
   private static final int sixteen = 16;
   private static final int two = 2;


    public Converter()
    {  
      // Set the layout of the frame with GridLayout 
      setLayout(new BorderLayout());
      
      // Create two new panels for each of the three buttons
      // using FlowLayout
      JPanel p1 = new JPanel(new GridLayout(3,1,0,0));
      JPanel p2 = new JPanel(new GridLayout(3,1,0,0));
      MessagePanel p3 = new MessagePanel(message);
     
       // Add three textfields and labels to the frame
      p1.add(new JLabel("Decimal"));  
      p1.add(new JLabel("Binary"));
      p1.add(new JLabel("Hexadecimal"));
      add(p1, BorderLayout.WEST);
      
      p2.add(decimal);
      decimal.setHorizontalAlignment(JTextField.RIGHT);
      decimal.addActionListener(listener);
      p2.add(binary);
      binary.setHorizontalAlignment(JTextField.RIGHT);
      binary.addActionListener(listener);
      p2.add(hexadecimal);
      hexadecimal.setHorizontalAlignment(JTextField.RIGHT);
      hexadecimal.addActionListener(listener);
      add(p2);
     
      p3.setPreferredSize(new Dimension(5, 25));
      add(p3, BorderLayout.SOUTH);
      

      
    }  
   // Class to draw message on panel 
   static class MessagePanel extends JPanel
   {     public MessagePanel(String message)
         {}
         
         // Pre condition - make sure message is param
         // Post condition - painted the message    
         @Override
         protected void paintComponent(Graphics g)
         {
            super.paintComponent(g);
            g.setFont(new Font("CourierNew", Font.PLAIN, 14));
            g.drawString(message, 15, 15);
            repaint();
         }
   
  } 
   

   class KeyEvent implements ActionListener
   {  // Pre condition - check which textfield used event
      // Post condition - use corresponding commands in if / else 
      public void actionPerformed(ActionEvent e)
      {  
         if(e.getSource() == decimal)
         {  dec = decimal.getText();
            message = "Decimal: " + dec + "  Binary:  " + dec2bin(dec) + "  Hexadecimal: " + dec2hex(dec);
           MessagePanel p = new MessagePanel(message);
            binary.setText(dec2bin(dec)); hexadecimal.setText(dec2hex(dec));          
         }
         else if(e.getSource() == binary)
         {  bin = binary.getText();          
            message = "Decimal: " + bin2dec(bin) + "  Binary:  " + bin + "  Hexadecimal: " + dec2hex(bin2dec(bin));
            MessagePanel p = new MessagePanel(message);
            decimal.setText(bin2dec(bin)); hexadecimal.setText(dec2hex(bin2dec(bin)));
         }  
         else if(e.getSource() == hexadecimal)
         {  hex = hexadecimal.getText();
            message = "Decimal: " + hex2dec(hex) + "  Binary:  " + dec2bin(hex2dec(hex)) + "  Hexadecimal: " + hex;
            MessagePanel p = new MessagePanel(message);
            decimal.setText(hex2dec(hex)); binary.setText(dec2bin(hex2dec(hex)));
         } 
      }
   }
    
   // Pre condition - must take string
   // Post condition - will go from decimal to hex
   public String dec2hex(String s)
   {  int r, r1;
      ArrayList<Integer> arr = new ArrayList<Integer>();
      String temp = new String();
         // run checker 
         r = r1 = checker(s);
         // add modded to arraylist
         while(r > 0)
         {  r %= sixteen;
            arr.add(r);
            r1 /= sixteen;
            r = r1;
         }
         // reverse
         Collections.reverse(arr);
         // create string with array
         for(int i = 0; i < arr.size() ; i++)
         {  if(arr.get(i) == A)
               temp += 'A';
            else if(arr.get(i) == B)
               temp += 'B'; 
            else if(arr.get(i) == C)
               temp += 'C';
            else if(arr.get(i) == D)
              temp += 'D';
            else if(arr.get(i) == E)
               temp += 'E';
            else if(arr.get(i) == F)
               temp += 'F';
            else        
               temp += "" + arr.get(i);
         }     
      return temp;
   }
   
   // Pre condition - must take string
   // Post condition - will go from decimal to binary
   public String dec2bin(String s)
      {   int r, r1;
          ArrayList<Integer> arr = new ArrayList<Integer>();
          String temp = new String();
         // run checker     
         r = r1 = checker(s);
         // add modded to arraylist
         while(r > 0)
         {  r %= two;
            arr.add(r);
            r1 /= two;
            r = r1;
         }
         
         // reverse
         Collections.reverse(arr);
         // create string with array
         for(int i = 0; i < arr.size() ; i++)
         {  if(arr.get(i) == '1')
               temp += "" + 1;
            else  
               temp += "" + arr.get(i);
         }
    
      return temp;
   }
   
   // Pre condition - must take string
   // Post condition - will go from binary to decimal
   public String bin2dec(String s)
   {     int a = 0;
         ArrayList<Integer> arr = new ArrayList<Integer>();
         
         // store char as int
         for(int i = 0; i < s.length(); i++)
            arr.add((s.charAt(i) - '0'));
         // convert from binary to decimal             
         for(int i = 0; i < arr.size(); i++)
            a += arr.get(i) * Math.pow(two, arr.size() -1 -i);
               
         return "" + a;
   }
   
   // Pre condition - must take string
   // Post condition - will go from hex to decimal
   public String hex2dec(String s)
   {     int a = 0;
         ArrayList<Integer> arr = new ArrayList<Integer>();
         
         // store the characters in the array as their real number
         for(int i = 0; i < s.length(); i++)
         {  if(s.charAt(i) == 'A')
               arr.add(A);
            else if(s.charAt(i) == 'B')
               arr.add(B); 
            else if(s.charAt(i) == 'C')
               arr.add(C);
            else if(s.charAt(i) == 'D')
               arr.add(D);
            else if(s.charAt(i) == 'E')
               arr.add(E);
            else if(s.charAt(i) == 'F')
               arr.add(F);
            else        
               arr.add((s.charAt(i) - '0'));
         } 
        // convert to hex     
        for(int i = 0; i < arr.size(); i++)
           a += arr.get(i) * Math.pow(sixteen, arr.size() -1 -i);
        
        return "" + a;
      
   }
   
   // Pre condition - must take string
   // Post condition - will return int for computation (decimal or base 10)
   public int checker(String s)
   {    int a = 0;
        for(int i = 0; i < s.length(); i++)
        {   if(s.charAt(i) == 'A')
               a += Math.pow(A, s.length() -1 -i) * (s.charAt(i) - '0') * A;
            else if(s.charAt(i) == 'B')
               a += Math.pow(A, s.length() -1 -i) * (s.charAt(i) - '0') * B; 
            else if(s.charAt(i) == 'C')
               a += Math.pow(A, s.length() -1 -i) * (s.charAt(i) - '0') * C;
            else if(s.charAt(i) == 'D')
               a += Math.pow(A, s.length() -1 -i) * (s.charAt(i) - '0') * D;
            else if(s.charAt(i) == 'E')
               a += Math.pow(A, s.length() -1 -i) * (s.charAt(i) - '0') * E;
            else if(s.charAt(i) == 'F')
               a += Math.pow(A, s.length() -1 -i) * (s.charAt(i) - '0') * F;
            else        
               a += Math.pow(A, s.length() -1 -i) * (s.charAt(i) - '0');
         }  
      return a;
   }
 }
