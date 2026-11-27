package com.adas.contatos.service;

import com.adas.contatos.model.Contato;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContatosService {

    //Declarando uma lista de contatos para simular uma banco d dados
    List<Contato> listaContatos = new ArrayList<>();
    int codigo = 0;

    public List<Contato> findAll(){
        return this.listaContatos;
    }

    //Função responsavel por encontrar o contato com o codigo igual ao enviado por paramentro
    public Contato buscarPorContato(int codigo){
        Contato contatoEncontrato = null;
        for (Contato contatoAtual : this.listaContatos) {
            if (contatoAtual.getCodigo() == codigo) {
                contatoEncontrato = contatoAtual;
            }
        }
        return contatoEncontrato;
    }

    //Função para excluir um contato pelo código
    public Contato excluir(int codigo){
        Contato contatoParaExcluir = this.buscarPorContato(codigo);
        if (contatoParaExcluir != null) {
            this.listaContatos.remove(contatoParaExcluir);
        }
        return contatoParaExcluir;
    }

    public Contato editar(int codigo, String novoNome, String novoTelefone){
        Contato contatoParaEditar = this.buscarPorContato(codigo);
        if (contatoParaEditar != null) {
            contatoParaEditar.setNome(novoNome);
            contatoParaEditar.setTelefone(novoTelefone);
        }
        return contatoParaEditar;
    }

    public Contato insert(String nome, String telefone){
        this.codigo++;

        Contato novoContato = new Contato();

        novoContato.setNome(nome);
        novoContato.setTelefone(telefone);
        novoContato.setCodigo(this.codigo);

        this.listaContatos.add(novoContato);
        return novoContato;

    }



}
