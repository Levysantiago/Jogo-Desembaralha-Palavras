package interfaces;

import jogodaforca.Dados_GUIPrincipal;
import jogodaforca.Palavra;

/**
 *
 * @author LT
 */
public interface MotorDoJogo {
    public Dados_GUIPrincipal gerarDados();
    public boolean verificaJanelaVitoria();
    public boolean decideFim(String resposta);
    public int retornarNivel();
    public Palavra capturarPalavra();
    public boolean verificarResposta(String resposta);
    public String informacaoFinal();
}
