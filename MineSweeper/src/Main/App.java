package Main;

import Main.ControlModel.GameBoard;
import Main.view.ConsoleGameBoard;

public class App {
    public static void main(String[] args) {
        
        GameBoard gameBoard = new GameBoard(6, 6, 3);
        new ConsoleGameBoard(gameBoard);
        
    }
    
}
