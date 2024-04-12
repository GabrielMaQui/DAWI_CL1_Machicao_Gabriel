package cibertec.com.pe.primera_evaluacion.controller;


import cibertec.com.pe.primera_evaluacion.model.NumberModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NumberController {

    @GetMapping("/numero-perfecto")
    public String numerosPerfectos(Model model){
        model.addAttribute("titulo", "Numero Perfecto");
        model.addAttribute("perfecto", new NumberModel());
        model.addAttribute("mostrarMensaje", false);
        return "numero-perfecto";
    }

    @PostMapping("/numero-perfecto")
    public String numerosPerfectos(@ModelAttribute("perfecto") NumberModel numeroPerfecto, Model model){
        int n = numeroPerfecto.getNumero();
        List<Integer> numeros = new ArrayList<Integer>();
        List<Boolean> isPerfect = new ArrayList<Boolean>();

        for (int i = 1; i <= n; i++){
            numeros.add(i);
            int suma = 0;
            for(int d = 1; d * d <= i; d++){
                if(i % d == 0){
                    suma += d;
                    if(d != i/d && d != 1){
                        suma += i/d;
                    }
                }
            }
            isPerfect.add(i == suma && i != 1);
        }
        model.addAttribute("numeros", numeros);
        model.addAttribute("isPerfect", isPerfect);
        model.addAttribute("mostrarMensaje", true);
        return "numero-perfecto";
    }
}
