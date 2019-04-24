public class Dealer
{
    Deck deck;

    public void shuffleDeck()
    {
        this.deck = new Deck();
        deck.shuffleCards();
    }

    private Card topCard()
    {
        if (deck.getCards().size() == 0)
        {
            return null;
        }

        else
        {
            Card card = deck.getCards().get(deck.getCards().size() - 1);
            deck.getCards().remove(card);
            return card;
        }
    }

    public void takeCard(Hand hand)
    {
        Card card = topCard();

        if (card == null)
        {
            System.exit(-1);
        }

        hand.giveCard(card);
    }

    public Dealer()
    {
        deck = new Deck();
    }
}
