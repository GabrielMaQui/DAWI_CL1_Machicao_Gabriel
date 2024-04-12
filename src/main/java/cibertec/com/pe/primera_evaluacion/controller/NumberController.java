package cibertec.com.pe.primera_evaluacion.controller;


import cibertec.com.pe.primera_evaluacion.model.NumberModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NumberController {

    @GetMapping("/numero-perfecto")
    public String numerosPerfectos(Model model){

        model.addAttribute("titulo", "Número Perfecto");
        model.addAttribute("perfecto", new NumberModel());
        model.addAttribute("mostrarMensaje", false);
        return "numero-perfecto";
    }
}
