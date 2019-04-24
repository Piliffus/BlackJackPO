public class Dealer
{
    Deck deck;

    public void shuffleDeck()
    {
        this.deck = new Deck();

        for (int i = 0; i < 100; i++)
        {
            Deck firstHalf = new Deck(deck.getCards().subList(0, (deck.getCards().size() - 1) / 2));
            Deck secondHalf = new Deck(deck.getCards().subList((deck.getCards().size() - 1) / 2, deck.getCards().size()));
            deck.getCards().clear();
            deck.putCardsInRandomOrder(firstHalf, secondHalf);
        }
    }

    private Card topCard()
    {
        if (deck.getCards().size() == 0)
        {
            return null;
        }
        else
            {
                Card card = deck.getCards().get(deck.getCards().size()-1);
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
