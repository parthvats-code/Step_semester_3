interface Serviceable {String performMaintenance();}
interface Insurable {String insuranceDetails();}
class Excavator implements Serviceable,Insurable {public String performMaintenance(){return "Excavator hydraulic and engine service completed";}public String insuranceDetails(){return "Excavator insurance active";}}
class Crane implements Serviceable {public String performMaintenance(){return "Crane cable and load-system inspection completed";}}
public class FleetMaintenanceTracker {public static void main(String[] args){Serviceable[] fleet={new Excavator(),new Crane()};for(Serviceable m:fleet)System.out.println(m.performMaintenance());System.out.println(((Insurable)fleet[0]).insuranceDetails());}}