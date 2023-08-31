package Main.ControlModel;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import Main.Exception.TriggeredException;

public class GameBoard {

    private int numberOfRows;
    private int numberOfColumns;
    private int numberOfMines;

    private final List<Field> fields = new ArrayList<>();

    public GameBoard(int numberOfRows, int numberOfColumns, int numberOfMines) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.numberOfMines = numberOfMines;

        generateField();
        connectAdjacentsSquares();
        raffleMines();
    }

    public void open(int row, int column) {
        try {
            fields.parallelStream()
                    .filter(f -> f.getRow() == row && f.getColumn() == column)
                    .findFirst()
                    .ifPresent(f -> f.openField());
        } catch (TriggeredException e) {
            fields.forEach(f -> f.setOpened(true));
            throw e;
        }
    }

    public void markingToggle(int row, int column) {
        fields.parallelStream()
                .filter(f -> f.getRow() == row && f.getColumn() == column)
                .findFirst()
                .ifPresent(f -> f.markingToggle());
    }

    private void generateField() {
        for (int row = 0; row < numberOfRows; row++) {
            for (int column = 0; column < numberOfColumns; column++) {
                fields.add(new Field(row, column));
            }
        }
    }

    private void connectAdjacentsSquares() {
        for (Field f1 : fields) {
            for (Field f2 : fields) {
                f1.addAdjacentSquare(f2);
            }
        }
    }

    private void raffleMines() {
        long armedMines = 0;
        Predicate<Field> mined = f -> f.isMinado();

        do {
            int randomValue = (int) (Math.random() * fields.size());
            fields.get(randomValue).layMine();
            armedMines = fields.stream().filter(mined).count();
        } while (armedMines < numberOfMines);
    }

    public boolean goalHasBeenMet() {
        return fields.stream().allMatch(f -> f.goalHasBeenMet());
    }

    public void restartGame() {
        fields.stream().forEach(f -> f.restartGame());
        raffleMines();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("  ");
        for (int c = 0; c < numberOfColumns; c++) {
            sb.append(" ");
            sb.append(c);
            sb.append(" ");
        }

        sb.append("\n");

        int i = 0;
        for (int r = 0; r < numberOfRows; r++) {
            sb.append(r);
            sb.append(" ");
        
            for (int c = 0; c < numberOfColumns; c++) {
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
