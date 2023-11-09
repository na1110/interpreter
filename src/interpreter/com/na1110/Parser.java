package com.na1110;

class Parser {
    private Lexer lex;

    public JTCode parse(Lexer lexer) {
        JTCode code = null;
        lex = lexer;
        try {
            code = program();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    private JTCode program() throws Exception {
        return exp();
    }

    private JTCode exp() throws Exception {
        JTCode code = null;
        if (lex.advance()) {
            int token = lex.token();
            switch (token) {
                case TokenType.INT:
                    code = new JTInt((Integer) lex.value());
                    break;
                default:
                    throw new Exception("空白文字、数字、終端記号以外の文字が読み込まれました。");
            }
        }
        return code;
    }
}
