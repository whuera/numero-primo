package com.app.demo;



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String numero;
        String res = null;
        System.out.println("inicio");
        while ((numero = r.readLine()) != null) {
            res = validateNumberPrimo(numero).toString();
            System.out.println(res);

        }
    }

    public static String validateNumberPrimo(String numero) {
        int vareval = Integer.parseInt(numero);
        boolean prime = true;
        for (int i = 2; i < vareval; i++) {
            if (vareval % i == 0) {
                prime = false;
                break;
            }
        }
        if (prime) {
            return "PRIMO";
        } else {
            return "NO_ES_PRIMO";
        }

    }


}