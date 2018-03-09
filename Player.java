import java.util.Collections;
import java.util.ArrayList;
public class Player
{
    private ArrayList<Card> hand = new ArrayList<Card>();
    private ArrayList<Card> initHand = new ArrayList<Card>();
    private ArrayList<Card> bestHand = new ArrayList<Card>();
    private int money;
    private int amountBet = 0;
    private int winTotal = 0;
    private int lossTotal = 0;
    private boolean hasPair;
    private boolean hasTwoPair;
    private boolean hasThreeOfAKind;
    private boolean hasStraight;
    private boolean hasFlush;
    private boolean hasFullHouse;
    private boolean hasFourOfAKind;
    private boolean hasStraightFlush;
    private String highCard = "2";
    private String secondHighCard = "2";
    private String pairOf = "2";
    private String twoPairHigh = "2";
    private String twoPairLow = "2";
    private String setOf = "2";
    private String straightHigh = "2";
    private String flushHigh = "2";
    private String flushSuit = "spades";
    private String fourOf = "2";
    private String fullHouseOf = "2";
    private String straightFlushHigh = "2";
    public Player()
    {
        money = 50;
        highCard = "2";
        hasPair = false;
        hasTwoPair = false;
        hasThreeOfAKind = false;
        hasStraight = false;
        hasFlush = false;
        hasFullHouse = false;
        hasFourOfAKind = false;
        hasStraightFlush = false;
    }
    
    public ArrayList<Card> randomHand()
    {
        Card c1 = new Card();
        Card c2 = new Card();
        c1.randomize();
        c2.randomize();
        hand.add(c1);
        hand.add(c2);
        return hand;
    }
    
    public String getHighCard()
    {return highCard;}
    
    public String getSecondHighCard()
    {return secondHighCard;}
    
    public boolean hasPair()
    {return hasPair;}
    
    public String getPair()
    {return pairOf;}
    
    public boolean hasTwoPair()
    {return hasTwoPair;}
    
    public String getTwoPair()
    {return twoPairHigh;}
    
    public String getTwoPairLow()
    {return twoPairLow;}
    
    public boolean hasThreeOfAKind()
    {return hasThreeOfAKind;}
    
    public String getSetOf()
    {return setOf;}
    
    public boolean hasStraight()
    {return hasStraight;}
    
    public String getStraightHigh()
    {return straightHigh;}
        
    public boolean hasFlush()
    {return hasFlush;}
    
    public String getFlushHigh()
    {return flushHigh;}
    
    public boolean hasFullHouse()
    {return hasFullHouse;}
    
    public String getFullHouseHigh()
    {return setOf;}
    
    public boolean hasFourOfAKind()
    {return hasFourOfAKind;}
    
    public String getFourOf()
    {return fourOf;}

    public boolean hasStraightFlush()
    {return hasStraightFlush;}
    
    public String getStraightFlushHigh()
    {return straightFlushHigh;}
    
    public void incrementWins()
    {
        winTotal++;
    }
    
    public void incrementLosses()
    {
        lossTotal++;
    }
    
    public void addMoney(int n)
    {money += n;}
    
    public void removeMoney(int n)
    {money -= n;}
    
    public int getMoney()
    {return money;}
    
    public int getAmountBet()
    {
        return amountBet;
    }
    
    public int bet(int n)
    {
        money -= n;
        amountBet += n;
        return n;
    }
    
    public int randomBet()
    {
        int n = (int)(money*Math.random());
        money -= n;
        return n;
    }
    
    public boolean randomCall()
    {
        int n = (int)(100*Math.random());
        boolean a = false;
        if (n > 1)
            a = true;
        return a;
    }
    
    public void ante()
    {money -= 5;}
    
    public ArrayList<Card> getHand()
    {return hand;}
    
    public ArrayList<Card> getInitHand()
    {return initHand;}
    
    public void addToHand(Card c)
    {hand.add(c);}
    
    public void addToInitHand(Card c)
    {
        initHand.add(c);
        hand.add(c);
    }
    
    public void addToHand(ArrayList<Card> cards)
    {
        for (Card c: cards)
        {
            hand.add(c);
        }
    }
    
    public int findHighCard()
    {
        int largest = 2;
        int secondLargest = 2;
        for (Card c: hand)
        {
            String a = c.getNumber();
            if (c.numberToInt() > largest  && !(a == pairOf || a == twoPairHigh || a == twoPairLow || a == setOf || a == straightHigh || a == fullHouseOf || a == fourOf))
                largest = c.numberToInt();
        }
        for (Card c: hand)
        {
            String b = c.getNumber();
            if (c.numberToInt() > secondLargest && c.numberToInt() != largest && !(b == highCard && b == pairOf || b == twoPairHigh || b == twoPairLow || b == setOf || b == straightHigh || b == fullHouseOf || b == fourOf))
                secondLargest = c.numberToInt();
        }
        String a = Card.integerToString(largest);
        String b = Card.integerToString(secondLargest);
        highCard = a;
        secondHighCard = b;
        return largest;
    }
    
