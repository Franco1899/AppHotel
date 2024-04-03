package service;

import model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNombreUsuario(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }

        // Obtén los roles del usuario si los tienes en tu modelo de Usuario
        String[] roles = usuario.getRoles().toArray(new String[0]);

        // Construye y devuelve un objeto UserDetails usando los detalles del usuario
        return User.builder()
                .username(usuario.getNombreUsuario())
                .password(usuario.getPassword()) // Asigna la contraseña del usuario
                .roles(roles) // Asigna los roles del usuario
                .build();
    }

}
