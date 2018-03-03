package pooado01;

/**
 *
 * @author Marcelo Pereira <marcelo.pereira@rerum.com.br>
 */
public class Regiao {
    
    private int idRegiao;
    private String nome;
    private float pib;
    private int qtdEstados;

    public Regiao() {
        
    }

    public int getIdRegiao() {
        return idRegiao;
    }

    public void setIdRegiao(int idRegiao) {
        this.idRegiao = idRegiao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPib() {
        return pib;
    }

    public void setPib(float pib) {
        this.pib = pib;
    }

    public int getQtdEstados() {
        return qtdEstados;
    }

    public void setQtdEstados(int qtdEstados) {
        this.qtdEstados = qtdEstados;
    }
    
    
    
}
