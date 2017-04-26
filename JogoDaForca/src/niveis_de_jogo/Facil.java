package niveis_de_jogo;

import interfaces.Organizadora;
import java.util.ArrayList;
import java.util.Random;
import jogodaforca.Palavra;

/**
 *
 * @author LT
 */
public class Facil implements Organizadora{

    @Override
    public Palavra retornaPalavraAleatoria(ArrayList<Palavra> lista) {
        int tamLista = lista.size();
        int random,i=0,k=0;
        ArrayList<Palavra> listaFacil = new ArrayList<Palavra>();
        Palavra palavra;
        Random rd = new Random();
        random = rd.nextInt(20);
        while(k < tamLista){
            if(lista.get(k).getNivel() == 1){
                listaFacil.add(lista.get(k));
            }
            k++;
        }
        tamLista = listaFacil.size();
        while(i < tamLista && i < random){
            i++;
        }
        palavra = new Palavra(listaFacil.get(i).getNivel(),listaFacil.get(i).getLetras(),listaFacil.get(i).getDica(),
                              listaFacil.get(i).getResposta(),listaFacil.get(i).getCategoria());
        return palavra;
    }
    
}
