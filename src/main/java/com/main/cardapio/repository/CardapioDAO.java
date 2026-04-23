/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.cardapio.repository;

import com.main.cardapio.model.CardapioBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class CardapioDAO {
    public List<CardapioBean> listarCardapio() {
        List<CardapioBean> lista = new ArrayList();
        try{
            Connection conn = Conexao.conectar();
            
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("Select * from itens");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                CardapioBean item = new CardapioBean();
                item.setId(rs.getInt("id"));
                item.setNome(rs.getString("nome"));
                item.setPreco(rs.getDouble("preco"));
                item.setCategoria(rs.getString("categoria"));
                item.setDisponivel(rs.getBoolean("disponivel"));
                lista.add(item);
            }
         
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return lista;
    }
    
    public void adicionarItem(CardapioBean item){
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("insert into itens (nome, preco, categoria, disponivel) values (?, ?, ?, ?)");
            
            stmt.setString(1, item.getNome());
            stmt.setDouble(2, item.getPreco());
            stmt.setString(3, item.getCategoria());
            stmt.setBoolean(4, item.isDisponivel());
            
            stmt.executeUpdate();
         
        }catch(SQLException e){
            
            e.printStackTrace();
        }
        
    }
}
