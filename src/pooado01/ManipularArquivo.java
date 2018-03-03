package pooado01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcelo Pereira <marcelo.pereira@rerum.com.br>
 */
public class ManipularArquivo {

    private String linha;

    public List<Estado> estados(String arq) {

        // Tive que aumentar o tamanho do vetor para não estourar nos ifs abaixo, não consegui tratar e o tempo estava correndo
        String[] listRegiao = {"Norte", "Nordeste", "Sudeste", "Sul", "Centro-Oeste"};
        List<String> listaEstado = new ArrayList<>();
        List<Estado> estados = new ArrayList<>();
        String[] dadosPib = new String[estados.size()];
        List<Regiao> regioes = new ArrayList<>();
        String separador = ";";
        Estado est = null;
        Regiao reg = null;
        String arqSaida = ".\\saida.txt";
        float pib = 0;
        int aux = 0;

        try {

            FileReader lerArquivo = new FileReader(arq);
            BufferedReader bufferArquivo = new BufferedReader(lerArquivo);

            FileReader lerArquivopib = new FileReader(".\\pib.txt");
            BufferedReader bufferArquivoPib = new BufferedReader(lerArquivopib);

            while ((linha = bufferArquivo.readLine()) != null) {

//                Adiciona os nomes dos estados em uma lista do tipo String - Aqui apenas os estados são incluídos, assim como também os espaços em branco
//                Eles são usados como condicional nos laços abaixo
                if (!linha.equalsIgnoreCase(listRegiao[aux])) {
                    listaEstado.add(linha);
                    if (!linha.equals("")) {
                    }
                }
                if (linha.equals("")) {
                    aux++;
                }
            }
            bufferArquivo.close();

//          Preenche a lista Regioes com os dados do vetor listRegiao
            for (int i = 0; i < listRegiao.length; i++) {
                reg = new Regiao();
                reg.setIdRegiao(i + 1);
                reg.setNome(listRegiao[i]);
                regioes.add(reg);
            }

//            Cria os objetos do tipo Estado e colocam eles no Array do mesmo tipo.
            aux = 0;
            for (int i = 0; i < listaEstado.size(); i++) {
                est = new Estado();
                if (!listaEstado.get(i).equals("")) {
                    est.setNome(listaEstado.get(i));
                    est.setRegiao(regioes.get(aux).getIdRegiao());
                    estados.add(est);
                } else {
                    aux++;
                }
            }

//            Atualiza Lista Regioes adicionando a quantidade de estados por Região - pode ser útil para o cálculo
            for (int i = 0; i < regioes.size(); i++) {
                aux = 0;

                for (int j = 0; j < estados.size(); j++) {
                    if (estados.get(j).getRegiao() == (i + 1)) {
                        aux++;
                    }
                }
                regioes.get(i).setQtdEstados(aux);
            }

//            Aqui vou criar uma nova chamada para ler o arquivo pib.txt
//            nele vou ler o arquivo e criar um vetor e a partir desse vetor popular o valor do PIB no Array Estados
            while ((linha = bufferArquivoPib.readLine()) != null) {
                dadosPib = linha.split(separador);
                for (int i = 0; i < estados.size(); i++) {
                    String uf = estados.get(i).getNome();
                    if (uf.equalsIgnoreCase(dadosPib[0])) {
                        estados.get(i).setPib(Float.parseFloat(dadosPib[1]));
                        break;
                    }
                }
            }
            bufferArquivoPib.close();

            for (int i = 0; i < estados.size(); i++) {
                pib += estados.get(i).getPib();
            }
            System.out.println("Pib Total: " + pib);

//                 Calculando o percentual por estado
            for (int i = 0; i < estados.size(); i++) {
                estados.get(i).setPibP((estados.get(i).getPib() / pib) * 100);
            }

//                              for(int i = 0; i < estados.size(); i++){
//                     System.out.println(estados.get(i).getNome() + " - " + estados.get(i).getPib() + " - " + estados.get(i).getPibP() + "%");
//                 }
//             Calcular total do pib por região
            aux = 1;

            for (int i = 0; i < regioes.size(); i++) {
                pib = 0;
                for (int j = 0; j < estados.size(); j++) {
                    float paux = estados.get(j).getPib(); // não consegui identifica o motivo de não somar sem precisar de uma variável auxiliar.
                    if (estados.get(j).getRegiao() == aux) { // estava tentando somar o valor do objeto com a var pib, mas não somava tudo
                        pib =pib + paux;
                    }
                }
                regioes.get(i).setPib(pib);
                aux++;
            }
//            System.out.println("Pib Total: " + pib);

//                 Criando arquivo com os dados solicitados
            try {

                FileWriter fileWriter = new FileWriter(arqSaida);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

//            bufferedWriter.write("pib da regiao Y = $$$$");
                for (int i = 0; i < regioes.size(); i++) {
                    bufferedWriter.write("pib da regiao " + regioes.get(i).getNome() + " = " + regioes.get(i).getPib());
                    bufferedWriter.newLine();
                }
                

                // feche o arquivo
                bufferedWriter.close();
            } catch (IOException ex) {
                System.out.println("Erro de escrita em '" + arqSaida + "'");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo inexistente: '" + arq + "'");
        } catch (IOException ex) {
            System.out.println("Erro lendo o arquivo '" + arq + "'");
        }

        return estados;
    }

}
