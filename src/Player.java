import java.util.ArrayList;
import java.util.List;

public class Player {

    public List<Card> hand;
    private final List<String> books;
    private Card i;
    private Card j;
    private Card k;
    private Card l;
    private Card m;

    public Player() {
        this.hand = new ArrayList<>();
        this.books = new ArrayList<>();
    }

    public List<Card> getHand() {
        return hand;
    }

    public void takeCard(Card card) {
        hand.add(card);
        sortHand();
    }

    public String getCardByNeed() {
        //decide if the cpu needs to hit or stand
        int cardRank = 0;
        for (int i = hand.size() - 1; i >= 0; i--) {
            int nextCardRank = 0;

            try {
                nextCardRank = Integer.parseInt(hand.get(i).getRank());
            } catch (NumberFormatException e) {
                switch (hand.get(i).getRank()) {
                    case "T":
                    case "J":
                    case "Q":
                    case "K":
                        nextCardRank = 10;
                    case "A":
                        nextCardRank = 11;
                }
            }

            if (cardRank + nextCardRank >= 17) {
                return "STAND";
            } else if (i != 0) {
                cardRank += nextCardRank;
            } else {
                return "HIT";
            }
        }
        return "";
    }

    public void removeRequestedCard(String card) {
        for (int i = hand.size() - 1; i >= 0; i--) {

            String card1 = hand.get(i).getRank();

            if (card1.equals(card)) {
                hand.remove(i);
            }
        }

    }

    public boolean checkRoyalFlush() {
        this.i = hand.get(4);
        this.j = hand.get(3);
        this.k = hand.get(2);
        this.l = hand.get(1);
        this.m = hand.get(0);

        if (i.getRank().equals("A") && j.getRank().equals("K") && k.getRank().equals("Q")
                && l.getRank().equals("J") && m.getRank().equals("T")); {
                    if (i.getSuit().equals(j.getSuit()) && j.getSuit().equals(k.getSuit())
                            && k.getSuit().equals(l.getSuit()) && l.getSuit().equals(m.getSuit())) {
                        return true;
                    }
        }
        return false;
    }

