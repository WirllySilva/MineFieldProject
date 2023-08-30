package Main;

import Main.ControlModel.GameBoard;

public class App {
    public static void main(String[] args) {
        
        GameBoard gameBoard = new GameBoard(6, 6, 6);
       
        gameBoard.open(3, 3);
        gameBoard.markingToggle(5, 4);
        gameBoard.open(1, 4);

        System.out.println(gameBoard);
    }
    
}