    public int findHighCard(ArrayList<Card> hand)
    {
        int largest = 2;
        int secondLargest = 2;
        for (Card c: hand)
        {
            String a = c.getNumber();
            if (c.numberToInt() > largest  && !(a == pairOf || a == twoPairHigh || a == twoPairLow || a == setOf || a == straightHigh || a == fullHouseOf || a == fourOf))
                largest = c.numberToInt();
        }
        for (Card c: hand)
        {
            String b = c.getNumber();
            if (c.numberToInt() > secondLargest && c.numberToInt() != largest && !(b == highCard && b == pairOf || b == twoPairHigh || b == twoPairLow || b == setOf || b == straightHigh || b == fullHouseOf || b == fourOf))
                secondLargest = c.numberToInt();
        }
        String a = Card.integerToString(largest);
        String b = Card.integerToString(secondLargest);
        highCard = a;
        secondHighCard = b;
        return largest;
    }
    
    public void findPair()
    {
        hasPair = false;
        ArrayList <Integer> nums = new ArrayList<Integer>();
        for (Card c: hand)
        {
            nums.add(c.numberToInt(c.getNumber()));
        }
        Collections.sort(nums);
        for (int i = 0; i < nums.size() - 1; i++)
        {
            if (nums.get(i) == nums.get(i+1))
            {
                    pairOf = Card.integerToString(nums.get(i));
                    hasPair = true;
            }
        }
    }
    
    public void findTwoPair()
    {
        hasTwoPair = false;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (Card c: hand)
        {
            nums.add(c.numberToInt(c.getNumber()));
        }
        Collections.sort(nums);
        if (hasPair == true)
            for (int i = 0; i < nums.size() - 1; i++)
            {
                if (nums.get(i) == nums.get(i+1) && !Card.integerToString(nums.get(i)).equals(pairOf))
                {
                    hasTwoPair = true;
                    twoPairHigh = pairOf;
                    twoPairLow = Card.integerToString(nums.get(i));
                }
            }
    }
    
    public void findThreeOfAKind()
    {
        hasThreeOfAKind = false;
        for (int i = 0; i < hand.size(); i++)
        {
            for (int j = 0; j < hand.size(); j++)
            {
                for (int k = 0; k < hand.size(); k++)
                {
                    if (hand.get(i).getNumber().equals(hand.get(j).getNumber()) && hand.get(j).getNumber().equals(hand.get(k).getNumber()) && !(i == j || i == k || j == k))
                    {
                        setOf = hand.get(i).getNumber();
                        hasThreeOfAKind = true;
                    }
                }
            }
        }
    }
    
    public void findFourOfAKind()
    {
        hasFourOfAKind = false;
        for (int i = 0; i < hand.size(); i++)
        {
            for (int j = 0; j < hand.size(); j++)
            {
                for (int k = 0; k < hand.size(); k++)
                {
                    for (int l = 0; l < hand.size(); l++)
                    {
                        if (hand.get(i).getNumber().equals(hand.get(j).getNumber()) && hand.get(j).getNumber().equals(hand.get(k).getNumber()) && hand.get(k).getNumber().equals(hand.get(l).getNumber()) && !(i == j || i == k || i == l || j == k || j == l || k == l))
                        {
                            fourOf = hand.get(i).getNumber();
                            hasFourOfAKind = true;
                        }
                    }
                }
            }
        }
    }
    
    public void findStraight()
    {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int a = 0;
        int inARow = 1;
        int maxInARow = 1;
        int indexOfLastInARow = 0;
        hasStraight = false;
        for (Card c: hand)
        {
            nums.add(c.numberToInt(c.getNumber()));
        }
        Collections.sort(nums);
        if (nums.get(nums.size()-1) == 14)
            nums.add(0,1);
        while (a < nums.size() - 1)
        {
            if (nums.get(a) == nums.get(a + 1))
                nums.remove(a);
            else
                a++;
        }
        for (int i = 0; i < nums.size(); i++)
        {
            nums.set(i, nums.get(i) - i);
        }
        for (int i = 0; i < nums.size() - 1; i++)
        {
            if (nums.get(i) == nums.get(i + 1))
            {
                inARow ++;
                if (inARow > maxInARow)
                    maxInARow = inARow;
                if (inARow >= 5)
                {
                    straightHigh = Card.integerToString(nums.get(i+1));
                    hasStraight = true;
                }
            }
            else
                inARow = 0;
        }
    }
    
