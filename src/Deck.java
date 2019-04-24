import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck
{
    private ArrayList<Card> cards;

    public ArrayList<Card> getCards()
    {
        return cards;
    }

    public void shuffleCards()
    {
        Collections.shuffle(cards);
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
