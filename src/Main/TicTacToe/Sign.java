package Main.TicTacToe;

import java.util.Random;

public class Sign {

    public static final char STONE = 'S';
    public static final char PAPER = 'P';
    public static final char KNIFE = 'K';
    char sign;

    public char compare(Sign sign){
        if(this.sign == sign.getSign()) return 'T';
        else if(this.sign == 'S' && sign.getSign() == 'P' || this.sign == 'P' && sign.getSign() == 'K' || this.sign == 'K' && sign.getSign() == 'S')return 'L';
        else return 'W';
    }
    public Sign(char sign){
        this.sign = sign;

    }

    public char getSign() {
        return sign;
    }

    public Sign(){
        char[] cl = new char[3];
        cl[0] = 'S';
        cl[1] = 'P';
        cl[2] = 'K';
        Random r = new Random();
        char s = cl[r.nextInt(3)];
        this.sign = s;
    }
}
