package ru.cft.focusstart;

import org.junit.*;
import org.junit.rules.ExpectedException;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class MultiplicationTablePrinterTest {

    private final BufferedReader reader = mock(BufferedReader.class);
    private final PrintStream printStream = mock(PrintStream.class);
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Rule
    public ExpectedException thrown = ExpectedException.none();



    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testPrintInConsole() {
        String expect = "1|2|3\n" +
                "-+-+-\n" +
                "2|4|6\n" +
                "-+-+-\n" +
                "3|6|9\n";
        MultiplicationTablePrinter.printInConsole(3);
        assertEquals(expect, outContent.toString());
    }

    @Test
    public void testPrintGreeting() throws IOException {
        MultiplicationTablePrinter.printGreeting(printStream);
        verify(printStream).println("Введите целое число в диапазоне от 1 до 32:");
    }

    @Test
    public void testReadTableLength() throws IOException {
        when(reader.readLine()).thenReturn("25");
        assertEquals(25, MultiplicationTablePrinter.readTableLength(reader));
    }

    @Test
    public void testReadTableLengthSuccessfulWithException() throws IOException {
        when(reader.readLine()).thenThrow(new RuntimeException("Some exception")).thenReturn("25");
        MultiplicationTablePrinter.readTableLength(reader);
        verify(reader, times(2)).readLine();
    }

    @Test
    public void testReadTableLengthIsCorrect() throws IOException {
        when(reader.readLine()).thenReturn("h").thenReturn("25");
        assertEquals("Wrong data", 25, MultiplicationTablePrinter.readTableLength(reader));
    }

    @Test
    public void testReadTableLengthIsNotNull() throws IOException {
        when(reader.readLine()).thenReturn(null).thenReturn("25");
        Assert.assertNotNull("Null data", MultiplicationTablePrinter.readTableLength(reader));
    }

}