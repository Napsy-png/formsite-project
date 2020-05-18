package ohpro1.formsite.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ohpro1.formsite.domain.Question;
import ohpro1.formsite.domain.QuestionRepository;

@CrossOrigin(maxAge = 3600)
@Controller
public class AdminController {
	@Autowired
	QuestionRepository qrepo;

	
	
	@GetMapping(value="/admin")
		public String questionList(Model model) {	
        model.addAttribute("Questions", qrepo.findAll());
        return "admin";
	}
	
		
	 @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		public String deleteQuestionById(@PathVariable("id") Long Id) {
			qrepo.deleteById(Id);
	        return "redirect:../admin";
			
		}
	 @GetMapping("addQuestion")
	 	public String addQuestion(Model model) {
		 model.addAttribute("newQuestion", new Question());
		 return "addQuestion";
	 }
	 @PostMapping("saveQuestion")
	 	public String saveQuestion(Question content) {
		 qrepo.save(content);
		 return "redirect:admin";
	 }

}
