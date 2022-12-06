package com.junot.desafiopadraoprojetodio.service.impl;

import java.util.Optional;

import com.junot.desafiopadraoprojetodio.model.Empresa;
import com.junot.desafiopadraoprojetodio.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.junot.desafiopadraoprojetodio.model.Cliente;
import com.junot.desafiopadraoprojetodio.repository.ClienteRepository;
import com.junot.desafiopadraoprojetodio.model.Endereco;
import com.junot.desafiopadraoprojetodio.repository.EnderecoRepository;
import com.junot.desafiopadraoprojetodio.repository.EmpresaRepository;
import com.junot.desafiopadraoprojetodio.service.ClienteService;
import com.junot.desafiopadraoprojetodio.service.ViaCepService;


@Service
public class ClienteServiceImpl implements ClienteService {

	// Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private ViaCepService viaCepService;
	@Autowired
	private EmpresaService empresaService;
	
	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<Cliente> buscarTodos() {
		// Buscar todos os Clientes.
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		// Buscar Cliente por ID.
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
		salvarClienteComCep(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// Buscar Cliente por ID, caso exista:
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {
			salvarClienteComCep(cliente);
		}
	}

	@Override
	public void deletar(Long id) {
		// Deletar Cliente por ID.
		clienteRepository.deleteById(id);
	}

	private void salvarClienteComCep(Cliente cliente) {
		// Verificar se o Endereco do Cliente já existe (pelo CEP).
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			// Caso não exista, integrar com o ViaCEP e persistir o retorno.
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});

		String cnpj = cliente.getEmpresa().getCnpj_raiz();
			Empresa novaEmpresa = empresaRepository.findById(cnpj).orElseGet(() -> {
				Empresa emp = empresaService.consultarCnpj(cnpj);
				empresaRepository.save(emp);
				return emp;
					});

		cliente.setEmpresa(novaEmpresa);
		cliente.setEndereco(endereco);
		// Inserir Cliente, vinculando o Endereco (novo ou existente).
		clienteRepository.save(cliente);
	}

}
