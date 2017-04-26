package niveis_de_jogo;

import interfaces.Organizadora;
import java.util.ArrayList;
import java.util.Random;
import jogodaforca.Palavra;

/**
 *
 * @author LT
 */
public class Medio implements Organizadora{
    
    @Override
    public Palavra retornaPalavraAleatoria(ArrayList<Palavra> lista) {
        int tamLista = lista.size();
        int random,i=0,k=0;
        ArrayList<Palavra> listaMedio = new ArrayList<Palavra>();
        Palavra palavra;
        Random rd = new Random();
        random = rd.nextInt(20);
        while(k < tamLista){
            if(lista.get(k).getNivel() == 2){
                listaMedio.add(lista.get(k));
            }
            k++;
        }
        tamLista = listaMedio.size();
        while(i < tamLista && i < random){
            i++;
        }
        palavra = new Palavra(listaMedio.get(i).getNivel(),listaMedio.get(i).getLetras(),listaMedio.get(i).getDica(),
                              listaMedio.get(i).getResposta(),listaMedio.get(i).getCategoria());
        return palavra;
    }
}
