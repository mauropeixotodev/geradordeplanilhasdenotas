package com.example.studentresult.controller.aluno.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlunoResponse {
	private Long id;
	private String nome;
	private String matricula;
}
