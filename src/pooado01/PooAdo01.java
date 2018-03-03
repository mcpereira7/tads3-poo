package pooado01;

import java.util.List;

/**
 *
 * @author Marcelo Pereira <marcelo.pereira@rerum.com.br>
 */
public class PooAdo01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String arquivo = ".\\regioes.txt";
        String sinal = "%";
        ManipularArquivo marq = new ManipularArquivo();
        List<Estado> estados = marq.estados(arquivo);
        
        for(int i = 0; i< estados.size(); i++){
//            System.out.printf(estados.get(i).getNome() + "   -   %.2f%s\n", estados.get(i).getPibP(), sinal);
            System.out.printf("%20s%3s%.2f\n", estados.get(i).getNome()," = ",estados.get(i).getPibP() );
        }
        
        System.out.println("Arquivo saida.txt criado com sucesso!");
        
//        for(Regiao s : regiao){
//            System.out.println(s.getNome() + " QtdEstados: " + s.getQtdEstados());
//        }
    }
    
}
