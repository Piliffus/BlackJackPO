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

    public LimitPlayer(int limit)
    {
        this.limit = limit;
    }

    public LimitPlayer()
    {
    }
}
