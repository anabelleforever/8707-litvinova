package ru.cft.focusstart;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class MultiplicationTablePrinterTest {

    private final BufferedReader reader = mock(BufferedReader.class);
    private final PrintStream printStream = mock(PrintStream.class);

    @Test
    public void testPrintGreeting() throws IOException {
        MultiplicationTablePrinter.printGreeting(printStream);
        verify(printStream).println("Введите целое число в диапазоне от " + MultiplicationTablePrinter.min + " до " + MultiplicationTablePrinter.max + ":");
    }

    @Test
    public void testPrintGreetingWithRetry() {
        doThrow(new RuntimeException("Some exception")).when(printStream).print(anyString());
        MultiplicationTablePrinter.printGreeting(printStream);
        verify(printStream, times(1)).println("Введите целое число в диапазоне от " + MultiplicationTablePrinter.min + " до " + MultiplicationTablePrinter.max + ":");

        doNothing().when(printStream).print(anyString());
        MultiplicationTablePrinter.printGreeting(printStream);
        verify(printStream, times(2)).println("Введите целое число в диапазоне от " + MultiplicationTablePrinter.min + " до " + MultiplicationTablePrinter.max + ":");
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
        when(reader.readLine()).thenReturn("null").thenReturn("25");
        Assert.assertNotNull("Null data", MultiplicationTablePrinter.readTableLength(reader));
    }
}