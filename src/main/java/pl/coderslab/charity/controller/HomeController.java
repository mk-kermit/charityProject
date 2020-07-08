package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.domain.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@AllArgsConstructor
@Controller
public class HomeController {

    private InstitutionRepository institutionRepository;

    @ModelAttribute(name = "institutions")
    public List<Institution> allInstitution (){
        List<Institution> institutions = institutionRepository.findAll();
        return institutions;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        return "index";
    }

}
