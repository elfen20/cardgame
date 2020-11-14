package de.elfen20;
import java.io.*;


public class Main {
    private static final int playerCardCount=5;

    static void Log(String text)
    {
        System.out.println(text);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        var game = new Game();
        Log("Init Game...");
        game.Init(playerCardCount);
        Log("start Game... enter 'stop' to stop at any time.");
        Log("Enter the name of the card you want to play or 'draw' to draw a card.");
        while (game.Playing)
        {
            Log(game.GetGameStatus());
            System.out.print("> ");
            var cardstring = reader.readLine();
            if (!game.CheckCommand(cardstring)) {
                if (!game.PlayCard(cardstring)) {
                    Log("could not play card [" + cardstring + "]");
                }
            }
            if (game.CheckWin()) {
                Log("You won!");
            }
        }
        Log("game ends.");
        System.out.flush();
    }
}
