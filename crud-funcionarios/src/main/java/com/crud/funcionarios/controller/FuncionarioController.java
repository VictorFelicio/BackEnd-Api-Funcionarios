package com.crud.funcionarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.crud.funcionarios.model.Funcionario;
import com.crud.funcionarios.services.FuncionarioService;



@RestController
public class FuncionarioController {
	@Autowired
	private FuncionarioService funcionarioService;

	@GetMapping("/funcionarios")
	public ResponseEntity<Iterable<Funcionario>> getFuncionarios() {
		return ResponseEntity.ok().body(funcionarioService.getFuncionarios());
	}

	@PostMapping("/funcionarios")
	public ResponseEntity<Void> adicionarioFuncionario(@RequestBody Funcionario funcionario) {
		funcionarioService.createFuncionario(funcionario);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("funcionarios/{id}")
	public ResponseEntity<Funcionario> getFuncionario(@PathVariable Long id) {
		return ResponseEntity.ok().body(funcionarioService.getFuncionario(id));
	}
	
	@PutMapping("/funcionarios")
	public ResponseEntity<Void> updateFuncionario(@RequestBody Funcionario funcionario){
		funcionarioService.updateFuncionario(funcionario);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@DeleteMapping("funcionarios/{id}")
	public ResponseEntity<Funcionario> deleteFuncionario(@PathVariable Long id){
		Funcionario funcionario = funcionarioService.getFuncionario(id);
		funcionarioService.deleteFuncionario(funcionario);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	

}









