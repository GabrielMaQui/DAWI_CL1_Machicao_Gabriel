package cibertec.com.pe.primera_evaluacion.controller;

import cibertec.com.pe.primera_evaluacion.model.PromedioModel;
import cibertec.com.pe.primera_evaluacion.model.YearModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PromedioController {

    @GetMapping("/promedio")
    public String promedio(Model model) {
        model.addAttribute("titulo", "Calculadora de Promedio");
        model.addAttribute("notas", new PromedioModel());
        model.addAttribute("mostrarMensaje", false);
        return "promedio";
    }

    @PostMapping("/promedio")
    public String promedio( @ModelAttribute("notas") PromedioModel notas, Model model) {

        double promedio = notas.getNota1() + notas.getNota2() + notas.getNota3();
        promedio /= 3.0;
        String mensaje = "El promedio es: " + String.format("%.2f", promedio);
        if(promedio >= 70) {
            mensaje += "; usted a aprobado.";
        }

        else {
            mensaje += "; usted a desaprobado.";
        }
        model.addAttribute("resultado", mensaje);
        model.addAttribute("mostrarMensaje", true);
        return "promedio";
    }


}
