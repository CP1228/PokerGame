import java.util.Collections;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PokerSim
{
    private ArrayList<Card> table = new ArrayList<Card>();
    public ArrayList<Card> deck = new ArrayList<Card>();
    private int pot;
    public PokerSim()
    {
        String number, suit;
        for (int s = 1; s < 5; s++)
        {
            if (s == 1)
                suit = "spades";
            else if (s == 2)
                suit = "hearts";
            else if (s == 3)
                suit = "clubs";
            else
                suit = "diamonds";
            for (int n = 1; n < 14; n++)
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
                deck.add(new Card(number,suit));
            }
        }
        shuffle();
        pot = 0;
    }
    
    public void dealCard(Player p)
    {
        p.addToInitHand(deck.remove(deck.size()-1));
    }
    
    public void initiateHeadToHead(Player p1, Player p2)
    {
        p1.ante();
        p2.ante();
        dealCard(p1);
        dealCard(p2);
        dealCard(p1);
        dealCard(p2);
    }
    
    public ArrayList<Card> initiateFlopH2H(Player p1, Player p2)
    {
        burn();
        table.add(deck.remove(deck.size()-1));
        table.add(deck.remove(deck.size()-1));
        table.add(deck.remove(deck.size()-1));
        p1.addToHand(table);
        p2.addToHand(table);
        return table;
    }
    
    public ArrayList<Card> initiateTurnH2H(Player p1, Player p2)
    {
        burn();
        table.add(deck.remove(deck.size()-1));
        p1.addToHand(table.get(table.size()-1));
        p2.addToHand(table.get(table.size()-1));
        return table;
    }
    
    public ArrayList<Card> initiateRiverH2H(Player p1, Player p2)
    {
        burn();
        table.add(deck.remove(deck.size()-1));
        p1.addToHand(table.get(table.size()-1));
        p2.addToHand(table.get(table.size()-1));
        return table;
    }
    
    public int getPot()
    {
        return pot;
    }
    
    public void setPot(int n)
    {
        pot = n;
    }
    
    public void addToPot(int n)
    {
        pot += n;
    }
    
    public void shuffle()
    {Collections.shuffle(deck);}
    
    public void burn()
    {deck.remove(deck.size()-1);}
    
    public Card getCardFromDeck(int pos)
    {return deck.get(pos - 1);}
    
    public Card getCardFromTable(int pos)
    {return table.get(pos - 1);}
    
    public ArrayList<Card> getTable()
    {return table;}
}
