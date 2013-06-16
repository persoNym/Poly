/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent.*;

/**
 *
 * @author nezu
 */
public class Canvas extends JPanel {
    
    
P9Model model ;
 
 public Canvas( P9Model m) {
        model = m;
        setSize(600, 600);
    } 
   
    @Override
    public void paint( Graphics g)  {
      super.paint(g);
        super.setName("Poly Gone");
//=====================================================================================     
        //getting the circles of click placement
        if(model.xx!=0 && model.yy!=0) {
        int radius = 5;
        g.setColor(Color.black);
        g.drawOval(model.xx-radius, model.yy-radius, 2*radius, 2*radius);
        g.fillOval(model.xx-radius, model.yy-radius, 2*radius, 2*radius);
        }
        //get the circles for line placement
          if(model.xxx!=0 && model.yyy!=0) {
        int radius = 5;
        g.setColor(Color.black);
        g.drawOval(model.xxx-radius, model.yyy-radius, 2*radius, 2*radius);
        g.fillOval(model.xxx-radius, model.yyy-radius, 2*radius, 2*radius);
        }
          
//=======================================================================================
          //draw line
          if(model.line ==1) {
               g.setColor(model.Color2);
               System.out.println("line" +model.lineX + model.lineY);
                       
         for(int k=0; k < model.count; k++){

         g.drawLine(model.lineX[0], model.lineY[0],model.lineX[1], model.lineY[1] );
         }
          }
        //draw polygon
       
        if(model.count ==3 ) {
         g.setColor(model.Color1);
         for(int l=0; l < model.count; l++){
       
         g.fillPolygon(model.polyX, model.polyY, model.count+1);
         }
         P9.instructions3.setForeground(Color.DARK_GRAY);
         P9.instructions3.setText("click the mouse inside the polygon and drag it outside the polygon");
        }
//========================================================================================

    }
}