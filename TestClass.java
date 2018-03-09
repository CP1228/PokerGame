import java.util.Scanner;
public class TestClass
{
    public static int rankHand(String s)
    {
        switch(s)
        {
            case "Straight Flush":
                return 1;
            case "Four of a Kind":
                return 2;
            case "Full House":
                return 3;
            case "Flush":
                return 4;
            case "Straight":
                return 5;
            case "Three of a Kind":
                return 6;
            case "Two Pair":
                return 7;
            case "Pair":
                return 8;
            case "High Card":
                return 9;
            default:
                throw new IllegalArgumentException("Invalid hand: " + s);
        }
    }
    
    public static int calculateWin(Player p1, Player p2)
    {
        int a;
        int b;
        int rank1 = rankHand(p1.findBestHand());
        int rank2 = rankHand(p2.findBestHand());
        if (Card.numberToInt(p1.getHighCard()) > Card.numberToInt(p2.getHighCard()))
            b = 1;
        else if (Card.numberToInt(p1.getHighCard()) < Card.numberToInt(p2.getHighCard()))
            b = -1;
        else
            if (Card.numberToInt(p1.getSecondHighCard()) > Card.numberToInt(p2.getSecondHighCard()))
                b = 1;
            else if (Card.numberToInt(p1.getSecondHighCard()) < Card.numberToInt(p2.getSecondHighCard()))
                b = -1;
            else
                b = 0;
        if (rank1 < rank2)
            a = 1;
        else if (rank1 > rank2)
            a = -1;
        else
        {
            if (rank1 == 9)
                a = b;
            else if (rank1 == 8)
                if (Card.numberToInt(p1.getPair()) > Card.numberToInt(p2.getPair()))
                    a = 1;
                else if (Card.numberToInt(p1.getPair()) < Card.numberToInt(p2.getPair()))
                    a = -1;
                else
                    a = b;
            else if (rank1 == 7)
                if (Card.numberToInt(p1.getTwoPair()) > Card.numberToInt(p2.getTwoPair()))
                    a = 1;
                else if (Card.numberToInt(p1.getTwoPair()) < Card.numberToInt(p2.getTwoPair()))
                    a = -1;
                else
                {
                if (Card.numberToInt(p1.getTwoPairLow()) > Card.numberToInt(p2.getTwoPairLow()))
                    a = 1;
                else if (Card.numberToInt(p1.getTwoPairLow()) < Card.numberToInt(p2.getTwoPairLow()))
                    a = -1;
                else
                    a = b;
                }
            else if (rank1 == 6)
                if (Card.numberToInt(p1.getSetOf()) > Card.numberToInt(p2.getSetOf()))
                    a = 1;
                else if (Card.numberToInt(p1.getSetOf()) < Card.numberToInt(p2.getSetOf()))
                    a = -1;
                else
                    a = b;
            else if (rank1 == 5)
                if (Card.numberToInt(p1.getStraightHigh()) > Card.numberToInt(p2.getStraightHigh()))
                    a = 1;
                else if (Card.numberToInt(p1.getStraightHigh()) < Card.numberToInt(p2.getStraightHigh()))
                    a = -1;
                else
                    a = b;
            else if (rank1 == 4)
                if (Card.numberToInt(p1.getFlushHigh()) > Card.numberToInt(p2.getFlushHigh()))
                    a = 1;
                else if (Card.numberToInt(p1.getFlushHigh()) < Card.numberToInt(p2.getFlushHigh()))
                    a = -1;
                else
                    a = b;
            else if (rank1 == 3)
                if (Card.numberToInt(p1.getFullHouseHigh()) > Card.numberToInt(p2.getFullHouseHigh()))
                    a = 1;
                else if (Card.numberToInt(p1.getFullHouseHigh()) < Card.numberToInt(p2.getFullHouseHigh()))
                    a = -1;
                else
                    a = b;
            else if (rank1 == 2)
                if (Card.numberToInt(p1.getFourOf()) > Card.numberToInt(p2.getFourOf()))
                    a = 1;
                else if (Card.numberToInt(p1.getFourOf()) < Card.numberToInt(p2.getFourOf()))
                    a = -1;
                else
                    a = b;
            else
                if (Card.numberToInt(p1.getStraightFlushHigh()) > Card.numberToInt(p2.getStraightFlushHigh()))
                    a = 1;
                else if (Card.numberToInt(p1.getStraightFlushHigh()) < Card.numberToInt(p2.getStraightFlushHigh()))
                    a = -1;
                else
                    a = b;
        }
        return a;
    }
    
