public class RockPaperScissors {
    String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove))
            return "Draw";

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper")))
            return "Player Wins";

        return "Computer Wins";
    }

    public static void main(String[] args) {
        RockPaperScissors obj = new RockPaperScissors();

        String[] player = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        String[] computer = {"Scissors", "Paper", "Rock", "Rock", "Scissors"};

        int wins = 0, losses = 0, draws = 0;

        System.out.println("Round | Player | Computer | Result");

        for (int i = 0; i < 5; i++) {
            String result = obj.playRound(player[i], computer[i]);
            System.out.println((i + 1) + " | " + player[i] + " | " + computer[i] + " | " + result);

            if (result.equals("Player Wins"))
                wins++;
            else if (result.equals("Computer Wins"))
                losses++;
            else
                draws++;
        }

        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win %: " + (wins * 100.0 / 5));
    }
}
