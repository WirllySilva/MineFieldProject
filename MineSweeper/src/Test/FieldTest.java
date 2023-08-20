package Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Main.ControlModel.Field;

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
}
