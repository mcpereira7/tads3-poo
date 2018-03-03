/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooado01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Marcelo Pereira <marcelo.pereira@rerum.com.br>
 */
public class Teste {

    public static void main(String[] args) throws FileNotFoundException {

//        File file = new File("..\\regioes.txt");
//        Scanner sc = new Scanner(file);
//        int qtd = 0;
//        while(sc.hasNextLine()){
//         //System.out.println(sc.nextLine());
//        qtd++;
//        }
//        System.out.println(qtd);

int[] array;//declaração do nosso array
        array = new int[10]; //cria e reserva o espaço para o nosso array
        System.out.printf("%s%10s\n", " _______", " ________ ");
        System.out.printf("%s%10s\n", "|Indice "  ,"| Valores|");
        System.out.printf("%s%10s\n", "|---", "||");
        for ( int i = 0; i <= 9; i++ ) {
            System.out.printf("|%5d%3s%7d |\n", i, " |", array[i]);
        }
        System.out.printf("%s%10s\n", "|---", "||");
    
    }
}
