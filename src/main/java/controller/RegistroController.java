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
        ModelAndView modelAndView = new ModelAndView("registro");
        // Agregar cualquier objeto necesario al modelo
        return modelAndView;
    }

    @PostMapping
    public ModelAndView procesarRegistro(@RequestParam("name") String name,
                                         @RequestParam("surname") String surname,
                                         @RequestParam("email") String email,
                                         @RequestParam("password") String password,
                                         @RequestParam("password2") String password2) {
        // Procesar la información del formulario y realizar el registro en la base de datos, etc.
        // Aquí debes validar los datos, verificar si el usuario ya existe, etc.
        // Por simplicidad, asumiré que la validación es exitosa y simplemente redireccionaré al usuario a la página principal.

        ModelAndView modelAndView = new ModelAndView("redirect:/login");
        return modelAndView;
    }
}