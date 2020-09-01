
package Controle;

import javax.swing.JOptionPane;


public class Manipular 
{
    //se a posicao do alfabeto for igual a 1, significa q ele está sendo utilizado
    int alfabeto[];
    String alfabetoLetra[] = {"@", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
         "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    
    int chaveVetor[];
    String controle;
    String textoControleFinal;
    String textoControle[];
    String novaRegra[];
    char regra[];
    String textoFinal;
    String textoVetor[];
    boolean encontrouLetra;
    int indiceTexto, indiceControle;
     String textoQuebrado[];
    public Manipular()
    {
        controle = "";
        chaveVetor = new int[26];
        alfabeto = new int[26];
        novaRegra = new String[26];
        regra = new char[26];
        textoVetor = new String[5000];
        textoControle = new String[26];
        textoQuebrado = new String[32];
        encontrouLetra = true;
        indiceTexto = 0;
        indiceControle = 0;
        textoControleFinal = "";
    }
    
    public String gerarIndice(String tmpTexto)
    {
        String textoFinal = "";
        int posicaoAlfabeto = 1;
        boolean loop = true;
        for(int i = 0; i < tmpTexto.length(); i++)//percorre cada letra
        {
            loop = true;
            posicaoAlfabeto = 1;
            textoQuebrado[i] =""+ tmpTexto.charAt(i);
            System.out.println(textoQuebrado[i]);
            while(loop == true)
            {
                if(posicaoAlfabeto < 27)
                {
                    if(textoQuebrado[i].compareTo(alfabetoLetra[posicaoAlfabeto]) == 0)
                    {
                        textoFinal+=posicaoAlfabeto+" ";
                        loop = false;
                    }
                    else posicaoAlfabeto++;
                }
                else
                {
                    loop = false;
                    posicaoAlfabeto++;
                }
            }
        }
        return textoFinal;
    }
    
    public String aplicarRegras(String texto, String tmpRegra, String chave)
    {
        zerarValores();
        System.out.println("Regra:");
        for(int i = 0; i < tmpRegra.length(); i++) //prepara vetor de regra
        {
            regra[i] = tmpRegra.charAt(i);
            novaRegra[i] = ""+ regra[i];
            System.out.println(novaRegra[i]);
        }
        
        String[] textoSeparado = chave.split(" ");
        System.out.println("------------------------------");
        System.out.println("Chave, cada posicao do vetor é uma posicao do alfabeto");
        System.out.println("chaveVetor[i]");
        
        for(int i = 0; i < textoSeparado.length; i++) //prepara vetor de chave
        {
            chaveVetor[i]= Integer.parseInt(textoSeparado[i]);
            System.out.println(chaveVetor[i]);
            
        }
        
        System.out.println("------------------------------");
        System.out.println("Resultado do CONTROLE:");
        System.out.println("textoControle[i]");
        
        textoControleFinal = "";
        for(int i = 0; i < tmpRegra.length(); i++)
        {
            controle += alfabetoLetra[chaveVetor[i]];
            
            textoControle[i] = alfabetoLetra[chaveVetor[i]]; //altera a letra de acordo com a posicao da posicao do vetor
            System.out.println(textoControle[i]);
            //textoFinal+=textoControle[i];
            textoControleFinal+=textoControle[i];
            
        }
        
        Controle.menu.campoControle.setText("");
        Controle.menu.campoControle.setText(textoControleFinal);
        //textoFinal+="|";
        System.out.println("------------------------------");
        System.out.println("Texto do usuário:");
        System.out.println("textoVetor[i]");
        String teste = "";
        for(int i = 0; i < texto.length(); i ++) //imprime na tela o vetor
        {
            textoVetor[i] = ""+texto.charAt(i);
            System.out.println(textoVetor[i]);
        }
        
        indiceControle = 0;
        for(int i = 0; i < texto.length(); i ++) //a cada letra do texto, faz um loop no controle
        {
            System.out.println("Posicao do índice de texto:" +i + ", lendo "+textoVetor[i]);
            encontrouLetra = false;
            while(encontrouLetra != true)
            {
                if(textoVetor[i].compareTo(textoControle[indiceControle]) == 0)
                {
                    textoFinal+=novaRegra[indiceControle];
                    System.out.println("Encontrou letra igual, indo para o proximo indice");
                    System.out.println(" ");
                    System.out.println("------------------------------------");
                    indiceControle = 0;
                    encontrouLetra = true;
                }
                else
                {
                    int limite = contarCaracteresControle();
                    int diferenca = limite - indiceControle;
                    System.out.println("Diferenã: "+diferenca);
                    System.out.println("Não encontrou letra igual dos índices.");
                    if(diferenca > 0)
                    {
                        indiceControle++;
                        System.out.println("Indo para o próximo indice do CONTROLE");
                    }
                    else if(diferenca == 0)
                    {
                        textoFinal+=textoVetor[i];
                        encontrouLetra = true;
                        System.out.println("Fim do indice do controle");
                        
                        System.out.println("Escrevendo "+textoVetor[i]);
                        System.out.println("------------------------------------");
                        indiceControle = 0;
                    }
                }
            }
        }
        return textoFinal;
    }
    
    public int contarCaracteresControle()
    {
        int contador = 0;
        for(int i = 0; i < textoControle.length; i++)
        {
            if(textoControle[i].compareTo("") != 0)
            {
                contador++;
            }
        }
        return contador;
    }
    
    public String obterAlfabeto(String texto)
    {
        
        zerarValores();
        String textoFinal;
        textoFinal = " ";
        
        for (int i = 0; i < texto.length(); i++) 
        {
            char letraAtual = texto.charAt(i);
            if(letraAtual == 'a' || letraAtual == 'A')
            {
                if(alfabeto[0] == 0)
                {
                    textoFinal += "A, ";
                    alfabeto[0] = 1;
                }
                
            }
            else
            if(letraAtual == 'b' || letraAtual == 'B')
            {
                if(alfabeto[1] == 0)
                {
                    textoFinal += "B, ";
                    alfabeto[1] = 1;
                }
            }
            else
            if(letraAtual == 'c' || letraAtual == 'C')
            {
                if(alfabeto[2] == 0)
                {
                    textoFinal += "C, ";
                    alfabeto[2] = 1;
                }
            }
            else
            if(letraAtual == 'd' || letraAtual == 'D')
            {
                if(alfabeto[3] == 0)
                {
                    textoFinal += "D, ";
                    alfabeto[3] = 1;
                }
            }
            else
            if(letraAtual == 'e' || letraAtual == 'E')
            {
                if(alfabeto[4] == 0)
                {
                    textoFinal += "E, ";
                    alfabeto[4] = 1;
                }
            }
            else
            if(letraAtual == 'f' || letraAtual == 'F')
            {
                if(alfabeto[5] == 0)
                {
                    textoFinal += "F, ";
                    alfabeto[5] = 1;
                }
            }
            else
            if(letraAtual == 'g' || letraAtual == 'G')
            {
                if(alfabeto[6] == 0)
                {
                    textoFinal += "G, ";
                    alfabeto[6] = 1;
                }
            }
            else
            if(letraAtual == 'h' || letraAtual == 'H')
            {
                if(alfabeto[7] == 0)
                {
                    textoFinal += "H, ";
                    alfabeto[7] = 1;
                }
            }
            else
            if(letraAtual == 'i' || letraAtual == 'I')
            {
                if(alfabeto[8] == 0)
                {
                    textoFinal += "I, ";
                    alfabeto[8] = 1;
                }
            }
            else
            if(letraAtual == 'j' || letraAtual == 'J')
            {
                if(alfabeto[9] == 0)
                {
                    textoFinal += "J, ";
                    alfabeto[9] = 1;
                }
            }
            else
            if(letraAtual == 'k' || letraAtual == 'K')
            {
                if(alfabeto[10] == 0)
                {
                    textoFinal += "K, ";
                    alfabeto[10] = 1;
                }
            }
            else
            if(letraAtual == 'l' || letraAtual == 'L')
            {
                if(alfabeto[11] == 0)
                {
                    textoFinal += "L, ";
                    alfabeto[11] = 1;
                }
            }
            else
            if(letraAtual == 'm' || letraAtual == 'M')
            {
                if(alfabeto[12] == 0)
                {
                    textoFinal += "M, ";
                    alfabeto[12] = 1;
                }
            }
            else
            if(letraAtual == 'n' || letraAtual == 'N')
            {
                if(alfabeto[13] == 0)
                {
                    textoFinal += "N, ";
                    alfabeto[13] = 1;
                }
            }
            else
            if(letraAtual == 'o' || letraAtual == 'O')
            {
                if(alfabeto[14] == 0)
                {
                    textoFinal += "O, ";
                    alfabeto[14] = 1;
                }
            }
            else
            if(letraAtual == 'p' || letraAtual == 'P')
            {
                if(alfabeto[15] == 0)
                {
                    textoFinal += "P, ";
                    alfabeto[15] = 1;
                }
            }
            else
            if(letraAtual == 'q' || letraAtual == 'Q')
            {
                if(alfabeto[16] == 0)
                {
                    textoFinal += "Q, ";
                    alfabeto[16] = 1;
                }
            }
            else
            if(letraAtual == 'r' || letraAtual == 'R')
            {
                if(alfabeto[17] == 0)
                {
                    textoFinal += "R, ";
                    alfabeto[17] = 1;
                }
            }
            else
            if(letraAtual == 's' || letraAtual == 'S')
            {
                if(alfabeto[18] == 0)
                {
                    textoFinal += "S, ";
                    alfabeto[18] = 1;
                }
            }
            else
            if(letraAtual == 't' || letraAtual == 'T')
            {
                if(alfabeto[19] == 0)
                {
                    textoFinal += "T, ";
                    alfabeto[19] = 1;
                }
            }
            else
            if(letraAtual == 'u' || letraAtual == 'U')
            {
                if(alfabeto[20] == 0)
                {
                    textoFinal += "U, ";
                    alfabeto[20] = 1;
                }
            }
            else
            if(letraAtual == 'v' || letraAtual == 'V')
            {
                if(alfabeto[21] == 0)
                {
                    textoFinal += "V, ";
                    alfabeto[21] = 1;
                }
            }
            else
            if(letraAtual == 'w' || letraAtual == 'W')
            {
                if(alfabeto[22] == 0)
                {
                    textoFinal += "W, ";
                    alfabeto[22] = 1;
                }
            }
            else
            if(letraAtual == 'x' || letraAtual == 'X')
            {
                if(alfabeto[23] == 0)
                {
                    textoFinal += "X, ";
                    alfabeto[23] = 1;
                }
            }
            else
            if(letraAtual == 'y' || letraAtual == 'Y')
            {
                if(alfabeto[24] == 0)
                {
                    textoFinal += "Y, ";
                    alfabeto[24] = 1;
                }
            }
            else
            if(letraAtual == 'z' || letraAtual == 'Z')
            {
                if(alfabeto[25] == 0)
                {
                    textoFinal += "Z, ";
                    alfabeto[25] = 1;
                }
            }
        }
        return textoFinal;
    }
    
  
    public void zerarValores()
    {
        controle = "";
        for(int i = 0; i < alfabeto.length; i++)
        {
            chaveVetor[i] = 0;
            alfabeto[i] = 0;
            novaRegra[i] = "";
            regra[i] = ' ';
            textoControle[i] = "";
            textoVetor[i] = "";
            textoFinal = "";
            textoQuebrado[i] = "";
        }
    }
    
    public int verificarLetraValida(String tmpLetra)
    {
        for(int i = 0; i < alfabetoLetra.length; i++)
        {
            if(tmpLetra.compareTo(tmpLetra) == 0)
            {
                return 1;
            }
        }
        return 0;
    }
}