package projektniZadatak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projektniZadatak.entity.Viewer;
import projektniZadatak.repository.ViewerRepository;

import javax.swing.text.View;
import java.util.List;

@Service
public class ViewerService {
    @Autowired
    private ViewerRepository viewerRepository;

    public Viewer findById(Long id){
        Viewer viewer = this.viewerRepository.findFirstById(id);
        return viewer;
    }

    public Viewer find(Long id){
        return this.viewerRepository.getOne(id);
    }
    public Viewer save(Viewer viewer){
        return this.viewerRepository.save(viewer);
    }
    public List<Viewer> findAll(){
        List<Viewer>viewers = this.viewerRepository.findAll();
        return viewers;
    }


}
