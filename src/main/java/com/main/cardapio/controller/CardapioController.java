
package com.main.cardapio.controller;

import com.main.cardapio.model.CardapioBean;
import com.main.cardapio.service.CardapioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/itens")
public class CardapioController {
    
    @Autowired
    private CardapioService service;
    
    @GetMapping
    public List<CardapioBean> listarItens(){
        return service.listarItems();
    }
    
    @PostMapping
    public void criarItem(@RequestBody CardapioBean item){
        System.out.println(item);
        service.adicionarItem(item);
    }
}
