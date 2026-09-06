
import java.util.Arrays;

class DischargeSummary {

    private final String patientId;
    private final String[] medicationCodes;

    public DischargeSummary(String patientId,
            String[] medicationCodes) {

        if (patientId == null || medicationCodes == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        for (String code : medicationCodes) {
            if (!isValidCode(code)) {
                throw new IllegalArgumentException(
                        "Invalid medication code");
            }
        }

        this.patientId = patientId;
        this.medicationCodes = medicationCodes.clone();
    }

    private boolean isValidCode(String code) {

        if (code == null || code.length() != 5) {
            return false;
        }

        if (!code.startsWith("MED-")) {
            return false;
        }

        return Character.isUpperCase(code.charAt(4));
    }

    public String getPatientId() {
        return patientId;
    }

    public String[] getMedicationCodes() {
        return medicationCodes.clone();
    }

    public DischargeSummary withCorrectedMedication(
            int index, String newCode) {

        if (index < 0 || index >= medicationCodes.length) {
            throw new IndexOutOfBoundsException();
        }

        if (!isValidCode(newCode)) {
            throw new IllegalArgumentException(
                    "Invalid medication code");
        }

        String[] corrected = medicationCodes.clone();
        corrected[index] = newCode;

        return new DischargeSummary(patientId, corrected);
    }
}

class CriticalCareDischargeSummary extends DischargeSummary {

    private final int icuDays;

    public CriticalCareDischargeSummary(
            String patientId,
            String[] medicationCodes,
            int icuDays) {

        super(patientId, medicationCodes);
        this.icuDays = icuDays;
    }

    public int getIcuDays() {
        return icuDays;
    }
}

public class DischargeSummaryLedger {

    static String systemName;

    static {
        systemName = "MediTrack Clinic";
    }

    static String processNightlyBatch(
            DischargeSummary[] summaries) {

        int processed = 0;
        int nullSkipped = 0;
        int criticalCare = 0;
        int routine = 0;

        for (DischargeSummary summary : summaries) {

            if (summary == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (summary instanceof CriticalCareDischargeSummary) {
                criticalCare++; 
            }else {
                routine++;
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + criticalCare + " critical-care | "
                + routine + " routine";
    }

    public static void main(String[] args) {

        try {
            new DischargeSummary(
                    "MT2026-0142",
                    new String[]{"MED-A", "bad"});
        } catch (Exception e) {
            System.out.println("Construction rejected");
        }

        DischargeSummary d
                = new DischargeSummary(
                        "MT2026-0142",
                        new String[]{"MED-A", "MED-B"});

        String[] codes = d.getMedicationCodes();
        codes[0] = "TAMPERED";

        System.out.println(
                d.getMedicationCodes()[0]);

        DischargeSummary corrected
                = d.withCorrectedMedication(
                        0, "MED-X");

        System.out.println(
                Arrays.toString(
                        corrected.getMedicationCodes()));

        DischargeSummary[] summaries = {
            new CriticalCareDischargeSummary(
            "MT001",
            new String[]{"MED-X"},
            4),
            null,
            new DischargeSummary(
            "MT002",
            new String[]{"MED-Y"})
        };

        System.out.println(
                processNightlyBatch(summaries));
    }
}
