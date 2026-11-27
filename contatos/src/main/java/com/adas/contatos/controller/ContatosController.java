package com.adas.contatos.controller;

import com.adas.contatos.model.Contato;
import com.adas.contatos.service.ContatosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatosController {

    private final ContatosService contatosService;

    public ContatosController(ContatosService contatosService){
        this.contatosService = contatosService;
    }

    /*
    * Tipos de Endpoints
    *
    * GET - Obter informações, exemplo: Buscar alista de todos os contatos
    * POST - Gerar dado novo no banco, exemplo: Cadastrar um novo usuario
    * PUT - Atualizar dados no banco
    * DELETE Excluir dados, Exemplo: Remover um registro do banco
    *
    *  */

    @GetMapping
    public List<Contato> findAll() {
        List<Contato> listaContatos = this.contatosService.findAll();
        return listaContatos;
    }

    //Criar um endpoint para buscar um usuario atraes do código
    @GetMapping("/{codigo}")
    public Contato buscarPorContato(@PathVariable int codigo){
        return this.contatosService.buscarPorContato(codigo);
    }

    @DeleteMapping("/{codigo}")
    public Contato excluir(@PathVariable int codigo){
        return this.contatosService.excluir(codigo);
    }

    @PostMapping("/novo")
    public Contato insert(
            @RequestParam String nome,
            @RequestParam String telefone) {
        return this.contatosService.insert(nome, telefone);
    }
    @PutMapping("/{codigo}")
    public Contato editar(
            @PathVariable int codigo,
            @RequestParam String novoNome,
            @RequestParam String novoTelefone){
        return this.contatosService.editar(codigo,novoNome,novoTelefone);
    }
}



