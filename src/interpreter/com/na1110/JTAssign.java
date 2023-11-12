package com.na1110;

public class JTAssign extends JTCode {
    private JTCode symbol;
    private JTCode code;

    public JTAssign(JTCode symbol, JTCode code) {
        this.symbol = symbol;
        this.code = code;
    }

    public JTCode run() throws Exception {
        JTSymbol sym = (JTSymbol) symbol;
        JTCode c = code.run();
        SymbolTable.set(sym.getName(), code);
        return c;
    }
}
