import java.util.Random;

public class RandomPlayer extends Player
{
    @Override
    public void playTurn(Dealer dealer)
    {
        Random generator = new Random();
        if (generator.nextInt(10) <= 4)
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

    public RandomPlayer(String name)
    {
        super(name);
    }
}
