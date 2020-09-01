package View;
import java.awt.Color;
import javax.swing.*;
public class Inicio extends JFrame
{
    public Inicio()
    {
        
        ImageIcon imagem;
        JLabel label;
        imagem = new ImageIcon("data/logo.png");
        label = new JLabel(imagem);
        label.setVisible(true);
        
        
        this.setUndecorated(true);
        this.setResizable(false);
        this.setSize(700, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(label);
        this.show();
        
    }

}
