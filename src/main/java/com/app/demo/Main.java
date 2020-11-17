package com.app.demo;



import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;


@Slf4j
public class Main {
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader r = new BufferedReader (new InputStreamReader (System.in));
        String s;
        System.out.println("Ingrese un número: \n");
        while (  (s=r.readLine()) != null) {
            System.out.println(is_my_number_prime(s));
        }
    }


    public static String is_my_number_prime(String input)
    {
        int vareval;
        if(input.isBlank() || input.isEmpty() ){
            return "debe ingresar un valor";
        }
        try {
            vareval = Integer.parseInt(input);
        }catch (NumberFormatException ex){
            return "solo debe ingresar numeros no letras";
        }
        boolean prime = true;
        try {
            for (int i = 2; i < vareval; i++) {
                if (vareval % i == 0) {
                    prime = false;
                    break;
                }
            }
        }catch (Exception ex){
            ex.getMessage();
        }

        if (prime) {
            input = "PRIMO";
        } else {
            input = "NO_ES_PRIMO";
        }
        return input;

    }

    public static String board_next_step(String initial_board, String steps)
    {
           char VIVO = '1';
           char MUERTO = '0';
           char[] ch = new char[initial_board.length()];
           String[] flag = new String[3];
        System.out.println("initial_board = " + initial_board + ", steps = " + steps);
        for (int i = 0; i < initial_board.length(); i++) {

            if(initial_board.charAt(i) == '1')
            {
                System.out.println("celula viva"+ch[i]);
                flag[0] = String.valueOf(initial_board.charAt(i));
                for (int ini = 0; ini < 3; ini ++){
                System.out.println("valor flag ["+ini+"] "+flag[ini]);}
            }else if (initial_board.charAt(i) == '0'){
                System.out.println("celula muerta"+ch[i]);
            }
            ch[i] = initial_board.charAt(i);
            System.out.println(ch);
        }
        return initial_board+steps;
    }

    public static String process_input(String input) {
        String[] parameters = input.split(",");
        return calculate_price(parameters[0],parameters[1],parameters[2],parameters[3]);
    }

    public static String calculate_price(String product_name,String category,String cost,String weight) {
        Double aditionalPound = 2.0;
        Double productCost = Double.parseDouble(cost);
        Double productCostEnv = 0.0;
        Double productWeight = Double.parseDouble(weight);
        Double productIva = 0.0;
        Double productTax = 0.0;
        Double productFinalCost = 0.0;
        Double productCostCommision = 0.0;
        //arancel
        productTax = productCost * 0.10;
        //calculo en base al peso
        if(productWeight > 4){
            productCostEnv = 10.0 + aditionalPound;
        }else{
            productCostEnv = 10.0;
        }
        //iva
        if (productCost> 200.0){
            productIva = (productCost + productCostEnv + productTax) * 0.19;
        }else{
            productIva = (productCost + productCostEnv) * 0.19;
        }
        //por categoria
        switch (category)
        {
            case "001":
                productCostCommision = productCost * 0.10;
                break;
            case "002":
                productCostCommision = productCost * 0.05;
                break;
            case "003":
                productCostCommision = productCost * 0.15;
                break;
            default:
                productCostCommision = productCost * 0.0;

        }
        productFinalCost = productCost + productTax + productIva + productCostEnv + productCostCommision;

        return product_name+','+String.valueOf(productFinalCost);
    }



}