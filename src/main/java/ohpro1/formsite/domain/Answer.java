package ohpro1.formsite.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Answer {
	private @Id @GeneratedValue(strategy=GenerationType.AUTO) Long id;
	private String answers;
	
	public Answer() {
		super();
	}
	
		public Answer(String answers){
			super();
			this.answers = answers;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getAnswers() {
			return answers;
		}

		public void setAnswers(String answers) {
			this.answers = answers;
		}
	

}
