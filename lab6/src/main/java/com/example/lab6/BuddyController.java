package com.example.lab6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BuddyController {

    @Autowired
    private BuddyInfoRepository buddyInfoRepository;

	@CrossOrigin(origins = "http://localhost:8080/addbuddyjs")
	@RequestMapping(value="/addbuddy", method=RequestMethod.GET)
	public String addBuddyForm(Model model) {
		model.addAttribute("addbuddy", new BuddyInfo());
		return "addbuddy";
	}

	@CrossOrigin(origins = "http://localhost:8080/addbuddyjs")
	@RequestMapping(value="/addbuddy", method=RequestMethod.POST)
	public String buddyAddedSubmit(@ModelAttribute BuddyInfo addbuddy, Model model) {
        buddyInfoRepository.save(addbuddy);
		model.addAttribute("addbuddy", addbuddy);
		return "buddyconfirmation";
	}
}