import java.util.ArrayList;
import java.util.Collections;

public class BaccaratDealer {

    ArrayList<Card> deck = new ArrayList<Card>();

    public void generateDeck() { // generate 6 decks
        int j = 0;
        for (int i = 1; i <= 13; i++) {
            deck.add(j, new Card("spades", i));
            j++;
        }
        j = 13;
        for (int i = 1; i <= 13; i++) {
            deck.add(j, new Card("hearts", i));
            j++;
        }
        j = 26;
        for (int i = 1; i <= 13; i++) {
            deck.add(j, new Card("diamonds", i));
            j++;
        }
        j = 39;
        for (int i = 1; i <= 13; i++) {
            deck.add(j, new Card("clubs", i));
            j++;
        }
        j = 52;
        for (int i = 1; i <= 13; i++) {
            deck.add(j, new Card("spades", i));
            j++;
        }
        j = 65;
        for (int i = 1; i <= 13; i++) {
            deck.add(j, new Card("hearts", i));
            j++;
        }
        j = 78;
        for (int i = 1; i <= 13; i++) {
            deck.add(j, new Card("diamonds", i));
            j++;
        }
        j = 91;
        for (int i = 1; i <= 13; i++) {
            deck.add(j, new Card("clubs", i));
            j++;
        }
        j = 104;
        for (int i = 1; i <= 13; i++) {
            deck.add(j, new Card("spades", i));
            j++;
        }
        j = 117;
        for (int i = 1; i <= 13; i++) {
            deck.add(j, new Card("hearts", i));
            j++;
        }
        j = 130;
        for (int i = 1; i <= 13; i++) {
            deck.add(j, new Card("diamonds", i));
            j++;
        }
        j = 143;
        for (int i = 1; i <= 13; i++) {
            deck.add(j, new Card("clubs", i));
            j++;
        }
        j = 156;
        for (int i = 1; i <= 13; i++) {
            deck.add(j, new Card("spades", i));
            j++;
        }
        j = 169;
        for (int i = 1; i <= 13; i++) {
            deck.add(j, new Card("hearts", i));
            j++;
        }
        j = 182;
        for (int i = 1; i <= 13; i++) {
            deck.add(j, new Card("diamonds", i));
            j++;
        }
        j = 195;
        for (int i = 1; i <= 13; i++) {
            deck.add(j, new Card("clubs", i));
            j++;
        }
        j = 208;
        for (int i = 1; i <= 13; i++) {
            deck.add(j, new Card("spades", i));
            j++;
        }
        j = 221;
        for (int i = 1; i <= 13; i++) {
            deck.add(j, new Card("hearts", i));
            j++;
        }
        j = 234;
        for (int i = 1; i <= 13; i++) {
            deck.add(j, new Card("diamonds", i));
            j++;
        }
        j = 247;
        for (int i = 1; i <= 13; i++) {
            deck.add(j, new Card("clubs", i));
            j++;
        }
        j = 260;
        for (int i = 1; i <= 13; i++) {
            deck.add(j, new Card("spades", i));
            j++;
        }
        j = 273;
        for (int i = 1; i <= 13; i++) {
            deck.add(j, new Card("hearts", i));
            j++;
        }
        j = 286;
        for (int i = 1; i <= 13; i++) {
            deck.add(j, new Card("diamonds", i));
            j++;
        }
        j = 299;
        for (int i = 1; i <= 13; i++) {
            deck.add(j, new Card("clubs", i));
            j++;
        }
    }

    public ArrayList<Card> dealHand() {
        generateDeck();
        shuffleDeck();
        ArrayList<Card> cards = new ArrayList<Card>();

        Card c1 = deck.get(0);
        Card c2 = deck.get(1);

        deck.remove(0);
        deck.remove(1);

        cards.add(c1);
        cards.add(c2);

        return cards;
    }

    public Card drawOne() {
        Card c1 = deck.get(0);
        deck.remove(0);
        return c1;
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public int deckSize() {
        return deck.size();
    }
}
