package Main.TicTacToe;

import java.util.Scanner;

public class HumanPlayer {

    public Sign requestSign(){
        Scanner sc = new Scanner(System.in);
        return new Sign(sc.next().charAt(0));

    }
}
