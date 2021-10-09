// 
// Decompiled by Procyon v0.5.36
// 

package br.uerj.calc.math;

import br.uerj.calc.math.operacoes.Operacoes;

public class Funcao
{
    String expressao;
    boolean isRad;
    
    public Funcao(final String exp, final boolean rad) {
        this.expressao = null;
        this.isRad = false;
        this.expressao = exp;
        this.isRad = rad;
    }
    
    public boolean verFuncao() {
        boolean retorno = true;
        int i;
        for (i = 0, i = 0; i < this.expressao.length() - 1; ++i) {
            if (this.expressao.charAt(i) == 'x' && (this.expressao.charAt(i + 1) == 'x' || (this.expressao.charAt(i + 1) <= '9' && this.expressao.charAt(i + 1) >= '0'))) {
                retorno = false;
                break;
            }
        }
        if (retorno) {
            retorno = Operacoes.verifyParent(this.expressao);
        }
        return retorno;
    }
    
    public Double fx(final double x) {
        String exp = "";
        Double retorno = null;
        for (int i = 0; i < this.expressao.length(); ++i) {
            if (this.expressao.charAt(i) == 'x') {
                exp = String.valueOf(exp) + Double.toString(x);
            }
            else {
                exp = String.valueOf(exp) + this.expressao.charAt(i);
            }
        }
        retorno = Operacoes.resolveExpressao(exp, this.isRad);
        return retorno;
    }
    
    public Double derivada(final double x0) {
        Double retorno = null;
        try {
            final double temp = x0 + 1.0E-13;
            final double aux = (this.fx(x0 + 1.0E-13) - this.fx(x0)) / 1.0E-13;
            retorno = new Double(aux);
        }
        finally {}
        return retorno;
    }
    
    public Double integral(double inf, double sup) {
        Double retorno = null;
        double intervalo = 0.0;
        double delta = 0.0;
        double acumulador = 0.0;
        double ret = 0.0;
        double aux1 = 0.0;
        double aux2 = 0.0;
        final double aux3 = 0.0;
        boolean inverte = false;
        if (inf > sup) {
            final double temp = sup;
            sup = inf;
            inf = temp;
            inverte = true;
        }
        intervalo = (double)((Math.round(sup) - Math.round(inf)) * 20L);
        if (intervalo < 0.0) {
            intervalo *= -1.0;
        }
        if (intervalo != 0.0) {
            intervalo *= 16.0;
        }
        else {
            intervalo = 20.0;
        }
        delta = (sup - inf) / intervalo;
        try {
            ret = 0.0;
            for (acumulador = inf, acumulador += 2.0 * delta; acumulador < sup; acumulador += 2.0 * delta) {
                aux1 += 2.0 * this.fx(acumulador);
            }
            for (acumulador = inf + delta; acumulador < sup; acumulador += 2.0 * delta) {
                aux2 += 4.0 * this.fx(acumulador);
            }
            ret = this.fx(inf) + this.fx(sup) + aux1 + aux2;
            ret *= delta / 3.0;
            if (inverte) {
                ret *= -1.0;
            }
            retorno = new Double(ret);
        }
        finally {}
        return retorno;
    }
    
    public Double raiz(double inf, double sup) {
        Double retorno = null;
        if (sup < inf) {
            final double temp = sup;
            sup = inf;
            inf = temp;
        }
        final double inc = (sup - inf) / 40.0;
        double limInf = inf;
        double limSup = inf + inc;
        try {
            while (limSup + inc < sup && this.fx(limInf) * this.fx(limSup) - 1.0E-7 > 0.0) {
                limInf = limSup;
                limSup += inc;
            }
            if (this.fx(limInf) == 0.0) {
                retorno = new Double(limInf);
            }
            else if (this.fx(limSup) == 0.0) {
                retorno = new Double(limSup);
            }
            if (retorno == null && limSup < sup) {
                double fx1;
                double fx2;
                double x;
                do {
                    x = (limInf + limSup) / 2.0;
                    fx1 = this.fx(x);
                    fx2 = this.fx(limInf);
                    if (fx1 * fx2 < 0.0) {
                        limSup = x;
                    }
                    else {
                        limInf = x;
                    }
                } while (Math.abs(limInf - limSup) > 1.0E-14 && Math.abs(fx1 - fx2) > 1.0E-14);
                if (Math.abs(this.fx(x)) < 1.0E-14) {
                    x = 0.0;
                }
                retorno = new Double(x);
            }
        }
        finally {}
        return retorno;
    }
    
    public String toString() {
        return this.expressao;
    }
}
