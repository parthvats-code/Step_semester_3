public class PatientProfile {

    private String patientId;
    private String name;
    private boolean discharged;
    private String lockerPin;

    public PatientProfile() {
        this(null, null);
    }

    public PatientProfile(String name) {
        this(null, name);
    }

    public PatientProfile(String patientId, String name) {
        this.patientId = patientId;
        this.name = name;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String id) {
        if (patientId == null)
            patientId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDischarged() {
        return discharged;
    }

    public void setDischarged(boolean discharged) {
        this.discharged = discharged;
    }

    public void setLockerPin(String pin) {
        if (pin == null)
            return;

        if (pin.length() < 4 || pin.length() > 6)
            return;

        for (int i = 0; i < pin.length(); i++) {
            if (!Character.isDigit(pin.charAt(i)))
                return;
        }

        lockerPin = pin.hashCode() + "";
    }

    public static void main(String[] args) {

        PatientProfile p =
                new PatientProfile("Arjun Iyer");

        System.out.println(p.getPatientId());

        p.setPatientId("MT2026-0142");
        p.setPatientId("HACKED-0000");

        System.out.println(p.getPatientId());

        p.setDischarged(true);

        System.out.println(p.isDischarged());

        p.setLockerPin("4820");
    }
}
