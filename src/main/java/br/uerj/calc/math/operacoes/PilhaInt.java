// 
// Decompiled by Procyon v0.5.36
// 

package br.uerj.calc.math.operacoes;

public class PilhaInt
{
    private Integer[] pilha;
    private int topo;
    
    public PilhaInt() {
        this.pilha = new Integer[100];
        this.topo = 0;
        this.topo = 0;
    }
    
    public void empilha(final int inteiro) {
        ++this.topo;
        this.pilha[this.topo] = new Integer(inteiro);
    }
    
    public int desempilha() {
        int retorna = 0;
        if (this.topo > 0) {
            retorna = this.pilha[this.topo];
            this.pilha[this.topo] = null;
            --this.topo;
        }
        return retorna;
    }
    
    public void esvazia() {
        while (this.topo >= 0) {
            this.pilha[this.topo] = null;
            --this.topo;
        }
    }
    
    public boolean isCheia() {
        return this.topo > 0;
    }
}
