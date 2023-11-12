package com.na1110;

public class JTSymbol extends JTCode {
    private String name;

    public JTSymbol(String s) {
        name = s;
    }

    public JTCode run() throws Exception {
        JTCode c = SymbolTable.get(name);
        if (c == null) {
            throw new Exception(name + "は未定義です");
        }
        return c;
    }

    public String getName() {
        return name;
    }
}
