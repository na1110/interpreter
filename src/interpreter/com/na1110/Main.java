package com.na1110;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main {
    static void usage() {
        System.out.println("usage: java Main [source_filename]");
    }

    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                usage();
            } else {
                BufferedReader in = new BufferedReader(new FileReader(args[0]));
                Lexer lex = new Lexer(in);
                Parser parser = new Parser();
                while (true) {
                    JTCode code = (JTCode) parser.parse(lex);
                    if (code == null) {
                        break;
                    }
                    System.out.println(code.run());
                }
                in.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("can't open file '" + args[0] + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
