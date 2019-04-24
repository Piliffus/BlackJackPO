import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Game implements Comparator<Player>
{
    ArrayList<Player> players;
    Dealer dealer;
    boolean gameOver;

    public void start(int howManyPlayers)
    {
        gameOver = false;
        preparePlayers(howManyPlayers);
        prepareDealer();
        playRound();
    }

    private void playRound()
    {
        while (!gameOver)
        {
            dealCards();
            givePoints();
        }

        whoWon();
    }

    private void whoWon()
    {
        ArrayList<Player> winners = new ArrayList<>(1);
        players.sort(this);
        int maxPoints = players.get(players.size()-1).getGameScore();

        for (int i = players.size()-1; i >= 0; i--)
        {
            if (players.get(i).getGameScore() == maxPoints)
            {
                winners.add(players.get(i));
            }
            else // (players.get(i).getGameScore() < maxPoints)
            {
                break;
            }
        }
    }

    private void givePoints()
    {
        int maxPoints = -1;

        Collections.sort(players);

        for (int i = players.size()-1; i >= 0; i--)
        {
            if (players.get(i).getScore() < 21)
            {
                maxPoints = players.get(i).getScore();
                break;
            }
        }

        for (Player player : players)
        {
            if (player.askForScore() == maxPoints)
            {
                player.givePoint();
            }
        }
    }

    private void dealCards()
    {
        for (Player player : players)
        {
            player.startOfTurn();
            while (!player.hasPassed())
            {
                player.playTurn();
            }
            player.endOfTurn();
        }
    }

    private void prepareDealer()
    {
        dealer = new Dealer();
    }

    private void preparePlayers(int howManyPlayers)
    {
        Random generator = new Random();
        String[] playerTypes = Player.getPlayerTypes();

        players = new ArrayList<>(howManyPlayers);
        players.add(0, new CroupierPlayer());

        for (int i = 1; i < howManyPlayers; i++) // '<=' would be howManyPlayers if we do not count the croupier
        {
            switch (playerTypes[generator.nextInt(playerTypes.length-1)])
            {
                case "Random":
                    players.add(i, new RandomPlayer());
                    break;
                case "Sleeper":
                    players.add(i, new SleeperPlayer());
                    break;
                case "Limit":
                    players.add(i, new LimitPlayer());
                    break;
                case "Careful":
                    players.add(i, new CarefulPlayer());
                    break;
            }
        }
    }

    @Override
    public int compare(Player o1, Player o2)
    {
        return o1.getGameScore() - o2.getGameScore();
    }
}
