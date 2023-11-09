package com.na1110;

import java.io.Reader;
import java.io.StringReader;

public class ParserTest {
    public void testParser() {
        Reader reader = new StringReader("  1234");
        Lexer lex = new Lexer(reader);
        Parser parser = new Parser();
        JTCode code = parser.parse(lex);
        if (code == null) {
            System.out.println("fault");
        } else {
            if (!code.toString().equals("1234")) {
                System.out.println("fault");
            }
        }
    }

    public static void main(String[] args) {
        ParserTest test = new ParserTest();
        test.testParser();
    }
}
