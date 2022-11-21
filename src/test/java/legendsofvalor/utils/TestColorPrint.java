package legendsofvalor.utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.*;

public class TestColorPrint {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        outContent.reset();
        errContent.reset();
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void TestColorPrintString() {
        Assertions.assertEquals("\033[31mTest\033[0m", ColorPrint.redString("Test"));
        Assertions.assertEquals("\033[32mTest\033[0m", ColorPrint.greenString("Test"));
        Assertions.assertEquals("\033[33mTest\033[0m", ColorPrint.yellowString("Test"));
    }

    @Test
    public void TestColorPrintIO() {
        ColorPrint.red("Test Red");
        Assertions.assertEquals("\033[31mTest Red\033[0m\n", outContent.toString());
        outContent.reset();
        ColorPrint.green("Test Green");
        Assertions.assertEquals("\033[32mTest Green\033[0m\n", outContent.toString());
        outContent.reset();
        ColorPrint.yellow("Test Yellow");
        Assertions.assertEquals("\033[33mTest Yellow\033[0m\n", outContent.toString());
        outContent.reset();
        ColorPrint.query("Test Query");
        Assertions.assertEquals("\033[33m[?] Test Query\033[0m\n", outContent.toString());
        outContent.reset();
        ColorPrint.error("Test Error");
        Assertions.assertEquals("\033[31m[!] Test Error\033[0m\n", outContent.toString());
        outContent.reset();
        ColorPrint.info("Test Info");
        Assertions.assertEquals("\033[32m[*] Test Info\033[0m\n", outContent.toString());
    }
}
