/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodaforca;

/**
 *
 * @author LT
 */
public class Palavra {
    private int nivel;
    private String letras;
    private String dica;
    private String resposta;
    private String categoria;
    private static int quantidade;

    public Palavra(int nivel, String letras, String dica, String resposta, String categoria) {
        this.nivel = nivel;
        this.letras = letras;
        this.dica = dica;
        this.resposta = resposta;
        this.categoria = categoria;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setLetras(String letras) {
        this.letras = letras;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public static void setQuantidade(int quantidade) {
        Palavra.quantidade = quantidade;
    }

    public String getLetras() {
        return letras;
    }

    public int getNivel() {
        return nivel;
    }

    public String getDica() {
        return dica;
    }

    public String getResposta() {
        return resposta;
    }

    public String getCategoria() {
        return categoria;
    }

    public static int getQuantidade() {
        return quantidade;
    }
    
    
    
}
