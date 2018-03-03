package pooado01;

/**
 *
 * @author Marcelo Pereira <marcelo.pereira@rerum.com.br>
 */
public class Estado {
    private String nome;
    private float pib;
    private float pibP;
    private int regiao;
    
    public Estado(){
        
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

    public int getRegiao() {
        return regiao;
    }

    public void setRegiao(int regiao) {
        this.regiao = regiao;
    }

    public float getPibP() {
        return pibP;
    }

    public void setPibP(float pibP) {
        this.pibP = pibP;
    }
    
    
}
