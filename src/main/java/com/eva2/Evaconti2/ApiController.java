package com.eva2.Evaconti2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
// imports for use List, Map, String and Object
//import java.util.List;
//import java.util.Map;
import java.lang.String;
//import java.lang.Object;

//import org.springframework.jdbc.core.JdbcTemplate;

@Controller	
@RequestMapping(path="/") 
public class ApiController {
	@Autowired 
	private CursoRepository cursoRepository;
	//private UserRepository userRepository;

	//@Autowired
  	//private JdbcTemplate jdbcTemplate;
	
	@GetMapping(path="/api/curso/listar")
	public @ResponseBody Iterable<Curso> getAllCursos() {
		return cursoRepository.findAll();
	}

	@PostMapping(path="/api/curso/nuevo") // Map ONLY POST Requests
	public @ResponseBody String addNewCurso (@RequestParam String nombre
			, @RequestParam Integer creditos) {
		Curso n = new Curso();
		n.setNombre(nombre);
		n.setCreditos(creditos);
		cursoRepository.save(n);
		return "Saved";
	}

	@DeleteMapping(path="/api/curso/eliminar")
	public @ResponseBody String delCurso (@RequestParam Integer id) {
		Curso n = new Curso();
		n.setId(id);
		cursoRepository.delete(n);
		return "Deleted";
	}


	/* 
	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam String email) {
		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}

	@DeleteMapping(path="/del")
	public @ResponseBody String delUser (@RequestParam Integer id) {
		User n = new User();
		n.setId(id);
		userRepository.delete(n);
		return "Deleted";
	}

	@PutMapping(path="/edit")
	public @ResponseBody String editUser (@RequestParam Integer id, @RequestParam String name
	, @RequestParam String email) {
		User n = new User();
		n.setId(id);
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Updated";
	}


	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping(path="/get/{id}")
	public @ResponseBody User getOneUser(@PathVariable Integer id) {
		return userRepository.findById(id).orElse(null);
	}
	*/

    /*
	@GetMapping(path="/get/report")
	public @ResponseBody List<Map<String, Object>> getReport() {
		List<Map<String, Object>> queryResult = jdbcTemplate.queryForList("SELECT CONCAT(name, ' ==> ', email) as mycol FROM user");
		return queryResult;
	}
    */


}
