import javafx.scene.image.*;

import javax.swing.*;

public class Card extends BaccaratDealer {

    private String suit;
    private int rank;
    private String path;
    private Image image;
    //private int point;

    public void setSuit (String s) {this.suit = s;}

    public void setRank (int r) {this.rank = r;}

    public String getSuit() {return this.suit;}

    public int getValue() {return this.rank;}

    public Image getImage() {return this.image;}

    public String getName() {return this.path;}

    //public int getPoint() {return this.point;}

    Card (String theSuit, int theRank) {
        this.suit = theSuit;
        this.rank = theRank;
        this.path = "/cards/"+ this.rank + this.suit.charAt(0) + ".png";
    }
}
