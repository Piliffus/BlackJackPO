import java.util.ArrayList;

public class Output
{
    public static void printHand(Hand hand)
    {
        if (hand.getCards().size() == 0)
        {
            System.out.println("This player has no cards");
        }
        else
        {
            System.out.print("Cards: ");
            for (Card card : hand.getCards())
            {
                System.out.print(card.getName() + " ");
            }
            System.out.print('\n');
        }
    }

    public static void printPlayerType(Player player)
    {
        System.out.println();
        System.out.println(player.getName());
    }

    public static void printWinners(ArrayList<Player> winners)
    {
        System.out.println();
        System.out.println("Game is over");
        System.out.println("Winners are:");
        for (Player player : winners)
        {
            System.out.print(player.getName() + " ");
        }
        System.out.print('\n');
    }

    public static void printRoundNumber(int roundNumber)
    {
        System.out.println();
        System.out.println("Round " + roundNumber);
    }

    public static void printScore(int score)
    {
        System.out.println("Score in this round: " + score);
    }

    public static void printRoundWinner(Player player)
    {
        System.out.println();
        System.out.println(player.getName() + " has won this round");
    }

    public static void printGameScore(ArrayList<Player> players)
    {
        System.out.println();
        for (Player player : players)
        {
            System.out.println(player.getName() + " has won " + player.getGameScore() + " rounds");
        }
    }
}
