public class Card
{
    private String number;
    private String suit;
    public Card()
    {
        number = "ace";
        suit = "spades";
    }
    
    public Card(String n, String s)
    {
        number = n;
        suit = s;
    }
    
    public void randomize()
    {
        int s = (int)(4*Math.random()+1);
        int n = (int)(13*Math.random()+1);
        intToString(n);
        if (s == 1)
            suit = "spades";
        else if (s == 2)
            suit = "hearts";
        else if (s == 3)
            suit = "clubs";
        else
            suit = "diamonds";
    }
    
    public String getNumber()
    {
        return number;
    }
    
    public String getSuit()
    {
        return suit;
    }
    
    public void printCard()
    {
        System.out.print(getNumber() + " of " + getSuit());
    }
    
    public void intToString(int n)
    {
        if (n < 11 && n != 1)
            number = Integer.toString(n);
        else if (n == 11)
            number = "jack";
        else if (n == 12)
            number = "queen";
        else if (n == 13)
            number = "king";
        else
            number = "ace";
    }
    
    public static String integerToString(int n)
    {
        String number = "";
        if (n < 11 && n != 1)
            number = Integer.toString(n);
        else if (n == 11)
            number = "jack";
        else if (n == 12)
            number = "queen";
        else if (n == 13)
            number = "king";
        else
            number = "ace";
        return number;
    }
    
    public int numberToInt()
    {
        switch(number)
        {
            case "ace":
                return 14;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":    
                return 7;
            case "8":    
                return 8;
            case "9":    
                return 9;
            case "10":    
                return 10;
            case "jack":    
                return 11;
            case "queen":    
                return 12;
            case "king":    
                return 13;
            default:
             throw new IllegalArgumentException("Invalid number: " + number);
        }
    }
    
    public static int numberToInt(String number)
    {
        switch(number)
        {
            case "ace":
                return 14;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":    
                return 7;
            case "8":    
                return 8;
            case "9":    
                return 9;
            case "10":    
                return 10;
            case "jack":    
                return 11;
            case "queen":    
                return 12;
            case "king":    
                return 13;
            default:
             throw new IllegalArgumentException("Invalid number: " + number);
        }
    }
}
