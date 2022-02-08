package com.nt.nareshit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nt.nareshit.dao.AlienRepo;
import com.nt.nareshit.model.Alien;

@Controller
public class HomeController {
	@Autowired
	AlienRepo repo;
	
	/*
	 * @RequestMapping("/") public String home(String name) { return "home.jsp";
	 * 
	 * }
	 */
	
	@RequestMapping("/addAlien")//http://localhost:8080/addAlien
	public String addAlien(Alien alien) {
		repo.save(alien);
		
		return "home.jsp";
		
	}
	/*
	@RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int aid) {
		
    	ModelAndView mv =new ModelAndView("showAlien.jsp");
    	Alien alien=repo.findById(aid).orElse(new Alien());
    	//System.out.println(alien);
    	
        System.out.println(repo.findByTech("java"));
        //System.out.println(repo.findByAidGreaterThan(102)); //List<Alien> findAidGreaterThan(int aid);
        System.out.println(repo.findByTechSorted("java"));
    	mv.addObject(alien);
		return mv;

    }
	*/
	
	@RequestMapping("/alien/{aid}")
	@ResponseBody
     public Optional<Alien> getAliens(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}

}
