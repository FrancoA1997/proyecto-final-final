package com.all4pets.Final.entidades.servicios;

import com.all4pets.Final.entidades.Usuario;
import com.all4pets.Final.enumeraciones.Rol;
import com.all4pets.Final.entidades.repositorios.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class UsuarioServicio implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepo;

    @Transactional
    public void crearUsuario(String nombre, String email, String clave) {
        
        Usuario u1 = new Usuario();
        u1.setNombre(nombre);
        u1.setEmail(email);
        u1.setRol(Rol.USUARIO);
        String claveEncriptada = new BCryptPasswordEncoder().encode(clave);
        u1.setClave(claveEncriptada);
        
        usuarioRepo.save(u1);
    }

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepo.buscarPorEmail(mail);
        if (usuario != null) {
            List<GrantedAuthority> permisos = new ArrayList<>();

            // Concateno la informacion del STRING del ENUM del rol del usuario
            GrantedAuthority p1 = new SimpleGrantedAuthority("ROLE_" + usuario.getRol());
            permisos.add(p1);

            //Esto me permite guardar el OBJETO USUARIO LOG, para luego ser utilizado
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            session.setAttribute("usuariosession", usuario);

            User user = new User(usuario.getEmail(), usuario.getClave(), permisos);
            return user;

        } else {
            return null;
        }

    }
}