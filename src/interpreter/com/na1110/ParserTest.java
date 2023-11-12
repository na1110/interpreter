package com.na1110;

import java.io.Reader;
import java.io.StringReader;

public class ParserTest {
    public void testParser() {
        Reader reader = new StringReader("\"Hello\" * 3");
        Lexer lex = new Lexer(reader);
        Parser parser = new Parser();
        JTCode code = parser.parse(lex);
        if (code == null) {
            System.out.println("fault: code is null");
        } else {
            try {
                if (!code.run().toString().equals("HelloHelloHello")) {
                    System.out.println("fault: " + code.run().toString());
                }
            } catch (Exception e) {
                System.out.println("fault: Exception occurred");
            }
        }
    }

    public static void main(String[] args) {
        ParserTest test = new ParserTest();
        test.testParser();
    }
}
