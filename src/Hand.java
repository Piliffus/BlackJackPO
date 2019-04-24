import java.util.ArrayList;

public class Hand
{
    private ArrayList<Card> cards;

    public ArrayList<Card> getCards()
    {
        return cards;
    }

    public void clearHand()
    {
        cards.clear();
    }

    public void giveCard(Card card)
    {
        cards.add(card);
    }

    public Hand()
    {
        this.cards = new ArrayList<>(0);
    }
}
