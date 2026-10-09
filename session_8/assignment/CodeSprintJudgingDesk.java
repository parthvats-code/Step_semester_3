import java.util.*;
interface ScoringRule  {
    double score(int idea, int execution, int presentation);
}
class InnovationScoring implements ScoringRule  {
    public double score(int i, int e, int p) {
        return i*.5+e*.3+p*.2;
    }
}
class OpenScoring implements ScoringRule  {
    public double score(int i, int e, int p) {
        return (i+e+p)/3.0;
    }
}
class HackathonTeam  {
    String name, track;
    List<String> members;
    String project;
    double score;
    HackathonTeam(String n, String t, List<String> m) {
        if(m.size()<2||m.size()>4)throw new IllegalArgumentException("A team must have 2 to 4 members");
        name=n;
        track=t;
        members=m;
    }
void submit(String p) {
        if(project!=null)throw new IllegalStateException("One project only");
        project=p;
    }
void judge(int i, int e, int p, ScoringRule rule, boolean published) {
        if(published)throw new IllegalStateException("Results have already been published");
        score=rule.score(i, e, p);
    }
}
public class CodeSprintJudgingDesk  {
    public static void main(String[] args) {
        HackathonTeam t=new HackathonTeam("ByteBusters", "Innovation", Arrays.asList("Asha", "Ravi", "Neha"));
        System.out.println("Team "+t.name+" registered ("+t.members.size()+" members, "+t.track+" track).");
        try {
            new HackathonTeam("SoloCoder", "Open", Arrays.asList("Kiran"));
        } catch(Exception e) {
            System.out.println("Registration failed: "+e.getMessage()+".");
        }
t.submit("SmartAttend");
        System.out.println("Project 'SmartAttend' submitted by "+t.name+".");
        t.judge(8, 7, 9, new InnovationScoring(), false);
        System.out.printf("Final score: %.2f%n", t.score);
        try {
            t.judge(10, 7, 9, new InnovationScoring(), true);
        } catch(Exception e) {
            System.out.println("Rescore rejected: "+e.getMessage()+".");
        }
    }
}
