package com.projectVynicius.produtosApi.controller;


import com.projectVynicius.produtosApi.Repository.ProdutoRepository;
import com.projectVynicius.produtosApi.model.Produto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvarProduto(@RequestBody Produto produto){

        System.out.println("Produto recebido: " + produto);
        var id = UUID.randomUUID().toString();
        produto.setId(id);
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("/{id}")
    public Produto devolverProdutoPorId(@PathVariable("id") String id){
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable("id") String id){
        produtoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void atualizarProduto(@PathVariable("id") String id,@RequestBody Produto produto){

        produto.setId(id);
        produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> buscarProduto(@RequestParam("nome") String nome){

        return produtoRepository.findByNome(nome);

    }
}
