package de.elfen20;

class Game {

    public boolean Playing = true;

    private Deck sourceDeck;
    private Deck stackDeck;
    private Deck playerDeck;

    public void Init(int playerCardCount) {
        sourceDeck = Deck.GetNewGameDeck();
        playerDeck = new Deck();
        for (int i=0; i<playerCardCount; i++) {
            DrawPlayerCard();
        }
        stackDeck = new Deck();
        stackDeck.AddCard(sourceDeck.DrawFirstCard());
    }

    public Card DrawPlayerCard()
    {
        Card card = sourceDeck.DrawFirstCard();
        playerDeck.AddCard(card);
        return card;
    }

    public boolean CanPlay(Card card)
    {
        Card topCard = stackDeck.PeekLastCard();
        return topCard.matchColorOrValue(card);
    }

    public boolean PlayCard(String cardstring) {
        Card card = playerDeck.GetCardWithName(cardstring);
        if (card != null) {
            if (CanPlay(card)) {
                playerDeck.RemoveCard(card);
                stackDeck.AddCard(card);
                return true;
            }
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
        return "Your Cards: " +
                playerDeck.toString() +
                " " + sourceDeck.Size() +
                " cards in main deck left." +
                System.lineSeparator() +
                stackDeck.PeekLastCard().toString() +
                " on stack.";
    }

    private void Log(String text)
    {
        System.out.println(text);
    }

}
