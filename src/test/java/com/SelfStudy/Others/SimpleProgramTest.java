package com.SelfStudy.Others;

import static org.junit.Assert.*;

import java.io.*;

import org.junit.*;

    public class SimpleProgramTest {
        private final InputStream systemIn = System.in;
        private final PrintStream systemOut = System.out;

        private ByteArrayInputStream testIn;
        private ByteArrayOutputStream testOut;

        @Before
        public void setUpOutput() {
            testOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(testOut));
        }

        private void provideInput(String data) {
            testIn = new ByteArrayInputStream(data.getBytes());
            System.setIn(testIn);
        }

        private String getOutput() {
            return testOut.toString();
        }

        @After
        public void restoreSystemInputOutput() {
            System.setIn(systemIn);
            System.setOut(systemOut);
        }

        @Test
        public void testCase1() {
            final String testString = "Hello!";
            provideInput(testString);

            SimpleProgram.main(new String[0]);

            assertEquals(testString, getOutput());
        }
    }

