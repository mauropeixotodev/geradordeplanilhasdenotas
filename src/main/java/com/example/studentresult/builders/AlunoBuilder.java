package com.example.studentresult.builders;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.studentresult.controller.aluno.request.AlunoRequest;
import com.example.studentresult.controller.aluno.response.AlunoResponse;
import com.example.studentresult.enums.StatusAluno;
import com.example.studentresult.model.Aluno;

@Component
public class AlunoBuilder {

	public Aluno alunoBuild(AlunoRequest alunoRequest) {
		return Aluno.builder().nome(alunoRequest.getNome()).matricula(alunoRequest.getMatricula())
				.status(StatusAluno.NAOAVALIADO).build();
	}

	public AlunoResponse alunoResponseBuild(Aluno aluno) {
		return AlunoResponse.builder().id(aluno.getId()).nome(aluno.getNome()).matricula(aluno.getMatricula()).build();
	}

	public List<AlunoResponse> alunoResponseBuild(List<Aluno> alunos) {
		return alunos.stream().map(aluno -> alunoResponseBuild(aluno)).toList();
	}

}
