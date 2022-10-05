package com.example.labn.controller;

import com.example.labn.entity.CategoryEntity;
import com.example.labn.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    HttpServletRequest req;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("list-category")
    public String show(Model model) {
        String tukhoa = req.getParameter("tukhoa");
        if(tukhoa == null) tukhoa = "";
        List<CategoryEntity> danhsach = categoryRepository.timkiem('%' + tukhoa + '%');
        model.addAttribute("danhsach", danhsach);

        return "./category/listCategory";
    }

    @GetMapping("add-category")
    public String showAddScr(Model model) {
        model.addAttribute("category" , new CategoryEntity());
        return "./category/addCategory";
    }

    @PostMapping("add-category")
    public String addCategory(@ModelAttribute("category") CategoryEntity categoryEntity) {
        categoryRepository.save(categoryEntity);
        return "redirect:list-category";
    }

}
