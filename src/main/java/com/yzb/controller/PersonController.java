package com.yzb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yzb.model.Person;
import com.yzb.service.IPersonService;

@Controller
@RequestMapping("/personController")
public class PersonController
{

	@Autowired
	private IPersonService personService;

	@RequestMapping("/showPerson")
	public String showPersons(Model model)
	{
		List<Person> persons = personService.listAllPerson();
		model.addAttribute("persons", persons);
		return "showperson";
	}
}
