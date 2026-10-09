interface DeviceAction  {
    String execute(String action);
}
class Light implements DeviceAction  {
    public String execute(String a) {
        return "Light "+a;
    }
}
class Thermostat implements DeviceAction  {
    public String execute(String a) {
        return "Thermostat "+a;
    }
}
class Speaker implements DeviceAction  {
    public String execute(String a) {
        return "Speaker "+a;
    }
}
public class ConnectedHomeControlPanel  {
    static void runScene(DeviceAction[] devices, String action) {
        for(DeviceAction d:devices)System.out.println(d.execute(action));
    }
public static void main(String[] args) {
        runScene(new DeviceAction[] {
            new Light(), new Thermostat(), new Speaker()
        }, "activated");
    }
}
