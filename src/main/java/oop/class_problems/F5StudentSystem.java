public class F5StudentSystem {

    static class FeeAccount {
        double totalFee;
        double amountPaid;

        FeeAccount(double totalFee) {
            this.totalFee = totalFee;
        }

        void pay(double amount) {
            if (amount > 0) {
                amountPaid += amount;
            }
        }

        void payInTwoInstallments(double amount) {
            pay(amount / 2);
            pay(amount / 2);
        }

        double getDue() {
            return totalFee - amountPaid;
        }

        double effectiveDue(double scholarshipPercent) {
            return getDue() -
                    (getDue() * scholarshipPercent / 100);
        }
    }

    static class HostelRoom {
        String roomNo;
        int beds;
        int occupied;

        HostelRoom(String roomNo, int beds) {
            this.roomNo = roomNo;
            this.beds = beds;
        }

        void allot(String studentName) {
            if (occupied < beds) {
                occupied++;
            }
        }
    }

    static class SrmStudent {
        String name;
        String regNo;
        FeeAccount feeAccount;
        HostelRoom room;

        static int totalStudents = 0;

        SrmStudent(String name, String regNo,
                FeeAccount feeAccount,
                HostelRoom room) {
            this.name = name;
            this.regNo = regNo;
            this.feeAccount = feeAccount;
            this.room = room;

            totalStudents++;
        }

        String fullStatus() {
            return name +
                    " | Due: Rs " +
                    feeAccount.getDue() +
                    " | Room: " +
                    room.roomNo;
        }
    }

    public static void main(String[] args) {
        FeeAccount fee1 = new FeeAccount(200000);
        FeeAccount fee2 = new FeeAccount(180000);
        FeeAccount fee3 = new FeeAccount(200000);

        HostelRoom room1 = new HostelRoom("C-214", 2);
        HostelRoom room2 = new HostelRoom("C-507", 2);
        HostelRoom room3 = new HostelRoom("C-309", 2);

        SrmStudent student1 = new SrmStudent(
                "Ravi",
                "101",
                fee1,
                room1);

        SrmStudent student2 = new SrmStudent(
                "Anitha",
                "102",
                fee2,
                room2);

        SrmStudent student3 = new SrmStudent(
                "Karthik",
                "103",
                fee3,
                room3);

        fee1.payInTwoInstallments(120000);
        fee3.pay(56000);

        System.out.println(student1.fullStatus());
        System.out.println(student2.fullStatus());
        System.out.println(student3.fullStatus());

        System.out.println(
                "Total students: " +
                        SrmStudent.totalStudents);
    }
}