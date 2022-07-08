package com.example.studentresult.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentresult.enums.StatusAluno;
import com.example.studentresult.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	public List<Aluno> findByStatus(StatusAluno statusAluno);

}
