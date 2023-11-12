package com.na1110;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    public static Map<String, JTCode> Globals = new HashMap<>();

    public static boolean hasSymbol(String sym) {
        return Globals.containsKey(sym);
    }

    public static JTCode get(String sym) {
        return (JTCode) Globals.get(sym);
    }

    public static void set(String sym, JTCode code) {
        Globals.put(sym, code);
    }
}
