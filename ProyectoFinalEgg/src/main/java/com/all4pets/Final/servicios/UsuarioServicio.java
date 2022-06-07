package com.all4pets.Final.servicios;

import com.all4pets.Final.entidades.Imagen;
import com.all4pets.Final.entidades.Usuario;
import com.all4pets.Final.enumeraciones.Rol;
import com.all4pets.Final.enumeraciones.Sexo;
import com.all4pets.Final.excepciones.ExcepcionPropia;
import com.all4pets.Final.repositorios.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
import org.springframework.web.multipart.MultipartFile;

@Service
public class UsuarioServicio implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepo;
    
    @Autowired
    private ImagenServicio imagenServicio;

    @Transactional
    public Usuario registrar(String nombre, String email, String clave) throws ExcepcionPropia {

        validar(nombre, email, clave);

        Usuario usuario = new Usuario();

        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setAlta(Boolean.TRUE);
        usuario.setRol(Rol.USUARIO);

        String claveEncriptada = new BCryptPasswordEncoder().encode(clave);
        usuario.setClave(claveEncriptada);

        return usuarioRepo.save(usuario);
    }

    public void modificar(String id, String nombre, String email, String clave, Sexo sexo, Integer edad, MultipartFile archivo) throws ExcepcionPropia {

        validar(nombre, email, clave);
        
        Optional<Usuario> respuesta = usuarioRepo.findById(id);
        if (respuesta.isPresent()) {
            Usuario usuario = respuesta.get();

            usuario.setNombre(nombre);
            usuario.setEmail(email);
            usuario.setSexo(sexo);
            usuario.setEdad(edad);

            String claveEncriptada = new BCryptPasswordEncoder().encode(clave);
            usuario.setClave(claveEncriptada);
            
            Imagen imagen = imagenServicio.multiPartToEntity(archivo);
            usuario.setImagen(imagen);
            
            usuarioRepo.save(usuario);
        } else {
            throw new ExcepcionPropia("No se encontro el usuario solicitado");
        }

    }
    
    public void deshabilitar(String id) throws ExcepcionPropia {
        
        Optional<Usuario> respuesta = usuarioRepo.findById(id);
        if (respuesta.isPresent()) {
            Usuario usuario = respuesta.get();         
            usuario.setAlta(Boolean.FALSE);           
            usuarioRepo.save(usuario);
        } else {
            throw new ExcepcionPropia("No se encontro el usuario solicitado");
        }
        
    }
    
    public void habilitar(String id) throws ExcepcionPropia {
        
        Optional<Usuario> respuesta = usuarioRepo.findById(id);
        if (respuesta.isPresent()) {
            Usuario usuario = respuesta.get();         
            usuario.setAlta(Boolean.TRUE);           
            usuarioRepo.save(usuario);
        } else {
            throw new ExcepcionPropia("No se encontro el usuario solicitado");
        }
        
    }

    private void validar(String nombre, String email, String clave) throws ExcepcionPropia {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ExcepcionPropia("Por favor, indique su nombre");
        }

        if (email == null || email.trim().isEmpty()) {
            throw new ExcepcionPropia("Por favor, indique su email");
        }

        if (clave == null || clave.trim().isEmpty()) {
            throw new ExcepcionPropia("Por favor, indique su clave");
        }

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