package com.example.studentresult.controller.boletim;

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
import com.example.studentresult.controller.boletim.request.BoletimRequest;
import com.example.studentresult.controller.boletim.response.BoletimResponse;
import com.example.studentresult.service.BoletimService;

@RestController
@RequestMapping("/boletim")
public class BoletimController {
	@Autowired
	BoletimService boletimService;

	@PostMapping("")
	public ResponseEntity<BoletimResponse> cadastro(@RequestBody @Validated BoletimRequest boletimRequest,
			UriComponentsBuilder uriBuilder) throws Exception {
		BoletimResponse boletim = boletimService.salvar(boletimRequest);
		URI uri = uriBuilder.path("/boletim/{matricula}").buildAndExpand(boletim.getMatricula()).toUri();
		return ResponseEntity.created(uri).body(boletim);
	}
	@GetMapping("")
	public List<BoletimResponse> listar() {
		return boletimService.buscar();
	}

}
