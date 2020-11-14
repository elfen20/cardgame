package de.elfen20;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

class Deck {
    private final LinkedList<Card> cards;

    public Deck() {
        cards = new LinkedList<Card>();
    }

    public int Size() {
        return this.cards.size();
    }

    public void AddCard(Card card)
    {
        cards.add(card);
    }

    public Card DrawFirstCard() {
        if (this.cards.size() > 0) {
            return cards.removeFirst();
        }
        return null;
    }

    public boolean RemoveCard(Card card) {
        return cards.remove(card);
    }


    public Card GetCardWithName(String cardname)
    {
        Iterator<Card> iter = this.cards.iterator();
        while (iter.hasNext()) {
            Card item = iter.next();
            if (item.toString().toLowerCase().equals("[" + cardname.toLowerCase() + "]")) {
                return item;
            }
        }
        return null;
    }

    public Card TryGetCardWithName(String cardname)
    {
        return this.GetCardWithName(cardname);
    }

    public void Shuffle() {
        Collections.shuffle(cards);
    }

    static public Deck GetNewGameDeck() {
        var newDeck = new Deck();
        for(byte i=1;i<10;i++) {
            newDeck.AddCard(new Card(CardColor.Red, i));
            newDeck.AddCard(new Card(CardColor.Green, i));
            newDeck.AddCard(new Card(CardColor.Blue, i));
            newDeck.AddCard(new Card(CardColor.Yellow, i));
        }
        newDeck.Shuffle();
        return newDeck;
    }

    @Override
    public String toString() {
        String Cstr = "";
        for (Card c:cards) {
            Cstr = Cstr.concat(c.toString() + ",");
        }
        return Cstr.replaceAll(",+$", "");
    }

}
