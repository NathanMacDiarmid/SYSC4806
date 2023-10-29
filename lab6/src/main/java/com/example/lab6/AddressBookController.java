package com.example.lab6;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddressBookController {

    @Autowired
    private AddressBookRepository addressBookRepository;
	private AddressBook book;
	private ArrayList<BuddyInfo> list = new ArrayList<BuddyInfo>();

	@RequestMapping(value="/addaddressbook", method=RequestMethod.GET)
	public String addAddressBookForm(Model model) {
		model.addAttribute("addaddressbook", new AddressBook());
		return "addaddressbook";
	}

	@RequestMapping(value="/addbuddytobook", method=RequestMethod.GET)
	public String addBuddyToBookForm(Model model) {
		model.addAttribute("addbuddytobook", new BuddyInfo());
		return "addbuddytobook";
	}

	@RequestMapping(value="/addaddressbook", method=RequestMethod.POST)
	public String addressBookAddedSubmit(@ModelAttribute AddressBook addaddressbook, Model model) {
		book = addaddressbook;
		model.addAttribute("addaddressbook", addaddressbook);
		return "addressbookconfirmation";
	}

	@RequestMapping(value="/addbuddytobook", method=RequestMethod.POST)
	public String buddyAddedToBookSubmit(@ModelAttribute BuddyInfo addbuddytobook, Model model) {
		list.add(addbuddytobook);
		book.setBuddies(list);
		if (addbuddytobook.getSubmit().equals("no") || addbuddytobook.getSubmit().equals("false") || addbuddytobook.getSubmit().equals(null)) {
			addressBookRepository.save(book);
			model.addAttribute("addbuddytobook", addbuddytobook);
			model.addAttribute("addaddressbook", book);
			return "viewaddressbook";
		} else {
			model.addAttribute("addbuddytobook", addbuddytobook);
			return "addbuddytobookconfirm";
		}
	}
}