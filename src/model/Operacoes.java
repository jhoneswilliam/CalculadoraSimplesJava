package model;

public class Operacoes {

    public static float Soma(float numeroPreOperando, float numeroPosOperando) {
        return numeroPreOperando + numeroPosOperando;
    }

    public static float Multiplicacao(float numeroPreOperando, float numeroPosOperando) {
        return numeroPreOperando * numeroPosOperando;
    }

    public static float Divisao(float numeroPreOperando, float numeroPosOperando) {
        if (numeroPosOperando == 0) {
            throw new ArithmeticException("Divisão por zero não é possivel");
        }
        return numeroPreOperando / numeroPosOperando;
    }

    public static float Subtracao(float numeroPreOperando, float numeroPosOperando) {
        return numeroPreOperando - numeroPosOperando;
    }
    
    public static float Logaritimo(float numeroPreOperando, float numeroPosOperando) {
        return (float) (Math.log(numeroPreOperando) - Math.log(numeroPosOperando));
    }
    
    public static float Radiciacao(float numeroPreOperando, float numeroPosOperando) {
        return (float)Math.pow(numeroPreOperando, 1 / numeroPosOperando);
    }
    
    public static float Exponenciacao(float numeroPreOperando, float numeroPosOperando) {
        return (float)Math.pow(numeroPreOperando, numeroPosOperando);
    }

    public static float ExecutarOperacao(float preDec, String posHexa, String operador) throws Exception {
        float posDec = Helper.HexaToDecimalFloat(posHexa);
        System.out.println(preDec);
        System.out.println(operador);
        System.out.println(posDec);

        switch (operador) {

            case Simbolo.SOMA:
                return Soma(preDec, posDec);

            case Simbolo.SUBTRACAO:
                return Subtracao(preDec, posDec);

            case Simbolo.DIVISAO:
                if (posHexa.trim().equalsIgnoreCase("0.0")) {
                    throw new ArithmeticException("Infinity");
                }
                return Divisao(preDec, posDec);

            case Simbolo.MUTIPLICACAO:
                return Multiplicacao(preDec, posDec);

            default:
                System.out.println("Nao foi indetificado o operador");
                throw new ArithmeticException("Operador invalido!");
        }
    }
}
