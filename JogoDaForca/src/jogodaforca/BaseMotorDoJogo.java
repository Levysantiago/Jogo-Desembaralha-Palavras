package jogodaforca;

import interface_grafica.GUI_Principal;
import interface_grafica.PreJogo;
import interfaces.MotorDoJogo;
import modos_de_jogo.Carreira;
import modos_de_jogo.Livre;

/**
 *
 * @author LT
 */
public class BaseMotorDoJogo{
    private static MotorDoJogo modo;
  
    public static MotorDoJogo retornaBaseMotorDoJogo (PreJogo preJogo, GUI_Principal gui){
        switch (preJogo.getJcb_modos().getSelectedIndex()) {
            case 1:{
                modo = new Livre(gui,preJogo);
                break;
            }
            case 2:{
                modo = new Carreira(gui,preJogo);
                break;
            }
            default:{
                modo = null;
                break;
            }
        }
        return modo;
    }
 }
