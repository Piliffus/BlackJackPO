import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Game implements Comparator<Player>
{
    private ArrayList<Player> players;
    private Dealer dealer;
    private boolean gameOver;
    private int roundNumber;
    private int howManyRounds;

    public void start(int howManyPlayers, int howManyRounds)
    {
        this.roundNumber = 0;
        this.howManyRounds = howManyRounds;
        this.gameOver = false;
        preparePlayers(howManyPlayers);
        prepareDealer();
        playRound();
    }

    private void playRound()
    {
        while (!gameOver)
        {
            roundNumber++;
            Output.printRoundNumber(roundNumber);
            dealCards();
            givePoints();
            if (roundNumber >= howManyRounds) gameOver = true;
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

        Output.printWinners(winners);
    }

    private void givePoints()
    {
        int maxPoints = -1;

        Collections.sort(players);

        for (int i = players.size()-1; i >= 0; i--)
        {
            if (players.get(i).getScore() <= 21)
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
                Output.printRoundWinner(player);
            }
        }

        Output.printGameScore(players);
    }

    private void dealCards()
    {
        dealer.shuffleDeck();
        for (Player player : players)
        {
            player.startOfTurn();
            while (!player.hasPassed())
            {
                player.playTurn(dealer);
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
        players.add(0, new CroupierPlayer("Croupier"));
        int howManyRandoms = 0;
        int howManySleepers = 0;
        int howManyLimiters = 0;
        int howManyCareful = 0;

        for (int i = 1; i < howManyPlayers; i++) // '<=' would be howManyPlayers if we do not count the croupier
        {
            switch (playerTypes[generator.nextInt(playerTypes.length)])
            {
                case "Random":
                    howManyRandoms++;
                    players.add(i, new RandomPlayer("Random #" + howManyRandoms));
                    break;
                case "Sleeper":
                    howManySleepers++;
                    players.add(i, new SleeperPlayer("Sleeper #" + howManySleepers));
                    break;
                case "Limit":
                    howManyLimiters++;
                    players.add(i, new LimitPlayer("Limit #" + howManyLimiters, 14));
                    break;
                case "Careful":
                    howManyCareful++;
                    players.add(i, new CarefulPlayer("Careful #" + howManyCareful));
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
