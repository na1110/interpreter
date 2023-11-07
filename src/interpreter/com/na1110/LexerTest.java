package com.na1110;

import java.io.Reader;
import java.io.StringReader;

public class LexerTest {
    public void testToken() {
        Reader reader = new StringReader("1234");
        Lexer lex = new Lexer(reader);
        if (lex.advance()) {
            if (lex.token() != TokenType.INT) {
                System.out.println("fault");
            }
        } else {
            System.out.println("fault");
        }
    }

    public void testValue() {
        Reader reader = new StringReader("1234  5678");
        Lexer lex = new Lexer(reader);
        if (lex.advance()) {
            if (!lex.value().toString().equals("1234")) {
                System.out.println("fault");
            }
        } else {
            System.out.println("fault");
        }
        if (lex.advance()) {
            if (!lex.value().toString().equals("5678")) {
                System.out.println("fault");
            }
        } else {
            System.out.println("fault");
        }
    }

    public static void main(String[] args) {
        LexerTest test = new LexerTest();
        test.testToken();
        test.testValue();
    }
}
