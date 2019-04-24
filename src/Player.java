public abstract class Player implements Comparable <Player>
{
    protected boolean hasPassed;
    protected int score;
    protected int gameScore;
    protected Hand hand;

    @Override
    public int compareTo(Player o)
    {
        return this.score - o.getScore();
    }

    protected void tooManyPoints()
    {
        if (score > 21)
        {
            pass();
        }
    }

    public int getScore()
    {
        return score;
    }

    public static String[] getPlayerTypes()
    {
        return new String[] {"Random", "Sleeper", "Limit", "Careful"};
    }

    public int askForScore()
    {
        int returnedValue = score;
        this.score = 0;
        return returnedValue;
    }

    protected void updateScore()
    {
        score = 0;
        for (Card card : hand.getCards())
        {
            score += card.getValue();
        }
    }

    public abstract void playTurn(Dealer dealer);

    public void startOfTurn()
    {
        this.score = 0;
        this.hasPassed = false;
        hand.clearHand();
    }

    public void endOfTurn()
    {
        hasPassed = true;
    }

    public boolean hasPassed()
    {
        return hasPassed;
    }

    public Player()
    {
        this.score = 0;
        this.gameScore = 0;
    }

    public void givePoint()
    {
        gameScore++;
    }

    protected void pass()
    {
        hasPassed = true;
    }

    public int getGameScore()
    {
        return gameScore;
    }
}
