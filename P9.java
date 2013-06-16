/*
 *@author            victoria
 *@description       listener project
 *@version           2.0
 *@date              3/29/13
 */
package p9;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent.*;
import javax.imageio.ImageIO;


public class P9 extends JFrame implements MouseListener, KeyListener {
    
P9Model model = new P9Model();
private Canvas myCanvas = new Canvas( model );
//=================================================
     //color palette
static final Color i = new Color(255,240,245);//lavender blush for background
static final Color ii = new Color(152,251,152);//color choice
static final Color iii = new Color(25,240,240);// color lines
static final Color iv = new Color(255,193,203);// for fill shape
static final Color v = new Color(216,191,215);//font color
//=================================================
 private JLabel mouse = new JLabel("     ");  // report on mouse action
 private JLabel entry = new JLabel("     ");  // report on mouse movement
 private JLabel key   = new JLabel("     ");  // report on key action
//=================================================

//JFrame Canvas = new JFrame("Polygone");
//JPanel canvasPane = new JPanel();
JLabel instructions = new JLabel("Please type the key code for two colors");//directions for pane
JLabel instructions2 = new JLabel("");//directions for pane
static JLabel instructions3 = new JLabel("");//directions for pane
JLabel color2 = new JLabel("1");//color key code label
JLabel color3 = new JLabel("2");//color key code label
JLabel color4 = new JLabel("3");//color key code label
//==================================================
  public static void main(String[] args) {
        // TODO code application logic here
        P9 poly = new P9();
        WinClose quit = new WinClose();// poly.WinClose also works.
        poly.addWindowListener( quit ); 
        poly.getName();
        poly.setVisible(true);
    }
//=================================================

public P9() { //constructor
//======================================================================================================
//to add instructions to pane
//Canvas print = new Canvas(model);
setSize(500, 500);
addMouseListener(this);
addKeyListener(this);
Container pane = getContentPane();
pane.setBackground(i);
            
JPanel p1 = new JPanel();
p1.setBackground( i );

p1.setLayout( new GridLayout(10, 1));
instructions.setForeground(v);
p1.add(instructions);

color2.setForeground(ii);
p1.add(color2);
color3.setForeground(iii);
p1.add(color3);
color4.setForeground(iv);
p1.add(color4);

instructions2.setForeground(Color.MAGENTA);
instructions3.setForeground(Color.CYAN);
p1.add(instructions2);
p1.add(instructions3);

p1.add(new JLabel("              "));

p1.add(entry);
p1.add( key ); 
p1.add(mouse); 

JPanel temp = new JPanel();
temp.add(myCanvas, "Center");
temp.setBackground(i);
pane.add(temp, "Center");
pane.add(p1, "South");
pane.setName("Poly Gone");

//========================================================================================================

//========================================================================================================
}

//===========================================================================================================          
    //inner classes for key events
            
