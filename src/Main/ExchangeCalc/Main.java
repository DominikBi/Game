package Main.ExchangeCalc;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class Main {

    //enumExample
    enum Season {
        SUMMER(0), FALL(1), WINTER(2), SPRING(3);


        private int value;

        Season(int value) {
            this.value = value;
        }
        }
    public static void main(String[] args){
        //print Enums
        for(Season s: Season.values()){
            System.out.println(s+ " " + s.value );
        }
        Main main = new Main();
        //run start method
        main.start();
    }
    //money that I got
    private final float money = 650;


    private void start() {

        System.out.println(String.valueOf(10) + String.valueOf(10));
        JFrame jFrame = new JFrame();
        JPanel panel = new JPanel();
        //creating all textfields
        JProgressBar progressBarDaysLeft = new JProgressBar();
        JProgressBar progressBarMoneyLeft = new JProgressBar();
        JTextField describePBDL = new JTextField("Amount of days left relative to total days");
        JTextField describePBML = new JTextField("Amount of money left relative to total money");
        JTextField moneyLeft = new JTextField();
        JTextField percentageOfDaysLeft = new JTextField();
        JTextField daysLeft = new JTextField();
        JTextField daysBehind = new JTextField();
        JTextField moneyAlreadySpent = new JTextField();
        JTextField moneyToSpendOnAverage = new JTextField();
        JTextField moneyToSpendOnAverageInDollars = new JTextField();
        JTextField moneySpendOnAverage = new JTextField();
        JTextField moneyToSpendOnAverageIfOnlyOnWeekends = new JTextField();
        JButton submit = new JButton("Submit");
        //getting all the dates
        LocalDate now = LocalDate.now();
        LocalDate depAt = LocalDate.of(2019,9,24);
        LocalDate arrivedAt = LocalDate.of(2019,7,9);
        LocalDate paArrives = LocalDate.of(2019,9,19);
        //calculating how much time has passed
        float timeGone = compare(arrivedAt,now);
        float timeLeft = compare(now,paArrives);
        float totalTime = compare(arrivedAt,paArrives);
        float timeTilPaArrives = compare(now,paArrives);
        System.out.println(totalTime);
        System.out.println(timeTilPaArrives);
        //System.out.println("C: " + sdf.format(now) + " L: " + sdf.format(depAt) + " A: " + sdf.format(arrivedAt));
        System.out.println("G: " + timeGone + " L:" + timeLeft);
        moneyLeft.setPreferredSize(new Dimension(120,30));
        submit.setPreferredSize(new Dimension(90,30));
        //adding button and moneyLeft textfield
        panel.add(moneyLeft);
        panel.add(submit);
        //init JFrame
        jFrame.add(panel);
        jFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        jFrame.setVisible(true);
        /*Frame frame = new Frame();
        frame.setBackground(Color.BLACK);
        frame.setUndecorated(true);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setVisible(true);*/

        submit.addActionListener(e -> {
            //calculating and setting all the values
            float moneyOnCard = Float.parseFloat(moneyLeft.getText());
            daysLeft.setText("Days Left: " + timeLeft);
            daysBehind.setText("Days behind: " + timeGone);
            float moneySpend = money-moneyOnCard;
            moneyAlreadySpent.setText("Money spent: " + moneySpend);
            float moneySpentPerDay = moneySpend/timeGone;
            moneySpendOnAverage.setText("Money spent on average: " + moneySpentPerDay);
            float moneyLeftToSpendPerDay = moneyOnCard/timeLeft;
            moneyToSpendOnAverage.setText("Money to spent each day: " + moneyLeftToSpendPerDay);
            moneyToSpendOnAverageInDollars.setText("Money to spend each day in dollars: " + moneyLeftToSpendPerDay*1.64);
            percentageOfDaysLeft.setText("Percentage of Days left: " + (timeLeft/(totalTime))*100);
            moneyToSpendOnAverageIfOnlyOnWeekends.setText("Money to spend if spend only on weekend: " + moneyLeftToSpendPerDay*7/3);
            //set Editable false on everyone
            moneyToSpendOnAverageIfOnlyOnWeekends.setEditable(false);
            percentageOfDaysLeft.setEditable(false);
            moneyAlreadySpent.setEditable(false);
            moneyToSpendOnAverageInDollars.setEditable(false);
            moneySpendOnAverage.setEditable(false);
            daysBehind.setEditable(false);
            daysLeft.setEditable(false);
            moneyToSpendOnAverage.setEditable(false);
            describePBDL.setEditable(false);
            describePBML.setEditable(false);
            progressBarDaysLeft.setMaximum(100);
            progressBarDaysLeft.setValue(100-(int)((timeLeft/(timeGone+timeLeft))*100));
            progressBarMoneyLeft.setMaximum((int) money);
            progressBarMoneyLeft.setValue((int) (money-moneyOnCard));

            //remove doesn't work
            jFrame.remove(submit);
            //adding all the textfield to the frame
            panel.add(daysBehind);
            panel.add(daysLeft);
            panel.add(percentageOfDaysLeft);
            panel.add(moneyAlreadySpent);
            panel.add(moneySpendOnAverage);
            panel.add(moneyToSpendOnAverage);
            panel.add(moneyToSpendOnAverageInDollars);
            panel.add(moneyToSpendOnAverageIfOnlyOnWeekends);
            panel.add(describePBDL);
            panel.add(progressBarDaysLeft);
            panel.add(describePBML);
            panel.add(progressBarMoneyLeft);
            //updating the jFrame. Maybe works with repaint->better
            jFrame.setSize(1,1);
            jFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        });
    }
    //compare two dates if they are in the same month
    private float compare(LocalDate first,LocalDate second){

        float daysBetween = 0;
        for(int i = first.getMonth().getValue(); i < second.getMonth().getValue();i++){
            //for every month add the number of days that the month has
           daysBetween = daysBetween + LocalDate.of(2019,i,1).getMonth().length(false);


        }
        //add month is done
        daysBetween+=second.getDayOfMonth()-first.getDayOfMonth();
    return daysBetween;
    }
}
