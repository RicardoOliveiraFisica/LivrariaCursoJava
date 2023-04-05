package com.minsait.livraria.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/livraria/livros")
public class TesteController {
	
	@GetMapping("/teste")
	public String teste() {
		return "<h1 style='color:blue;'>Teste</h1>";
	}
}
