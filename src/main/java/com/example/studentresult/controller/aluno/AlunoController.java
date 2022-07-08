package com.example.studentresult.controller.aluno;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.studentresult.controller.aluno.request.AlunoRequest;
import com.example.studentresult.controller.aluno.response.AlunoResponse;
import com.example.studentresult.service.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	@Autowired
	AlunoService alunoService;

	@PostMapping("")
	public ResponseEntity<AlunoResponse> cadastro(@RequestBody @Validated AlunoRequest alunoRequest,
			UriComponentsBuilder uriBuilder) throws Exception {
		AlunoResponse aluno = alunoService.salvar(alunoRequest);
		URI uri = uriBuilder.path("/aluno/{id}").buildAndExpand(aluno.getId()).toUri();
		return ResponseEntity.created(uri).body(aluno);
	}

	@GetMapping("")
	public List<AlunoResponse> listar() {
		return alunoService.buscar();
	}

}
