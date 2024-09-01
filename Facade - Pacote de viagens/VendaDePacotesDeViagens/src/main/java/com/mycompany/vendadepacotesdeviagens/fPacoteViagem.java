/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vendadepacotesdeviagens;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 55649
 */
public class fPacoteViagem {
    private ReservaPassagemAerea passagem;
    private ReservaHotel hotel;
    private AluguelCarro carro;
    private MetodoPagamento pagamento;

    public fPacoteViagem() {
        this.passagem = new ReservaPassagemAerea();
        this.hotel = new ReservaHotel();
        this.carro = new AluguelCarro();
        this.pagamento = new MetodoPagamento();
    }

    public void escolherPassagem(String classeVoo, String assento) {
        passagem.escolherPassagem(classeVoo, assento);
    }

    public void reservarHotel(String tipoQuarto, int numeroPessoas) {
        hotel.reservarHotel(tipoQuarto, numeroPessoas);
    }

    public void alugarCarro(String tipoCarro) {
        carro.alugarCarro(tipoCarro); 
    }

    public void efetuarPagamento(String metodoPagamento, int parcelas, Cliente[] compradores) {
        double valorBase = calcularValorBase();
        double valorFinal = pagamento.calcularValorPacote(
            passagem.getClasseVoo(), 
            hotel.getTipoQuarto(), 
            carro.getTipoCarro(), 
            hotel.getNumeroPessoas(), 
            parcelas, 
            metodoPagamento
        );

        System.out.println("\n=== Dados dos Compradores ===");
        for (Cliente comprador : compradores) {
            System.out.println("Nome: " + comprador.getNome() + ", CPF: " + comprador.getCpf());
        }

        System.out.println("\n=== Detalhes da Compra ===");
        System.out.println("Valor Total do Pacote: R$ " + valorBase);
        System.out.println("Valor Final com Descontos/Juros: R$ " + valorFinal);

        pagamento.processarPagamento(metodoPagamento, valorFinal, parcelas);
    }

    private double calcularValorBase() {
        double valorVoo = passagem.getPrecoPassagem();
        double valorHotel = hotel.getPrecoHotel();
        double valorCarro = carro.getPrecoCarro();

        return valorVoo + valorHotel + valorCarro;
    }
}



