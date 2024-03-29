package controller;

import model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
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
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                RedirectAttributes redirectAttributes) {

        Usuario usuario = usuarioService.buscarPorNombreUsuario(username);

        if (usuario != null && usuario.getPassword().equals(password)) {
            // Usuario autenticado correctamente
            redirectAttributes.addFlashAttribute("mensaje", "¡Bienvenido, " + username + "!");
            return "redirect:/inicio";
        } else {
            // Credenciales incorrectas
            redirectAttributes.addFlashAttribute("error", "Nombre de usuario o contraseña incorrectos.");
            return "redirect:/login";
        }
    }

    @GetMapping("/inicio")
    public String paginaInicio(Model model) {
        // Lógica para cargar datos en la página de inicio
        return "inicio";
    }
}