    @Override
    public void keyTyped(KeyEvent ke) {
       int code = ke.getKeyCode();
       key.setText(code + " Key typed.");
       System.out.println(code + " key typed");
       repaint();
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int code = ke.getKeyCode();
        key.setText(code + "  Key pressed.");
        System.out.println(code + " key pressed");
        repaint();
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int code = ke.getKeyCode();
                key.setText(key + "  Key released.");
                System.out.println(key + " key released");
                    if (code==KeyEvent.VK_1 && model.Color1 == null) {
                        model.Color1 = ii;
                       //sets the chosen color in a variable
                        System.out.println("color 1 selected for first color choice ");
                        keyTyped(ke);
                        instructions2.setText("Click four places in the window");
                        repaint();
                    }
                    else if(code==KeyEvent.VK_1 && model.Color1 != null) {
                        model.Color2 = ii;
                        System.out.println("color 1 selected for second color choice ");
                        keyTyped(ke);
                        instructions2.setForeground(Color.PINK);
                        instructions2.setText("Click four places in the window");
                        repaint();
                    }
                    else if (code==KeyEvent.VK_2 && model.Color1 == null) {
                        model.Color1 = iii;
                       //sets the chosen color in a variable
                        System.out.println("color 2 selected for first color choice ");
                        keyTyped(ke);
                        instructions2.setForeground(Color.BLUE);
                        instructions2.setText("Click four places in the window");
                        repaint();
                    }
                    else if(code==KeyEvent.VK_2 && model.Color1 != null) {
                        model.Color2 = iii;
                        System.out.println("color code 2 selected for second color choice ");
                        keyTyped(ke);
                        instructions2.setForeground(Color.ORANGE);
                        instructions2.setText("Click four places in the window");
                        repaint();
                    }
                     else if (code==KeyEvent.VK_3 && model.Color1 == null) {
                        model.Color1 = iv;
                       //sets the chosen color in a variable
                        System.out.println("color 3 selected for first color choice ");
                        keyTyped(ke);
                        instructions2.setForeground(Color.YELLOW);
                        instructions2.setText("Click four places in the window");
                        repaint();
                    }
                    else if(code==KeyEvent.VK_3 && model.Color1 != null) {
                        model.Color2 = iv;
                        System.out.println("color code 3 selected for second color choice");
                        keyTyped(ke);
                        instructions2.setForeground(Color.RED);
                        instructions2.setText("Click four places in the window");
                        repaint();
                    }

                    else {
                        instructions2.setForeground(Color.LIGHT_GRAY);
                        instructions2.setText("Invalid input!");
                        System.out.println("incorrect input");
                        keyTyped(ke); 
                        repaint();
                    }
            }
//=======================================================================================================
    //inner classes for mouse events
        @Override
    public void mousePressed(MouseEvent me) {
       System.out.println("x = " + model.xx +"\t " +" y = " + model.yy);
       mouse.setText("Mouse pressed "+ model.xx + ", "+ model.yy);

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(model.count <4) {
       model.xx = me.getX();
       model.yy = me.getY();
       System.out.println("x = " + model.xx +"\t " +" y = " + model.yy);
       mouse.setText("Mouse clicked: "+ model.xx + ", "+ model.yy);  
       
       model.polyX[model.count] = model.xx;
       model.polyY[model.count] = model.yy;
       
       Graphics g = getGraphics();
       myCanvas.paint(g);
       model.count++;
        }
        else if(model.count >= 4) {
            model.xxx = me.getX();
       model.yyy = me.getY();
        System.out.println("x = " + model.xxx +"\t " +" y = " + model.yyy);
       mouse.setText("Mouse clicked: "+ model.xxx + ", "+ model.yyy);
       if (model.line == 0 && model.yyy < model.polyY[0]|| model.yyy < model.polyY[1] //check for out of bounds
       ||model.yyy < model.polyY[2]|| model.yyy < model.polyY[3]) {
       model.lineX[model.line] = model.xxx;
       model.lineY[model.line] = model.yyy;
       System.out.println(model.lineX );
       System.out.println( model.lineY);
    Graphics g = getGraphics();
       myCanvas.paint(g);
       model.line++;
       }
       
       else if(model.line == 0 && model.yyy > model.polyY[0]|| model.yyy > model.polyY[1] 
       ||model.yyy > model.polyY[2]|| model.yyy > model.polyY[3]){
        JOptionPane.showMessageDialog(null, "Point out of bounds", "Error", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Out of bounds error");   
       }
       else if(model.line == 1 || model.line ==2) {
       model.lineX[model.line] = model.xxx;
       model.lineY[model.line] = model.yyy;
       System.out.println(model.lineX );
       System.out.println( model.lineY);
    Graphics g = getGraphics();
       myCanvas.paint(g);
       model.line++;
       
       }
    }
}

    @Override
    public void mouseReleased(MouseEvent me) {
      mouse.setText("Mouse dragged "+ model.xx + ", "+ model.yy);  
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        entry.setText("Now you see me...  ");
    }

    @Override
    public void mouseExited(MouseEvent me) {
        entry.setText("Now you don't!  ");
        JPanel panel1 = new JPanel(new GridBagLayout());//extra credit reoccuring popup image
               GridBagConstraints c = new GridBagConstraints();
               JFrame frame1 = new JFrame("\t\tFinish Line");
               JButton buttOn = new JButton();
               JLabel label = new JLabel("CONGRATULATIONS!");
               
               Image img1 = null;
            try {
                img1 = ImageIO.read(getClass().getResource("1.jpg"));
            } catch (IOException ex) {
                Logger.getLogger(P9.class.getName()).log(Level.SEVERE, null, ex);
            }
                buttOn.setIcon(new ImageIcon(img1));
               c.gridx = 1;
               c.gridy = 1;
               
               panel1.add(buttOn,c);
               c.gridx = 1;
               c.gridy = 3;
               panel1.add(label,c);
               frame1.add(BorderLayout.CENTER,panel1);
               frame1.setSize(300,150);
               frame1.setLocation(60, 160);
               frame1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
               frame1.setVisible(true); 
    }
//===============================================================================================================
    //window event     
    public static class WinClose extends WindowAdapter {
    @Override
    public void windowClosing( WindowEvent Poly ) {
        JOptionPane.showMessageDialog(null, "Thankyou! Goodbye! Please Come Again!", "Program Exit", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Program terminating");
        System.exit(0);
    }
  }
//===============================================================================================================

}

