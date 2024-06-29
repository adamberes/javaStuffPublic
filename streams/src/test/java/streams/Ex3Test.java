package streams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex3Test {

    String stringBase = "C:\\Users\\Adam Beres";
    String string     = "C:\\Users\\Adam Beres\\OneDrive\\Bilder\\ControlCenter4\\Scan\\";
    String stringExpectedResult = "OneDrive\\Bilder\\ControlCenter4\\Scan\\";


    @Test
    void pathPathElementAddition() {
        Ex3 ex3 = new Ex3();
        String stringAdded = ex3.pathAddition(stringBase, stringExpectedResult);
        assertEquals(stringAdded, string);
    }

    @Test
    void pathSubtraction() {
        Ex3 ex3 = new Ex3();
        String resultPath = ex3.pathSubtraction(stringBase, string);
        assertEquals(resultPath, stringExpectedResult);
    }
}