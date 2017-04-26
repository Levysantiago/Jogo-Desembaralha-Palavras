package niveis_de_jogo;

import interfaces.Organizadora;
import java.util.ArrayList;
import java.util.Random;
import jogodaforca.Palavra;

/**
 *
 * @author LT
 */
public class Dificil implements Organizadora{
    @Override
    public Palavra retornaPalavraAleatoria(ArrayList<Palavra> lista) {
        int tamLista = lista.size();
        int random,i=0,k=0;
        ArrayList<Palavra> listaDificil = new ArrayList<Palavra>();
        Palavra palavra;
        Random rd = new Random();
        random = rd.nextInt(20);
        while(k < tamLista){
            if(lista.get(k).getNivel() == 3){
                listaDificil.add(lista.get(k));
            }
            k++;
        }
        tamLista = listaDificil.size();
        while(i < tamLista && i < random){
            i++;
        }
        palavra = new Palavra(listaDificil.get(i).getNivel(),listaDificil.get(i).getLetras(),listaDificil.get(i).getDica(),
                              listaDificil.get(i).getResposta(),listaDificil.get(i).getCategoria());
        return palavra;
    }
}
