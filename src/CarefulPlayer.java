public class CarefulPlayer extends LimitPlayer
{
    public CarefulPlayer()
    {
        this.limit = 21 - Card.maxValue() + 1;
    }
}
