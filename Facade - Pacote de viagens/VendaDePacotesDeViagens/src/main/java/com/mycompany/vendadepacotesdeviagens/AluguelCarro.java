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
public class AluguelCarro {
    public static final double PRECO_CARRO_ECONOMICO = 150.00;
    public static final double PRECO_CARRO_EXECUTIVO = PRECO_CARRO_ECONOMICO;
    public static final double PRECO_CARRO_LUXO = PRECO_CARRO_EXECUTIVO;

    private Map<String, Double> precoTipoCarro;

    private String tipoCarro;

    public AluguelCarro() {
        precoTipoCarro = new HashMap<>();
        precoTipoCarro.put("Economico", PRECO_CARRO_ECONOMICO);
        precoTipoCarro.put("Executivo", PRECO_CARRO_EXECUTIVO);
        precoTipoCarro.put("Luxo", PRECO_CARRO_LUXO);
    }

    public void alugarCarro(String tipoCarro) {
        if (!precoTipoCarro.containsKey(tipoCarro)) {
            throw new IllegalArgumentException("Tipo de carro invalido.");
        }
        this.tipoCarro = tipoCarro;
    }

    public double getPrecoCarro() {
        if (tipoCarro == null || !precoTipoCarro.containsKey(tipoCarro)) {
            throw new IllegalStateException("Tipo de carro nao selecionado corretamente.");
        }
        return precoTipoCarro.get(tipoCarro);
    }

    public String getTipoCarro() {
        return tipoCarro;
    }
}

