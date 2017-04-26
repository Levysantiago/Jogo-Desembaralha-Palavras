package jogodaforca;

import interface_grafica.Erro;
import interface_grafica.GUI_Principal;
import interface_grafica.Ganhar;
import interface_grafica.Perder;
import interface_grafica.PreJogo;
import interfaces.MotorDoJogo;
import modos_de_jogo.Carreira;

/**
 *
 * @author Levy Santiago e Tulio Campos
 */
public class Principal {
    public static void main(String args[]){        
        GUI_Principal gui = new GUI_Principal();
        Dados_GUIPrincipal dados = new Dados_GUIPrincipal();
        PreJogo preJogo = new PreJogo(gui);
        MotorDoJogo motor;
        boolean flagFim = false;
        String resposta = "";
        
        do{//JOGO
            preJogo.setVisible(true);
            preJogo.inicializaDados();
            preJogo.setEnabled(true);
            while(!gui.isActive());//Espera até que a tela de jogo seja aberta
            motor = BaseMotorDoJogo.retornaBaseMotorDoJogo(preJogo, gui);
            //INICIO DE JOGO
            do{//Laço da GUI_Principal
                //GERANDO DADOS NA TELA DO JOGO
                dados = motor.gerarDados();
                gui.getLb_jogador().setText(dados.getNome());
                gui.getLb_palavra().setText(dados.getLetras());
                gui.getLb_tamanho().setText(dados.getTamanho());
                gui.getLb_dica().setText(dados.getDica());
                gui.getLb_nivel().setText(dados.getNivel());
                gui.getLb_pontos().setText(dados.getPontos());
                gui.getLb_erros().setText(dados.getErros());
                if(motor instanceof Carreira){
                    gui.getLb_recorde().setVisible(false);
                }else{
                    gui.getLb_recorde().setVisible(true);
                    gui.getLb_recorde().setText(dados.getRecorde());
                }
                
                do{//Tratando do campo resposta
                    while(!gui.getBtn_verificar().isSelected());//ESPERA ATÉ O BOTÃO SER ACIONADO
                    if(!gui.isActive()){
                        gui.getBtn_verificar().setSelected(false);
                        break;
                    }
                    gui.getBtn_verificar().setSelected(false); //DESSELECIONA O BOTÃO
                    resposta = gui.getTf_resposta().getText(); //RECEBE RESPOSTA DO JOGADOR
                    if(resposta.length() < 1){
                        new Erro(gui,"Insira uma resposta por favor.").setVisible(true);
                    }
                }while(resposta.length() < 1);
                //System.out.println("Resposta: "+resposta); //Imprime a resposta correta
                gui.setTf_resposta("");
                if(!gui.isActive()){
                    break;
                }
                flagFim = motor.decideFim(resposta); //O MOTOR DO JOGO DECIDE SE É O FIM DO JOGO
            }while(!flagFim);
            if(gui.isActive()){
                //FIM DE JOGO
                String mensagemFinal;
                mensagemFinal = motor.informacaoFinal();
                if(motor.verificaJanelaVitoria()){
                    Ganhar ganhar = new Ganhar(gui,preJogo);
                    ganhar.setVisible(true);
                    ganhar.setLb_conquista(mensagemFinal);
                    while(!ganhar.getBtn_menuG().isSelected());
                }else{
                    Perder perder = new Perder(gui,preJogo);
                    perder.setVisible(true);
                    perder.setLb_informacao(mensagemFinal);
                    while(!perder.getBtn_menuP().isSelected());
                }
                gui.setVisible(false);
            }
        }while(true);
    }
}


