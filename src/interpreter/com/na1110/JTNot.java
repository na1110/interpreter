package com.na1110;

public class JTNot extends JTCode {
    private JTCode code;

    public JTNot(JTCode c) {
        code = c;
    }

    @Override
    public JTCode run() throws Exception {
        JTCode c = code.run();
        if (c.getClass() != JTBool.class) {
            throw new Exception("単行演算子'!'が適用できません");
        }
        JTBool p = (JTBool) c;
        if (p.isTrue()) {
            return JTBool.False;
        } else {
            return JTBool.True;
        }
    }
}