    public static void main (String [] args)
    {
        Scanner kboard = new Scanner(System.in);
        String s = "n";
        do
        {
            PokerSim a = new PokerSim();
            Player p1 = new Player();
            Player p2 = new Player();
            a.initiateHeadToHead(p1, p2);
            int i = 0;
            int n;
            System.out.println("The cards in your hand are:");
            for (Card c: p1.getHand())
            {
                c.printCard();
                System.out.println();
            }
            while (i == 0)
            {
                n = kboard.nextInt();
                if (p1.getMoney() - n < 0)
                    System.out.println("You can't bet that much.");
                else
                {
                    p1.bet(n);
                    i++;
                    a.addToPot(n);
                }
            }
            if (p2.randomCall())
            {
                a.addToPot(p1.getAmountBet() - p2.getAmountBet());
                p2.bet(p1.getAmountBet() - p2.getAmountBet());
            }
            else
            {
                System.out.print("\f");
                return;
            }
            i = 0;
            a.initiateFlopH2H(p1, p2);
            System.out.println("The cards on the table are:");
            for (Card c: a.getTable())
            {
                    c.printCard();
                    System.out.println();
            }
            while (i == 0)
            {
                n = kboard.nextInt();
                if (p1.getMoney() - n < 0)
                    System.out.println("You can't bet that much.");
                else
                {
                    p1.bet(n);
                    i++;
                    a.addToPot(n);
                }
            }
            if (p2.randomCall())
            {
                a.addToPot(p1.getAmountBet() - p2.getAmountBet());
                p2.bet(p1.getAmountBet() - p2.getAmountBet());
            }
            else
            {
                System.out.print("\f");
                return;
            }
            i = 0;
            a.initiateTurnH2H(p1, p2);
            System.out.println("The cards on the table are:");
            for (Card c: a.getTable())
            {
                c.printCard();
                System.out.println();
            }
            while (i == 0)
            {
                 n = kboard.nextInt();
                 if (p1.getMoney() - n < 0)
                    System.out.println("You can't bet that much.");
                 else
                 {
                    p1.bet(n);
                    i++;
                    a.addToPot(n);
                 }
            }
            if (p2.randomCall())
            {
                 a.addToPot(p1.getAmountBet() - p2.getAmountBet());
                 p2.bet(p1.getAmountBet() - p2.getAmountBet());
            }
            else
            {
                System.out.print("\f");
                return;
            }
            i = 0;
            a.initiateRiverH2H(p1, p2);
            System.out.println("The cards on the table are:");
            for (Card c: a.getTable())
            {
                 c.printCard();
                 System.out.println();
            }
            while (i == 0)
            {
                n = kboard.nextInt();
                if (p1.getMoney() - n < 0)
                    System.out.println("You can't bet that much.");
                else
                {
                    p1.bet(n);
                    i++;
                    a.addToPot(n);
                }
            }
            if (p2.randomCall())
            {
                a.addToPot(p1.getAmountBet() - p2.getAmountBet());
                p2.bet(p1.getAmountBet() - p2.getAmountBet());
            }
            else
            {
                System.out.print("\f");
                return;
            }
            i = 0;
            System.out.println("The cards in Player 2's hand are:");
            for (Card c: p2.getInitHand())
            {
                c.printCard();
                System.out.println();
            }
            System.out.println("Your opponent's best hand is a " + p2.findBestHand());
            System.out.println("Your best hand is a " + p1.findBestHand());
            System.out.println("Your total hand:");
            for (Card c: p1.getHand())
            {
                 c.printCard();
                 System.out.println();
            }
            if (rankHand(p1.findBestHand()) < 9)
                System.out.println("Your kicker is a " + p1.getHighCard());
            else
                System.out.println("Your high card is a " + p1.getHighCard());
            if (p1.hasPair())
                System.out.println("You have a pair of " + p1.getPair() + "s.");
            if (p1.hasTwoPair())
                System.out.println("You have a two pair with " + p1.getTwoPair() + " high.");
            if (p1.hasThreeOfAKind())
                System.out.println("You have three of a kind with " + p1.getSetOf());
            if (p1.hasStraight())
                System.out.println("You have a straight with " + p1.getStraightHigh() + " high.");
            if (p1.hasFlush())
                System.out.println("You have a flush with " + p1.getFlushHigh() + " high.");
            if (p1.hasFullHouse())
                System.out.println("You have a full house with " + p1.getFullHouseHigh() + " high.");
            if (p1.hasFourOfAKind())
                System.out.println("You have four of a kind with " + p1.getFourOf());
            if (p1.hasStraightFlush())
                System.out.println("You have a straight flush with " + p1.getStraightFlushHigh() + " high.");
            if (calculateWin(p1, p2) == 1)
            {
                System.out.println("You win.");
                p1.incrementWins();
                p2.incrementLosses();
                p1.addMoney(a.getPot());
                p2.removeMoney(a.getPot());
            }
            else if (calculateWin(p1, p2) == -1)
            {
                System.out.println("You lost.");
                p1.incrementLosses();
                p2.incrementWins();
                p1.removeMoney(a.getPot());
                p2.addMoney(a.getPot());
            }
            else
            {
                System.out.println("It's a tie.");
                p1.addMoney(a.getPot()/2);
                p2.addMoney(a.getPot()/2);
            }
            a.setPot(0);
            System.out.println("Keep playing? (y/n)");
            while (i == 0)
            {
                s = kboard.nextLine();
                if (s.equals("n") || s.equals("y"))
                {
                    i++;
                }
                else
                {
                    System.out.println("Invalid input");
                }
            }
            i = 0;
            System.out.print("\f");
        }while(s.equals("y"));
    }
}