public class Card
{
    private String name;
    private int value;

    public static int maxValue()
    {
        return 11;
    }

    public int getValue()
    {
        return value;
    }

    public static String[] getNames()
    {
        return new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "ace"};
    }

    public String getName()
    {
        return name;
    }

    private void assignValue()
    {
        if (name.equals("Jack") || name.equals("Queen") || name.equals("King"))
        {
            this.value = 10;
        }
        else if (name.equals("ace"))
        {
            this.value = 11;
        }
        else
        {
            String[] names = Card.getNames();
            for (int i = 0; i < 9; i++)
            {
                if (names[i].equals(name))
                {
                    this.value = i + 2;
                }
            }
        }
    }

    public Card(String name)
    {
        this.name = name;
        assignValue();
    }
}
