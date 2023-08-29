package Main.ControlModel;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    
    private int numberOfrows;
    private int numberOfcolumns;
    private int numberOfMines;

    private final List<Field> fields = new ArrayList<>();


    public GameBoard(int numberOfrows, int numberOfcolumns, int numberOfMines) {
        this.numberOfrows = numberOfrows;
        this.numberOfcolumns = numberOfcolumns;
        this.numberOfMines = numberOfMines;

        generateField();
        connectAdjacentsSquares();
        raffleMines();
    }

    private void generateField() {
        for (int row = 0; row < numberOfrows; row++) {
            for (int column = 0; column < numberOfcolumns; column++) {
                fields.add(new Field(row, column));
            }
        }
    }
    
    private void connectAdjacentsSquares() {
        for(Field f1: fields) {
            for(Field f2: fields) {
                f1.addAdjacentSquare(f2);
            }
        }
    }
    
    private void raffleMines() {
    }

    
    

}
