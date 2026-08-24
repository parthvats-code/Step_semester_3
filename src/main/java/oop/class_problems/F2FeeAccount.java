public class F2FeeAccount {

    static class FeeAccount {
        private String regNo;
        private double totalFee;
        private double amountPaid;

        FeeAccount(String regNo, double totalFee) {
            this.regNo = regNo;
            this.totalFee = totalFee;
            this.amountPaid = 0;
        }

        void pay(double amount) {
            if (amount <= 0) {
                System.out.println("Invalid payment");
                return;
            }

            amountPaid += amount;
        }

        double getDue() {
            return totalFee - amountPaid;
        }

        void payInTwoInstallments(double amount) {
            pay(amount / 2);
            pay(amount / 2);
        }

        double effectiveDue(double scholarshipPercent) {
            return getDue() - (getDue() * scholarshipPercent / 100);
        }
    }

    public static void main(String[] args) {
        FeeAccount accountA = new FeeAccount("A101", 200000);
        FeeAccount accountB = new FeeAccount("A102", 180000);

        accountA.payInTwoInstallments(120000);

        System.out.println("Account A due: Rs " +
                accountA.getDue());

        System.out.println("Account B effective due: Rs " +
                accountB.effectiveDue(20));
    }
}

