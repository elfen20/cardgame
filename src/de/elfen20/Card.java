package de.elfen20;

import java.util.Objects;

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

    public boolean matchColor(Card card) {
        if (card == null) return false;
        return CColor == card.CColor;
    }

    public boolean matchValue(Card card) {
        if (card == null) return false;
        return Value == card.Value;
    }

    public boolean matchColorOrValue(Card card) {
        if (card == null) return false;
        return ((CColor == card.CColor) || Value == card.Value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Value == card.Value &&
                CColor == card.CColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(CColor, Value);
    }
}
