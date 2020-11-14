package de.elfen20;

class Game {

    public boolean Playing = true;

    private Deck sourceDeck;
    private Deck playerDeck;

    public void Init(int playerCardCount) {
        sourceDeck = Deck.GetNewGameDeck();
        playerDeck = new Deck();
        for (int i=0; i<playerCardCount; i++) {
            DrawPlayerCard();
        }
    }

    public Card DrawPlayerCard()
    {
        Card card = sourceDeck.DrawFirstCard();
        playerDeck.AddCard(card);
        return card;
    }

    public boolean PlayCard(String cardstring) {
        Card card = playerDeck.GetCardWithName(cardstring);
        if (card != null) {
            playerDeck.RemoveCard(card);
            return true;
        }
        return false;
    }

    public boolean CheckCommand(String command) {
        switch (command) {
            case "draw" -> {
                Log("drawn card: " + DrawPlayerCard().toString());
                return true;
            }
            case "stop" -> {
                this.Playing = false;
                Log("Game stop!");
                return true;

            }
        }
        return false;
    }

    public boolean CheckWin() {
        if (playerDeck.Size() == 0) {
            this.Playing = false;
            return true;
        }
        return false;
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
