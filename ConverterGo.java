import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class ConverterGo extends JFrame
{  
   public static void main(String[] args)
   {  
     // Create new frame of type Hello
      JFrame frame = new Converter();
      
      // Set the title, size, start position, default close, and visibility
      frame.setTitle("Decimal   -   Hexadecimal   -   Binary Converter ");
      frame.setSize(400,180);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //frame.pack();
      frame.setVisible(true);
      
   

  }

}
