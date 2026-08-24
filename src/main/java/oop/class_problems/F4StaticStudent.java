public class F4StaticStudent {

    static class SrmStudent {
        String name;
        String regNo;
        int attendance;

        static String university = "SRM Institute of Science and Technology";

        static int admissionCount = 0;

        SrmStudent(String name, int attendance) {
            this.name = name;
            this.attendance = attendance;

            admissionCount++;

            this.regNo = "RA2311003010" +
                    (10 + admissionCount);
        }

        void printIdCard() {
            System.out.println(
                    name + " | " + regNo + " | " + university);
        }

        static void printTotalAdmissions() {
            System.out.println(
                    "Students admitted so far: " +
                            admissionCount);
        }
    }

    public static void main(String[] args) {
        SrmStudent student1 = new SrmStudent("Ravi", 82);

        SrmStudent student2 = new SrmStudent("Meera", 74);

        SrmStudent student3 = new SrmStudent("Karthik", 91);

        student1.printIdCard();
        student2.printIdCard();
        student3.printIdCard();

        SrmStudent.printTotalAdmissions();
    }
}