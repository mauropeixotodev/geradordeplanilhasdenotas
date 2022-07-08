package com.example.studentresult.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.example.studentresult.enums.ResultadoFinal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
public class Boletim {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "boletim_seq")
	@SequenceGenerator(name = "boletim_seq", sequenceName = "boletim_seq", allocationSize = 1)
	@EqualsAndHashCode.Include
	private Long id;
	@Column(nullable = false)
	private Double nota1;
	@Column(nullable = false)
	private Double nota2;
	@Column(nullable = false)
	private Double nota3;
	@Column(nullable = false)
	private Double nota4;
	@Column(nullable = false)
	private Double notaFinal;
	@Column(nullable = false)
	private ResultadoFinal resultado;
	@OneToOne()
	@JoinColumn(name = "aluno_id", referencedColumnName = "id")
	private Aluno aluno;

}
