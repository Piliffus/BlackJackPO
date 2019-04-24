public abstract class Player implements Comparable<Player>
{
    protected boolean hasPassed;
    protected int score;
    protected int gameScore;
    protected Hand hand;
    protected String name;

    public abstract void playTurn(Dealer dealer);

    @Override
    public int compareTo(Player o)
    {
        return this.score - o.getScore();
    }

    public static String[] getPlayerTypes()
    {
        return new String[]{"Random", "Sleeper", "Limit", "Careful"};
    }

    public void startOfTurn()
    {
        this.score = 0;
        this.hasPassed = false;
        hand.clearHand();
    }

    public void endOfTurn()
    {
        hasPassed = true;
        Output.printPlayerType(this);
        Output.printHand(hand);
        Output.printScore(score);
    }

    protected void updateScore()
    {
        score = 0;
        for (Card card : hand.getCards())
        {
            score += card.getValue();
        }
    }

    public int askForScore()
    {
        int returnedValue = score;
        this.score = 0;
        return returnedValue;
    }

    protected void tooManyPoints()
    {
        if (score > 21)
        {
            pass();
        }
    }

    protected void pass()
    {
        hasPassed = true;
    }

    public void givePoint()
    {
        gameScore++;
    }

    public boolean hasPassed()
    {
        return hasPassed;
    }

    public int getGameScore()
    {
        return gameScore;
    }

    public int getScore()
    {
        return score;
    }

    public String getName()
    {
        return name;
    }

    public Player(String name)
    {
        this.score = 0;
        this.name = name;
        this.gameScore = 0;
        this.hand = new Hand();
    }
}
