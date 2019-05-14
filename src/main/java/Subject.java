public class Subject {
    public boolean HaveSubject = false;
    public String time;
    public String subject;
    public String type;
    public String classRoom;
    public String teacher;

    public Subject() {
    }

    public Subject(boolean haveSubject) {
        HaveSubject = haveSubject;
    }

    public Subject(boolean haveSubject, String time, String subject, String type, String classRoom, String teacher) {
        HaveSubject = haveSubject;
        this.time = time;
        this.subject = subject;
        this.type = type;
        this.classRoom = classRoom;
        this.teacher = teacher;
    }
}
