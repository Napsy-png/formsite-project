package ohpro1.formsite.web;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ohpro1.formsite.domain.Answer;
import ohpro1.formsite.domain.AnswerRepository;

@CrossOrigin(maxAge = 3600)
@RestController
public class AnswerController {
	private final AnswerRepository arepo;
	AnswerController(AnswerRepository arepo){
		this.arepo = arepo;
	}
	@GetMapping("/answers")
	List<Answer> all(){
		return arepo.findAll();
	}
	
	@PostMapping("/answers")
	Answer newAnswer(@RequestBody Answer newAnswer) {
		return arepo.save(newAnswer);

	}
}
