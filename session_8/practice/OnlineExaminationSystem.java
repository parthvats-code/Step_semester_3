import java.util.*;
interface ExamQuestion {
    boolean correct(String a);
}
class ChoiceQuestion implements ExamQuestion {
    String answer;
    ChoiceQuestion(String a) {
        answer=a;
    }
    public boolean correct(String a) {
        return answer.equalsIgnoreCase(a);
    }
}
class ExamAttempt {
    String title;
    Map<Integer, String> answers=new HashMap<>();
    boolean submitted;
    ExamAttempt(String t) {
        title=t;
    }
    void answer(int q, String a) {
        if(submitted)throw new IllegalStateException("Submitted");
        answers.put(q, a);
    }
    int submit(ExamQuestion[] q) {
        if(submitted)throw new IllegalStateException("Already submitted");
        submitted=true;
        int n=0;
        for(int i=0;i<q.length;i++)if(q[i].correct(answers.getOrDefault(i+1, "")))n++;
        return n;
    }
}
public class OnlineExaminationSystem {
    public static void main(String[]x) {
        ExamQuestion[] q= {
            new ChoiceQuestion("A"), new ChoiceQuestion("B")
        };
        ExamAttempt a=new ExamAttempt("Math Quiz");
        System.out.println("Examination 'Math Quiz' started by Student.");
        a.answer(1, "A");
        System.out.println("Question 1 answered with 'A'.");
        a.answer(2, "C");
        System.out.println("Question 2 answered with 'C'.");
        System.out.println("Examination 'Math Quiz' submitted successfully.");
        System.out.println("Result for 'Math Quiz' attempt: "+a.submit(q)+"/2 correct.");
    }
}
