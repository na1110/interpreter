package com.na1110;

public class JTBinExp extends JTCode {
    private int op;
    private JTCode code1;
    private JTCode code2;

    public JTBinExp(int operator, JTCode c1, JTCode c2) {
        op = operator;
        code1 = c1;
        code2 = c2;
    }

    public JTCode run() throws Exception {
        JTCode c1 = code1.run();
        JTCode c2 = code2.run();
        JTCode result = null;

        if (op == '+') {
            if (c1 instanceof JTInt && c2 instanceof JTString) {
                result = new JTInt(((JTInt) c1).getValue() + ((JTInt) c2).getValue());
            } else if (c1 instanceof JTString && c2 instanceof JTString) {
                result = new JTString(((JTString) c1).getValue() + ((JTString) c2).getValue());
            } else {
                throw new Exception("unknown operand");
            }
        } else if (op == '-') {
            if (c1 instanceof JTInt && c2 instanceof JTInt) {
                result = new JTInt(((JTInt) c1).getValue() - ((JTInt) c2).getValue());
            } else {
                throw new Exception("unknown operand");
            }
        } else if (op == '*') {
            if (c1 instanceof JTInt && c2 instanceof JTInt) {
                result = new JTInt(((JTInt) c1).getValue() * ((JTInt) c2).getValue());
            } else if (c1 instanceof JTString && c2 instanceof JTInt) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < ((JTInt) c2).getValue(); i++) {
                    sb.append(((JTString) c1).getValue());
                }
                result = new JTString(sb.toString());
            } else {
                throw new Exception("unknown operand");
            }
        } else if (op == '/') {
            if (c1 instanceof JTInt && c2 instanceof JTInt) {
                result = new JTInt(((JTInt) c1).getValue() / ((JTInt) c2).getValue());
            } else {
                throw new Exception("unknown operand");
            }
        }

        return result;
    }
}
