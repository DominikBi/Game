package Main;

import java.time.LocalDate;

public class Date {
    private enum Month{
        JANUARY (1),FEBRUARY(2),MARCH(3),APRIL(4),MAY(5),JUNE(6),JULY(7),AUGUST(8),SEPTEMBER(9),OCTOBER(10),NOVEMBER(11),DECEMBER(12);

        private int value;
        private int numberOfDays;
        Month(int i) {
            this.value = i;
            numberOfDays = LocalDate.of(1,i,1).getMonth().length(false);


        }
        private int getValue(){
            return value;
        }
    }

    int year;
    Month month;
    int day;


    Date(int day,Month month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
}
