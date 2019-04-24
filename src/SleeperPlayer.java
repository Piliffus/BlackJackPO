public class SleeperPlayer extends Player
{
    @Override
    public void playTurn(Dealer dealer)
    {
        // Sleeper instantly passes
        pass();
    }
}
