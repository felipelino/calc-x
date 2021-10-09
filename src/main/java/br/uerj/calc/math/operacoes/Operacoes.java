// 
// Decompiled by Procyon v0.5.36
// 

package br.uerj.calc.math.operacoes;

public class Operacoes
{
    public static boolean verifyParent(final String exp) {
        int abre = 0;
        int fecha = 0;
        int i;
        for (i = 0, i = 0; i < exp.length(); ++i) {
            if (exp.charAt(i) == '(') {
                ++abre;
            }
            else if (exp.charAt(i) == ')') {
                ++fecha;
                if (i + 1 < exp.length() && ((exp.charAt(i + 1) <= '9' && exp.charAt(i + 1) >= '0') || exp.charAt(i + 1) == '.')) {
                    fecha = fecha + abre + 1;
                    break;
                }
            }
        }
        return abre == fecha;
    }
    
    public static Double resolveExpressao(final String entrada, final boolean isRad) {
        Double retorno = null;
        String exp = "(" + entrada + ")";
        String aux1 = null;
        String aux2 = null;
        final PilhaInt p1 = new PilhaInt();
        int limInf = 0;
        int limSup = 0;
        boolean ok = false;
        p1.empilha(0);
        do {
            ok = true;
            aux1 = null;
            aux2 = null;
            for (limSup = limInf + 1; exp.charAt(limSup) != ')'; ++limSup) {
                if (exp.charAt(limSup) == '(') {
                    p1.empilha(limSup);
                }
            }
            limInf = p1.desempilha();
            aux1 = exp.substring(0, limInf);
            aux2 = exp.substring(limInf + 1, limSup);
            final Double resultado = calcula(aux2, isRad);
            if (resultado == null) {
                ok = false;
                break;
            }
            final String ret = resultado.toString();
            aux1 = String.valueOf(aux1) + ret;
            aux1 = (exp = String.valueOf(aux1) + exp.substring(limSup + 1, exp.length()));
        } while (p1.isCheia() && ok);
        if (ok) {
            retorno = new Double(Double.parseDouble(exp));
        }
        return retorno;
    }
    
    public static Double calcula(final String temp, final boolean isRad) {
        Double retorno = null;
        final PilhaOperadores pilhaOperador = new PilhaOperadores();
        final ParNumeroPos[] listaNum = new ParNumeroPos[50];
        int i = 0;
        int j = 0;
        int ant = 0;
        int contNum = 0;
        String num = "";
        boolean entrou = false;
        while (i < temp.length()) {
            j = i;
            while ((temp.charAt(i) <= '9' && temp.charAt(i) >= '0') || temp.charAt(i) == '.' || temp.charAt(i) == 'E' || temp.charAt(i) == '-') {
                num = String.valueOf(num) + temp.charAt(i);
                ++i;
                entrou = true;
                if (i >= temp.length()) {
                    break;
                }
            }
            if (entrou) {
                final ParNumeroPos x = new ParNumeroPos(Double.parseDouble(num), j);
                listaNum[contNum] = x;
                ++contNum;
                entrou = false;
                num = "";
            }
            if (i < temp.length() && temp.charAt(i) >= 'A' && temp.charAt(i) <= 'N') {
                pilhaOperador.empilha(new ParOperadorPos(temp.charAt(i), i));
                if (++i >= temp.length()) {
                    break;
                }
                continue;
            }
        }
        pilhaOperador.ordena();
        while (pilhaOperador.isCheia()) {
            final ParOperadorPos op = pilhaOperador.desempilha();
            if (op.operador <= 'H') {
                final int numero = procNumPos(op, listaNum, contNum);
                if (numero <= -1) {
                    ant = -1;
                    break;
                }
                final ParNumeroPos ret = opera(op.operador, listaNum[numero], isRad);
                if (ret == null) {
                    ant = -1;
                    pilhaOperador.esvazia();
                }
                else {
                    listaNum[numero] = null;
                    listaNum[numero] = ret;
                }
            }
            else {
                final int pos = procNumPos(op, listaNum, contNum);
                ant = procNumAnt(op, listaNum, contNum);
                if (ant <= -1 || pos <= -1) {
                    ant = -1;
                    break;
                }
                final ParNumeroPos ret = opera(op.operador, listaNum[ant], listaNum[pos]);
                if (ret == null) {
                    ant = -1;
                    pilhaOperador.esvazia();
                }
                else {
                    listaNum[pos] = (listaNum[ant] = null);
                    listaNum[ant] = ret;
                }
            }
        }
        if (ant > -1) {
            final ParNumeroPos result = listaNum[ant];
            retorno = new Double(result.numero);
        }
        return retorno;
    }
    
    public static int procNumPos(final ParOperadorPos op, final ParNumeroPos[] lista, final int tam) {
        int i = 0;
        int maior = 0;
        int retorno = -1;
        ParNumeroPos aux1 = null;
        aux1 = lista[0];
        if (aux1 != null) {
            maior = aux1.posicao;
            for (i = 1; i < tam; ++i) {
                if (lista[i] != null) {
                    aux1 = lista[i];
                    if (aux1.posicao > maior) {
                        maior = aux1.posicao;
                    }
                }
            }
            for (i = 0; i < tam; ++i) {
                if (lista[i] != null) {
                    aux1 = lista[i];
                    if (aux1.posicao > op.posicao && aux1.posicao <= maior) {
                        retorno = i;
                        maior = aux1.posicao;
                    }
                }
            }
        }
        return retorno;
    }
    
