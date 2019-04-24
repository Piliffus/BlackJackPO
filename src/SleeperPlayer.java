public class SleeperPlayer extends Player
{
    @Override
    public void playTurn(Dealer dealer)
    {
        // Sleeper instantly passes
        pass();
    }

    public SleeperPlayer(String name)
    {
        super(name);
    }
}
