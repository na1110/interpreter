package com.na1110;

public class JTBinExp extends JTCode {
    private int op;
    private JTCode code1;
    private JTCode code2;

    public JTBinExp(int operator, JTCode c1, JTCode c2) {
        op = operator;
        c1 = code1;
        c2 = code2;
    }

    public JTCode run() throws Exception {
        JTCode c1 = code1.run();
        JTCode c2 = code2.run();
        JTCode result = null;

        if (op == '+') {
            result = new JTInt(((JTInt) c1).getValue() + ((JTInt) c2).getValue());
        } else if (op == '-') {
            result = new JTInt(((JTInt) c1).getValue() - ((JTInt) c2).getValue());
        } else if (op == '*') {
            result = new JTInt(((JTInt) c1).getValue() * ((JTInt) c2).getValue());
        } else if (op == '/') {
            result = new JTInt(((JTInt) c1).getValue() / ((JTInt) c2).getValue());
        }

        return result;
    }
}
