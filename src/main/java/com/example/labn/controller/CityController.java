package com.example.labn.controller;

import com.example.labn.entity.CityEntity;
import com.example.labn.entity.CountryEntity;
import com.example.labn.repository.CityRepository;
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
public class CityController {
    @Autowired
    CityRepository cityRepository;
    @Autowired
    HttpServletRequest req;
    @Autowired
    ContryRepository contryRepository;

    @GetMapping("city")
    public String showcity(Model model) {
        String tukhoa = req.getParameter("tukhoa");
        if(tukhoa == null) tukhoa = "";
        List<CityEntity> lstcity = cityRepository.timkiem('%' + tukhoa + '%');
        model.addAttribute("lstcity",lstcity);
        return "./city/listCity";
    }
    @GetMapping("add-city")
    public String city(Model model){
        List<CountryEntity> lstcontry = contryRepository.getAll();
        model.addAttribute("lstcountry",lstcontry);
        model.addAttribute("listcity",new CityEntity());
        return "./city/addCity";
    }

    @PostMapping("add-city")
    public String addcity(@ModelAttribute("list") CityEntity cityEntity) {
        cityRepository.save(cityEntity);
        return "redirect:city";
    }
}
