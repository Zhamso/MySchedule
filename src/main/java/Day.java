import java.util.ArrayList;

public class Day {
    String DayName = "";
    public ArrayList<Subject> subjects = new ArrayList<Subject>();

    public Day() {
        DayName = "";
    }

    public void PrintSchedule() {
        if(subjects.size() == 0) {
            System.out.println("Занятий нет...");
        } else {
            for(Subject subject : subjects) {
                if(subject.HaveSubject) {
                    String out = String.format("%5s %-25s%-5s%-7s%-25s", subject.time, subject.subject, subject.type, subject.classRoom, subject.teacher);
                    System.out.println(out);
                } else {
                    System.out.println("  -:- Занятия нет");
                }
            }
        }
    }
}
