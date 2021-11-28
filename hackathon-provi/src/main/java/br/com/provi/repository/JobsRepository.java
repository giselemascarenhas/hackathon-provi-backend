package br.com.provi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.provi.model.Jobs;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Long>{
	
	public List<Jobs> findAllByPositionContainingIgnoreCase(String position);	

}
