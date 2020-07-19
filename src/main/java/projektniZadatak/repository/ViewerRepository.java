package projektniZadatak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projektniZadatak.entity.Viewer;

import javax.swing.text.View;

public interface ViewerRepository extends JpaRepository<Viewer,Long> {
    public Viewer findFirstById(Long id);
}
