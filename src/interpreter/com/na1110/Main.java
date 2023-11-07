package com.na1110;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader in;
            if (args.length == 0) {
                in = new BufferedReader(new InputStreamReader(System.in));
            } else {
                in = new BufferedReader(new FileReader(args[0]));
            }
            Lexer lex = new Lexer(in);



            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("can't open file '" + args[0] + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
