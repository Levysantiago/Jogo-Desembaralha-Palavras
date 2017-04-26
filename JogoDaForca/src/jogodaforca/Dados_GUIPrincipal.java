package jogodaforca;

/**
 *
 * @author LT
 */
public class Dados_GUIPrincipal {
    private String nome;
    private String letras;
    private String tamanho;
    private String dica;
    private String nivel;
    private String pontos;
    private String erros;
    private String recorde;
    
    public Dados_GUIPrincipal(){
        this.nome = "";
        this.letras = "XXXXX";
        this.tamanho = "X";
        this.dica = "XXXXXX";
        this.nivel = "0";
        this.pontos = "00";
        this.erros = "00";
        this.recorde = "00";
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLetras() {
        return letras;
    }

    public void setLetras(String letras) {
        this.letras = letras;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getDica() {
        return dica;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getPontos() {
        return pontos;
    }

    public void setPontos(String pontos) {
        this.pontos = pontos;
    }

    public String getErros() {
        return erros;
    }

    public void setErros(String erros) {
        this.erros = erros;
    }

    public String getRecorde() {
        return recorde;
    }

    public void setRecorde(String recorde) {
        this.recorde = recorde;
    }
    
    
}
