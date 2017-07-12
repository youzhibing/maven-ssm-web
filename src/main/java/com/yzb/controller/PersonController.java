package com.yzb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping("/person")
	@ResponseBody
	public Person showPerson(int personId)
	{
		return personService.getPerson(personId);
	}
}
