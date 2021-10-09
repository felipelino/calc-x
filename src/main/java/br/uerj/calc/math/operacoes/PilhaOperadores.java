// 
// Decompiled by Procyon v0.5.36
// 

package br.uerj.calc.math.operacoes;

public class PilhaOperadores
{
    ParOperadorPos[] pilha;
    private int topo;
    
    PilhaOperadores() {
        this.topo = 0;
        this.pilha = new ParOperadorPos[50];
        this.topo = 0;
    }
    
    public void empilha(final ParOperadorPos objeto) {
        ++this.topo;
        this.pilha[this.topo] = objeto;
    }
    
    public ParOperadorPos desempilha() {
        ParOperadorPos retorna = null;
        if (this.topo > 0) {
            retorna = this.pilha[this.topo];
            --this.topo;
        }
        return retorna;
    }
    
    public void esvazia() {
        this.topo = 0;
    }
    
    public boolean isCheia() {
        return this.topo > 0;
    }
    
    public void ordena() {
        int i = 0;
        int j = 0;
        for (i = 2; i <= this.topo; ++i) {
            final ParOperadorPos temp = this.pilha[i];
            this.pilha[0] = temp;
            for (j = i; this.pilha[j - 1].operador < temp.operador; --j) {
                this.pilha[j] = this.pilha[j - 1];
            }
            this.pilha[j] = temp;
        }
    }
}
