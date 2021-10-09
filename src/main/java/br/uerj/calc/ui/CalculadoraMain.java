// 
// Decompiled by Procyon v0.5.36
// 

package br.uerj.calc.ui;

import java.awt.event.WindowEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.*;

import br.uerj.calc.math.operacoes.Operacoes;
import java.awt.Image;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Container;

import br.uerj.calc.math.Funcao;
import br.uerj.calc.math.operacoes.PilhaInt;
import java.awt.event.WindowListener;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;

public class CalculadoraMain extends JFrame implements ActionListener, KeyListener, WindowListener
{
    Double dVar1;
    Double dTela;
    double var1;
    double varTela;
    double memo;
    String expressao;
    String funcao;
    String funcao2;
    String display;
    String status;
    char operador;
    boolean bolPonto;
    boolean bolNum;
    boolean bolExp;
    boolean bolFunc;
    int intOpera;
    int intModo;
    int intFunc;
    PilhaInt tamStr;
    Funcao funcaoFx;
    double funcX1;
    double funcX2;
    relatorioCalc jRelatorio;
    help jAjuda;
    String op1;
    String op2;
    private JMenuBar barraMenu;
    private JMenu menu1Ajuda;
    private JMenuItem m1Ajuda;
    private JMenuItem m1Sobre;
    private JLabel lbStatus;
    private JLabel lbDisplay;
    private JLabel lbTitulo;
    private JTextField txtStatus;
    private JTextField txtDisplay;
    JRadioButton rb1Grau;
    JRadioButton rb1Radiano;
    ButtonGroup grupoRB1;
    private JButton num1;
    private JButton num2;
    private JButton num3;
    private JButton num4;
    private JButton num5;
    private JButton num6;
    private JButton num7;
    private JButton num8;
    private JButton num9;
    private JButton num0;
    private JButton g1trocaSin;
    private JButton g1Ponto;
    private JButton g1BackSpace;
    private JButton g1Clear;
    private JButton g1ClearAll;
    public JButton g1Relatorio;
    private JButton g1RM;
    private JButton g1Mmais;
    private JButton g1Entra;
    private JButton g1Igual;
    private JButton opDiv;
    private JButton opMul;
    private JButton opSom;
    private JButton opSub;
    private JButton opSen;
    private JButton opCos;
    private JButton opTan;
    private JButton opLn;
    private JButton opXeY;
    private JButton opArcSen;
    private JButton opArcCos;
    private JButton opArcTan;
    private JButton opRaiz;
    private JButton opExp;
    private JButton cstPi;
    private JButton cstE;
    private JButton cstAbre;
    private JButton cstFecha;
    private JButton g2Funcao;
    private JButton g2Exp;
    private JButton funcFx;
    private JButton funcX;
    private JButton funcRaiz;
    private JButton funcInt;
    private JButton funcDer;
    private Container cp;
    
