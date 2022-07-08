package com.example.studentresult.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentresult.builders.BoletimBuilder;
import com.example.studentresult.controller.boletim.request.BoletimRequest;
import com.example.studentresult.controller.boletim.response.BoletimResponse;
import com.example.studentresult.repository.BoletimRepository;

@Service
public class BoletimService {
	@Autowired
	private BoletimBuilder boletimBuilder;
	@Autowired
	private BoletimRepository boletimReposiotry;

	public BoletimResponse salvar(BoletimRequest boletimRequest) throws Exception {
		return boletimBuilder.boletimReponseBuild(boletimReposiotry.save(boletimBuilder.boletimBuild(boletimRequest)));
	}

	public List<BoletimResponse> buscar() {
		return boletimBuilder.boletimReponseBuild(boletimReposiotry.findAll());
	}

}
