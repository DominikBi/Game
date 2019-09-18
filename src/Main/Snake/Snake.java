package Main.Snake;


import javax.swing.*;
import java.awt.*;

public class Snake {

    public static void main(String[] args){
        Snake snake = new Snake();
    }
    Snake(){

        JFrame frame = new JFrame();
        JSnake snakeField = new JSnake();
        frame.add(snakeField);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setVisible(true);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        frame.requestFocus();
        System.out.println("Req fos");

    }
}
