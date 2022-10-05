package com.example.labn.controller;

import com.example.labn.entity.ActorEntity;
import com.example.labn.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ActorController {
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    HttpServletRequest req;

    @GetMapping("actor")
    public String showactor(Model model) {
        String tukhoa = req.getParameter("tukhoa");
        if(tukhoa == null) tukhoa = "";
        List<ActorEntity> lstactor = actorRepository.timkiem('%' + tukhoa + '%');
        model.addAttribute("lstactor", lstactor);
        return "./actor/listactor";


    }
    @GetMapping("add-actor")
    public String actor(Model model){
        model.addAttribute("actor",new ActorEntity());
        return "./actor/actor";
    }
    @PostMapping("add-actor")
    public String addactor(@ModelAttribute("actor") ActorEntity actorEntity) {
        actorRepository.save(actorEntity);
        return "redirect:actor";
    }
}
