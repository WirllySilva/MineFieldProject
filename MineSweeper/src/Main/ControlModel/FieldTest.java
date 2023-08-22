package Main.ControlModel;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FieldTest {

    private Field field;
    @BeforeEach
    void startField() {
        field = new Field(3, 3);
    }

    @Test
    void realAdjacentSquareFirstDistance() {
        Field leftAdjacentSquare = new Field(3, 2);
        boolean resultLeftAdjacentSquare = field.addAdjacentSquare(leftAdjacentSquare);
        assertTrue(resultLeftAdjacentSquare);
        
    }

    @Test
    void realAdjacentSquareSecondDistance() {
        Field rightAdjacentSquare = new Field(3, 2);
        boolean resultRightAdjacentSquare = field.addAdjacentSquare(rightAdjacentSquare);
        assertTrue(resultRightAdjacentSquare);
    }

    @Test
    void realAdjacentSquareThirdDistance() {
        Field downAdjacentSquare = new Field(4, 3);
        boolean resultDownAdjacentSquare = field.addAdjacentSquare(downAdjacentSquare);
        assertTrue(resultDownAdjacentSquare);
    }

    @Test
    void realAdjacentSquareFourthDistance() {
        Field upAdjacentSquare = new Field(2, 3);
        boolean resultUpAdjacentSquare = field.addAdjacentSquare(upAdjacentSquare);
        assertTrue(resultUpAdjacentSquare);
    }

    @Test
    void realdAdjacentSquareFifthDistance() {
        Field leftUpDiagonallyAdjacentSquare = new Field(2, 4);
        boolean leftUpdiagonallyAdjacentSquareResult = field.addAdjacentSquare(leftUpDiagonallyAdjacentSquare);
        assertTrue(leftUpdiagonallyAdjacentSquareResult);
    }   
}
