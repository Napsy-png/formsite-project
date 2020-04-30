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
	private String acontent;
	
	public Answer() {
		super();
	}
	
		public Answer(String acontent){
			super();
			this.acontent = acontent;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getAcontent() {
			return acontent;
		}

		public void setAcontent(String content) {
			this.acontent = content;
		}
	

}
