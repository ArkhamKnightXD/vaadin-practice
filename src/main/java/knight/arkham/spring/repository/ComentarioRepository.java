package knight.arkham.spring.repository;

import knight.arkham.spring.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    Comentario findComentarioByContenido(String Contenido);

}
