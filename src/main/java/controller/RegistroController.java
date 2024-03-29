package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/registro")
public class RegistroController {

    @GetMapping
    public ModelAndView mostrarFormularioRegistro() {
        ModelAndView modelAndView = new ModelAndView("Registro");
        // Agregar cualquier objeto necesario al modelo
        return modelAndView;
    }

    @PostMapping
    public ModelAndView procesarRegistro(@RequestParam("username") String username,
                                         @RequestParam("password") String password) {
        // Procesar la información del formulario y realizar el registro en la base de datos, etc.
        ModelAndView modelAndView = new ModelAndView("redirect:/inicio");
        return modelAndView;
    }
}
