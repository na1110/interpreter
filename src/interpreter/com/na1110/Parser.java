package com.na1110;

class Parser {
    private Lexer lex;
    private int token;

    public JTCode parse(Lexer lexer) {
        JTCode code = null;
        lex = lexer;
        getToken();
        try {
            code = program();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }

    private JTCode program() throws Exception {
        JTCode code = exp();
        if (token != TokenType.EOS) {
            throw new Exception("文法エラー: プログラムの最後に余計なトークンがあります。");
        }
        return code;
    }

    private JTCode exp() throws Exception {
        JTCode code = term();
        switch (token) {
        case '+':
        case '-':
            code = exp2(code);
            break;
        }
        return code;
    }

    private JTCode exp2(JTCode code) throws Exception {
        JTBinExp result = null;
        while ((token == '+') || (token == '-')) {
            int op = token;
            getToken();
            JTCode code2 = term();
            if (code2 == null) {
                throw new Exception("文法エラー: 右の項がありません");
            } else if (result == null) {
                result = new JTBinExp(op, code, code2);
            } else {
                result = new JTBinExp(op, result, code2);
            }
        }
        return result;
    }

    private JTCode term() throws Exception {
        JTCode code = factor();
        switch (token) {
        case '*':
        case '/':
            code = term2(code);
            break;
        }
        return code;
    }

    private JTCode term2(JTCode code) throws Exception {
        JTBinExp result = null;
        while ((token == '*') || (token == '/')) {
            int op = token;
            getToken();
            JTCode code2 = factor();
            if (code2 == null) {
                throw new Exception("文法エラー: 右の項がありません");
            } else if (result == null) {
                result = new JTBinExp(op, code, code2);
            } else {
                result = new JTBinExp(op, result, code2);
            }
        }
        return result;
    }

    private JTCode factor() throws Exception {
        JTCode code = null;
        switch (token) {
        case TokenType.EOS:
            break;
        case TokenType.INT:
            code = new JTInt((Integer) lex.value());
            getToken();
            break;
        case '-':
            getToken();
            code = new JTMinus(factor());
            break;
        case '(':
            getToken();
            code = exp();
            if (token != ')') {
                throw new Exception("文法エラー: 対応する括弧がありません");
            }
            getToken();
            break;
        case TokenType.SYMBOL:
            JTSymbol sym = new JTSymbol((String) lex.value());
            getToken();
            if (token == '=') {
                getToken();
                code = new JTAssign(sym, exp());
            } else {
                code = sym;
            }
            break;
        case TokenType.STRING:
            code = new JTString((String) lex.value());
            getToken();
            break;
        default:
            throw new Exception("文法エラー");
        }
        return code;
    }

    private void getToken() {
        if (lex.advance()) {
            token = lex.token();
        } else {
            token = TokenType.EOS;
        }
    }
}
