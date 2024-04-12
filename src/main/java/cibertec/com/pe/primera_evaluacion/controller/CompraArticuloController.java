package cibertec.com.pe.primera_evaluacion.controller;


import cibertec.com.pe.primera_evaluacion.model.CompraArticuloModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompraArticuloController {

    @GetMapping("/calculadora")
    public String calculadoraCompra(Model model) {
        model.addAttribute("titulo", "Calculadora Articulo");
        model.addAttribute("articulo", new CompraArticuloModel());
        model.addAttribute("mostrarMensaje", false);

        return "calculadora-compra";
    }

    @PostMapping("calculadora")
    public String procesoCalculadora(@ModelAttribute("articulo") CompraArticuloModel articulo, Model model){
        model.addAttribute("titulo", "Calculadora Articulo");
        double precio_final = articulo.getPrecio() * articulo.getCantidad();
        double descuento = 0;
        String tipo = "nulo";
        if(articulo.getCantidad() > 20){
            descuento = 0.1;
            tipo = "del 10%";
        }

        else if (articulo.getCantidad() > 10){
            descuento = 0.05;
            tipo = "del 5%";
        }

        precio_final = precio_final - (precio_final * descuento);

        model.addAttribute("mostrarMensaje", true);
        model.addAttribute("resultado", "El precio a pagar es de : " + String.format("%.2f", precio_final) + ", con un descuento " + tipo );

        return "calculadora-compra";



    }


}
