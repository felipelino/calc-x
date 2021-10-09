// 
// Decompiled by Procyon v0.5.36
// 

package br.uerj.calc.ui;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import java.awt.event.ActionEvent;
import java.awt.Image;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Point;
import java.awt.Container;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class RelatorioCalc extends JFrame implements ActionListener
{
    JButton btSalva;
    JButton btLimpa;
    JTextArea txtRel;
    private Container cp;
    private String arqNome;
    
    RelatorioCalc(final Point pontoMain) {
        super("Relat\u00f3rio dos C\u00e1lculos");
        this.arqNome = null;
        final Image iconeRelat = Toolkit.getDefaultToolkit().getImage(this.getClass().getClassLoader().getResource("img/bloco.gif"));
        this.setIconImage(iconeRelat);
        this.setLocation(pontoMain.x + 510, pontoMain.y);
        this.setSize(260, 290);
        this.setResizable(false);
        this.setDefaultCloseOperation(0);
        this.cp = this.getContentPane();
        (this.txtRel = new JTextArea()).setEditable(false);
        this.txtRel.setFont(new Font("Courier", 0, 12));
        this.txtRel.setBackground(Color.WHITE);
        final Font font1 = new Font("Arial", 1, 11);
        this.btSalva = new JButton("Salvar");
        this.btLimpa = new JButton("Limpar");
        this.btSalva.setName("Salvar");
        this.btLimpa.setName("Limpar");
        this.btSalva.setFont(font1);
        this.btLimpa.setFont(font1);
        final Dimension dim1 = new Dimension();
        dim1.height = 227;
        dim1.width = 200;
        final JScrollPane scrollPane = new JScrollPane(this.txtRel, 22, 30);
        scrollPane.setPreferredSize(dim1);
        this.btSalva.setToolTipText("Salvar");
        this.btSalva.addActionListener(this);
        this.btLimpa.setToolTipText("Limpar");
        this.btLimpa.addActionListener(this);
        this.cp.add("North", scrollPane);
        final JPanel p1 = new JPanel();
        p1.add(this.btSalva);
        p1.add(this.btLimpa);
        this.cp.add("South", p1);
        this.txtRel.setText(" Calculadora Cient\u00edfica\n       Calc-X 1.0\n ----------------------\n Tipo: Deg");
    }
    
    public void actionPerformed(final ActionEvent evt) {
        if (evt.getSource() == this.btSalva) {
            this.salvaAlt();
        }
        else if (evt.getSource() == this.btLimpa) {
            this.limpa();
        }
    }
    
    public void salvar() {
        final JFileChooser escolha = new JFileChooser();
        if (escolha.showSaveDialog(this) != 1) {
            final File arquivo = escolha.getSelectedFile();
            try {
                if (arquivo.getName().endsWith(".txt") || arquivo.getName().endsWith(".TXT")) {
                    this.arqNome = new StringBuffer().append(arquivo).toString();
                }
                else {
                    this.arqNome = arquivo + ".txt";
                }
                final PrintWriter out = new PrintWriter(new FileWriter(this.arqNome));
                out.print(this.txtRel.getText());
                out.close();
            }
            catch (IOException exc) {
                JOptionPane.showMessageDialog(null, exc, "IOException: \n" + exc, 0);
            }
        }
    }
    
    public void salvaAlt() {
        if (this.arqNome == null) {
            this.salvar();
        }
        else {
            try {
                final PrintWriter out = new PrintWriter(new FileWriter(this.arqNome));
                out.print(this.txtRel.getText());
                out.close();
            }
            catch (IOException exc) {
                JOptionPane.showMessageDialog(null, exc, "IOException: \n" + exc, 0);
            }
        }
    }
    
    public void limpa() {
        this.txtRel.setText(" Calculadora Cient\u00edfica\n       Calc-X 1.0\n ----------------------\n Tipo: Deg");
        this.arqNome = null;
    }
}
