package Main.view;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import Main.ControlModel.GameBoard;
import Main.Exception.GetOutException;
import Main.Exception.TriggeredException;

public class ConsoleGameBoard {
    
    private GameBoard gameBoard;
    private Scanner keyBoard = new Scanner(System.in);

    public ConsoleGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;

        implementGame();
    }

    private void implementGame() {
        try {
            boolean continueGame = true;
            
            while(continueGame) {
                gameCycle();
                System.out.println("New game? (S/n) ");
                String answer = keyBoard.nextLine();

                if("n".equalsIgnoreCase(answer)) {
                    continueGame = false;
                } else {
                    gameBoard.restartGame();
                } 
            }
        } catch (GetOutException e) {
            System.out.println("See you soon");
        } finally {
            keyBoard.close();
        }
    }

    private void gameCycle() {
        try {

            while(!gameBoard.goalHasBeenMet()) {
                System.out.println(gameBoard);

                String playerCommand = playerCommandAnswer("Type (x, y): ");
                
                Iterator<Integer> xy = Arrays.stream(playerCommand.split(","))
                    .map(e -> Integer.parseInt(e.trim())).iterator();
                
                playerCommandAnswer("1 - Open or 2 - (Un)flag: ");
                
                if("1".equals(playerCommand)) {
                    gameBoard.open(xy.next(), xy.next());
                } else if("2".equals(playerCommand)) {
                    gameBoard.markingToggle(xy.next(), xy.next());
                }
            }
            
            System.out.println("You win!!");
        } catch(TriggeredException e) {
            System.out.println("You lose!");
        }
    }

    private String playerCommandAnswer(String playerAnswer) {
        System.out.print(playerAnswer);
        String playerCommand = keyBoard.nextLine();

        if("sair".equalsIgnoreCase(playerCommand)) {
            throw new GetOutException();
        }
        return playerCommand;
    }
}