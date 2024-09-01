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
public class ReservaHotel {
    public static final double PRECO_QUARTO_SIMPLES = 200.00;
    public static final double PRECO_QUARTO_EXECUTIVO = PRECO_QUARTO_SIMPLES * 2.5;
    public static final double PRECO_SUITE_PRESIDENCIAL = PRECO_QUARTO_EXECUTIVO * 4.0;

    private Map<String, Double> precoTipoQuarto;

    private String tipoQuarto;
    private int numeroPessoas;

    public ReservaHotel() {
        precoTipoQuarto = new HashMap<>();
        precoTipoQuarto.put("Simples", PRECO_QUARTO_SIMPLES);
        precoTipoQuarto.put("Executivo", PRECO_QUARTO_EXECUTIVO);
        precoTipoQuarto.put("Suite Presidencial", PRECO_SUITE_PRESIDENCIAL);
    }

    public void reservarHotel(String tipoQuarto, int numeroPessoas) {
        if (!precoTipoQuarto.containsKey(tipoQuarto)) {
            throw new IllegalArgumentException("Tipo de quarto invalido.");
        }
        this.tipoQuarto = tipoQuarto;
        this.numeroPessoas = numeroPessoas;
    }

    public double getPrecoHotel() {
        if (tipoQuarto == null || !precoTipoQuarto.containsKey(tipoQuarto)) {
            throw new IllegalStateException("Tipo de quarto nao selecionado corretamente.");
        }
        return precoTipoQuarto.get(tipoQuarto) * numeroPessoas;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public int getNumeroPessoas() {
        return numeroPessoas;
    }
}


