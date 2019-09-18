package Main.TicTacToe;

import java.util.Map;

public class Main {

    public static void main(String args[]){
        Main main = new Main();
        main.run();
    }

    public void run(){
        AIPlayer aiPlayer = new AIPlayer();
        HumanPlayer humanPlayer = new HumanPlayer();
        Sign hp = humanPlayer.requestSign();
        Sign ai = aiPlayer.requestSign();
        Result result = new Result();
        result.calc(ai,hp);

    }
}
