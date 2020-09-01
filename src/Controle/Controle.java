package Controle;

import View.*;

public class Controle 
{
    public static Menu menu = new Menu();
    public static void main(String[] args) 
    {
        try
        {
            Inicio inicio = new Inicio();
            Thread.sleep(1000);
            inicio.dispose();
            menu.show();
        }
        catch(Exception erro)
        {
            
        }
    }
    
}
