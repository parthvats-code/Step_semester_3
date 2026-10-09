interface Exportable {
    String exportData();
}
class ExportCounter {
    static int total;
    static int getTotalExports() {
        return total;
    }
}
class ReportGenerator implements Exportable {
    String name;
    ReportGenerator(String n) {
        name=n;
    }
    public String exportData() {
        ExportCounter.total++;
        return "Exported report: "+name;
    }
}
class UserProfile implements Exportable {
    String username;
    UserProfile(String u) {
        username=u;
    }
    public String exportData() {
        ExportCounter.total++;
        return "Exported profile: "+username;
    }
}
public class OneClickDataExport {
    static void exportAll(Exportable[] items) {
        for(Exportable e:items)System.out.println(e.exportData());
    }
    static int getTotalExports() {
        return ExportCounter.getTotalExports();
    }
    public static void main(String[] args) {
        ReportGenerator r=new ReportGenerator("Sales Q1");
        UserProfile u=new UserProfile("jane_doe");
        exportAll(new Exportable[] {
            r, u
        });
        System.out.println(getTotalExports());
    }
}
