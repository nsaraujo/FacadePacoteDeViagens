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
public class ReservaPassagemAerea {
    public static final double PRECO_CLASSE_ECONOMICA = 500.00;
    public static final double PRECO_CLASSE_EXECUTIVA = PRECO_CLASSE_ECONOMICA * 2.5;
    public static final double PRECO_1A_CLASSE = PRECO_CLASSE_EXECUTIVA * 2.5;

    private Map<String, Double> precoClasseVoo;

    private String classeVoo;
    private String assento;

    public ReservaPassagemAerea() {
        precoClasseVoo = new HashMap<>();
        precoClasseVoo.put("Economica", PRECO_CLASSE_ECONOMICA);
        precoClasseVoo.put("Executiva", PRECO_CLASSE_EXECUTIVA);
        precoClasseVoo.put("1a Classe", PRECO_1A_CLASSE);
    }

    public void escolherPassagem(String classeVoo, String assento) {
        if (!precoClasseVoo.containsKey(classeVoo)) {
            throw new IllegalArgumentException("Classe de voo inválida.");
        }
        this.classeVoo = classeVoo;
        this.assento = assento;
    }

    public double getPrecoPassagem() {
        if (classeVoo == null || !precoClasseVoo.containsKey(classeVoo)) {
            throw new IllegalStateException("Classe de voo não selecionada corretamente.");
        }
        return precoClasseVoo.get(classeVoo);
    }

    public String getClasseVoo() {
        return classeVoo;
    }

    public String getAssento() {
        return assento;
    }
}


