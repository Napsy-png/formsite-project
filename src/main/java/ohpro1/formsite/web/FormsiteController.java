package ohpro1.formsite.web;

import java.util.List;


import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ohpro1.formsite.domain.Question;
import ohpro1.formsite.domain.QuestionRepository;

@RestController
public class FormsiteController {
	private final QuestionRepository qrepo;
	
	FormsiteController(QuestionRepository qrepo){
		this.qrepo = qrepo;
		
	}
	
	@GetMapping("/")
	List<Question> all(){
		return qrepo.findAll();
	}
	

	@GetMapping("/questions")
	List<Question> all2(){
		return qrepo.findAll();
	}
	
	@PostMapping("/questions")
	Question newQuestion(@RequestBody Question newQuestion) {
		return qrepo.save(newQuestion);
		
	}
	
	@GetMapping("/questions/{id}")
	Optional<Question> one(@PathVariable Long id) {
		return qrepo.findById(id);
	}
	
	@PutMapping("/questions/{id}")
	Question replaceQuestion(@RequestBody Question newQuestion, @PathVariable Long id) {
		return qrepo.findById(id)
				.map(question ->{
				question.setContent(newQuestion.getContent());
				return qrepo.save(question);
				})
		.orElseGet(() -> {
			newQuestion.setId(id);
	        return qrepo.save(newQuestion);
		});
		
	
	
	
}
	
}
