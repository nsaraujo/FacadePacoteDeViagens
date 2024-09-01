/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vendadepacotesdeviagens;

import java.util.Scanner;

/**
 *
 * @author 55649
 */
public class VendaDePacotesDeViagens { 
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o numero de compradores: ");
        int numCompradores = scanner.nextInt();
        scanner.nextLine();
        Cliente[] compradores = new Cliente[numCompradores];

        for (int i = 0; i < numCompradores; i++) {
            System.out.print("Digite o nome do comprador " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            System.out.print("Digite o CPF do comprador " + (i + 1) + ": ");
            String cpf = scanner.nextLine();
            compradores[i] = new Cliente(nome, cpf);
        }

        System.out.print("\nEscolha a classe de voo (Economica, Executiva, 1a Classe): ");
        String classeVoo = scanner.nextLine();

        System.out.print("Escolha o assento (ex: 12A): ");
        String assento = scanner.nextLine();

        System.out.print("Escolha o tipo de quarto (Simples, Executivo, Suite Presidencial): ");
        String tipoQuarto = scanner.nextLine();

        System.out.print("Numero de pessoas: ");
        int numeroPessoas = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Escolha o tipo de carro (Economico, Executivo, Luxo): ");
        String tipoCarro = scanner.nextLine();

        System.out.print("Escolha o metodo de pagamento (Pix, Boleto, Debito, Credito): ");
        String metodoPagamento = scanner.nextLine();

        int parcelas = 1;
        if ("Crédito".equals(metodoPagamento)) {
            System.out.print("Numero de parcelas (1 a 6): ");
            parcelas = scanner.nextInt();
        }

        fPacoteViagem pacoteViagem = new fPacoteViagem();

        pacoteViagem.escolherPassagem(classeVoo, assento);
        
        pacoteViagem.reservarHotel(tipoQuarto, numeroPessoas);

        pacoteViagem.alugarCarro(tipoCarro);
 
        pacoteViagem.efetuarPagamento(metodoPagamento, parcelas, compradores);

        scanner.close();
    }
}



