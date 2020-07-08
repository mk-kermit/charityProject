package pl.coderslab.charity.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.domain.Institution;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@AllArgsConstructor
@Controller
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HomeController {

    InstitutionRepository institutionRepository;
    DonationRepository donationRepository;

    @ModelAttribute(name = "institutions")
    public List<Institution> allInstitution() {
        List<Institution> institutions = institutionRepository.findAll();
        return institutions;
    }

    @ModelAttribute(name = "numberOfDonations")
    public int showNumberOfDonations() {
        return donationRepository.numberOfDonations();
    }

    @ModelAttribute(name = "numberOfBags")
    public int showNumberOfBags() {
        return donationRepository.numberOfBags();
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        return "index";
    }

}
