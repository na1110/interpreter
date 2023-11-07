package com.na1110;

import java.io.Reader;

public class Lexer {
    private int tok;
    private Object val;
    private LexerReader reader;

    public Lexer(Reader r) {
        reader = new LexerReader(r);
    }

    public int token() {
        return tok;
    }

    public Object value() {
        return val;
    }

    public boolean advance() {
        return false;
    }

    private void lexDigit() throws Exception {
        int num = 0;
        while (true) {
            int c = reader.read();
            if (c < 0) {
                break;
            }
            if (!Character.isDigit((char) c)) {
                reader.unread();
                break;
            }
            num = (num * 10) + (c - '0');
        }
        val = Integer.valueOf(num);
    }

    private void skipWhiteSpace() throws Exception {
        int c = reader.read();
        while (c != 0 && Character.isWhitespace((char) c)) {
            c = reader.read();
        }
        reader.unread();
    }
}
