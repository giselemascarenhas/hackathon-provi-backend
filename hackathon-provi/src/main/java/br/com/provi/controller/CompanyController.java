package br.com.provi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.provi.model.Company;
import br.com.provi.repository.CompanyRepository;

@RestController
@RequestMapping("/companies")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;
	
	@GetMapping
	public ResponseEntity<List<Company>> getAll(){
		return ResponseEntity.ok(companyRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Company> getById(@PathVariable long id){
		return companyRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<Company>> getByName(@PathVariable String name){
		return ResponseEntity.ok(companyRepository.findAllByNameContainingIgnoreCase(name));
	}
	
	@PostMapping
	public ResponseEntity<Company> postCompany(@RequestBody Company company){
		return ResponseEntity.status(HttpStatus.CREATED).body(companyRepository.save(company));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Company> putCompany(@RequestBody Company company){
		return ResponseEntity.status(HttpStatus.OK).body(companyRepository.save(company));
	}
	
	@DeleteMapping("/{id}")
	public void deleteCompany(@PathVariable long id) {
		companyRepository.deleteById(id);
	}
}