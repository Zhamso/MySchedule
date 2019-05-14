import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
Scanner sc = new Scanner(System.in);
//System.out.println("Введите номер группы");
//String groupId = sc.nextLine();
        String groupId = "05370";
        Helper helper = new Helper();
        Day[] days = new Day[14];
        for (int i = 0; i < 14; i++) {
            days[i] = new Day();
        }
        for (int i = 0; i < 7; i++) {
            if (i == 0) {
                days[i].DayName = "Понедельник";
                days[i + 7].DayName = "Понедельник";
            }
            if (i == 1) {
                days[i].DayName = "Вторник";
                days[i + 7].DayName = "Вторник";
            }
            if (i == 2) {
                days[i].DayName = "Среда";
                days[i + 7].DayName = "Среда";
            }
            if (i == 3) {
                days[i].DayName = "Четверг";
                days[i + 7].DayName = "Четверг";
            }
            if (i == 4) {
                days[i].DayName = "Пятница";
                days[i + 7].DayName = "Пятница";
            }
            if (i == 5) {
                days[i].DayName = "Суббота";
                days[i + 7].DayName = "Суббота";
            }
            if (i == 6) {
                days[i].DayName = "Воскресенье";
                days[i + 7].DayName = "Воскресенье";
            }
        }
        MyCounter myCounter = new MyCounter();
        Document page = Jsoup.connect("http://bsu.ru/rasp/?g=" + groupId).get();
        Elements allWeeks = page.select("div.week");
        Element firstWeek = allWeeks.get(0).select("tbody").first();
        Elements firstWeekDays = firstWeek.select("tr");
        Element secondWeek = allWeeks.get(1).select("tbody").first();
        Elements secondWeekDays = secondWeek.select("tr");
        int index = 0;
        for (Element element : firstWeekDays) {
            if (helper.IsDayOfWeek(element.text())) {
                String dayName = element.text();
                index = helper.GetIndexOfDayOfWeek(dayName);
                days[index].DayName = dayName;
            } else {
                if (element.text().length() < 10) {
                    days[index].subjects.add(new Subject(false));
                } else {
                    days[index].subjects.add(new Subject(true,
                            element.select("td.rasp_time").first().text(),
                            element.select("td.rasp_subj").first().text(),
                            element.select("td.rasp_subj_type").first().text(),
                            element.select("td.rasp_aud").first().text(),
                            element.select("td.rasp_teacher").first().text()));
                }
            }
        }

        for (Element element : secondWeekDays) {
            if (helper.IsDayOfWeek(element.text())) {
                String dayName = element.text();
                index = helper.GetIndexOfDayOfWeek(dayName) + 7;
                days[index].DayName = dayName;
            } else {
                if (element.text().length() < 10) {
                    days[index].subjects.add(new Subject(false));
                } else {
                    days[index].subjects.add(new Subject(true,
                            element.select("td.rasp_time").first().text(),
                            element.select("td.rasp_subj").first().text(),
                            element.select("td.rasp_subj_type").first().text(),
                            element.select("td.rasp_aud").first().text(),
                            element.select("td.rasp_teacher").first().text()));
                }
            }
        }
        myCounter.setValue(helper.GetTodayIndex(allWeeks));
        System.out.println("---==Расписание группы " + groupId + "==---");
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                System.out.println(days[myCounter.getValue()].DayName + " (сегодня)");
            } else {
                System.out.println(days[myCounter.getValue()].DayName);
            }
            days[myCounter.getValue()].PrintSchedule();
            myCounter.incrementCounter();
            System.out.println();
        }
        String trashVar = sc.next();
    }
}
