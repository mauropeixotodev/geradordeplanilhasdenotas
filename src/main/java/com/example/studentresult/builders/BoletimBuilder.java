package com.example.studentresult.builders;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.studentresult.controller.boletim.request.BoletimRequest;
import com.example.studentresult.controller.boletim.response.BoletimResponse;
import com.example.studentresult.enums.ResultadoFinal;
import com.example.studentresult.enums.StatusAluno;
import com.example.studentresult.model.Aluno;
import com.example.studentresult.model.Boletim;
import com.example.studentresult.repository.AlunoRepository;

@Component
public class BoletimBuilder {
	@Autowired
	private AlunoRepository alunoRepository;

	@Transactional
	public Boletim boletimBuild(BoletimRequest boletimRequest) throws Exception {

		Optional<Aluno> alunoOpitional = alunoRepository.findById(boletimRequest.getAlunoId());

		if (alunoOpitional.isPresent()) {
			if (alunoOpitional.get().getStatus() == StatusAluno.NAOAVALIADO) {
				Aluno aluno = alunoOpitional.get();
				aluno.setStatus(StatusAluno.AVALIADO);
				Boletim boletim = Boletim.builder().aluno(aluno).nota1(boletimRequest.getNota1())
						.nota2(boletimRequest.getNota2()).nota3(boletimRequest.getNota3())
						.nota4(boletimRequest.getNota4())
						.notaFinal((boletimRequest.getNota1() + boletimRequest.getNota2() + boletimRequest.getNota3()
								+ boletimRequest.getNota4()) / 4)
						.build();
				if (boletim.getNotaFinal() >= 7) {
					boletim.setResultado(ResultadoFinal.APROVADO);
				} else {
					boletim.setResultado(ResultadoFinal.REPROVADO);
				}

				return boletim;
			} else {
				throw new Exception("Aluno já avaliado");
			}

		} else {
			throw new Exception("Aluno não existente");
		}

	}

	public BoletimResponse boletimReponseBuild(Boletim boletim) {
		return BoletimResponse.builder().matricula(boletim.getAluno().getMatricula()).nome(boletim.getAluno().getNome())
				.nota1(boletim.getNota1()).nota2(boletim.getNota2()).nota3(boletim.getNota3()).nota4(boletim.getNota4())
				.notaFinal(boletim.getNotaFinal()).resultado(boletim.getResultado()).build();
	}

	public List<BoletimResponse> boletimReponseBuild(List<Boletim> boletins) {
		return boletins.stream().map(boletim -> boletimReponseBuild(boletim)).toList();
	}

}
