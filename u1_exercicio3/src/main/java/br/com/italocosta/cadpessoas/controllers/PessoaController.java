package br.com.italocosta.cadpessoas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.italocosta.cadpessoas.model.Pessoa;
import br.com.italocosta.cadpessoas.repositories.PessoaRepository;

@Controller
@RequestMapping("/")
public class PessoaController {

  @Autowired
  PessoaRepository pessoaRepo;

  public PessoaController(PessoaRepository pessoaRepo) {
    this.pessoaRepo = pessoaRepo;
  }

  // Página Inicial
  @GetMapping
  public String index() {
    return "index";
  }

  // Página de Lista de Pessoas
  @GetMapping("/listarPessoas")
  public ModelAndView listarPessoas() {
    List<Pessoa> pessoas = pessoaRepo.findAll();
    ModelAndView mv = new ModelAndView("listarPessoas");
    mv.addObject("pessoas", pessoas);
    return mv;
  }

  // Página de Adicionar Pessoa
  @GetMapping("/adicionarPessoa")
  public ModelAndView formularioAdicionarPessoa() {
    ModelAndView mv = new ModelAndView("adicionarPessoa");
    mv.addObject("pessoa", new Pessoa());
    return mv;
  }

  @PostMapping("/adicionarPessoa")
  public String adicionarPessoa(Pessoa pessoa) {
    this.pessoaRepo.save(pessoa);
    return "redirect:/listarPessoas";
  }

  @GetMapping("/remover/{id}")
  public String removerPessoa(@PathVariable("id") Long id) {
    Pessoa toRemove = pessoaRepo.findById(id).orElseThrow(
        () -> new IllegalArgumentException("Pessoa inválida: " + id));
    pessoaRepo.delete(toRemove);
    return "redirect:/listarPessoas";
  }

  @GetMapping("/editar/{id}")
  public ModelAndView formularioEditarPessoa(@PathVariable("id") Long id) {
    Pessoa toEdit = pessoaRepo.findById(id).orElseThrow(
        () -> new IllegalArgumentException("Pessoa inválida: " + id));
    ModelAndView mv = new ModelAndView("editarPessoa");
    mv.addObject(toEdit);
    return mv;
  }

  @PostMapping("/editar/{id}")
  public String editarPessoa(@PathVariable("id") Long id, Pessoa pessoa) {
    this.pessoaRepo.save(pessoa);
    return "redirect:/listarPessoas";
  }
}
