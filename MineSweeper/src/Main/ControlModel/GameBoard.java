package Main.ControlModel;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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

    public void open(int row, int column) {
        fields.parallelStream()
        .filter(f -> f.getRow() == row && f.getColumn() == column)
        .findFirst()
        .ifPresent(f -> f.openField());
    }

    public void markingToggle(int row, int column) {
        fields.parallelStream()
            .filter(f -> f.getRow() == row && f.getColumn() == column)
            .findFirst()
            .ifPresent(f -> f.markingToggle());
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
        long armedMines = 0;
        Predicate<Field> mined = f -> f.isMinado();

        do {
            armedMines = fields.stream().filter(mined).count();
            int randomValue = (int) (Math.random() * fields.size());
            fields.get(randomValue).layMine();
        } while(armedMines < numberOfMines);
    }

    public boolean goalHasBeenMet() {
        return fields.stream().allMatch(f -> f.goalHasBeenMet());
    }

    public  void restartGame() {
        fields.stream().forEach(f -> f.restartGame());
        raffleMines();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        for(int r = 0; r < numberOfrows; r++) {
            for(int c = 0; c < numberOfcolumns; c++) {
                sb.append(" ");
                sb.append(fields.get(i));
                sb.append(" ");
                i++;
            }
            sb.append("\n");
        }

        return sb.toString();
    }
 

}
