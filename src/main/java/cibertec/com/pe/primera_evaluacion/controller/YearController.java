package cibertec.com.pe.primera_evaluacion.controller;

import cibertec.com.pe.primera_evaluacion.model.YearModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
