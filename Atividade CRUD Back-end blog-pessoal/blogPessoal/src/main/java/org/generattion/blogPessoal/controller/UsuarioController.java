package org.generattion.blogPessoal.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.generattion.blogPessoal.model.UserLongin;
import org.generattion.blogPessoal.model.Usuario;
import org.generattion.blogPessoal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	public @PostMapping ("/logar") ResponseEntity<UserLongin> Autentication(@RequestBody Optional<UserLongin> user){
		return usuarioService.Logar(user)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	public @PostMapping ("/cadastrar") ResponseEntity<Optional<Usuario>> post(@Valid @RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.cadastrarUsuario(usuario));
	}
}
