package Main;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args){
        Main main = new Main();
        main.start();
    }
    private final float money = 800;
    private static final DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private void start() {
        String s = "";
        System.out.println(s.split(" ").length);
        JFrame jFrame = new JFrame();
        JPanel panel = new JPanel();
        JTextField moneyLeft = new JTextField();
        JTextField daysLeft = new JTextField();
        JTextField daysBehind = new JTextField();
        JTextField moneyAlreadySpent = new JTextField();
        JTextField moneyToSpendOnAverage = new JTextField();
        JTextField moneySpendOnAverage = new JTextField();
        JButton submit = new JButton();
        LocalDate now = LocalDate.now();
        LocalDate depAt = LocalDate.of(2019,9,24);
        LocalDate arrivedAt = LocalDate.of(2019,7,9);
        float timeGone = compare(arrivedAt,now);
        float timeLeft = compare(now,depAt);
        //System.out.println("C: " + sdf.format(now) + " L: " + sdf.format(depAt) + " A: " + sdf.format(arrivedAt));
        System.out.println("G: " + timeGone + " L:" + timeLeft);
        System.out.println((timeLeft/(timeGone+timeLeft))*100);
        moneyLeft.setPreferredSize(new Dimension(120,30));
        panel.add(moneyLeft);
        panel.add(submit);
        jFrame.add(panel);
        jFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        jFrame.setVisible(true);
        submit.addActionListener(e -> {
            float moneyOnCard = Float.parseFloat(moneyLeft.getText());
            daysLeft.setText("Days Left: " + timeLeft);
            daysBehind.setText("Days to go: " + timeGone);
            float moneySpend = 800-moneyOnCard;
            moneyAlreadySpent.setText("Money spent: " + moneySpend);
            float moneySpentPerDay = moneySpend/timeGone;
            moneySpendOnAverage.setText("Money spent on average: " + moneySpentPerDay);
            float moneyLeftToSpendPerDay = moneyOnCard/timeLeft;
            moneyToSpendOnAverage.setText("Money to spent each day: " + moneyLeftToSpendPerDay);
            moneyAlreadySpent.setEditable(false);
            moneyLeft.setEditable(false);
            moneySpendOnAverage.setEditable(false);
            daysBehind.setEditable(false);
            daysLeft.setEditable(false);
            moneyToSpendOnAverage.setEditable(false);
            jFrame.remove(submit);
            panel.add(daysBehind);
            panel.add(daysLeft);
            panel.add(moneyAlreadySpent);
            panel.add(moneySpendOnAverage);
            panel.add(moneyToSpendOnAverage);
            jFrame.setSize(1,1);
            jFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        });
    }
    private float compare(LocalDate first,LocalDate second){
        float daysBetween = 0;
        for(int i = first.getMonth().getValue(); i < second.getMonth().getValue();i++){
           daysBetween = daysBetween + LocalDate.of(2019,i,1).getMonth().length(false);


        }
        daysBetween+=second.getDayOfMonth()-first.getDayOfMonth();
    return daysBetween;
    }
}
