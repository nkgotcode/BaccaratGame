import java.util.ArrayList;

public class BaccaratGameLogic {

    public String whoWon(ArrayList<Card> hand1, ArrayList<Card> hand2) {
        int t1 = handTotal(hand1);
        int t2 = handTotal(hand2);

        if (t1 > t2) {
            return "Player";
        } else if (t1 < t2) {
            return "Banker";
        } else {
            return "Draw";
        }
    }

    public int handTotal(ArrayList<Card> hand) {
        int count = 0;

        for (Card card : hand) {
            if (card.getValue() == 10 ||
                    card.getValue() == 11 ||
                    card.getValue() == 12 ||
                    card.getValue() == 13) {
                continue;
            }
            count = count + card.getValue();
        }

        if (count >= 20) return (count - 20);
        else if (count >= 10) return (count - 10);
        else return count;
    }

    public boolean evaluateBankerDraw(ArrayList<Card> hand, Card playerCard) {
        int t = handTotal(hand);

        if (playerCard == null) {
            return t != 6 && t != 7 && t != 8 && t != 9;
        }

        if (t <= 2) {
            return true;
        } // banker draws if sum is 0,1,2

        else if (t >= 7) {
            return false;
        } // banker stands if sum is 7,8,9

        else if (t == 3) {
            return playerCard.getValue() != 8;
        } // banker draws if player card is not 8

        else if (t == 4) {
            // banker draws if player card is not 0,1,8,9
            return playerCard.getValue() != 0 &&
                    playerCard.getValue() != 1 &&
                    playerCard.getValue() != 8 &&
                    playerCard.getValue() != 9;
        } else if (t == 5) {
            // banker draws if player card is not 0,1,2,3,8,9
            return playerCard.getValue() != 0 &&
                    playerCard.getValue() != 1 &&
                    playerCard.getValue() != 2 &&
                    playerCard.getValue() != 3 &&
                    playerCard.getValue() != 8 &&
                    playerCard.getValue() != 9;
        } else {
            // banker stands if player card is not 6,7
            return playerCard.getValue() == 6 ||
                    playerCard.getValue() == 7;
        }
    }

    public boolean evaluatePlayerDraw(ArrayList<Card> hand) {
        int t = handTotal(hand);

        if (t <= 5 && t >= 0) {
            return true;
        } else {
            return false;
        }
    }
}
