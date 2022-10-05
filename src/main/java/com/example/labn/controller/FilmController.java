package com.example.labn.controller;

import com.example.labn.entity.AddressEntity;
import com.example.labn.entity.CityEntity;
import com.example.labn.entity.FilmEntity;
import com.example.labn.entity.LanguageEntity;
import com.example.labn.repository.FilmRepository;
import com.example.labn.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class FilmController {
    @Autowired
    HttpServletRequest req;
    @Autowired
    FilmRepository filmRepository;
    @Autowired
    LanguageRepository languageRepository;
    @GetMapping("film")
    public String showfilm(Model model){
        String tukhoa = req.getParameter("tukhoa");
        if(tukhoa == null) tukhoa = "";
        List<FilmEntity> lst = filmRepository.timkiem( tukhoa );
        model.addAttribute("lstfilm",lst);
        return "./film/film";
    }
    @GetMapping("add-film")
    public String film(Model model){
        List<LanguageEntity> lst = languageRepository.getAll();
        model.addAttribute("lstlanguage",lst);
        model.addAttribute("specnull","Behind the Scenes");
        model.addAttribute("listfilm",new FilmEntity());
        return "./film/addfilm";
    }
    @PostMapping("add-film")
    public String add(@ModelAttribute("film") FilmEntity filmEntity) {
        if (filmEntity.getSpecialFeatures().equals("asd")){
            filmEntity.setSpecialFeatures(null);
        }
        filmRepository.save(filmEntity);
        return "redirect:film";
    }
}
