import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Helper {
    public boolean IsDayOfWeek(String str) {
        if( str.equals("Понедельник") ||
            str.equals("Вторник")    ||
            str.equals("Среда")      ||
            str.equals("Четверг")    ||
            str.equals("Пятница")    ||
            str.equals("Суббота")    ||
            str.equals("Воскресенье")) {
            return true;
        } else {
            return false;
        }
    }

    public int GetIndexOfDayOfWeek(String str) {
        if(str.equals("Понедельник")) return 0;
        if(str.equals("Вторник")) return 1;
        if(str.equals("Среда")) return 2;
        if(str.equals("Четверг")) return 3;
        if(str.equals("Пятница")) return 4;
        if(str.equals("Суббота")) return 5;
        return 6;
    }

    public int GetTodayIndex(Elements allWeeks) {
        //String tempStr = allWeeks.get(0).select("h2.week_num").text();
        if(allWeeks.get(0).select("h2.week_num").text().contains("(текущая)")) {
            return (getCurrentDayOfWeek());
        } else {
            return (getCurrentDayOfWeek() + 7);
        }
    }

    private int getCurrentDayOfWeek() {
        Calendar calendar = new GregorianCalendar();
        if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
            return 0;
        }
        if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
            return 1;
        }
        if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
            return 2;
        }
        if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
            return 3;
        }
        if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
            return 4;
        }
        if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            return 5;
        }
        return 6;
    }
}