    public void findFlush()
    {
        ArrayList<Card> flushed = new ArrayList<Card>();
        int sCount = 0;
        int hCount = 0;
        int cCount = 0;
        int dCount = 0;
        hasFlush = false;
        for(Card c: hand)
        {
            if (c.getSuit().equals("spades"))
                sCount++;
            else if (c.getSuit().equals("hearts"))
                hCount++;
            else if (c.getSuit().equals("clubs"))
                cCount++;
            else if (c.getSuit().equals("diamonds"))
                dCount++;
        }
        
        if (sCount >= 5)
        {
            hasFlush = true;
            for (Card c: hand)
            {
                if (c.getSuit().equals("spades"))
                    flushed.add(c);
            }
            flushHigh = Card.integerToString(findHighCard(flushed));
            flushSuit = "spades";
        }
        else if (hCount >= 5)
        {
            hasFlush = true;
            for (Card c: hand)
            {
                if (c.getSuit().equals("hearts"))
                    flushed.add(c);
            }
            flushHigh = Card.integerToString(findHighCard(flushed));
            flushSuit = "hearts";
        }
        else if (cCount >= 5)
        {
            hasFlush = true;
            for (Card c: hand)
            {
                if (c.getSuit().equals("clubs"))
                    flushed.add(c);
            }
            flushHigh = Card.integerToString(findHighCard(flushed));
            flushSuit = "clubs";
        }
        else if (dCount >= 5)
        {
            hasFlush = true;
            for (Card c: hand)
            {
                if (c.getSuit().equals("diamonds"))
                    flushed.add(c);
            }
            flushHigh = Card.integerToString(findHighCard(flushed));
            flushSuit = "diamonds";
        }
    }
    
    public void findFullHouse()
    {
        if (hasThreeOfAKind && hasTwoPair && (twoPairHigh.equals(setOf) || twoPairLow.equals(setOf)))
        {
            hasFullHouse = true;
            fullHouseOf = setOf;
        }   
    }
    
    public void findStraightFlush()
    {
        ArrayList<Card> copy = hand;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        boolean a = false;
        
        if (hasStraight() && hasFlush())
        {
            for (int i = copy.size() - 1; i > - 1; i--)
            {
                if (copy.get(i).getSuit() != flushSuit)
                    copy.remove(i);
            }
            for (Card c: copy)
            {
                nums.add(c.numberToInt(c.getNumber()));
            }
            Collections.sort(nums);
            if (nums.get(nums.size()-1) == 14)
                nums.add(0,1);
            for (int i = 0; i < nums.size(); i++)
                {
                    nums.set(i, nums.get(i) - i);
                }
            if (nums.size() == 5)
            {
                a = true;
                for (int i = 0; i < nums.size() - 1; i++)
                {
                    if (nums.get(i) != nums.get(i+1))
                        a = false;
                    else
                        straightFlushHigh = Card.integerToString(nums.get(nums.size()-1));
                }
            }
            else
            {
                a = true;
                if (nums.get(0) != nums.get(1))
                {
                    for (int i = 1; i < nums.size() - 1; i++)
                    {
                        if (nums.get(i) != nums.get(i+1))
                        {
                            a = false;
                        }
                    }
                    if (a = true)
                    {
                        straightFlushHigh = "ace";
                    }
                }
                else
                {
                    for (int i = 0; i < nums.size() - 2; i++)
                    {
                        if (nums.get(i) != nums.get(i+1))
                        {
                            a = false;
                        }
                    }
                    if (a = true)
                    {
                        straightFlushHigh = Card.integerToString(nums.get(nums.size()-1));
                    }
                }
            }
        }
        hasStraightFlush = a;
    }
    
    public String findBestHand()
    {
        findPair();
        findTwoPair();
        findThreeOfAKind();
        findStraight();
        findFlush();
        findFullHouse();
        findFourOfAKind();
        findStraightFlush();
        findHighCard();
        if (hasStraightFlush == true)
            return "Straight Flush";
        else if (hasFourOfAKind == true)
            return "Four of a Kind";
        else if (hasFullHouse == true)
            return "Full House";
        else if (hasFlush == true)
            return "Flush";
        else if (hasStraight == true)
            return "Straight";
        else if (hasThreeOfAKind == true)
            return "Three of a Kind";
        else if (hasTwoPair == true)
            return "Two Pair";
        else if (hasPair == true)
            return "Pair";
        else
            return "High Card";
    }
}