    public static int procNumAnt(final ParOperadorPos op, final ParNumeroPos[] lista, final int tam) {
        int i = 0;
        int menor = 0;
        int retorno = -1;
        ParNumeroPos aux1 = null;
        aux1 = lista[0];
        if (aux1 != null) {
            menor = aux1.posicao;
            for (i = 1; i < tam; ++i) {
                if (lista[i] != null) {
                    aux1 = lista[i];
                    if (aux1.posicao < menor) {
                        menor = aux1.posicao;
                    }
                }
            }
            for (i = 0; i < tam; ++i) {
                if (lista[i] != null) {
                    aux1 = lista[i];
                    if (aux1.posicao < op.posicao && aux1.posicao >= menor) {
                        retorno = i;
                        menor = aux1.posicao;
                    }
                }
            }
        }
        return retorno;
    }
    
    public static ParNumeroPos opera(final char operador, final ParNumeroPos num, final boolean isRad) {
        ParNumeroPos retorno = null;
        double aux = 0.0;
        if (operador <= 'C') {
            if (!isRad) {
                aux = Math.toRadians(num.numero);
            }
            else {
                aux = num.numero;
            }
        }
        switch (operador) {
            case 'A': {
                retorno = new ParNumeroPos(Math.sin(aux), num.posicao);
                break;
            }
            case 'B': {
                retorno = new ParNumeroPos(Math.cos(aux), num.posicao);
                break;
            }
            case 'C': {
                if (aux == 1.5707963267948966 || aux != -1.5707963267948966) {}
                retorno = new ParNumeroPos(Math.tan(aux), num.posicao);
                break;
            }
            case 'D': {
                if (num.numero >= -1.0 && num.numero <= 1.0) {
                    double temp = Math.asin(num.numero);
                    if (!isRad) {
                        temp = Math.toDegrees(temp);
                    }
                    retorno = new ParNumeroPos(temp, num.posicao);
                    break;
                }
                break;
            }
            case 'F': {
                if (num.numero >= -1.0 && num.numero <= 1.0) {
                    double temp = Math.acos(num.numero);
                    if (!isRad) {
                        temp = Math.toDegrees(temp);
                    }
                    retorno = new ParNumeroPos(temp, num.posicao);
                    break;
                }
                break;
            }
            case 'G': {
                double temp = Math.atan(num.numero);
                if (!isRad) {
                    temp = Math.toDegrees(temp);
                }
                retorno = new ParNumeroPos(temp, num.posicao);
                break;
            }
            case 'H': {
                if (num.numero > 0.0) {
                    retorno = new ParNumeroPos(Math.log(num.numero), num.posicao);
                    break;
                }
                break;
            }
        }
        return retorno;
    }
    
    public static ParNumeroPos opera(final char operador, final ParNumeroPos ant, final ParNumeroPos pos) {
        ParNumeroPos retorno = null;
        switch (operador) {
            case 'J': {
                retorno = new ParNumeroPos(Math.pow(ant.numero, pos.numero), ant.posicao);
                break;
            }
            case 'K': {
                if (pos.numero != 0.0) {
                    retorno = new ParNumeroPos(ant.numero / pos.numero, ant.posicao);
                    break;
                }
                break;
            }
            case 'L': {
                retorno = new ParNumeroPos(ant.numero * pos.numero, ant.posicao);
                break;
            }
            case 'N': {
                retorno = new ParNumeroPos(ant.numero + pos.numero, ant.posicao);
                break;
            }
            case 'M': {
                retorno = new ParNumeroPos(ant.numero - pos.numero, ant.posicao);
                break;
            }
        }
        return retorno;
    }
    
    public static Double opera(final char operador, final double num, final boolean isRad) {
        Double retorno = null;
        double aux = 0.0;
        if (operador <= 'C') {
            if (!isRad) {
                aux = Math.toRadians(num);
            }
            else {
                aux = num;
            }
        }
        switch (operador) {
            case 'A': {
                retorno = new Double(Math.sin(aux));
                break;
            }
            case 'B': {
                retorno = new Double(Math.cos(aux));
                break;
            }
            case 'C': {
                if (aux == 1.5707963267948966 || aux != -1.5707963267948966) {}
                retorno = new Double(Math.tan(aux));
                break;
            }
            case 'D': {
                if (num >= -1.0 && num <= 1.0) {
                    double temp = Math.asin(num);
                    if (!isRad) {
                        temp = Math.toDegrees(temp);
                    }
                    retorno = new Double(temp);
                    break;
                }
                break;
            }
            case 'F': {
                if (num >= -1.0 && num <= 1.0) {
                    double temp = Math.acos(num);
                    if (!isRad) {
                        temp = Math.toDegrees(temp);
                    }
                    retorno = new Double(temp);
                    break;
                }
                break;
            }
            case 'G': {
                double temp = Math.atan(num);
                if (!isRad) {
                    temp = Math.toDegrees(temp);
                }
                retorno = new Double(temp);
                break;
            }
            case 'H': {
                if (num > 0.0) {
                    retorno = new Double(Math.log(num));
                    break;
                }
                break;
            }
        }
        return retorno;
    }
    
    public static Double opera(final char operador, final double ant, final double pos) {
        Double retorno = null;
        switch (operador) {
            case 'J': {
                retorno = new Double(Math.pow(ant, pos));
                break;
            }
            case 'K': {
                if (pos != 0.0) {
                    retorno = new Double(ant / pos);
                    break;
                }
                break;
            }
            case 'L': {
                retorno = new Double(ant * pos);
                break;
            }
            case 'N': {
                retorno = new Double(ant + pos);
                break;
            }
            case 'M': {
                retorno = new Double(ant - pos);
                break;
            }
        }
        return retorno;
    }
}
