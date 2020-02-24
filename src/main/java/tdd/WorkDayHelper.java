package tdd;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WorkDayHelper {
    public static LocalDate getFirstWorkDay(LocalDate localDate){
        localDate=localDate.minusDays(localDate.getDayOfMonth()-1);
        do{
            DayOfWeek dayOfWeek=localDate.getDayOfWeek();
            if(dayOfWeek.getValue()>=0&&dayOfWeek.getValue()<=5)return localDate;
            localDate = localDate.plusDays(1);
        }while (true);
    }
    public static LocalDate getLastWorkDay(LocalDate localDate){
        localDate=localDate.plusDays(localDate.lengthOfMonth()-localDate.getDayOfMonth());
        do{
            DayOfWeek dayOfWeek=localDate.getDayOfWeek();
            if(dayOfWeek.getValue()>=0&&dayOfWeek.getValue()<=5)return localDate;
            localDate = localDate.minusDays(1);
        }while (true);
    }
}
