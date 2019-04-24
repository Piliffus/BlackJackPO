public abstract class Player implements Comparable <Player>
{
    private boolean hasPassed;
    private int score;
    private int gameScore;

    @Override
    public int compareTo(Player o)
    {
        return this.score - o.getScore();
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

    public abstract void playTurn();

    public void startOfTurn()
    {
        hasPassed = false;
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

    public int getGameScore()
    {
        return gameScore;
    }
}
