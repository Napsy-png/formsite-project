package ohpro1.formsite.web;

import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ohpro1.formsite.domain.Answer;
import ohpro1.formsite.domain.Person;
import ohpro1.formsite.domain.PersonRepository;
import ohpro1.formsite.domain.Question;
import ohpro1.formsite.domain.QuestionRepository;

@CrossOrigin(maxAge = 3600 )
@RestController
public class FormsiteController {
	private final QuestionRepository qrepo;
	private final PersonRepository prepo;
	
	FormsiteController(QuestionRepository qrepo, PersonRepository prepo){
		this.prepo = prepo;
		this.qrepo = qrepo;
		
	}
	
	@GetMapping("/")
	List<Question> listAll(){
		return qrepo.findAll();
	}
	

	@GetMapping("/questions")
	List<Question> listQuestions(){
		return qrepo.findAll();
	}
	@GetMapping("/people")
		List<Person> listPeople(){
			return prepo.findAll();
		}
	
	
	@PostMapping("/people")
	Person newPerson(@RequestBody Person newPerson) {
		return prepo.save(newPerson);
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
