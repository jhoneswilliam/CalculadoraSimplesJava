package model;

import java.nio.channels.GatheringByteChannel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControleCalculadora {

    private static ArrayList<Operador> Operacao;
    private static float Resultado = 0;

    public static void montaExpressao(String key) throws Exception {
        IniciaOperacao();//Se operador não foi iniciado é porque é a primeira operação

        if (Helper.EHexa(key)) {
            AddNumero(key);
        } else if (key == Simbolo.PONTO) {
            AddPonto(key);
        } else if (Helper.EOperador(key)) {
            AddOperador(key);
        } else {
            System.out.println("Nao atende nenhuma!");
        }

    }

    public static void IniciaOperacao() {
        if (Operacao == null) {
            Operacao = new ArrayList<Operador>();
            Operador op = new Operador();
            op.Operador = Simbolo.SOMA;
            Operacao.add(op);
        }
    }

    private static Operador UltimoOperador() {
        if (Operacao.size() > 0) {
            return Operacao.get(Operacao.size() - 1);
        }
        return null;
    }

    private static void AddOperador(String key) throws Exception {
        System.out.println("Adicionando Operador!");
        if (Resultado == 0) {
            //se o operador foi inserido duas vezes
            if (UltimoOperador().Numero.length() == 0) {
                System.out.println("Substituindo operador!");
                UltimoOperador().Operador = key;
            } else {
                System.out.println("nova operação!");
                Operador novaOP = new Operador();
                novaOP.Operador = key;
                Operacao.add(novaOP);
            }
        } else {
            float valor = Resultado;
            LimpaTudo();
            IniciaOperacao();            
            UltimoOperador().Numero = Helper.DecimalFloatToHexa(valor);            
            Operador op = new Operador();
            op.Operador = key;
            Operacao.add(op);            
        }
    }

    private static void AddNumero(String key) throws Exception {
        System.out.println("Adicionando numero!");
        UltimoOperador().Numero += key;
        testa();
    }

    private static void AddPonto(String key) {
        System.out.println("é Ponto!");
        if (!UltimoOperador().Numero.contains(key)) {
            if (UltimoOperador().Numero.length() == 0) {
                UltimoOperador().Numero += "0";
            }
            UltimoOperador().Numero += key;
            System.out.println("Adicionando Ponto!");
        } else {
            System.out.println("Ponto nao adicionado!");
        }
    }

    public static String ObterResultado() throws Exception {
        return Helper.DecimalFloatToHexa(Caucular());
    }

    private static void testa() throws Exception {
        System.out.println(Helper.HexaToDecimalFloat(UltimoOperador().Numero));
    }

    public static String getExpressao() {
        String expressao = "";
        int i = 0;
        for (Operador operador : Operacao) {
            if (i >= 1) {
            	expressao += " ";
                expressao += operador.Operador;
                expressao += " ";
            }
            expressao += operador.Numero;
            i++;
        }
        
        expressao.replace("L", "Log");
        expressao.replace("R", "Raiz");
        return expressao;
    }

    private static float Caucular() throws Exception {
        Resultado = 0;
        for (Operador operador : Operacao) {
            Resultado = Operacoes.ExecutarOperacao(Resultado, operador.Numero, operador.Operador);
        }
        System.out.println("Resultado: " + Resultado);
        return Resultado;
    }

    public static void ApagaUltimoCaractereOperacao() {
        //Apaga o utimo numero
        if (UltimoOperador() != null) {
            if (UltimoOperador().Numero != null && UltimoOperador().Numero.length() > 0) {
                UltimoOperador().Numero = UltimoOperador().Numero.substring(0, UltimoOperador().Numero.length() - 1);
            } else if (UltimoOperador().Operador != null && UltimoOperador().Operador.length() > 0) {
                UltimoOperador().Operador = UltimoOperador().Operador.substring(0, UltimoOperador().Operador.length() - 1);
            }

            if (UltimoOperador().Operador != null && UltimoOperador().Operador.length() == 0) {
                Operacao.remove(UltimoOperador());
            }
        }

        if (UltimoOperador() == null) {
            LimpaTudo();
        }
    }

    public static void LimpaTudo() {
        Operacao = null;
        Resultado = 0;
        IniciaOperacao();
    }
}
