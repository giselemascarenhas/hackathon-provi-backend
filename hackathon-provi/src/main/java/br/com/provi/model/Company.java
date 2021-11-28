package br.com.provi.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.lang.Nullable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

		@Entity
		@Table(name = "tb_company")
		public class Company {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@NotNull
		private String name;
		
		@CNPJ
		@Nullable
		private String cnpj;
		
		@OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
		@JsonIgnoreProperties("company")
		List<Jobs> jobs;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCnpj() {
			return cnpj;
		}

		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}

		public List<Jobs> getJobs() {
			return jobs;
		}

		public void setJobs(List<Jobs> jobs) {
			this.jobs = jobs;
		}
}
