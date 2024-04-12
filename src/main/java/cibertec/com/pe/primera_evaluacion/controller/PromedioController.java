package cibertec.com.pe.primera_evaluacion.controller;

import cibertec.com.pe.primera_evaluacion.model.PromedioModel;
import cibertec.com.pe.primera_evaluacion.model.YearModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PromedioController {

    @GetMapping("/promedio")
    public String promedio(Model model) {
        model.addAttribute("titulo", "Calculadora de Promedio");
        model.addAttribute("notas", new PromedioModel());
        model.addAttribute("mostrarMensaje", false);
        return "promedio";
    }


}
