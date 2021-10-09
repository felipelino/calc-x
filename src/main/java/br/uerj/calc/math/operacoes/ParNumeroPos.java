// 
// Decompiled by Procyon v0.5.36
// 

package br.uerj.calc.math.operacoes;

public class ParNumeroPos
{
    double numero;
    int posicao;
    
    ParNumeroPos(final double op, final int pos) {
        this.numero = op;
        this.posicao = pos;
    }
    
    public String toString() {
        return Double.toString(this.numero);
    }
}
