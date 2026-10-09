import java.util.*;
interface Capability {
    String name();
    String apply(String device, String value);
}
class PowerCapability implements Capability {
    public String name() {
        return "Power";
    }
    public String apply(String d, String v) {
        if(!v.equals("ON")&&!v.equals("OFF"))return "Rejected power value";
        return d+": "+v+".";
    }
}
class BrightnessCapability implements Capability {
    public String name() {
        return "Brightness";
    }
    public String apply(String d, String v) {
        int n=Integer.parseInt(v);
        return n<0||n>100?"Rejected: brightness must be 0-100%.":d+": brightness set to "+n+"%.";
    }
}
class TemperatureCapability implements Capability {
    public String name() {
        return "Temperature";
    }
    public String apply(String d, String v) {
        int n=Integer.parseInt(v);
        return n<16||n>30?"Rejected: temperature must be between 16°C and 30°C.":d+": temperature set to "+n+"°C.";
    }
}
class SmartDevice {
    String name;
    Map<String, Capability> caps=new HashMap<>();
    SmartDevice(String n) {
        name=n;
    }
    void add(Capability c) {
        caps.put(c.name(), c);
    }
    String apply(String cap, String val) {
        Capability c=caps.get(cap);
        return c==null?name+": capability missing.":c.apply(name, val);
    }
}
public class SmartLabControlPanel {
    public static void main(String[] args) {
        SmartDevice ac=new SmartDevice("Lab AC"), lights=new SmartDevice("Ceiling Lights"), projector=new SmartDevice("Projector");
        ac.add(new PowerCapability());
        ac.add(new TemperatureCapability());
        lights.add(new PowerCapability());
        lights.add(new BrightnessCapability());
        projector.add(new PowerCapability());
        System.out.println("Scene 'Lecture Mode' started.");
        for(SmartDevice d:new SmartDevice[] {
            ac, lights, projector
        })System.out.println(d.apply("Power", "ON"));
        System.out.println(lights.apply("Brightness", "40"));
        System.out.println(ac.apply("Temperature", "24"));
        System.out.println("Rejected: "+ac.apply("Temperature", "12"));
        projector.add(new BrightnessCapability());
        System.out.println("Projector: Brightness capability added.");
        System.out.println(projector.apply("Brightness", "70"));
    }
}
