package modos_de_jogo;

import Arquivo.FontePalavras;
import interface_grafica.Erro;
import interface_grafica.GUI_Principal;
import interface_grafica.PreJogo;
import interfaces.MotorDoJogo;
import interfaces.Organizadora;
import java.util.ArrayList;
import jogodaforca.BaseOrganizadora;
import jogodaforca.Dados_GUIPrincipal;
import jogodaforca.Palavra;

/**
 *
 * @author LT
 */
public class Carreira implements MotorDoJogo{
    private static final int PALAVRAS_pNivel = 5;//Quantidade de palavras por nivel
    private GUI_Principal gui;
    private PreJogo preJogo;
    private Palavra palavra;
    private int pontos;
    private int nivel;
    private int erros;
    private String nome;
    
    public Carreira(GUI_Principal gui,PreJogo preJogo){
        this.gui = gui;
        this.preJogo = preJogo;
        this.pontos = 0;
        this.nome = preJogo.getTf_nome().getText();
        this.nivel = retornarNivel();
        this.erros = 3;
    }
    
    @Override
    public Dados_GUIPrincipal gerarDados() {
        palavra = capturarPalavra();
        Dados_GUIPrincipal dados = null;
        if(palavra != null){
            dados = new Dados_GUIPrincipal();
            dados.setNome(nome);
            dados.setLetras(palavra.getLetras());
            dados.setPontos(pontos+"");
            dados.setTamanho(palavra.getResposta().length()+"");
            dados.setDica(palavra.getDica());
            dados.setNivel(nivel+"");
            dados.setErros(erros+"");
        }else{
            new Erro(preJogo,"Erro ao recuperar informações.").setVisible(true);
        }
        return dados;
    }

    @Override
    public boolean verificaJanelaVitoria() {
        boolean val = false;
        if(nivel > 2 && pontos > PALAVRAS_pNivel-1){
            val = true;
        }
        return val;
    }

    @Override
    public boolean decideFim(String resposta) {
        boolean fim = false;
        if(verificarResposta(resposta)){
            contabilizarPontos();
            if(nivel < 3 && pontos > PALAVRAS_pNivel-1){
                nivel++;
                pontos = 0;
            }
            else if(nivel > 2 && pontos > PALAVRAS_pNivel-1){
                fim = true;
            }
        }else{
            contabilizaErros();
            if(erros < 1){
                fim = true;
            }
        }
        return fim;
    }

    @Override
    public int retornarNivel() {
        return 1;
    }

    @Override
    public Palavra capturarPalavra() {
        ArrayList<Palavra> lista = new ArrayList<Palavra>();
        Palavra novaPalavra;
        Organizadora org;
        
        if(nivel != 0){
            try {
                lista = FontePalavras.LerArquivo();
            } catch (Exception ex) {
                new Erro(null,"Erro ao recuperar informações.").setVisible(true);
            }
        }else{
            return null;
        }
        org = BaseOrganizadora.retornaOrganizadora(nivel);
        novaPalavra = org.retornaPalavraAleatoria(lista);
        
        return novaPalavra;
    }

    @Override
    public boolean verificarResposta(String resposta) {
        resposta = resposta.toUpperCase();
        return resposta.equals(palavra.getResposta());
    }

    @Override
    public String informacaoFinal() {
        String msg;
        if(verificaJanelaVitoria()){
            msg = "Você conseguiu zerar o jogo!";
        }else{
            msg = "Você não conseguiu zerar o jogo.";
        }
        return msg;
    }
    
    private void contabilizarPontos(){
        this.pontos++;
    }
    
    private void contabilizaErros(){
        this.erros--;
    }
    
}
