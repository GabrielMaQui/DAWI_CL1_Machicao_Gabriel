package cibertec.com.pe.primera_evaluacion.controller;

import cibertec.com.pe.primera_evaluacion.model.YearModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Year;

@Controller
public class YearController {

    @GetMapping("/bisiesto")
    public String bisiesto(Model model) {
        model.addAttribute("titulo", "Examinador de Bisiestos");
        model.addAttribute("bisiesto", new YearModel());
        model.addAttribute("mostrarMensaje", false);
        return "bisiesto";
    }

    @PostMapping("/bisiesto")
    public String bisiesto(@ModelAttribute("bisiesto") YearModel yearModel, Model model) {
        model.addAttribute("titulo", "Examinador de Bisiestos");
        model.addAttribute("mostrarMensaje", true);

        if(yearModel.getYear() % 4 == 0 && yearModel.getYear() % 100 != 0 || yearModel.getYear() % 400 == 0 ){
            model.addAttribute("resultado", "Es un año Bisiesto");
        }
        else {
            model.addAttribute("resultado", "No es un año Bisiesto");
        }
        return "bisiesto";
    }

}
