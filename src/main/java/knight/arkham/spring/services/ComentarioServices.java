package knight.arkham.spring.services;

import knight.arkham.spring.model.Comentario;
import knight.arkham.spring.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioServices {

    @Autowired
    private ComentarioRepository comentarioRepository;


    public void createComentario(Comentario comentario){

        comentarioRepository.save(comentario);
    }


    public List<Comentario> listAllComentarios(){

        return comentarioRepository.findAll();
    }

    public void deleteComentario(String contenido){

        Comentario comentario= comentarioRepository.findComentarioByContenido(contenido);

        comentarioRepository.delete(comentario);

    }
}