    CalculadoraMain() {
        super("Calc-X 1.0 - Felipe Lino IME/UERJ");
        this.expressao = null;
        this.funcao = null;
        this.funcao2 = null;
        this.display = "";
        this.status = "";
        this.bolPonto = false;
        this.bolNum = false;
        this.bolExp = false;
        this.bolFunc = true;
        this.intOpera = 0;
        this.intModo = 0;
        this.intFunc = 0;
        this.tamStr = new PilhaInt();
        this.funcaoFx = null;
        this.funcX1 = 0.0;
        this.funcX2 = 0.0;
        this.jRelatorio = null;
        this.jAjuda = null;
        this.op1 = "";
        this.op2 = "";
        final Image iconeCalc = Toolkit.getDefaultToolkit().getImage(this.getClass().getClassLoader().getResource("img/calc.gif"));
        this.setIconImage(iconeCalc);
        this.setSize(510, 290);
        this.setLocation(45, 110);
        this.setResizable(false);
        (this.cp = this.getContentPane()).addKeyListener(this);
        this.barraMenu = new JMenuBar();
        this.menu1Ajuda = new JMenu("Ajuda");
        (this.m1Ajuda = new JMenuItem("Conte\u00fado de Ajuda")).addActionListener(this);
        this.m1Ajuda.addKeyListener(this);
        (this.m1Sobre = new JMenuItem("Sobre")).addActionListener(this);
        this.m1Sobre.addKeyListener(this);
        this.menu1Ajuda.add(this.m1Ajuda);
        this.menu1Ajuda.add(this.m1Sobre);
        this.menu1Ajuda.addKeyListener(this);
        this.barraMenu.add(this.menu1Ajuda);
        this.setJMenuBar(this.barraMenu);
        this.barraMenu.addKeyListener(this);
        final Font font1 = new Font("Arial", 1, 11);
        final Font font2 = new Font("Courier", 1, 14);
        final Font font3 = new Font("Courier", 1, 11);
        final Font font4 = new Font("Arial", 1, 13);
        this.lbStatus = new JLabel("Express\u00e3o");
        this.lbDisplay = new JLabel("   Normal");
        this.lbTitulo = new JLabel("Calc-X 1.0");
        this.lbStatus.setFont(font2);
        this.lbDisplay.setFont(font2);
        this.lbStatus.addKeyListener(this);
        this.lbDisplay.addKeyListener(this);
        (this.txtStatus = new JTextField("")).addKeyListener(this);
        (this.txtDisplay = new JTextField("")).addKeyListener(this);
        this.txtStatus.setColumns(35);
        this.txtDisplay.setColumns(35);
        this.txtStatus.setEditable(false);
        this.txtStatus.setBackground(Color.WHITE);
        this.txtStatus.setText("Calculadora v1.0");
        this.txtDisplay.setEditable(false);
        this.txtDisplay.setBackground(Color.WHITE);
        (this.rb1Grau = new JRadioButton("Deg")).setFont(font3);
        this.rb1Grau.addActionListener(this);
        this.rb1Grau.addKeyListener(this);
        (this.rb1Radiano = new JRadioButton("Rad")).setFont(font3);
        this.rb1Radiano.addActionListener(this);
        this.rb1Radiano.addKeyListener(this);
        (this.grupoRB1 = new ButtonGroup()).add(this.rb1Grau);
        this.grupoRB1.add(this.rb1Radiano);
        (this.g2Funcao = new JButton("Fun\u00e7\u00e3o")).setFont(font1);
        this.g2Funcao.setBorder(BorderFactory.createRaisedBevelBorder());
        this.g2Funcao.setForeground(Color.WHITE);
        this.g2Funcao.setBackground(Color.GRAY);
        this.g2Funcao.addActionListener(this);
        this.g2Funcao.addKeyListener(this);
        (this.g2Exp = new JButton("Expres")).setBorder(BorderFactory.createRaisedBevelBorder());
        this.g2Exp.setFont(font1);
        this.g2Exp.setForeground(Color.WHITE);
        this.g2Exp.setBackground(Color.GRAY);
        this.g2Exp.addActionListener(this);
        this.g2Exp.addKeyListener(this);
        (this.num1 = new JButton("1")).addActionListener(this);
        this.num1.setFont(font1);
        this.num1.setForeground(Color.BLUE);
        this.num1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.num1.addKeyListener(this);
        (this.num2 = new JButton("2")).addActionListener(this);
        this.num2.setFont(font1);
        this.num2.setForeground(Color.BLUE);
        this.num2.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.num2.addKeyListener(this);
        (this.num3 = new JButton("3")).addActionListener(this);
        this.num3.setFont(font1);
        this.num3.setForeground(Color.BLUE);
        this.num3.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.num3.addKeyListener(this);
        (this.num4 = new JButton("4")).addActionListener(this);
        this.num4.setFont(font1);
        this.num4.setForeground(Color.BLUE);
        this.num4.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.num4.addKeyListener(this);
        (this.num5 = new JButton("5")).addActionListener(this);
        this.num5.setFont(font1);
        this.num5.setForeground(Color.BLUE);
        this.num5.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.num5.addKeyListener(this);
        (this.num6 = new JButton("6")).addActionListener(this);
        this.num6.setFont(font1);
        this.num6.setForeground(Color.BLUE);
        this.num6.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.num6.addKeyListener(this);
        (this.num7 = new JButton("7")).addActionListener(this);
        this.num7.setFont(font1);
        this.num7.setForeground(Color.BLUE);
        this.num7.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.num7.addKeyListener(this);
        (this.num8 = new JButton("8")).addActionListener(this);
        this.num8.setFont(font1);
        this.num8.setForeground(Color.BLUE);
        this.num8.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.num8.addKeyListener(this);
        (this.num9 = new JButton("9")).addActionListener(this);
        this.num9.setFont(font1);
        this.num9.setForeground(Color.BLUE);
        this.num9.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.num9.addKeyListener(this);
        (this.num0 = new JButton("0")).addActionListener(this);
        this.num0.setFont(font1);
        this.num0.setForeground(Color.BLUE);
        this.num0.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.num0.addKeyListener(this);
        (this.g1trocaSin = new JButton("+/-")).setForeground(Color.BLUE);
        this.g1trocaSin.addActionListener(this);
        this.g1trocaSin.setFont(font4);
        this.g1trocaSin.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.g1trocaSin.addKeyListener(this);
        (this.g1Ponto = new JButton(".")).setForeground(Color.BLUE);
        this.g1Ponto.addActionListener(this);
        this.g1Ponto.setFont(font4);
        this.g1Ponto.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        this.g1Ponto.addKeyListener(this);
        (this.g1BackSpace = new JButton("<<")).setFont(font4);
        this.g1BackSpace.setBackground(Color.BLUE);
        this.g1BackSpace.setForeground(Color.WHITE);
        this.g1BackSpace.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        this.g1BackSpace.addActionListener(this);
        this.g1BackSpace.addKeyListener(this);
        (this.g1Clear = new JButton("CE")).setFont(font1);
        this.g1Clear.setBackground(Color.BLUE);
        this.g1Clear.setForeground(Color.WHITE);
        this.g1Clear.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        this.g1Clear.addActionListener(this);
        this.g1Clear.addKeyListener(this);
        (this.g1ClearAll = new JButton("AC")).setFont(font1);
        this.g1ClearAll.setBackground(Color.RED);
        this.g1ClearAll.setForeground(Color.WHITE);
        this.g1ClearAll.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        this.g1ClearAll.addActionListener(this);
        this.g1ClearAll.addKeyListener(this);
        (this.g1Relatorio = new JButton("REL")).setForeground(Color.WHITE);
        this.g1Relatorio.setBackground(Color.GRAY);
        this.g1Relatorio.setBorder(BorderFactory.createRaisedBevelBorder());
        this.g1Relatorio.addActionListener(this);
        this.g1Relatorio.setFont(font1);
        this.g1Relatorio.addKeyListener(this);
        (this.g1RM = new JButton("RM")).setBackground(Color.BLUE);
        this.g1RM.setForeground(Color.WHITE);
        this.g1RM.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        this.g1RM.addActionListener(this);
        this.g1RM.setFont(font1);
        this.g1RM.addKeyListener(this);
        (this.g1Mmais = new JButton("M+")).setBackground(Color.BLUE);
        this.g1Mmais.setForeground(Color.WHITE);
        this.g1Mmais.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        this.g1Mmais.addActionListener(this);
        this.g1Mmais.setFont(font1);
        this.g1Mmais.addKeyListener(this);
        (this.g1Entra = new JButton("ENT")).setBackground(Color.BLUE);
        this.g1Entra.setForeground(Color.WHITE);
        this.g1Entra.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        this.g1Entra.addActionListener(this);
        this.g1Entra.setFont(font1);
        this.g1Entra.addKeyListener(this);
        (this.g1Igual = new JButton("=")).addActionListener(this);
        this.g1Igual.setFont(font4);
        this.g1Igual.setForeground(Color.RED);
        this.g1Igual.setBorder(BorderFactory.createLineBorder(Color.RED));
        this.g1Igual.addKeyListener(this);
        (this.opDiv = new JButton("/")).addActionListener(this);
        this.opDiv.setFont(font4);
        this.opDiv.setForeground(Color.RED);
        this.opDiv.addKeyListener(this);
        (this.opMul = new JButton("*")).addActionListener(this);
        this.opMul.setFont(font4);
        this.opMul.setForeground(Color.RED);
        this.opMul.addKeyListener(this);
        (this.opSom = new JButton("+")).addActionListener(this);
        this.opSom.setFont(font1);
        this.opSom.setForeground(Color.RED);
        this.opSom.addKeyListener(this);
        (this.opSub = new JButton("-")).addActionListener(this);
        this.opSub.setFont(font4);
        this.opSub.setForeground(Color.RED);
        this.opSub.addKeyListener(this);
        (this.opSen = new JButton("sen")).setFont(font1);
        this.opSen.addActionListener(this);
        this.opSen.setForeground(Color.RED);
        this.opSen.addKeyListener(this);
        (this.opCos = new JButton("cos")).addActionListener(this);
        this.opCos.setFont(font1);
        this.opCos.setForeground(Color.RED);
        this.opCos.addKeyListener(this);
        (this.opTan = new JButton("tan")).addActionListener(this);
        this.opTan.setFont(font1);
        this.opTan.setForeground(Color.RED);
        this.opTan.addKeyListener(this);
        (this.opLn = new JButton("LN")).addActionListener(this);
        this.opLn.setFont(font1);
        this.opLn.setForeground(Color.RED);
        this.opLn.addKeyListener(this);
        (this.opXeY = new JButton("x^y")).addActionListener(this);
        this.opXeY.setFont(font1);
        this.opXeY.setForeground(Color.RED);
        this.opXeY.addKeyListener(this);
        (this.opArcSen = new JButton("ArcSen")).setFont(font1);
        this.opArcSen.addActionListener(this);
        this.opArcSen.setForeground(Color.RED);
        this.opArcSen.addKeyListener(this);
        (this.opArcCos = new JButton("ArcCos")).addActionListener(this);
        this.opArcCos.setFont(font1);
        this.opArcCos.setForeground(Color.RED);
        this.opArcCos.addKeyListener(this);
        (this.opArcTan = new JButton("ArcTan")).addActionListener(this);
        this.opArcTan.setFont(font1);
        this.opArcTan.setForeground(Color.RED);
        this.opArcTan.addKeyListener(this);
        (this.opRaiz = new JButton("x^1/2")).addActionListener(this);
        this.opRaiz.setFont(font1);
        this.opRaiz.setForeground(Color.RED);
        this.opRaiz.addKeyListener(this);
        (this.opExp = new JButton("EXP")).addActionListener(this);
        this.opExp.setFont(font1);
        this.opExp.setForeground(Color.RED);
        this.opExp.addKeyListener(this);
        (this.cstPi = new JButton("PI")).addActionListener(this);
        this.cstPi.setFont(font1);
        this.cstPi.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.cstPi.addKeyListener(this);
        (this.cstE = new JButton("e")).addActionListener(this);
        this.cstE.setFont(font1);
        this.cstE.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.cstE.addKeyListener(this);
        (this.cstAbre = new JButton("(")).addActionListener(this);
        this.cstAbre.setFont(font1);
        this.cstAbre.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.cstAbre.addKeyListener(this);
        (this.cstFecha = new JButton(")")).addActionListener(this);
        this.cstFecha.setFont(font1);
        this.cstFecha.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.cstFecha.addKeyListener(this);
        (this.funcFx = new JButton("F(x)")).setFont(font1);
        this.funcFx.addActionListener(this);
        this.funcFx.setForeground(Color.BLUE);
        this.funcFx.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.BLUE));
        this.funcFx.addKeyListener(this);
        (this.funcX = new JButton("x")).setFont(font1);
        this.funcX.addActionListener(this);
        this.funcX.setForeground(Color.BLUE);
        this.funcX.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.BLUE));
        this.funcX.addKeyListener(this);
        (this.funcRaiz = new JButton("Ra\u00edz")).addActionListener(this);
        this.funcRaiz.setFont(font1);
        this.funcRaiz.setForeground(Color.BLUE);
        this.funcRaiz.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.BLUE));
        this.funcRaiz.addKeyListener(this);
        (this.funcInt = new JButton("Integ")).addActionListener(this);
        this.funcInt.setFont(font1);
        this.funcInt.setForeground(Color.BLUE);
        this.funcInt.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.BLUE));
        this.funcInt.addKeyListener(this);
        (this.funcDer = new JButton("Deriv")).addActionListener(this);
        this.funcDer.setFont(font1);
        this.funcDer.setForeground(Color.BLUE);
        this.funcDer.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.BLUE));
        this.funcDer.addKeyListener(this);
        final JPanel p1 = new JPanel();
        final JPanel p2 = new JPanel();
        final JPanel p3 = new JPanel();
        p1.setLayout(new FlowLayout());
        p2.setLayout(new FlowLayout());
        final GridLayout gl1 = new GridLayout(2, 1, 1, 1);
        p3.setLayout(gl1);
        p1.add(this.lbStatus);
        p1.add(this.txtStatus);
        p2.add(this.lbDisplay);
        p2.add(this.txtDisplay);
        p3.add(p1);
        p3.add(p2);
        this.cp.add("North", p3);
        final JPanel p4 = new JPanel();
        final GridLayout gl2 = new GridLayout(1, 3, 2, 2);
        p4.setLayout(new FlowLayout());
        final GridLayout gl3 = new GridLayout(6, 2, 2, 2);
        final JPanel p5 = new JPanel();
        p5.setLayout(gl3);
        p5.add(this.rb1Grau);
        p5.add(this.rb1Radiano);
        p5.add(this.funcX);
        p5.add(this.funcFx);
        p5.add(this.cstE);
        p5.add(this.funcRaiz);
        p5.add(this.cstPi);
        p5.add(this.funcDer);
        p5.add(this.cstAbre);
        p5.add(this.cstFecha);
        p5.add(this.lbTitulo);
        p5.add(this.funcInt);
        final JPanel p6 = new JPanel();
        final GridLayout gl4 = new GridLayout(6, 2, 2, 2);
        p6.setLayout(gl4);
        p6.add(this.g2Exp);
        p6.add(this.g2Funcao);
        p6.add(this.opArcSen);
        p6.add(this.opSen);
        p6.add(this.opArcCos);
        p6.add(this.opCos);
        p6.add(this.opArcTan);
        p6.add(this.opTan);
        p6.add(this.opRaiz);
        p6.add(this.opLn);
        p6.add(this.opExp);
        p6.add(this.opXeY);
        final JPanel p7 = new JPanel();
        final GridLayout gl5 = new GridLayout(6, 4, 2, 2);
        p7.setLayout(gl5);
        p7.add(this.g1BackSpace);
        p7.add(this.g1Clear);
        p7.add(this.g1ClearAll);
        p7.add(this.opDiv);
        p7.add(this.num7);
        p7.add(this.num8);
        p7.add(this.num9);
        p7.add(this.opMul);
        p7.add(this.num4);
        p7.add(this.num5);
        p7.add(this.num6);
        p7.add(this.opSub);
        p7.add(this.num1);
        p7.add(this.num2);
        p7.add(this.num3);
        p7.add(this.opSom);
        p7.add(this.num0);
        p7.add(this.g1trocaSin);
        p7.add(this.g1Ponto);
        p7.add(this.g1Entra);
        p7.add(this.g1RM);
        p7.add(this.g1Mmais);
        p7.add(this.g1Relatorio);
        p7.add(this.g1Igual);
        p4.add(p5);
        p4.add(p6);
        p4.add(p7);
        this.cp.add("Center", p4);
        this.clearAll();
    }
    
    private void numeros(final JButton btNumero) {
        if (!this.display.equalsIgnoreCase("0")) {
            if (this.bolExp && this.display.endsWith("E0")) {
                this.display = this.display.substring(0, this.display.length() - 1);
            }
            this.display = String.valueOf(this.display) + btNumero.getText();
            this.expressao = String.valueOf(this.expressao) + btNumero.getText();
            this.funcao = String.valueOf(this.funcao) + btNumero.getText();
        }
        else {
            this.display = btNumero.getText();
            this.expressao = this.display;
            this.funcao = this.expressao;
        }
        this.tamStr.empilha(1);
        this.txtDisplay.setText(this.display);
    }
    
    private void parentesis(final JButton btPar) {
        if (this.intModo == 1) {
            this.tamStr.empilha(1);
            if (!this.display.equals("0")) {
                this.display = String.valueOf(this.display) + btPar.getText();
                this.expressao = String.valueOf(this.expressao) + btPar.getText();
                this.txtDisplay.setText(this.display);
            }
            else {
                this.display = btPar.getText();
                this.expressao = btPar.getText();
                this.txtDisplay.setText(this.display);
            }
        }
        else if (this.intModo == 2) {
            this.tamStr.empilha(1);
            if (!this.display.equals("0")) {
                this.display = String.valueOf(this.display) + btPar.getText();
                this.funcao = String.valueOf(this.funcao) + btPar.getText();
                this.txtDisplay.setText(this.display);
            }
            else {
                this.display = btPar.getText();
                this.funcao = btPar.getText();
                this.txtDisplay.setText(this.display);
            }
        }
    }
    
    private void constantePi() {
        if (this.intModo == 0) {
            this.tamStr.empilha(Double.toString(3.141592653589793).length());
            this.display = Double.toString(3.141592653589793);
            this.txtDisplay.setText(this.display);
            this.display = "0";
        }
        else if (this.intModo == 1) {
            this.tamStr.empilha(Double.toString(3.141592653589793).length());
            this.bolPonto = true;
            if (!this.display.equals("0")) {
                this.expressao = String.valueOf(this.expressao) + 3.141592653589793;
                this.display = String.valueOf(this.display) + 3.141592653589793;
            }
            else {
                this.expressao = Double.toString(3.141592653589793);
                this.display = this.expressao;
            }
            this.txtDisplay.setText(this.display);
        }
        else if (this.intModo == 2) {
            this.tamStr.empilha(Double.toString(3.141592653589793).length());
            this.bolPonto = true;
            if (!this.display.equals("0")) {
                this.funcao = String.valueOf(this.funcao) + 3.141592653589793;
                this.display = String.valueOf(this.display) + 3.141592653589793;
            }
            else {
                this.funcao = Double.toString(3.141592653589793);
                this.display = this.funcao;
            }
            this.txtDisplay.setText(this.display);
        }
    }
    
    private void constanteE() {
        if (this.intModo == 0) {
            this.tamStr.empilha(Double.toString(2.718281828459045).length());
            this.display = Double.toString(2.718281828459045);
            this.txtDisplay.setText(this.display);
            this.display = "0";
        }
        else if (this.intModo == 1) {
            this.tamStr.empilha(Double.toString(2.718281828459045).length());
            this.bolPonto = true;
            if (!this.display.equals("0")) {
                this.expressao = String.valueOf(this.expressao) + 2.718281828459045;
                this.display = String.valueOf(this.display) + 2.718281828459045;
            }
            else {
                this.expressao = Double.toString(2.718281828459045);
                this.display = this.expressao;
            }
            this.txtDisplay.setText(this.display);
        }
        else if (this.intModo == 2) {
            this.tamStr.empilha(Double.toString(2.718281828459045).length());
            this.bolPonto = true;
            if (!this.display.equals("0")) {
                this.funcao = String.valueOf(this.funcao) + 2.718281828459045;
                this.display = String.valueOf(this.display) + 2.718281828459045;
            }
            else {
                this.funcao = Double.toString(2.718281828459045);
                this.display = this.funcao;
            }
            this.txtDisplay.setText(this.display);
        }
    }
    
    private void constanteX() {
        this.tamStr.empilha(1);
        this.bolPonto = true;
        if (!this.display.equals("0")) {
            this.funcao = String.valueOf(this.funcao) + "x";
            this.display = String.valueOf(this.display) + "x";
        }
        else {
            this.funcao = "x";
            this.display = this.funcao;
        }
        this.txtDisplay.setText(this.display);
    }
    
    private void ponto() {
        if (!this.bolPonto) {
            if (!this.display.equals("0")) {
                this.display = String.valueOf(this.display) + ".";
                this.expressao = String.valueOf(this.expressao) + ".";
                this.funcao = String.valueOf(this.funcao) + ".";
            }
            else if (this.intModo == 0) {
                this.display = "0.";
                this.expressao = this.display;
                this.funcao = this.display;
            }
            else {
                this.display = String.valueOf(this.display) + "0.";
                this.expressao = String.valueOf(this.expressao) + "0.";
                this.funcao = String.valueOf(this.funcao) + "0.";
            }
            this.bolPonto = true;
        }
        this.txtDisplay.setText(this.display);
    }
    
    private void trocaSin() {
        if (!this.bolExp) {
            double num = Double.parseDouble(this.txtDisplay.getText());
            num *= -1.0;
            this.display = Double.toString(num);
        }
        else {
            String aux1 = "";
            String aux2 = "";
            this.tamStr.esvazia();
            int i = 0;
            int num2 = 0;
            for (aux1 = this.txtDisplay.getText(), i = 0; i < aux1.length() && aux1.charAt(i) != 'E'; ++i) {}
            aux2 = aux1.substring(i + 1, this.display.length());
            num2 = Integer.parseInt(aux2);
            num2 *= -1;
            aux2 = Integer.toString(num2);
            aux1 = aux1.substring(0, i + 1);
            this.display = String.valueOf(aux1) + aux2;
            this.tamStr.empilha(i);
            this.tamStr.empilha(aux2.length());
        }
        this.bolPonto = false;
        this.txtDisplay.setText(this.display);
        this.display = "0";
    }
    
    private void backSpace() {
        if (this.display.length() > 1 && this.tamStr.isCheia()) {
            this.display = this.display.substring(0, this.display.length() - this.tamStr.desempilha());
            if (this.intModo == 1) {
                this.expressao = this.expressao.substring(0, this.expressao.length() - 1);
            }
            else if (this.intModo == 2) {
                this.funcao = this.funcao.substring(0, this.funcao.length() - 1);
            }
        }
        else {
            this.display = "0";
        }
        if (this.display.endsWith(".")) {
            this.display = this.display.substring(0, this.display.length() - 1);
            if (this.intModo == 1) {
                this.expressao = this.expressao.substring(0, this.expressao.length() - 1);
            }
            else if (this.intModo == 2) {
                this.funcao = this.funcao.substring(0, this.funcao.length() - 1);
            }
            this.bolPonto = false;
        }
        this.txtDisplay.setText(this.display);
    }
    
    private void clear() {
        this.varTela = 0.0;
        this.var1 = 0.0;
        this.dVar1 = null;
        this.dTela = null;
        this.display = "0";
        this.operador = '0';
        this.bolPonto = false;
        this.bolNum = false;
        this.intOpera = 0;
        this.tamStr.esvazia();
        this.txtDisplay.setText(this.display);
        if (this.jRelatorio != null) {
            this.jRelatorio.txtRel.append("\n -------- CE -------- ");
        }
    }
    
    private void clearAll() {
        this.dVar1 = null;
        this.dTela = null;
        this.var1 = 0.0;
        this.varTela = 0.0;
        this.memo = 0.0;
        this.expressao = null;
        this.funcao = null;
        this.funcao2 = null;
        this.bolPonto = false;
        this.bolNum = false;
        this.bolExp = false;
        this.bolFunc = true;
        this.intOpera = 0;
        this.intModo = 0;
        this.intFunc = 0;
        this.tamStr.esvazia();
        this.funcaoFx = null;
        this.funcX1 = 0.0;
        this.funcX2 = 0.0;
        this.btPadrao();
        this.display = "0";
        this.status = "";
        this.operador = 'Z';
        this.txtDisplay.setText(this.display);
        this.lbDisplay.setText("   Normal");
        if (this.jRelatorio != null) {
            this.jRelatorio.txtRel.append("\n -------- AC --------\n Tipo: Deg");
        }
    }
    
    private void memoryMais() {
        this.varTela = Double.parseDouble(this.txtDisplay.getText());
        this.memo += this.varTela;
        this.display = "0";
        this.lbDisplay.setText("     Memo");
        this.tamStr.esvazia();
    }
    
    private void memoryRM() {
        this.display = new StringBuffer().append(this.memo).toString();
        this.txtDisplay.setText(this.display);
        this.display = "0";
        this.tamStr.esvazia();
    }
    
    private void operacao2(final JButton btOperador) {
        this.bolPonto = false;
        this.bolExp = false;
        if (this.intOpera == 0) {
            this.var1 = Double.parseDouble(this.txtDisplay.getText());
            this.intOpera = 1;
            this.display = "0";
        }
        else if (this.intOpera == 1 && this.display != "0") {
            this.varTela = Double.parseDouble(this.txtDisplay.getText());
            this.intOpera = 2;
            this.dVar1 = Operacoes.opera(this.operador, this.var1, this.varTela);
            this.verErro1();
        }
        else if (this.intOpera == 2) {
            final double var2 = Double.parseDouble(this.txtDisplay.getText());
            if (this.display != "0" || this.var1 != var2) {
                this.varTela = var2;
                this.intOpera = 2;
                this.dVar1 = Operacoes.opera(this.operador, this.var1, this.varTela);
                this.verErro1();
            }
        }
        else {
            this.var1 = Double.parseDouble(this.txtDisplay.getText());
            this.intOpera = 1;
            this.display = "0";
        }
        this.op2 = btOperador.getText();
        switch (this.op2.charAt(0)) {
            case '/': {
                this.operador = 'K';
                break;
            }
            case '*': {
                this.operador = 'L';
                break;
            }
            case '-': {
                this.operador = 'M';
                break;
            }
            case '+': {
                this.operador = 'N';
                break;
            }
            default: {
                this.operador = 'J';
                break;
            }
        }
        this.tamStr.esvazia();
    }
    
    private void operacao1(final JButton btOperador) {
        this.varTela = Double.parseDouble(this.txtDisplay.getText());
        this.bolPonto = false;
        this.bolExp = false;
        this.op1 = btOperador.getText();
        char operador1 = 'Z';
        if (this.op1.length() <= 3) {
            switch (this.op1.charAt(0)) {
                case 's': {
                    operador1 = 'A';
                    break;
                }
                case 'c': {
                    operador1 = 'B';
                    break;
                }
                case 't': {
                    operador1 = 'C';
                    break;
                }
                case 'L': {
                    operador1 = 'H';
                    break;
                }
            }
        }
        else if (this.op1.length() >= 4) {
            switch (this.op1.charAt(3)) {
                case 'S': {
                    operador1 = 'D';
                    break;
                }
                case 'C': {
                    operador1 = 'F';
                    break;
                }
                case 'T': {
                    operador1 = 'G';
                    break;
                }
                case '/': {
                    operador1 = 'J';
                    break;
                }
            }
        }
        if (operador1 == 'J') {
            this.dTela = Operacoes.opera(operador1, this.varTela, 0.5);
        }
        else {
            this.dTela = Operacoes.opera(operador1, this.varTela, this.isRadiano());
        }
        this.tamStr.esvazia();
        this.verErro2();
    }
    
    private void igual() {
        if (this.intOpera == 1) {
            this.varTela = Double.parseDouble(this.txtDisplay.getText());
            this.intOpera = 3;
            this.dVar1 = Operacoes.opera(this.operador, this.var1, this.varTela);
            this.verErro1();
        }
        else if (this.intOpera == 3 || this.intOpera == 2) {
            final double var2 = Double.parseDouble(this.txtDisplay.getText());
            if (var2 != this.var1) {
                this.varTela = var2;
            }
            this.intOpera = 3;
            this.dVar1 = Operacoes.opera(this.operador, this.var1, this.varTela);
            this.verErro1();
        }
        this.bolPonto = false;
        this.tamStr.esvazia();
    }
    
    private void verErro1() {
        String relat = "\n\n   ";
        relat = String.valueOf(relat) + this.var1 + "\n " + this.op2 + " " + this.varTela;
        if (this.dVar1 == null) {
            this.status = "Erro";
            this.txtStatus.setText(this.status);
            this.display = "0";
        }
        else {
            this.var1 = this.dVar1;
            this.display = this.dVar1.toString();
            this.txtDisplay.setText(this.display);
            this.display = "0";
            this.status = "";
            this.dVar1 = null;
        }
        if (this.jRelatorio != null && this.bolFunc) {
            this.jRelatorio.txtRel.append(relat);
            relat = "\n = " + this.txtDisplay.getText() + " " + this.status;
            this.jRelatorio.txtRel.append(relat);
        }
        this.tamStr.esvazia();
    }
    
    private void verErro2() {
        String relat = "\n";
        relat = "\n\n " + this.op1 + "(" + this.varTela + ")";
        if (this.dTela == null) {
            this.status = "Erro";
            this.txtStatus.setText(this.status);
            this.display = "0";
            this.txtDisplay.setText(this.display);
        }
        else {
            this.varTela = this.dTela;
            this.display = this.dTela.toString();
            this.txtDisplay.setText(this.display);
            this.display = "0";
            this.status = "";
            this.dTela = null;
        }
        this.tamStr.esvazia();
        if (this.jRelatorio != null && this.bolFunc) {
            this.jRelatorio.txtRel.append(relat);
            relat = "\n = " + this.txtDisplay.getText() + " " + this.status;
            this.jRelatorio.txtRel.append(relat);
        }
    }
    
    private void expressao1() {
        this.g2Funcao.setEnabled(false);
        this.g2Exp.setEnabled(false);
        this.g2Exp.setBorder(BorderFactory.createLoweredBevelBorder());
        this.cstAbre.setEnabled(true);
        this.cstFecha.setEnabled(true);
        this.g1Entra.setEnabled(true);
        this.opRaiz.setEnabled(false);
        this.g1Mmais.setEnabled(false);
        this.g1RM.setEnabled(false);
        this.opExp.setEnabled(false);
        this.g1trocaSin.setEnabled(false);
        this.intModo = 1;
        this.lbDisplay.setText("Express\u00e3o");
        this.status = "Digite a express\u00e3o num\u00e9rica";
        this.txtStatus.setText(this.status);
        this.bolPonto = false;
        this.bolExp = false;
        this.display = "0";
        this.txtDisplay.setText(this.display);
    }
    
    private void opExp(final JButton btOperador) {
        final String op = btOperador.getText();
        this.bolPonto = false;
        char operador1 = 'Z';
        if (op.length() <= 3) {
            switch (op.charAt(0)) {
                case 's': {
                    operador1 = 'A';
                    break;
                }
                case 'c': {
                    operador1 = 'B';
                    break;
                }
                case 't': {
                    operador1 = 'C';
                    break;
                }
                case 'L': {
                    operador1 = 'H';
                    break;
                }
                case '/': {
                    operador1 = 'K';
                    break;
                }
                case '*': {
                    operador1 = 'L';
                    break;
                }
                case '-': {
                    operador1 = 'M';
                    break;
                }
                case '+': {
                    operador1 = 'N';
                    break;
                }
                case 'x': {
                    operador1 = 'J';
                    break;
                }
            }
        }
        else if (op.length() >= 4) {
            switch (op.charAt(3)) {
                case 'S': {
                    operador1 = 'D';
                    break;
                }
                case 'C': {
                    operador1 = 'F';
                    break;
                }
                case 'T': {
                    operador1 = 'G';
                    break;
                }
            }
        }
        if (op.compareToIgnoreCase("x^y") == 0) {
            this.display = String.valueOf(this.display) + "^";
            this.tamStr.empilha(1);
        }
        else {
            if (this.expressao != null) {
                this.display = String.valueOf(this.display) + op;
            }
            else {
                this.display = op;
            }
            this.tamStr.empilha(op.length());
        }
        this.txtDisplay.setText(this.display);
        if (this.expressao == null) {
            this.expressao = new StringBuffer(String.valueOf(operador1)).toString();
        }
        else {
            this.expressao = String.valueOf(this.expressao) + operador1;
        }
    }
    
    private void opFuncao(final JButton btOperador) {
        final String op = btOperador.getText();
        this.bolPonto = false;
        char operador1 = 'Z';
        if (op.length() <= 3) {
            switch (op.charAt(0)) {
                case 's': {
                    operador1 = 'A';
                    break;
                }
                case 'c': {
                    operador1 = 'B';
                    break;
                }
                case 't': {
                    operador1 = 'C';
                    break;
                }
                case 'L': {
                    operador1 = 'H';
                    break;
                }
                case '/': {
                    operador1 = 'K';
                    break;
                }
                case '*': {
                    operador1 = 'L';
                    break;
                }
                case '-': {
                    operador1 = 'M';
                    break;
                }
                case '+': {
                    operador1 = 'N';
                    break;
                }
                case 'x': {
                    operador1 = 'J';
                    break;
                }
            }
        }
        else if (op.length() >= 4) {
            switch (op.charAt(3)) {
                case 'S': {
                    operador1 = 'D';
                    break;
                }
                case 'C': {
                    operador1 = 'F';
                    break;
                }
                case 'T': {
                    operador1 = 'G';
                    break;
                }
            }
        }
        if (op.compareToIgnoreCase("x^y") == 0) {
            this.display = String.valueOf(this.display) + "^";
            this.tamStr.empilha(1);
        }
        else {
            if (this.display.equalsIgnoreCase("0")) {
                this.display = op;
            }
            else {
                this.display = String.valueOf(this.display) + op;
            }
            this.tamStr.empilha(op.length());
        }
        this.txtDisplay.setText(this.display);
        if (this.funcao == null) {
            this.funcao = new StringBuffer(String.valueOf(operador1)).toString();
        }
        else {
            this.funcao = String.valueOf(this.funcao) + operador1;
        }
    }
    
    private void funcao1() {
        this.g2Funcao.setEnabled(false);
        this.g2Funcao.setBorder(BorderFactory.createLoweredBevelBorder());
        this.cstAbre.setEnabled(true);
        this.cstFecha.setEnabled(true);
        this.g1Entra.setEnabled(true);
        this.funcX.setEnabled(true);
        this.g2Exp.setEnabled(false);
        this.opRaiz.setEnabled(false);
        this.g1Mmais.setEnabled(false);
        this.g1RM.setEnabled(false);
        this.opExp.setEnabled(false);
        this.g1trocaSin.setEnabled(false);
        this.intModo = 2;
        this.intFunc = 0;
        this.status = "Digite a Fun\u00e7\u00e3o F(x)";
        this.txtStatus.setText(this.status);
        this.display = "0";
        this.txtDisplay.setText(this.display);
        this.bolPonto = false;
        this.bolExp = false;
    }
    
    private void entraExp() {
        this.dTela = null;
        this.status = "";
        this.bolFunc = false;
        this.bolPonto = false;
        final String temp = this.display;
        if (Operacoes.verifyParent(this.expressao)) {
            this.dTela = Operacoes.resolveExpressao(this.expressao, this.isRadiano());
        }
        this.verErro2();
        this.status = String.valueOf(temp) + " = " + this.txtDisplay.getText() + " " + this.status;
        this.txtStatus.setText(this.status);
        this.lbDisplay.setText("   Normal");
        this.btExp2();
        this.intModo = 0;
        this.expressao = null;
        if (this.jRelatorio != null) {
            final String relat = "\n\n Express\u00e3o: \n " + this.status;
            this.jRelatorio.txtRel.append(relat);
        }
        this.bolFunc = true;
    }
    
    private void funcFx1() {
        this.intFunc = 1;
        this.funcX.setEnabled(false);
        this.funcFx.setEnabled(false);
        this.funcRaiz.setEnabled(false);
        this.funcDer.setEnabled(false);
        this.funcInt.setEnabled(false);
        this.g1Entra.setEnabled(true);
        this.status = String.valueOf(this.funcao2) + " - Digite o valor de X";
        this.txtStatus.setText(this.status);
        this.lbDisplay.setText("     x = ");
    }
    
    private void funcDer1() {
        this.intFunc = 4;
        this.funcX.setEnabled(false);
        this.funcFx.setEnabled(false);
        this.funcRaiz.setEnabled(false);
        this.funcDer.setEnabled(false);
        this.funcInt.setEnabled(false);
        this.g1Entra.setEnabled(true);
        this.status = String.valueOf(this.funcao2) + " - Digite o valor de X";
        this.txtStatus.setText(this.status);
        this.lbDisplay.setText("     x = ");
    }
    
    private void funcInt1() {
        this.intFunc = 2;
        this.funcX.setEnabled(false);
        this.funcFx.setEnabled(false);
        this.funcRaiz.setEnabled(false);
        this.funcDer.setEnabled(false);
        this.funcInt.setEnabled(false);
        this.g1Entra.setEnabled(true);
        this.status = String.valueOf(this.funcao2) + " - Digite o limite inferior do intervalo de integra\u00e7\u00e3o";
        this.txtStatus.setText(this.status);
        this.lbDisplay.setText("    x1 = ");
    }
    
    private void funcRaiz() {
        this.intFunc = 5;
        this.funcX.setEnabled(false);
        this.funcFx.setEnabled(false);
        this.funcRaiz.setEnabled(false);
        this.funcDer.setEnabled(false);
        this.funcInt.setEnabled(false);
        this.g1Entra.setEnabled(true);
        this.status = String.valueOf(this.funcao2) + " - Digite o limite inferior do intervalo da ra\u00edz";
        this.txtStatus.setText(this.status);
        this.lbDisplay.setText("    x1 = ");
    }
    
    private void entFunc() {
        this.funcaoFx = new Funcao(this.funcao, this.isRadiano());
        this.intModo = 0;
        if (this.funcaoFx.verFuncao()) {
            this.status = this.txtDisplay.getText();
            this.txtStatus.setText(this.status);
            this.funcao2 = this.status;
            this.lbDisplay.setText("   Fun\u00e7\u00e3o");
            this.lbStatus.setText("    F(x)=");
            if (this.jRelatorio != null) {
                final String relat = "\n\n Fun\u00e7\u00e3o: F(x)= " + this.funcao2;
                this.jRelatorio.txtRel.append(relat);
            }
            this.cstAbre.setEnabled(false);
            this.cstFecha.setEnabled(false);
            this.funcX.setEnabled(false);
            this.funcFx.setEnabled(true);
            this.funcRaiz.setEnabled(true);
            this.funcDer.setEnabled(true);
            this.funcInt.setEnabled(true);
            this.g1Entra.setEnabled(false);
            this.g1trocaSin.setEnabled(true);
            this.opRaiz.setEnabled(true);
            this.g1Mmais.setEnabled(true);
            this.g1RM.setEnabled(true);
            this.opExp.setEnabled(true);
            this.g2Exp.setEnabled(false);
        }
        else {
            this.funcaoFx = null;
            this.status = "Erro na Fun\u00e7\u00e3o f(x) digitada";
            this.txtStatus.setText(this.status);
            this.clearAll();
        }
        this.display = "0";
        this.txtDisplay.setText(this.display);
        this.bolPonto = false;
    }
    
    private void entFuncX() {
        this.bolFunc = false;
        final double x = Double.parseDouble(this.txtDisplay.getText());
        this.dTela = this.funcaoFx.fx(x);
        this.verErro2();
        final String erro = this.status;
        this.status = String.valueOf(this.funcao2) + " P/ x = " + x + " \u00e9 " + this.txtDisplay.getText() + " " + this.status;
        this.txtStatus.setText(this.status);
        this.lbDisplay.setText("   Fun\u00e7\u00e3o");
        this.funcFx.setEnabled(true);
        this.funcRaiz.setEnabled(true);
        this.funcDer.setEnabled(true);
        this.funcInt.setEnabled(true);
        this.g1Entra.setEnabled(false);
        if (this.jRelatorio != null) {
            final String relat = "\n\n F(x)= " + this.funcao2 + "\n P/ x = " + x + " \u00e9 " + this.txtDisplay.getText() + " " + erro;
            this.jRelatorio.txtRel.append(relat);
        }
        this.bolFunc = true;
        this.bolPonto = false;
    }
    
    private void entFuncI1() {
        this.intFunc = 3;
        this.status = String.valueOf(this.funcao2) + " - Digite o limite superior do intervalo de integra\u00e7\u00e3o";
        this.txtStatus.setText(this.status);
        this.lbDisplay.setText("    x2 = ");
        this.funcX1 = Double.parseDouble(this.txtDisplay.getText());
        this.display = "0";
        this.bolPonto = false;
    }
    
    private void entFuncI2() {
        this.intFunc = 7;
        this.bolFunc = false;
        this.funcX2 = Double.parseDouble(this.txtDisplay.getText());
        this.dTela = this.funcaoFx.integral(this.funcX1, this.funcX2);
        this.verErro2();
        final String erro = this.status;
        this.status = String.valueOf(this.funcao2) + " Integral em [" + this.funcX1 + " , " + this.funcX2 + "] \u00e9 " + this.txtDisplay.getText() + " " + this.status;
        this.txtStatus.setText(this.status);
        this.lbDisplay.setText("   Fun\u00e7\u00e3o");
        this.funcFx.setEnabled(true);
        this.funcRaiz.setEnabled(true);
        this.funcDer.setEnabled(true);
        this.funcInt.setEnabled(true);
        this.bolFunc = true;
        if (this.jRelatorio != null) {
            final String relat = "\n\n F(x)= " + this.funcao2 + "\n Integral em [" + this.funcX1 + " , " + this.funcX2 + "] \u00e9 \n = " + this.txtDisplay.getText() + " " + erro;
            this.jRelatorio.txtRel.append(relat);
        }
        this.bolPonto = false;
    }
    
    private void entFuncD() {
        this.bolFunc = false;
        final double x = Double.parseDouble(this.txtDisplay.getText());
        this.dTela = this.funcaoFx.derivada(x);
        this.verErro2();
        final String erro = this.status;
        this.status = String.valueOf(this.funcao2) + " derivada P/ x = " + x + " \u00e9 " + this.txtDisplay.getText() + " " + this.status;
        this.txtStatus.setText(this.status);
        this.lbDisplay.setText("   Fun\u00e7\u00e3o");
        this.funcFx.setEnabled(true);
        this.funcRaiz.setEnabled(true);
        this.funcDer.setEnabled(true);
        this.funcInt.setEnabled(true);
        this.bolFunc = true;
        if (this.jRelatorio != null) {
            final String relat = "\n\n F(x)= " + this.funcao2 + "\n Derivada P/ x = " + x + " \u00e9 " + this.txtDisplay.getText() + " " + erro;
            this.jRelatorio.txtRel.append(relat);
        }
        this.bolPonto = false;
    }
    
    private void entFuncR1() {
        this.intFunc = 6;
        this.lbDisplay.setText("    x2 = ");
        this.funcX1 = Double.parseDouble(this.txtDisplay.getText());
        this.display = "0";
        this.bolPonto = false;
    }
    
    private void entFuncR2() {
        this.intFunc = 7;
        this.bolFunc = false;
        this.funcX2 = Double.parseDouble(this.txtDisplay.getText());
        this.dTela = this.funcaoFx.raiz(this.funcX1, this.funcX2);
        this.verErro2();
        final String erro = this.status;
        this.status = String.valueOf(this.funcao2) + " Ra\u00edz em [" + this.funcX1 + " , " + this.funcX2 + "] \u00e9 " + this.txtDisplay.getText() + " " + this.status;
        this.txtStatus.setText(this.status);
        this.lbDisplay.setText("   Fun\u00e7\u00e3o");
        this.funcFx.setEnabled(true);
        this.funcRaiz.setEnabled(true);
        this.funcDer.setEnabled(true);
        this.funcInt.setEnabled(true);
        this.bolFunc = true;
        if (this.jRelatorio != null) {
            final String relat = "\n\n F(x)= " + this.funcao2 + "\n Ra\u00edz em [" + this.funcX1 + " , " + this.funcX2 + "] \u00e9 " + this.txtDisplay.getText() + " " + erro;
            this.jRelatorio.txtRel.append(relat);
        }
        this.bolPonto = false;
    }
    
    private void btPadrao() {
        this.g2Funcao.setEnabled(true);
        this.g2Funcao.setBorder(BorderFactory.createRaisedBevelBorder());
        this.g2Exp.setEnabled(true);
        this.g2Exp.setBorder(BorderFactory.createRaisedBevelBorder());
        this.g1Entra.setEnabled(false);
        this.funcX.setEnabled(false);
        this.funcFx.setEnabled(false);
        this.funcRaiz.setEnabled(false);
        this.funcDer.setEnabled(false);
        this.funcInt.setEnabled(false);
        this.cstAbre.setEnabled(false);
        this.cstFecha.setEnabled(false);
        this.g1Entra.setEnabled(false);
        this.g1trocaSin.setEnabled(true);
        this.opRaiz.setEnabled(true);
        this.g1Mmais.setEnabled(true);
        this.g1RM.setEnabled(true);
        this.opExp.setEnabled(true);
        this.rb1Grau.setSelected(true);
        this.txtDisplay.setText(this.display);
        this.lbStatus.setText("   Status");
        this.lbDisplay.setText("   Normal");
        this.txtStatus.setText("");
    }
    
    private void btExp2() {
        this.g2Exp.setEnabled(true);
        this.g2Exp.setBorder(BorderFactory.createRaisedBevelBorder());
        this.cstAbre.setEnabled(false);
        this.cstFecha.setEnabled(false);
        this.g1Entra.setEnabled(false);
        this.g2Funcao.setEnabled(true);
        this.opRaiz.setEnabled(true);
        this.g1Mmais.setEnabled(true);
        this.g1RM.setEnabled(true);
        this.opExp.setEnabled(true);
        this.g1trocaSin.setEnabled(true);
    }
    
    private void notaCient() {
        if (!this.display.equals("0")) {
            this.display = String.valueOf(this.display) + "E0";
        }
        else {
            this.display = "1E0";
        }
        this.bolExp = true;
        this.bolPonto = true;
        this.txtDisplay.setText(this.display);
        this.tamStr.esvazia();
    }
    
    public boolean isRadiano() {
        boolean retorno = true;
        if (this.rb1Grau.isSelected()) {
            retorno = false;
        }
        else if (this.rb1Radiano.isSelected()) {
            retorno = true;
        }
        return retorno;
    }
    
    private void grauRad(final JRadioButton bt) {
        if (this.jRelatorio != null) {
            if (bt.getText().equals("Deg")) {
                this.jRelatorio.txtRel.append("\n\n Tipo: Deg");
            }
            else if (bt.getText().equals("Rad")) {
                this.jRelatorio.txtRel.append("\n\n Tipo: Radiano");
            }
        }
    }
    
    private void grauRadTec() {
        if (this.rb1Grau.isSelected()) {
            this.rb1Radiano.setSelected(true);
            this.rb1Grau.setSelected(false);
            if (this.jRelatorio != null) {
                this.jRelatorio.txtRel.append("\n\n Tipo: Radiano");
            }
        }
        else if (this.rb1Radiano.isSelected()) {
            this.rb1Radiano.setSelected(false);
            this.rb1Grau.setSelected(true);
            if (this.jRelatorio != null) {
                this.jRelatorio.txtRel.append("\n\n Tipo: Deg");
            }
        }
    }
    
    private void relatorio() {
        if (this.jRelatorio == null || !this.jRelatorio.isShowing()) {
            this.g1Relatorio.setBorder(BorderFactory.createLoweredBevelBorder());
            (this.jRelatorio = new relatorioCalc(this.getLocation())).show();
        }
        else {
            this.g1Relatorio.setBorder(BorderFactory.createRaisedBevelBorder());
            this.jRelatorio.txtRel.setText("");
            this.jRelatorio.dispose();
            this.jRelatorio = null;
        }
    }
    
    private void sobre() {
        final String msg = "\"Porque Deus amou ao mundo de tal \n maneira que deu o seu Filho unig\u00eanito, \n para que todo o que nele cr\u00ea n\u00e3o pere\u00e7a, \n mas tenha a vida eterna.\"\n (Jo\u00e3o 3:16)\n\nCalculadora Cient\u00edfica vers\u00e3o: 1.0\nAutor:  Felipe Lino IME/UERJ\nE-mail: felipelino44@gmail.com\nRio de Janeiro, 26 de dezembro de 2005\nDesenvolvido em Java, usando Eclipse 3.0";
        JOptionPane.showMessageDialog(null, msg, "Sobre Calc-X 1.0", 3);
        this.setFocusable(true);
    }
    
    private void ajuda() {
        if (this.jAjuda == null || !this.jAjuda.isShowing()) {
            (this.jAjuda = new help(this.getLocation())).show();
        }
    }
    
    public void actionPerformed(final ActionEvent evt) {
        if (evt.getSource() == this.num1) {
            this.numeros(this.num1);
        }
        else if (evt.getSource() == this.num2) {
            this.numeros(this.num2);
        }
        else if (evt.getSource() == this.num3) {
            this.numeros(this.num3);
        }
        else if (evt.getSource() == this.num4) {
            this.numeros(this.num4);
        }
        else if (evt.getSource() == this.num5) {
            this.numeros(this.num5);
        }
        else if (evt.getSource() == this.num6) {
            this.numeros(this.num6);
        }
        else if (evt.getSource() == this.num7) {
            this.numeros(this.num7);
        }
        else if (evt.getSource() == this.num8) {
            this.numeros(this.num8);
        }
        else if (evt.getSource() == this.num9) {
            this.numeros(this.num9);
        }
        else if (evt.getSource() == this.num0) {
            this.numeros(this.num0);
        }
        else if (evt.getSource() == this.cstPi) {
            this.constantePi();
        }
        else if (evt.getSource() == this.cstE) {
            this.constanteE();
        }
        else if (evt.getSource() == this.rb1Grau) {
            this.grauRad(this.rb1Grau);
        }
        else if (evt.getSource() == this.rb1Radiano) {
            this.grauRad(this.rb1Radiano);
        }
        else if (evt.getSource() == this.g1Clear) {
            this.clear();
        }
        else if (evt.getSource() == this.g1ClearAll) {
            this.clearAll();
        }
        else if (evt.getSource() == this.g1Mmais) {
            this.memoryMais();
        }
        else if (evt.getSource() == this.g1RM) {
            this.memoryRM();
        }
        else if (evt.getSource() == this.g1BackSpace) {
            this.backSpace();
        }
        else if (evt.getSource() == this.cstAbre) {
            this.parentesis(this.cstAbre);
        }
        else if (evt.getSource() == this.cstFecha) {
            this.parentesis(this.cstFecha);
        }
        else if (evt.getSource() == this.funcX) {
            if (this.intModo == 2) {
                this.constanteX();
            }
        }
        else if (evt.getSource() == this.g2Exp) {
            if (this.intModo == 0) {
                this.expressao1();
            }
        }
        else if (evt.getSource() == this.g2Funcao) {
            if (this.intModo == 0) {
                this.funcao1();
            }
        }
        else if (evt.getSource() == this.g1trocaSin) {
            if (this.intModo == 0) {
                this.trocaSin();
            }
        }
        else if (evt.getSource() == this.g1Ponto) {
            this.ponto();
        }
        else if (evt.getSource() == this.opDiv) {
            if (this.intModo == 0) {
                this.operacao2(this.opDiv);
            }
            else if (this.intModo == 2) {
                this.opFuncao(this.opDiv);
            }
            else if (this.intModo == 1) {
                this.opExp(this.opDiv);
            }
        }
        else if (evt.getSource() == this.opMul) {
            if (this.intModo == 0) {
                this.operacao2(this.opMul);
            }
            else if (this.intModo == 2) {
                this.opFuncao(this.opMul);
            }
            else if (this.intModo == 1) {
                this.opExp(this.opMul);
            }
        }
        else if (evt.getSource() == this.opSub) {
            if (this.intModo == 0) {
                this.operacao2(this.opSub);
            }
            else if (this.intModo == 2) {
                this.opFuncao(this.opSub);
            }
            else if (this.intModo == 1) {
                this.opExp(this.opSub);
            }
        }
        else if (evt.getSource() == this.opSom) {
            if (this.intModo == 0) {
                this.operacao2(this.opSom);
            }
            else if (this.intModo == 2) {
                this.opFuncao(this.opSom);
            }
            else if (this.intModo == 1) {
                this.opExp(this.opSom);
            }
        }
        else if (evt.getSource() == this.opXeY) {
            if (this.intModo == 0) {
                this.operacao2(this.opXeY);
            }
            else if (this.intModo == 2) {
                this.opFuncao(this.opXeY);
            }
            else if (this.intModo == 1) {
                this.opExp(this.opXeY);
            }
        }
        else if (evt.getSource() == this.opRaiz) {
            if (this.intModo == 0) {
                this.operacao1(this.opRaiz);
            }
        }
        else if (evt.getSource() == this.opSen) {
            if (this.intModo == 0) {
                this.operacao1(this.opSen);
            }
            else if (this.intModo == 2) {
                this.opFuncao(this.opSen);
            }
            else if (this.intModo == 1) {
                this.opExp(this.opSen);
            }
        }
        else if (evt.getSource() == this.opCos) {
            if (this.intModo == 0) {
                this.operacao1(this.opCos);
            }
            else if (this.intModo == 2) {
                this.opFuncao(this.opCos);
            }
            else if (this.intModo == 1) {
                this.opExp(this.opCos);
            }
        }
        else if (evt.getSource() == this.opTan) {
            if (this.intModo == 0) {
                this.operacao1(this.opTan);
            }
            else if (this.intModo == 2) {
                this.opFuncao(this.opTan);
            }
            else if (this.intModo == 1) {
                this.opExp(this.opTan);
            }
        }
        else if (evt.getSource() == this.opLn) {
            if (this.intModo == 0) {
                this.operacao1(this.opLn);
            }
            else if (this.intModo == 2) {
                this.opFuncao(this.opLn);
            }
            else if (this.intModo == 1) {
                this.opExp(this.opLn);
            }
        }
        else if (evt.getSource() == this.opArcSen) {
            if (this.intModo == 0) {
                this.operacao1(this.opArcSen);
            }
            else if (this.intModo == 2) {
                this.opFuncao(this.opArcSen);
            }
            else if (this.intModo == 1) {
                this.opExp(this.opArcSen);
            }
        }
        else if (evt.getSource() == this.opArcCos) {
            if (this.intModo == 0) {
                this.operacao1(this.opArcCos);
            }
            else if (this.intModo == 2) {
                this.opFuncao(this.opArcCos);
            }
            else if (this.intModo == 1) {
                this.opExp(this.opArcCos);
            }
        }
        else if (evt.getSource() == this.opArcTan) {
            if (this.intModo == 0) {
                this.operacao1(this.opArcTan);
            }
            else if (this.intModo == 2) {
                this.opFuncao(this.opArcTan);
            }
            else if (this.intModo == 1) {
                this.opExp(this.opArcTan);
            }
        }
        else if (evt.getSource() == this.g1Igual) {
            if (this.intModo == 0) {
                this.igual();
            }
            else if (this.intModo == 1 && this.expressao != null) {
                this.entraExp();
                if (this.intOpera == 1) {
                    this.igual();
                }
            }
        }
        else if (evt.getSource() == this.opExp && !this.bolExp) {
            this.notaCient();
        }
        else if (evt.getSource() == this.funcFx) {
            this.funcFx1();
        }
        else if (evt.getSource() == this.funcDer) {
            this.funcDer1();
        }
        else if (evt.getSource() == this.funcInt) {
            this.funcInt1();
        }
        else if (evt.getSource() == this.funcRaiz) {
            this.funcRaiz();
        }
        else if (evt.getSource() == this.g1Entra) {
            if (this.intModo == 1 && this.expressao != null) {
                this.entraExp();
            }
            else if (this.intModo == 2 || this.funcaoFx != null) {
                if (this.intFunc == 0 && this.funcao != null) {
                    this.entFunc();
                }
                else if (this.intFunc == 1) {
                    this.entFuncX();
                }
                else if (this.intFunc == 2) {
                    this.entFuncI1();
                }
                else if (this.intFunc == 3) {
                    this.entFuncI2();
                }
                else if (this.intFunc == 4) {
                    this.entFuncD();
                }
                else if (this.intFunc == 5) {
                    this.entFuncR1();
                }
                else if (this.intFunc == 6) {
                    this.entFuncR2();
                }
            }
        }
        else if (evt.getSource() == this.g1Relatorio) {
            this.relatorio();
        }
        else if (evt.getSource() == this.m1Sobre) {
            this.sobre();
        }
        else if (evt.getSource() == this.m1Ajuda) {
            this.ajuda();
        }
    }
    
    public void keyPressed(final KeyEvent evento) {
        switch (evento.getKeyChar()) {
            case '1': {
                this.num1.doClick();
                break;
            }
            case '2': {
                this.num2.doClick();
                break;
            }
            case '3': {
                this.num3.doClick();
                break;
            }
            case '4': {
                this.num4.doClick();
                break;
            }
            case '5': {
                this.num5.doClick();
                break;
            }
            case '6': {
                this.num6.doClick();
                break;
            }
            case '7': {
                this.num7.doClick();
                break;
            }
            case '8': {
                this.num8.doClick();
                break;
            }
            case '9': {
                this.num9.doClick();
                break;
            }
            case '0': {
                this.num0.doClick();
                break;
            }
            case '.': {
                this.g1Ponto.doClick();
                break;
            }
            case '(': {
                this.cstAbre.doClick();
                break;
            }
            case ')': {
                this.cstFecha.doClick();
                break;
            }
            case '+': {
                this.opSom.doClick();
                break;
            }
            case '-': {
                this.opSub.doClick();
                break;
            }
            case '*': {
                this.opMul.doClick();
                break;
            }
            case '/': {
                this.opDiv.doClick();
                break;
            }
        }
        switch (evento.getKeyCode()) {
            case 10: {
                this.g1Igual.doClick();
                break;
            }
            case 8: {
                this.g1BackSpace.doClick();
                break;
            }
            case 127: {
                this.g1Clear.doClick();
                break;
            }
            case 27: {
                this.g1ClearAll.doClick();
                break;
            }
            case 65: {
                this.grauRadTec();
                break;
            }
            case 112: {
                this.ajuda();
                break;
            }
            case 69: {
                this.cstE.doClick();
                break;
            }
            case 80: {
                this.cstPi.doClick();
                break;
            }
            case 88: {
                this.funcX.doClick();
                break;
            }
            case 77: {
                this.g1Mmais.doClick();
                break;
            }
            case 78: {
                this.g1RM.doClick();
                break;
            }
            case 113: {
                this.sobre();
                break;
            }
            case 114: {
                this.g2Exp.doClick();
                break;
            }
            case 115: {
                this.g2Funcao.doClick();
                break;
            }
            case 116: {
                this.opExp.doClick();
                break;
            }
            case 117: {
                this.g1Relatorio.doClick();
                break;
            }
            case 35: {
                this.g1Entra.doClick();
                break;
            }
            case 67: {
                this.opCos.doClick();
                break;
            }
            case 83: {
                this.opSen.doClick();
                break;
            }
            case 84: {
                this.opTan.doClick();
                break;
            }
            case 76: {
                this.opLn.doClick();
                break;
            }
            case 89: {
                this.opXeY.doClick();
                break;
            }
            case 86: {
                this.opRaiz.doClick();
                break;
            }
            case 91: {
                this.opArcSen.doClick();
                break;
            }
            case 93: {
                this.opArcCos.doClick();
                break;
            }
            case 92: {
                this.opArcTan.doClick();
                break;
            }
            case 90: {
                this.g1trocaSin.doClick();
                break;
            }
            case 70: {
                this.funcFx.doClick();
                break;
            }
            case 68: {
                this.funcDer.doClick();
                break;
            }
            case 73: {
                this.funcInt.doClick();
                break;
            }
            case 82: {
                if (this.funcRaiz.isEnabled()) {
                    this.funcRaiz();
                    break;
                }
                break;
            }
            case 118: {
                if (this.jRelatorio != null) {
                    this.jRelatorio.btSalva.doClick();
                    break;
                }
                break;
            }
            case 119: {
                if (this.jRelatorio != null) {
                    this.jRelatorio.btLimpa.doClick();
                    break;
                }
                break;
            }
        }
    }
    
    public void keyReleased(final KeyEvent tecla) {
    }
    
    public void keyTyped(final KeyEvent tecla) {
    }
    
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
        calc.setFocusable(true);
    }
    
    public void windowClosed(final WindowEvent e) {
    }
    
    public void windowOpened(final WindowEvent e) {
        this.sobre();
    }
    
    public void windowActivated(final WindowEvent e) {
        final CalculadoraMain calc = (CalculadoraMain)e.getSource();
        calc.setFocusable(true);
    }
    
    public void windowDeactivated(final WindowEvent e) {
    }
    
    public static void main(final String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        final CalculadoraMain jMain = new CalculadoraMain();
        jMain.addWindowListener(jMain);
        jMain.addKeyListener(jMain);
        jMain.setFocusable(true);
        jMain.show();
    }
}
