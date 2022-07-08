package com.example.studentresult.controller.boletim.response;

import com.example.studentresult.enums.ResultadoFinal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoletimResponse {
	private String matricula;
	private String nome;
	private Double nota1;
	private Double nota2;
	private Double nota3;
	private Double nota4;
	private Double notaFinal;
	private ResultadoFinal resultado;
}
