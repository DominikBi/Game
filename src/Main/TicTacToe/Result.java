package Main.TicTacToe;

public class Result {


    public void calc(Sign aiC, Sign hpC) {
        switch (hpC.compare(aiC)){
            case 'W':System.out.println("You won!");break;
            case 'L':System.out.println("You lost!");break;
            default:System.out.println("Tie");break;

        }
    }
}
