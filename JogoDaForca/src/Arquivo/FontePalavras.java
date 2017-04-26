package Arquivo;

import interface_grafica.Erro;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import jogodaforca.Palavra;

/**
 *
 * @author LT
 */
public class FontePalavras {
    //Escrita
    private static FileOutputStream arquivoEscrita;
    private static PrintWriter escritor;
    //Leirura
    private static FileInputStream arquivoLeirura;
    private static InputStreamReader input;
    private static BufferedReader leitor;
    
    private static void conectarArquivoLeitura(String nomeArquivo)throws Exception{
        arquivoLeirura = new FileInputStream(nomeArquivo);
        input = new InputStreamReader(arquivoLeirura);
        leitor = new BufferedReader(input);
    }
    
    private static void conectarArquivoEscrita(String nomeArquivo)throws Exception{
        arquivoEscrita = new FileOutputStream(nomeArquivo);
        escritor = new PrintWriter(nomeArquivo);
    }
    
    private static void finalizarConexaoLeitura() throws Exception{
        leitor.close();
        input.close();
        arquivoLeirura.close();
    }
    
    private static void finalizarConexaoEscrita() throws Exception{
        escritor.close();
        arquivoEscrita.close();
    }
    
    public static ArrayList<Palavra> LerArquivo() throws Exception{
        //Preparando para a leitura do arquivo
        conectarArquivoLeitura("Palavras.txt");
        String[] array = new String[5];
        ArrayList<Palavra> lista = new ArrayList<Palavra>();
        String linha;
        do{
            linha = leitor.readLine();
            if(linha != null){
                array = linha.split("\t");
                lista.add(new Palavra(Integer.parseInt(array[0]),array[1], array[2], array[3],array[4]));
            }
        }while(linha != null);
        finalizarConexaoLeitura();
        return lista;        
    }
    
    public static int getRecordeLivre(){
        try {
            int recorde = 0;
            String[] array = new String[2];
            String linha;
            
            conectarArquivoLeitura("Recordes.txt");
            linha = leitor.readLine();
            if(linha != null){
                array = linha.split(": ");
                recorde = Integer.parseInt(array[1]);
            }
            finalizarConexaoLeitura();
            return recorde;
        } catch (Exception ex) {
            new Erro(null,"Erro ao recuperar informações.").setVisible(true);
            return -1;
        }
    }
    
    public static void setRecordeLivre(int novoRecorde){
        try {
            conectarArquivoEscrita("Recordes.txt");
            
            escritor.println("Recorde Livre: "+novoRecorde);
            
            finalizarConexaoEscrita();
        } catch (Exception ex) {
            new Erro(null,"Erro ao recuperar informações.").setVisible(true);
        }
    }
}
