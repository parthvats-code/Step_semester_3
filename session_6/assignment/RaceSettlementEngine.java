import java.util.*;
public class RaceSettlementEngine {
    static class Entry { final String id; final double fee; Entry(String i,double f){id=i;fee=f;} }
    static class RaceSystem {
        private int nextId=1001; private final Map<String,Entry> entries=new LinkedHashMap<>();
        String issue(double fee){String id="RACE-"+nextId++;entries.put(id,new Entry(id,fee));return id;}
        double discountedFee(double fee,String code){if("RUN10".equals(code))return fee*.9;if("STUDENT20".equals(code))return fee*.8;return fee;}
        double settle(){double total=0;for(Entry e:entries.values())total+=e.fee;return total;}
        int count(){return entries.size();}
    }
    public static void main(String[] args){RaceSystem r=new RaceSystem();System.out.println(r.issue(r.discountedFee(100,"RUN10")));System.out.println(r.issue(r.discountedFee(200,"STUDENT20")));System.out.printf("Entries: %d | Settlement: %.2f%n",r.count(),r.settle());}
}