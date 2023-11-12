package com.na1110;

import java.io.Reader;
import java.io.StringReader;

public class ParserTest {
    public void testParser() {
        Reader reader = new StringReader("str = \"XYZ\"");
        Lexer lex = new Lexer(reader);
        Parser parser = new Parser();
        JTCode code = parser.parse(lex);
        if (code == null) {
            System.out.println("fault");
        } else {
            try {
                if (!code.run().toString().equals("XYZ")) {
                    System.out.println("fault");
                }
            } catch (Exception e) {
                System.out.println("fault");
            }
        }
    }

    public static void main(String[] args) {
        ParserTest test = new ParserTest();
        test.testParser();
    }
}
