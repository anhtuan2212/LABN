package com.example.labn.controller;

import com.example.labn.entity.AddressEntity;
import com.example.labn.entity.CityEntity;
import com.example.labn.entity.CountryEntity;
import com.example.labn.repository.AddressRepository;
import com.example.labn.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AddressController {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    HttpServletRequest req;
    @Autowired
    CityRepository cityRepository;

    @GetMapping("address")
    public String show(Model model) {
        String tukhoa = req.getParameter("tukhoa");
        if(tukhoa == null) tukhoa = "";
        List<AddressEntity> lst = addressRepository.timkiem('%' + tukhoa + '%' );
        model.addAttribute("lstadress", lst);
        return "./address/address";
    }
    @GetMapping("add-address")
    public String address(Model model){
        List<CityEntity> lstcity = cityRepository.getAll();
        model.addAttribute("lstcity",lstcity);
        model.addAttribute("listaddress",new AddressEntity());
        return "./address/addaddress";
    }
    @PostMapping("add-address")
    public String addaddress(@ModelAttribute("listaddress") AddressEntity addressEntity) {
        addressRepository.save(addressEntity);
        return "redirect:address";
    }
}
