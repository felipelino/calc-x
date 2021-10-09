// 
// Decompiled by Procyon v0.5.36
// 

package br.uerj.calc.ui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class FechaJanela extends WindowAdapter
{
    public void windowClosing(final WindowEvent e) {
        System.exit(0);
    }
    
    public void windowIconified(final WindowEvent e) {
        final CalculadoraMain calc = (CalculadoraMain)e.getSource();
        if (calc.jRelatorio != null) {
            calc.jRelatorio.setState(1);
        }
        if (calc.jAjuda != null) {
            calc.jAjuda.setState(1);
        }
    }
    
    public void windowDeiconified(final WindowEvent e) {
        final CalculadoraMain calc = (CalculadoraMain)e.getSource();
        if (calc.jRelatorio != null) {
            calc.jRelatorio.setState(0);
        }
        if (calc.jAjuda != null) {
            calc.jAjuda.setState(0);
        }
    }
}
