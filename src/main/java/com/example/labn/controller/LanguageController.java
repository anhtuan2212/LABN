package com.example.labn.controller;

import com.example.labn.entity.CountryEntity;
import com.example.labn.entity.LanguageEntity;
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
public class LanguageController {
    @Autowired
    HttpServletRequest req;
    @Autowired
    LanguageRepository languageRepository;

    @GetMapping("showlanguage")
    public String show(Model model) {
        String tukhoa = req.getParameter("tukhoa");
        if (tukhoa == null) tukhoa = "";
        List<LanguageEntity> lst = languageRepository.timkiem('%' + tukhoa + '%');
        model.addAttribute("lst", lst);
        return "./language/showlanguage";
    }

    @GetMapping("add-language")
    public String language(Model model) {
        model.addAttribute("lstlanguage", new LanguageEntity());
        return "./language/addlanguage";
    }

    @PostMapping("add-language")
    public String addlanguage(@ModelAttribute("listlanguage") LanguageEntity languageEntity) {
        languageRepository.save(languageEntity);
        return "redirect:showlanguage";
    }
}
