package Main.ControlModel;

import java.util.ArrayList;
import java.util.List;

public class Field {

    private final int row;
    private final int column;

    private boolean opened = false;
    private boolean mined = false;
    private boolean marked = false;

    private List<Field> neighboringSquares = new ArrayList<>();

    Field(int row, int column) {
        this.row = row;
        this.column = column;
    }
    
}
