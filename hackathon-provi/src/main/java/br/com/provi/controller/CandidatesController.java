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

import br.com.provi.model.Candidates;
import br.com.provi.repository.CandidatesRepository;

@RestController
@RequestMapping("/candidates")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CandidatesController {
	
	@Autowired
	private CandidatesRepository candidatesRepository;
	
	@GetMapping
	public ResponseEntity <List<Candidates>> getAll(){
		return ResponseEntity.ok(candidatesRepository.findAll());
	}
		
		@GetMapping("/{id}")
		public ResponseEntity<Candidates> findById(@PathVariable long id) {
			return candidatesRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
		
		@GetMapping("/candidate/{candidate}")
		public ResponseEntity<List<Candidates>> getByCandidate(@PathVariable String candidates){
			return ResponseEntity.ok(candidatesRepository.findAllByCandidatesContainingIgnoreCase(candidates));
		}
	
		@PostMapping
		public ResponseEntity<Candidates> postCandidates(@RequestBody Candidates candidates){
			return ResponseEntity.status(HttpStatus.CREATED).body( candidatesRepository.save(candidates));
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<Candidates> putCandidates(@RequestBody Candidates candidates){
			return ResponseEntity.status(HttpStatus.OK).body(candidatesRepository.save(candidates));
		}
		
		@DeleteMapping("/{id}")
		public void deleteCandidates(@PathVariable long id) {
			candidatesRepository.deleteById(id);
		}
	}