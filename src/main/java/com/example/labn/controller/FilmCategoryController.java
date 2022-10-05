package com.example.labn.controller;

import com.example.labn.entity.*;
import com.example.labn.repository.CategoryRepository;
import com.example.labn.repository.FilmCategoryRepository;
import com.example.labn.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FilmCategoryController {
    @Autowired
    FilmCategoryRepository filmCategoryRepository;
      @Autowired
      CategoryRepository categoryRepository;
      @Autowired
    FilmRepository filmRepository;


    @GetMapping("filmcategory")
    public String show(Model model) {
        List<FilmCategoryEntity> listfilm = filmCategoryRepository.getAll();
        model.addAttribute("lst",listfilm);
        return "./film_category/film-category";
    }
    @GetMapping("add-film-category")
    public String city(Model model){
        List<FilmEntity> lstfilm = filmRepository.getAll();
        List<CategoryEntity> lstcate = categoryRepository.getAllCategory();
        model.addAttribute("lstcate",lstcate);
        model.addAttribute("lstfilm",lstfilm);
        model.addAttribute("lstfilmcate",new FilmCategoryEntity());
        return "./film_category/add";
    }
    @PostMapping("add-film-category")
    public String add(@ModelAttribute("list") FilmCategoryEntity cityEntity) {
        filmCategoryRepository.save(cityEntity);
        return "redirect:filmcategory";
    }
}
