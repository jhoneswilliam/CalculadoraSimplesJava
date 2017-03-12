package model;

import java.util.Arrays;

public class Helper {

    public static String Operadores = "+,-,*,/,=,L,R";
    public static String Hexadecimal = "0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F";

    public static float HexaToDecimalFloat(String hexa) throws Exception {
        try {
            String decimal = "";
            if (hexa.contains(Simbolo.PONTO)) {
                String pp = hexa.replace(Simbolo.PONTO, "#");
                String[] hexaA = pp.split("#");
                System.out.println("teste");

                decimal += HexaToDecimalInt(hexaA[0]) + "";//antes do ponto = aa.bb -> aa
                decimal += Simbolo.PONTO;//bota ponto.

                if (hexaA[1].length() > 0) {
                    decimal += HexaToDecimalInt(hexaA[1]) + "";//depois do ponto   
                } else {
                    decimal += "0";
                }
            } else {
                decimal += HexaToDecimalInt(hexa) + "";
            }
            return Float.parseFloat(decimal);
        } catch (Exception e) {
            throw new Exception("Não foi possivel converter");
        }
    }

    public static int HexaToDecimalInt(String hexa) {
        Integer decimal = Integer.parseInt(hexa, 16);
        System.out.println("hexa [" + hexa + "] -> decimal[" + decimal + "]");
        return decimal;
    }

    //http://stackoverflow.com/questions/13465098/decimal-to-hexadecimal-converter-in-java
    public static String DecimalFloatToHexa(float decimal) throws Exception {
        try {
            String decString = (decimal+"");
            decString = decString.replace(".", "#");
            String[] ADeci = decString.split("#");
            
            System.out.println("ADECI[]" + DecimalIntToHexa(Integer.parseInt(ADeci[0])));
            System.out.println("ADECI[]" + Integer.parseInt(ADeci[1]));
            
            String r = "";            
            r += DecimalIntToHexa(Integer.parseInt(ADeci[0]));
            r += Simbolo.PONTO;
            r += DecimalIntToHexa(Integer.parseInt(ADeci[1]));     
            
            System.out.println("Hexa: "+ r);
            return r;            
        } catch (Exception e) {
            throw new Exception("Não foi possivel converter");
        }
    }
    //15EF3BF
    public static String DecimalIntToHexa(int decimal) {
        return Integer.toHexString(decimal).toUpperCase();
    }

    public static boolean EOperador(String operador) {
        return Operadores.contains(operador);
    }

    public static boolean EHexa(String operador) {
        return Hexadecimal.contains(operador);
    }
}
