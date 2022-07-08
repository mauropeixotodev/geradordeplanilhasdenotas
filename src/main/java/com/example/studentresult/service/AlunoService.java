package com.example.studentresult.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentresult.builders.AlunoBuilder;
import com.example.studentresult.controller.aluno.request.AlunoRequest;
import com.example.studentresult.controller.aluno.response.AlunoResponse;
import com.example.studentresult.enums.StatusAluno;
import com.example.studentresult.repository.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	private AlunoBuilder alunoBuilder;
	@Autowired
	private AlunoRepository alunoRepository;

	public AlunoResponse salvar(AlunoRequest alunoRequest) {
		return alunoBuilder.alunoResponseBuild(alunoRepository.save(alunoBuilder.alunoBuild(alunoRequest)));
	}
	
	public List<AlunoResponse> buscar(){
		return alunoBuilder.alunoResponseBuild(alunoRepository.findByStatus(StatusAluno.NAOAVALIADO));
	}

}
