package pl.coderslab.charity.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.domain.Category;
import pl.coderslab.charity.domain.Donation;
import pl.coderslab.charity.domain.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Controller
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DonationController {
    InstitutionRepository institutionRepository;
    CategoryRepository categoryRepository;
    DonationRepository donationRepository;

    @ModelAttribute(name = "institutions")
    public List<Institution> allInstitutions() {
        return institutionRepository.findAll();
    }

    @ModelAttribute(name = "categories")
    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/form")
    public String processForm(@ModelAttribute Donation donation){
        donationRepository.save(donation);
        return "form-confirmation";
    }
}
