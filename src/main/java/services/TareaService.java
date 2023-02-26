package services;

import entities.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TareaRepository;

import java.util.List;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;
    public List<Tarea> list() {
        return tareaRepository.findAll();
    }
}
