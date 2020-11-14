package de.elfen20;

class Card {
    public final CardColor CColor;
    public final byte Value;

    public Card() {
        this.CColor = CardColor.None;
        this.Value = 0;
    }

    public Card(CardColor CColor, byte value) {
        this.CColor = CColor;
        this.Value = value;
    }

    @Override
    public String toString() {
        return "[" + CColor + Value + ']';
    }
}
