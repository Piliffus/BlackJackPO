public class CarefulPlayer extends LimitPlayer
{
    public CarefulPlayer(String name)
    {
        super(name);
        this.limit = 21 - Card.maxValue() + 1; // we need +1 because limit is exclusive, not inclusive
    }
}
