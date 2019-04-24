public class LimitPlayer extends Player
{
    protected int limit;

    @Override
    public void playTurn(Dealer dealer)
    {
        if (score < limit)
        {
            dealer.takeCard(hand);
            updateScore();
            tooManyPoints();
        }
        else
        {
            pass();
        }
    }

    public static int defaultLimit()
    {
        return 13;
    }

    public LimitPlayer(String name)
    {
        super(name);
        this.limit = LimitPlayer.defaultLimit();
    }

    public LimitPlayer(String name, int limit)
    {
        super(name);
        this.limit = limit;
    }
}
