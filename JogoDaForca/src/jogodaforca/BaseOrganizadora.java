package jogodaforca;

import interface_grafica.Erro;
import niveis_de_jogo.Dificil;
import niveis_de_jogo.Facil;
import niveis_de_jogo.Medio;
import interfaces.Organizadora;
import interface_grafica.PreJogo;
/**
 *
 * @author LT
 */
public class BaseOrganizadora {
    
    public static Organizadora retornaOrganizadora(int nivel){
        if(nivel == 1){
            return new Facil();
        }else if(nivel == 2){
            return new Medio();
        }else if(nivel == 3){
            return new Dificil();
        }
        new Erro(null,"Erro ao recuperar informações.").setVisible(true);
        return null;
    }
}
