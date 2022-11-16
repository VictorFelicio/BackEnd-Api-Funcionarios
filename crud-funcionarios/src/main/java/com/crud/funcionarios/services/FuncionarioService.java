package com.crud.funcionarios.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.funcionarios.model.Funcionario;
import com.crud.funcionarios.repository.FuncionarioRepository;

@Service

public class FuncionarioService {
	@Autowired
	private FuncionarioRepository repository;

	public Iterable<Funcionario> getFuncionarios() {
		return repository.findAll();
	}

	public void createFuncionario(Funcionario funcionario) {
		repository.save(funcionario);
	}

	public Funcionario getFuncionario(Long id) {
		return repository.findById(id).orElse(null);
	}

	public void deleteFuncionario(Funcionario funcionario) {
		repository.delete(funcionario);
	}

	public void updateFuncionario(Funcionario funcionario) {
		repository.save(funcionario);
	}
}
