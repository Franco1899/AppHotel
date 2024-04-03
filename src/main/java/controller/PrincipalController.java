package controller;

import model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.UsuarioService;

@Controller
public class PrincipalController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login"; // Retorna el nombre de la vista correspondiente al formulario de inicio de sesión
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                RedirectAttributes redirectAttributes) {

        UserDetails usuario = usuarioService.loadUserByUsername(username); // Utiliza el método loadUserByUsername de UsuarioService

        if (usuario != null && usuario.getPassword().equals(password)) {
            // Usuario autenticado correctamente
            redirectAttributes.addFlashAttribute("mensaje", "¡Bienvenido, " + username + "!");
            return "redirect:/inicio"; // Redirecciona al usuario a la página de inicio si la autenticación es exitosa
        } else {
            // Credenciales incorrectas
            redirectAttributes.addFlashAttribute("error", "Nombre de usuario o contraseña incorrectos.");
            return "redirect:/login"; // Redirecciona al usuario al formulario de inicio de sesión si las credenciales son incorrectas
        }
    }

    @GetMapping("/inicio")
    public String paginaInicio(Model model) {
        // Lógica para cargar datos en la página de inicio
        return "inicio"; // Retorna el nombre de la vista correspondiente a la página de inicio
    }
}
