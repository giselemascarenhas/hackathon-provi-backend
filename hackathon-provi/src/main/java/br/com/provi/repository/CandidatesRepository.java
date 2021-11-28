package br.com.provi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.provi.model.Candidates;

@Repository
public interface CandidatesRepository extends JpaRepository<Candidates, Long> {
	
	public List<Candidates> findAllByCandidatesContainingIgnoreCase(String candidates);

}
