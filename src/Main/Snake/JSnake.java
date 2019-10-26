package Main.Snake;

import javax.swing.*;
import java.awt.*;

public class JSnake extends JComponent {


    Positon position = new Positon();


    @Override
    protected void paintComponent(Graphics g) {


        setBackground(Color.BLACK);
        g.setColor(Color.BLACK);
        g.fillRect(position.getX()*30, position.getY()*30,30,30);
        System.out.println(position.getX());
        super.paintComponent(g);
    }

    public void positionChanged(Positon p){
        this.position = p;
        repaint();
    }
}
