package com.seberino.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.seberino.pix.ChavePix;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ChaveTeste {
    
    @Test
    public void adicionaChave()
    {
        //System.out.println("Testando a API");
        ChavePix chave = new ChavePix();
        chave.setAgencia(10);
        chave.setConta(10);
        chave.setDigito(1);
        chave.setChave("richard@seberino.com.br");

        //adiciona a chave
        ChavePix.persist(chave);
        
        ChavePix teste = ChavePix.findById(chave.getChave());
        String id_1 = chave.getAgencia() + "-" + chave.getConta() + "-" + chave.getDigito();
        String id_2 = teste.getAgencia() + "-" + teste.getConta() + "-" + teste.getDigito();
        assertEquals(id_1, id_2);


    }
}
