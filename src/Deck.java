import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck
{
    private ArrayList<Card> cards;

    public ArrayList<Card> getCards()
    {
        return cards;
    }

    public void putCardsInRandomOrder(Deck deck1, Deck deck2)
    {
        Random random = new Random();
        int deck1LastCard = 0;
        int deck2LastCard = 0;

        for (int i = 0; i < Card.getNames().length * 4; i++)
        {
            int rand;
            if (deck1LastCard == deck1.getCards().size() || deck2LastCard == deck2.getCards().size())
            {
                rand = (deck1LastCard == deck1.getCards().size() ? 1 : 0);
            }
            else rand = random.nextInt(1);

            switch (rand)
            {
                case 0:
                    this.cards.add(i, deck1.getCards().get(deck1LastCard));
                    deck1LastCard++;
                    break;
                case 1:
                    this.cards.add(i, deck2.getCards().get(deck2LastCard));
                    deck2LastCard++;
                    break;
            }
        }
    }

    public Deck(List<Card> cards)
    {
        this.cards = new ArrayList<>(cards);
    }

    public Deck()
    {
        String[] names = Card.getNames();
        cards = new ArrayList<>(names.length * 4);

        for (String name : names)
        {
            for (int y = 0; y < 4; y++)
            {
                cards.add(new Card(name));
            }
        }
    }
}
