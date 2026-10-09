import java.util.*;
class Student  {
    String name, type;
    int credits;
    Student(String n, String t) {
        name=n;
        type=t;
    }
int limit() {
        return type.equals("Honors")?28:type.equals("Exchange")?20:24;
    }
}
class Elective  {
    String name;
    int capacity, credits;
    List<Student> enrolled=new ArrayList<>(), wait=new ArrayList<>();
    Elective(String n, int c, int cr) {
        name=n;
        capacity=c;
        credits=cr;
    }
String enroll(Student s) {
        if(enrolled.contains(s)||wait.contains(s))return "Duplicate enrollment rejected.";
        if(s.credits+credits>s.limit())return "Credit limit exceeded.";
        if(enrolled.size()<capacity) {
            enrolled.add(s);
            s.credits+=credits;
            return s.name+" enrolled in "+name;
        }
wait.add(s);
        return s.name+" added to waitlist for "+name;
    }
void drop(Student s) {
        if(enrolled.remove(s)) {
            s.credits-=credits;
            while(!wait.isEmpty()) {
                Student n=wait.remove(0);
                if(n.credits+credits<=n.limit()) {
                    enrolled.add(n);
                    n.credits+=credits;
                    System.out.println(n.name+" promoted from waitlist.");
                    break;
                }
            }
        }
    }
}
public class ElectiveSeatRush  {
    public static void main(String[] args) {
        Elective e=new Elective("AI Ethics", 1, 3);
        Student a=new Student("Asha", "Regular"), b=new Student("Ravi", "Honors");
        System.out.println(e.enroll(a));
        System.out.println(e.enroll(b));
        e.drop(a);
        System.out.println("Enrolled: "+e.enrolled.size());
    }
}
