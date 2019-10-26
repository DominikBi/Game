package Main.Snake;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Snake  {



    public static void main(String[] args){
        Snake snake = new Snake();
    }

   Positon positon = new Positon();
    JSnake snakeField = new JSnake();
    boolean alive = true;

    public enum Direction{
        UP("up"),DOWN("down"),LEFT("left"),RIGHT("right");

        String value;

        Direction(String a){
            value = a;


        }

    }
    public enum Move{
        MOVED_UP,MOVED_DOWN,MOVED_LEFT,MOVED_RIGHT;
    }

    volatile Direction direction = Direction.DOWN;
    Snake(boolean first){

    }
    Snake() {

        JFrame frame = new JFrame();

        frame.add(snakeField);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setVisible(true);
        frame.addKeyListener(new KeyAdapter() {
                                 @Override
                                 public void keyReleased(KeyEvent e) {
                                     super.keyReleased(e);
                                     if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                                         direction = Direction.DOWN;
                                         System.out.println(direction.value);
                                     } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                                         direction = Direction.UP;
                                         System.out.println(direction.value);
                                     } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                                         direction = Direction.LEFT;
                                         System.out.println(direction.value);
                                     } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                                         direction = Direction.RIGHT;
                                         System.out.println(direction.value);
                                     }
                                 }
                             });
                //Runnable runnable = new Snake(true);
                //new Thread(runnable).start();
        while (true) {
            try {
                Thread.sleep(250);
                if (direction == Direction.DOWN) {
                    positon.setY(positon.getY() + 1);
                } else if (direction == Direction.UP) {
                    positon.setY(positon.getY() - 1);
                } else if (direction == Direction.LEFT) {
                    positon.setX(positon.getX() - 1);
                } else if (direction == Direction.RIGHT) {
                    positon.setX(positon.getX() + 1);
                }
                if(positon.getY()<0){
                    positon.setY(positon.getY()+1);
                    alive = false;
                }
                else if(positon.getY()>27){
                    positon.setY(positon.getY()-1);
                    alive = false;
                }else if (positon.getX()<0){
                    positon.setX(positon.getX()+1);
                    alive = false;
                }else if (positon.getX()>48){
                    positon.setX(positon.getX()-1);
                    alive = false;
                }
                snakeField.positionChanged(positon);
                if (!alive)break;

                System.out.println("x: " + positon.getX() + " y: " + positon.getY());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
