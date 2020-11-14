package de.elfen20;

class Game {

    public boolean Playing = true;

    private Deck sourceDeck;
    private Deck playerDeck;

    public void Init(int playerCardCount) {
        sourceDeck = Deck.GetNewGameDeck();
        playerDeck = new Deck();
        for (int i=0; i<playerCardCount; i++) {
            playerDeck.AddCard(sourceDeck.DrawFirstCard());
        }
    }

    public boolean PlayCard(String cardstring) {
        Card card = playerDeck.GetCardWithName(cardstring);
        if (card != null) {
            playerDeck.RemoveCard(card);
            return true;
        }
        if (cardstring.equals("stop")) {
            this.Playing = false;
            Log("Game stop!");
        }
        return false;
    }

    public void Check() {
        if (playerDeck.Size() == 0) {
            Log("You won!");
            this.Playing = false;
        }
    }

    public String GetGameStatus()
    {
        return "Your Cards: " + playerDeck.toString() + " " + sourceDeck.Size() + " cards in main deck left.";
    }

    private void Log(String text)
    {
        System.out.println(text);
    }

}
