package cibertec.com.pe.primera_evaluacion.controller;


import cibertec.com.pe.primera_evaluacion.model.CompraArticuloModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompraArticuloController {

    @GetMapping("/calculadora")
    public String calculadoraCompra(Model model) {
        model.addAttribute("titulo", "Calculadora Articulo");
        model.addAttribute("articulo", new CompraArticuloModel());
        model.addAttribute("mostrarMensaje", false);

        return "calculadora-compra";
    }


}