    public boolean checkStraightFlush() {
        this.i = hand.get(4);
        this.j = hand.get(3);
        this.k = hand.get(2);
        this.l = hand.get(1);
        this.m = hand.get(0);

        if (i.getSuit().equals(j.getSuit()) && j.getSuit().equals(k.getSuit())
                && k.getSuit().equals(l.getSuit()) && l.getSuit().equals(m.getSuit())) {
            if ((i.orderedRank()) == (j.orderedRank() + 1) && (j.orderedRank()) == (k.orderedRank() + 1) &&
                    (k.orderedRank()) == (l.orderedRank() + 1) && (l.orderedRank()) == (m.orderedRank() + 1)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkFourOfAKind() {
        this.i = hand.get(4);
        this.j = hand.get(3);
        this.k = hand.get(2);
        this.l = hand.get(1);
        this.m = hand.get(0);

        if ((i.getRank().equals(j.getRank()) && j.getRank().equals(k.getRank()) && k.getRank().equals(l.getRank()))) {
            return true;
        } else if ((j.getRank().equals(k.getRank()) && k.getRank().equals(l.getRank()) && l.getRank().equals(m.getRank()))) {
            return true;
        }
        return false;
    }

    public boolean checkFullHouse() {
        this.i = hand.get(4);
        this.j = hand.get(3);
        this.k = hand.get(2);
        this.l = hand.get(1);
        this.m = hand.get(0);

        if ((i.getRank().equals(j.getRank()) && j.getRank().equals(k.getRank()))) {
            if (l.getRank().equals(m.getRank()) && !(m.getRank().equals(i.getRank()))) {
                return true;
            }
        } else if (k.getRank().equals(l.getRank()) && l.getRank().equals(m.getRank())) {
            if (i.getRank().equals(j.getRank()) && !(i.getRank().equals(m.getRank()))) {
                return true;
            }
        }

        return false;
    }

    public boolean checkFlush() {
        this.i = hand.get(4);
        this.j = hand.get(3);
        this.k = hand.get(2);
        this.l = hand.get(1);
        this.m = hand.get(0);

        if (i.getSuit().equals(j.getSuit()) && j.getSuit().equals(k.getSuit())
                && k.getSuit().equals(l.getSuit()) && l.getSuit().equals(m.getSuit())) {
            return true;
        }

        return false;
    }

    public boolean checkStraight() {
        this.i = hand.get(4);
        this.j = hand.get(3);
        this.k = hand.get(2);
        this.l = hand.get(1);
        this.m = hand.get(0);

        if ((i.orderedRank()) == (j.orderedRank() + 1) && (j.orderedRank()) == (k.orderedRank() + 1) &&
                (k.orderedRank()) == (l.orderedRank() + 1) && (l.orderedRank()) == (m.orderedRank() + 1)) {
            return true;
        }

        return false;
    }

    public boolean checkThreeOfAKind() {
        this.i = hand.get(4);
        this.j = hand.get(3);
        this.k = hand.get(2);
        this.l = hand.get(1);
        this.m = hand.get(0);

        if ((i.getRank().equals(j.getRank()) && j.getRank().equals(k.getRank()))) {
            return true;
        } else if (j.getRank().equals(k.getRank()) && k.getRank().equals(l.getRank())) {
            return true;
        } else if (k.getRank().equals(l.getRank()) && l.getRank().equals(m.getRank())) {
            return true;
        }

        return false;
    }

    public boolean checkTwoPair() {
        this.i = hand.get(4);
        this.j = hand.get(3);
        this.k = hand.get(2);
        this.l = hand.get(1);
        this.m = hand.get(0);

        if (i.getRank().equals(j.getRank()) && k.getRank().equals(l.getRank()) && !(k.getRank().equals(j.getRank()))) {
            return true;
        } else if (j.getRank().equals(k.getRank()) && l.getRank().equals(m.getRank()) && !(l.getRank().equals(k.getRank()))) {
            return true;
        } else if (i.getRank().equals(j.getRank()) && l.getRank().equals(m.getRank()) && !(m.getRank().equals(j.getRank()))) {
            return true;
        }

        return false;
    }

    public boolean checkGoodPair() {
        this.i = hand.get(4);
        this.j = hand.get(3);
        this.k = hand.get(2);
        this.l = hand.get(1);
        this.m = hand.get(0);

        if (i.getRank().equals(j.getRank())) {
            if (i.orderedRank() > 10) {
                return true;
            }
        } else if (j.getRank().equals(k.getRank())) {
            if (j.orderedRank() > 10) {
                return true;
            }
        } else if (k.getRank().equals(l.getRank())) {
            if (k.orderedRank() > 10) {
                return true;
            }
        } else if (l.getRank().equals(m.getRank())) {
            if (l.orderedRank() > 10) {
                return true;
            }
        }

        return false;
    }

    public boolean nothing() {
        this.i = hand.get(4);
        this.j = hand.get(3);
        this.k = hand.get(2);
        this.l = hand.get(1);
        this.m = hand.get(0);

        if (!checkRoyalFlush() && !checkStraightFlush() && !checkFourOfAKind() && !checkFullHouse() && !checkFlush() &&
                !checkStraight() && !checkThreeOfAKind() && !checkTwoPair() && !checkGoodPair()) {
            return true;
        }

        return false;
    }
    private void sortHand() {
        hand.sort((a, b) -> {
            if (Card.getOrderedRank(a.getRank()) == Card.getOrderedRank(b.getRank())) {
                return Card.getOrderedSuit(a.getSuit()) - Card.getOrderedSuit(b.getSuit());
            }

            return Card.getOrderedRank(a.getRank()) - Card.getOrderedRank(b.getRank());
        });
    }

    public int handSum() {
        int sum = 0;
        int nextCardRank = 0;

        for (Card card : hand) {
            switch (card.getRank()) {
                case "2":
                    nextCardRank = 2;
                    break;
                case "3":
                    nextCardRank = 3;
                    break;
                case "4":
                    nextCardRank = 4;
                    break;
                case "5":
                    nextCardRank = 5;
                    break;
                case "6":
                    nextCardRank = 6;
                    break;
                case "7":
                    nextCardRank = 7;
                    break;
                case "8":
                    nextCardRank = 8;
                    break;
                case "9":
                    nextCardRank = 9;
                    break;
                case "T":
                case "J":
                case "Q":
                case "K":
                    nextCardRank = 10;
                    break;
                case "A":
                    if (sum > 10) {
                        nextCardRank = 1;
                    } else {
                        nextCardRank = 11;
                    }
                    break;
            }

            sum = sum + nextCardRank;
        }
        return sum;
    }
}

