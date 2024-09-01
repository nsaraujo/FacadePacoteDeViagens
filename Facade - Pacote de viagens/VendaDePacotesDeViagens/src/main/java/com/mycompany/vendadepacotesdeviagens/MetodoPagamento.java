/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vendadepacotesdeviagens;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 *
 * @author 55649
 */
public class MetodoPagamento {

    // Preços pré-definido
    private static final double PRECO_CLASSE_ECONOMICA = 500.00;
    private static final double PRECO_CLASSE_EXECUTIVA = PRECO_CLASSE_ECONOMICA * 2.5;
    private static final double PRECO_1A_CLASSE = PRECO_CLASSE_EXECUTIVA * 2.5;

    private static final double PRECO_QUARTO_SIMPLES = 200.00;
    private static final double PRECO_QUARTO_EXECUTIVO = PRECO_QUARTO_SIMPLES * 2.5;
    private static final double PRECO_SUITE_PRESIDENCIAL = PRECO_QUARTO_EXECUTIVO * 4.0;

    private static final double PRECO_CARRO_ECONOMICO = 150.00;
    private static final double PRECO_CARRO_EXECUTIVO = PRECO_CARRO_ECONOMICO;
    private static final double PRECO_CARRO_LUXO = PRECO_CARRO_EXECUTIVO;

    // Mapeamentos para preços
    private Map<String, Double> precoClasseVoo = new HashMap<>();
    private Map<String, Double> precoTipoQuarto = new HashMap<>();
    private Map<String, Double> precoTipoCarro = new HashMap<>();
    private Map<String, BiFunction<Double, Integer, Double>> metodosPagamentoMap;

    public MetodoPagamento() {
        // Inicializar os preços das classes de voo
        precoClasseVoo.put("Econômica", PRECO_CLASSE_ECONOMICA);
        precoClasseVoo.put("Executiva", PRECO_CLASSE_EXECUTIVA);
        precoClasseVoo.put("1a Classe", PRECO_1A_CLASSE);

        // Inicializar os preços dos tipos de quarto
        precoTipoQuarto.put("Simples", PRECO_QUARTO_SIMPLES);
        precoTipoQuarto.put("Executivo", PRECO_QUARTO_EXECUTIVO);
        precoTipoQuarto.put("Suite Presidencial", PRECO_SUITE_PRESIDENCIAL);

        // Inicializar os preços dos tipos de carro
        precoTipoCarro.put("Economico", PRECO_CARRO_ECONOMICO);
        precoTipoCarro.put("Executivo", PRECO_CARRO_EXECUTIVO);
        precoTipoCarro.put("Luxo", PRECO_CARRO_LUXO);

        metodosPagamentoMap = new HashMap<>();
        metodosPagamentoMap.put("Pix", (valorBase, parcelas) -> valorBase * 0.9); 
        metodosPagamentoMap.put("Boleto", (valorBase, parcelas) -> valorBase * 0.95); 
        metodosPagamentoMap.put("Debito", (valorBase, parcelas) -> valorBase); 
        metodosPagamentoMap.put("Credito", (valorBase, parcelas) -> {
            if (parcelas > 1) {
                return valorBase * Math.pow(1.0399, parcelas - 1); 
            }
            return valorBase; 
        });
    }

    public double calcularValorPacote(String classeVoo, String tipoQuarto, String tipoCarro, int numPessoas,
        int parcelas, String metodoPagamento) {

        double valorVoo = calcularValorVoo(classeVoo);
        double valorHotel = calcularValorHotel(tipoQuarto, numPessoas);
        double valorCarro = calcularValorCarro(tipoCarro);

        double valorBase = valorVoo + valorHotel + valorCarro;
        return calcularValorFinal(valorBase, metodoPagamento, parcelas);
    }

    private double calcularValorVoo(String classeVoo) {
        Double preco = precoClasseVoo.get(classeVoo);
        if (preco == null) {
            throw new IllegalArgumentException("Classe de voo invalida.");
        }
        return preco;
    }

    private double calcularValorHotel(String tipoQuarto, int numPessoas) {
        Double precoPorPessoa = precoTipoQuarto.get(tipoQuarto);
        if (precoPorPessoa == null) {
            throw new IllegalArgumentException("Tipo de quarto invalido.");
        }
        return precoPorPessoa * numPessoas;
    }

    private double calcularValorCarro(String tipoCarro) {
        Double preco = precoTipoCarro.get(tipoCarro);
        if (preco == null) {
            throw new IllegalArgumentException("Tipo de carro invalido.");
        }
        return preco;
    }

    private double calcularValorFinal(double valorBase, String metodoPagamento, int parcelas) {
        BiFunction<Double, Integer, Double> funcaoCalculo = metodosPagamentoMap.get(metodoPagamento);
        if (funcaoCalculo != null) {
            return funcaoCalculo.apply(valorBase, parcelas);
        } else {
            throw new IllegalArgumentException("Método de pagamento invalido.");
        }
    }

    public void processarPagamento(String metodoPagamento, double valorFinal, int parcelas) {
        System.out.println("Pagamento realizado via " + metodoPagamento + ". Valor final: R$ " + valorFinal);
        if ("Crédito".equals(metodoPagamento) && parcelas > 1) {
            System.out.println("Numero de parcelas: " + parcelas);
        }

    }
}
