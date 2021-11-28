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
import br.com.provi.model.Jobs;
import br.com.provi.repository.JobsRepository;

@RestController
@RequestMapping("/opportunities")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JobsController {
	
	@Autowired
	private  JobsRepository jobsRepository;
	
	@GetMapping
	public ResponseEntity<List<Jobs>> getAll(){
		return ResponseEntity.ok(jobsRepository.findAll());
	}
	
	@GetMapping("/id")
	public ResponseEntity<Jobs> getById(@PathVariable long id){
		return jobsRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/position/{position}")
	public ResponseEntity<List<Jobs>> getByNome(@PathVariable String position){
		return ResponseEntity.ok( jobsRepository.findAllByPositionContainingIgnoreCase(position));
	}
	
	@PostMapping
	public ResponseEntity<Jobs> postJobs(@RequestBody Jobs jobs){
		return ResponseEntity.status(HttpStatus.CREATED).body( jobsRepository.save(jobs));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Jobs> putJobs(@RequestBody Jobs jobs){
		return ResponseEntity.status(HttpStatus.OK).body( jobsRepository.save(jobs));
	}
	
	@DeleteMapping("/{id}")
	public void deleteJobs(@PathVariable long id) {
		 jobsRepository.deleteById(id);
	}
}
