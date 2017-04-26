package modos_de_jogo;

import interface_grafica.GUI_Principal;
import interface_grafica.PreJogo;
import interfaces.MotorDoJogo;
import interfaces.Organizadora;
import java.util.ArrayList;
import jogodaforca.BaseOrganizadora;
import niveis_de_jogo.Dificil;
import niveis_de_jogo.Facil;
import Arquivo.FontePalavras;
import interface_grafica.Erro;
import jogodaforca.Dados_GUIPrincipal;
import niveis_de_jogo.Medio;
import jogodaforca.Palavra;

/**
 *
 * @author LT
 */
public class Livre implements MotorDoJogo{
    private GUI_Principal gui;
    private PreJogo preJogo;
    private Palavra palavra;
    private int nivel;
    private int recorde;
    private int pontos;
    private int erros;
    private String nome;
    
    public Livre(GUI_Principal gui,PreJogo preJogo){
        this.gui = gui;
        this.preJogo = preJogo;
        nome = preJogo.getTf_nome().getText();
        nivel = retornarNivel();
        recorde = FontePalavras.getRecordeLivre();
        pontos = 0;
        erros = 3;
    }
    
    @Override
    public Dados_GUIPrincipal gerarDados(){
        palavra = capturarPalavra();
        Dados_GUIPrincipal dados = null;
        if(palavra != null){
            dados = new Dados_GUIPrincipal();
            dados.setNome(nome);
            dados.setLetras(palavra.getLetras());
            dados.setTamanho(palavra.getResposta().length()+"");
            dados.setDica(palavra.getDica());
            dados.setNivel(nivel+"");
            dados.setPontos(pontos+"");
            dados.setErros(erros+"");
            dados.setRecorde(recorde+"");
        }else{
            new Erro(preJogo,"Erro ao recuperar informações.").setVisible(true);
        }
        return dados;
    }
    
    @Override
    public boolean verificaJanelaVitoria(){
        return verificaRecorde();
    }
    
    @Override
    //True se for pra chamar a interface Ganhar
    //False se for pra chamar a interface Perder
    public String informacaoFinal(){
        String msg;
        if(verificaJanelaVitoria()){
            msg = "Bateu o recorde! Novo recorde: "+pontos;
            FontePalavras.setRecordeLivre(pontos);
        }else{
            msg = "Você não conseguiu bater o recorde: "+recorde;
        }
        return msg;
    }
    
    /*Retorna true se for o final do jogo e false se for pra continuar*/
    @Override
    public boolean decideFim(String resposta){
        boolean fim = false;
        if(verificarResposta(resposta)){
            contabilizarPontos();
        }else{
            contabilizaErros();
            if(erros < 1){
                fim = true;
            }
        }
        return fim;
    }
    
    /*Retorna true se bateu o recorde, false caso contrário*/
    public boolean verificaRecorde(){
        boolean val = false;
        if(pontos > recorde){
            val = true;
        }
        return val;
    }
    
    @Override
    public int retornarNivel(){
        if(preJogo.getJb_facil().isSelected()){
            return 1;
        }else if(preJogo.getJb_medio().isSelected()){
            return 2;
        }else if(preJogo.getJb_dificil().isSelected()){
            return 3;
        }else{//orgNivel == NULL
            new Erro(preJogo,"Erro ao recuperar informações.").setVisible(true);
            return 0;
        }
    }
    
    @Override
    public Palavra capturarPalavra(){
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
        //Capturando palavra
        org = BaseOrganizadora.retornaOrganizadora(nivel);
        novaPalavra = org.retornaPalavraAleatoria(lista);
        
        return novaPalavra;
    }
    
    /*Retorna true se acertou e false se errou*/
    @Override
    public boolean verificarResposta(String resposta){
        resposta = resposta.toUpperCase();
        return resposta.equals(palavra.getResposta());
    }
    
    private void contabilizarPontos(){
        this.pontos++;
    }
    
    private void contabilizaErros(){
        this.erros--;
    }

    public int getPontos() {
        return pontos;
    }

    public int getRecorde() {
        return recorde;
    }
}
