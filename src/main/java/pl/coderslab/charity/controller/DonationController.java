package pl.coderslab.charity.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.charity.domain.Category;
import pl.coderslab.charity.domain.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DonationController {
    InstitutionRepository institutionRepository;
    CategoryRepository categoryRepository;

    @ModelAttribute(name = "institutions")
    public List<Institution> allInstitutions() {
        List<Institution> institutions = institutionRepository.findAll();
        return institutions;
    }

    @ModelAttribute(name = "categories")
    public List<String> allCategories() {
        List<String> categories = categoryRepository.getAllNames();
        return categories;
    }

    @GetMapping("/form")
    public String showForm(){
        return "form";
    }
}
