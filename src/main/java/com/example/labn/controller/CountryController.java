package com.example.labn.controller;

import com.example.labn.entity.CountryEntity;
import com.example.labn.repository.ContryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
public class CountryController {
    @Autowired
    HttpServletRequest req;
    @Autowired
    ContryRepository contryRepository;
    @GetMapping("country")
    public String show(Model model){
        String tukhoa = req.getParameter("tukhoa");
        if(tukhoa == null) tukhoa = "";
        List<CountryEntity> lst = contryRepository.timkiem('%' + tukhoa + '%');
        model.addAttribute("lst",lst);
        return "./country/country";
    }
    @GetMapping("add-country")
    public String contry(Model model){
        model.addAttribute("listcountry",new CountryEntity());
        return "./country/addcountry";
    }
    @PostMapping("add-country")
    public String addcontry(@ModelAttribute("listcountry") CountryEntity countryEntity) {
        contryRepository.save(countryEntity);
        return "redirect:country";
}
}
