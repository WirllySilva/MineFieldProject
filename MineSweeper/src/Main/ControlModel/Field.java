package Main.ControlModel;

import java.util.ArrayList;
import java.util.List;

public class Field {

    private final int row;
    private final int column;

    private boolean opened = false;
    private boolean mined = false;
    private boolean marked = false;

    private List<Field> adjacentSquares = new ArrayList<>();

    Field(int row, int column) {
        this.row = row;
        this.column = column;
    }

    boolean addAdjacentSquare(Field adjacentSquare) {
        boolean differentRow = row != adjacentSquare.row;
        boolean differentColumn = column != adjacentSquare.column;
        boolean diagonallyAdjacent = differentRow && differentColumn;

        int deltaRow = Math.abs(row - adjacentSquare.row);
        int deltaColumn = Math.abs(column - adjacentSquare.column);
        int generalDelta = deltaColumn + deltaRow;

        if(generalDelta == 1 && !diagonallyAdjacent) {
            adjacentSquares.add(adjacentSquare);
            return true;
        } else if(generalDelta == 2 && diagonallyAdjacent) {
            adjacentSquares.add(adjacentSquare);
            return true;
        } else {
            return false;
        }
    }
    
}
