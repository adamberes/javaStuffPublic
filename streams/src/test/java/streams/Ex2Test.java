package streams;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class Ex2Test {

    @Test
    public void testCombineDataFromTwoStreams() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Ex2 ex2 = new Ex2();
        ex2.combineDataFromTwoStreams();

        String[] expectedOutputs = {
                "Lower letter list: stringListLowerCase",
                "[a1, b2, c3, d4, e5, f6, g7, h8, i9, j10]",
                "Capital letter list: stringListUpperCase",
                "[A1, B2, C3, D4, E5, F6, G7, H8, I9, J10]",
                "Combined list: mergedResultList Elements from stringListLowerCase added to stringListUpperCase",
                "[A1-a1, B2-b2, C3-c3, D4-d4, E5-e5, F6-f6, G7-g7, H8-h8, I9-i9, J10-j10]"
        };

        String[] lines = outContent.toString().split(System.getProperty("line.separator"));
        assertArrayEquals(expectedOutputs, lines);

        System.setOut(originalOut);
    }
}