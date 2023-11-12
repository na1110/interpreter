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
        try {
            skipWhiteSpace();
            int c = reader.read();
            if (c < 0) {
                return false;
            }
            switch (c) {
            case '+': case '-': case '*': case '/': case '(': case ')': case '=':
                tok = c;
                break;
            default:
                if (Character.isDigit((char) c)) {
                    reader.unread();
                    lexDigit();
                    tok = TokenType.INT;
                } else if (Character.isJavaIdentifierStart(c)) {
                    reader.unread();
                    lexSymbol();
                    tok = TokenType.SYMBOL;
                } else {
                    throw new Exception("不正な文字: " + (char) c);
                }  
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
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

    private void lexSymbol() throws Exception {
        StringBuilder sb = new StringBuilder();
        int c = 0;
        while (true) {
            c = reader.read();
            if (c == -1 | !Character.isJavaIdentifierPart(c)) {
                reader.unread();
                break;
            }
            sb.append((char) c);
        }
        val = sb.toString();
    }

    private void skipWhiteSpace() throws Exception {
        int c = reader.read();
        while (c != 0 && Character.isWhitespace((char) c)) {
            c = reader.read();
        }
        reader.unread();
    }
}
