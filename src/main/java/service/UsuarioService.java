package service;

import model.Usuario;
import repository.UsuarioRepository;
import controller.PrincipalController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario buscarPorNombreUsuario(String nombreUsuario) {

        return usuarioRepository.findByNombreUsuario(nombreUsuario);


    }
}
