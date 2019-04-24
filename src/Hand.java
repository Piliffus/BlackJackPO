import java.util.ArrayList;

public class Hand
{
    ArrayList<Card> cards;

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
}
