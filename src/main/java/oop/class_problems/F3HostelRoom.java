public class F3HostelRoom {

    static class HostelRoom {
        String roomNo;
        int beds;
        int occupied;

        HostelRoom(String roomNo, int beds) {
            this.roomNo = roomNo;
            this.beds = beds;
            this.occupied = 0;
        }

        void allot(String studentName) {
            if (occupied < beds) {
                occupied++;
                System.out.println(studentName +
                        " allotted to room " + roomNo);
            } else {
                System.out.println("Waiting list for " + studentName);
            }
        }
    }

    public static void main(String[] args) {
        HostelRoom room214 = new HostelRoom("C-214", 2);

        HostelRoom sameRoom = room214;

        sameRoom.allot("Ravi");

        System.out.println("room214 occupied: " +
                room214.occupied);

        HostelRoom separate = new HostelRoom("C-214", 2);

        System.out.println("sameRoom == room214: " +
                (sameRoom == room214));

        System.out.println("separate == room214: " +
                (separate == room214));

        room214.allot("Anitha");
        room214.allot("Karthik");
    }
}

