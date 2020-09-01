package View;

import Controle.Manipular;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener
{
    Font fonte;
    Container containerPrincipal;
    JTextField campoRegra, campoChave, alfabeto, alfabeto2, campoIndice;
    public JTextField campoControle;
    JTextArea campoTexto, campoTextoFinal;
    JLabel textoCampoRegra, textoCampoChave, textoCampoControle, textoSimboloAlfa;
    int tamanhoCaixaX = 300, tamanhoCaixaY = 40;
    JButton botaoAplicarRegras, botaoRestaurarRegras, botaoAplicarTexto, botaoRestaurarTexto,
            botaoRestaurarFinal, botaoGerarIndice;
    
    ImageIcon imagem;
    JLabel labelImagem;
    Manipular manipular = new Manipular();
    
    public Menu()
    {
        super("Linguagens formais e autômatos - Enígma - Jucelio Delmondes do Amaral");
        this.setResizable(false);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);        
        prepararObjetos();
        //campoTexto.setForeground(Color.blue);
    }
    
    public void prepararObjetos()
    {
       
        imagem = new ImageIcon("data/azul.jpg");
        labelImagem = new JLabel(imagem);
        this.add(labelImagem);
        
        fonte = new Font("Arial", Font.PLAIN, 25);
        containerPrincipal = new Container();
        this.add(containerPrincipal);
         
        campoIndice = new JTextField();
        campoIndice.setBounds(100, 450, tamanhoCaixaX, tamanhoCaixaY);
        campoIndice.setFont(fonte);
        containerPrincipal.add(campoIndice);
        
        
        campoRegra = new JTextField();
        campoRegra.setBounds(100, 500, tamanhoCaixaX, tamanhoCaixaY);
        campoRegra.setFont(fonte);
        containerPrincipal.add(campoRegra);
        
        campoChave = new JTextField();   
        campoChave.setBounds(100, 550, tamanhoCaixaX, tamanhoCaixaY);
        campoChave.setFont(fonte);
        containerPrincipal.add(campoChave);
        
        campoControle = new JTextField();   
        campoControle.setBounds(100, 600, tamanhoCaixaX, tamanhoCaixaY);
        campoControle.setFont(fonte);
        campoControle.setEditable(false);
        campoControle.setForeground(Color.red);
        containerPrincipal.add(campoControle);
        
        textoCampoRegra = new JLabel("GerarID");
        textoCampoRegra.setBounds(10, 450, tamanhoCaixaX, tamanhoCaixaY);
        textoCampoRegra.setFont(fonte);
        containerPrincipal.add(textoCampoRegra);
        
        textoCampoRegra = new JLabel("Regra:");
        textoCampoRegra.setBounds(10, 500, tamanhoCaixaX, tamanhoCaixaY);
        textoCampoRegra.setFont(fonte);
        containerPrincipal.add(textoCampoRegra);
         
        textoCampoChave = new JLabel("Chave:");
        textoCampoChave.setBounds(10, 550, tamanhoCaixaX, tamanhoCaixaY);
        textoCampoChave.setFont(fonte);
        containerPrincipal.add(textoCampoChave);
        
        textoCampoControle = new JLabel("Contr:");
        textoCampoControle.setBounds(10, 600, tamanhoCaixaX, tamanhoCaixaY);
        textoCampoControle.setFont(fonte);
        containerPrincipal.add(textoCampoControle);
        
        textoSimboloAlfa = new JLabel("∑={                                                                                        }");
        textoSimboloAlfa.setBounds(290, 7, tamanhoCaixaX+500, tamanhoCaixaY);
        textoSimboloAlfa.setFont(fonte);
        containerPrincipal.add(textoSimboloAlfa);
        
        
        botaoAplicarRegras = new JButton("Aplicar");
        botaoAplicarRegras.setBounds(100, 650, 100, 20);
        botaoAplicarRegras.addActionListener(this);
        containerPrincipal.add(botaoAplicarRegras);
        
        botaoRestaurarRegras = new JButton("Restaurar");
        botaoRestaurarRegras.setBounds(300, 650, 100, 20);
        botaoRestaurarRegras.addActionListener(this);
        containerPrincipal.add(botaoRestaurarRegras);
        //======================================================================
        campoTexto = new JTextArea();
        campoTexto.setBounds(770, 500, 500, 140);
        campoTexto.setFont(fonte);
        campoTexto.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(campoTexto);
        containerPrincipal.add(campoTexto);
        
        
        botaoAplicarTexto = new JButton("Aplicar");
        botaoAplicarTexto.setBounds(770, 650, 100, 20);
        botaoAplicarTexto.addActionListener(this);
        containerPrincipal.add(botaoAplicarTexto);
    
        botaoRestaurarTexto = new JButton("Restaurar");
        botaoRestaurarTexto.setBounds(1170, 650, 100, 20);
        botaoRestaurarTexto.addActionListener(this);
        containerPrincipal.add(botaoRestaurarTexto);
     
        alfabeto = new JTextField();
        alfabeto.setBounds(340, 10, tamanhoCaixaX+300, tamanhoCaixaY);
        alfabeto.setOpaque(false);
        alfabeto.setFont(new Font("Arial", Font.PLAIN, 18));
        alfabeto.setEditable(false);
        alfabeto.setForeground(Color.red);
        containerPrincipal.add(alfabeto);
        
        
        campoTextoFinal = new JTextArea();
        campoTextoFinal.setBounds(240, 100, 800, 300);
        campoTextoFinal.setFont(fonte);
        campoTextoFinal.setEditable(false);
        
        campoTextoFinal.setLineWrap(true);
        containerPrincipal.add(campoTextoFinal);
        
        botaoRestaurarFinal = new JButton("Restaurar");
        botaoRestaurarFinal.setBounds(590, 405, 100, 20);
        botaoRestaurarFinal.addActionListener(this);
        containerPrincipal.add(botaoRestaurarFinal);//"∑"
        
        botaoGerarIndice = new JButton("Ok");
        botaoGerarIndice.setBounds(400, 460, 100, 20);
        botaoGerarIndice.addActionListener(this);
        containerPrincipal.add(botaoGerarIndice);
    }

    public void actionPerformed(ActionEvent evt) 
    {
        if(evt.getSource() == botaoAplicarRegras)
        {
            try
            {
                String texto = "";
                texto = manipular.aplicarRegras(campoTextoFinal.getText()+"", campoRegra.getText()+"", campoChave.getText()+"");
                campoTextoFinal.setText("");
                campoTextoFinal.setText(texto);
                alfabeto.setText("");
                alfabeto.setText(manipular.obterAlfabeto(campoTextoFinal.getText()));
                
            }
            catch(Exception erro)
            {
                JOptionPane.showMessageDialog(null, "Verifique todos os campos preenchidos!\n "+ erro);
            }
        }
        else
        if(evt.getSource() == botaoRestaurarRegras)
        {
            campoRegra.setText("");
            campoChave.setText("");
            campoControle.setText("");
            campoIndice.setText("");
        }
        else
        if(evt.getSource() == botaoAplicarTexto)
        {
            campoTextoFinal.setText(campoTexto.getText());
            alfabeto.setText(manipular.obterAlfabeto(campoTextoFinal.getText()));
        }
        else
        if(evt.getSource() == botaoRestaurarTexto)
        {
            campoTexto.setText("");
        }
        else
        if(evt.getSource() == botaoRestaurarFinal)
        {
            campoTextoFinal.setText("");
            alfabeto.setText("");
        }
        else
        if(evt.getSource() == botaoGerarIndice)
        {
            campoIndice.setText(manipular.gerarIndice(campoIndice.getText()));
        }
    }
}
