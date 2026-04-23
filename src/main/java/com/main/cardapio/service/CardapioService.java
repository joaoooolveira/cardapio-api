/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.cardapio.service;

import com.main.cardapio.model.CardapioBean;
import com.main.cardapio.repository.CardapioDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardapioService {
    
    @Autowired
    private CardapioDAO repository;
    
    public List<CardapioBean> listarCardapio() {
        return repository.listarCardapio();
    }
    
    public void adicionarItem(CardapioBean item){
        repository.adicionarItem(item);
    }
}
