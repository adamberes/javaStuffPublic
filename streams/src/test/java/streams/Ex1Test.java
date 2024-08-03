package streams;
import org.junit.jupiter.api.*;
import java.io.*;

public class Ex1Test {
    private PrintStream standardOut = System.out;
    private ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testGet2ListFromOneWithStreams() {
        Ex1 ex1 = new Ex1();
        ex1.get2ListFromOneWithStreams();
        String expectedOutput = "Input list: stringListLowerCase\n" +
                "[a1, b2, c3, d4, e5, f6, g7, h8, i9, j10]\n" +
                "First ResultList stringListFirstResult\n" +
                "[a, b, c, d, e, f, g, h, i, j]\n" +
                "Second ResultList stringListSecondResult\n" +
                "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]\n";
        Assertions.assertEquals(expectedOutput.trim(), outputStreamCaptor.toString().replace("\r", "").trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}