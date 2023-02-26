package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import services.TareaService;

@Controller
// ESTE 'RequestMapping' LO QUE HACE ES ESTABLECER '/tarea' COMO LA RUTA PRINCIPAL PARA ESTE '@Controller'.
@RequestMapping("/tarea")
public class TareaController {


    /*
    RUTA DE LOS DATOS --------------
    CLIENTE (HTML con THYMELEAF) / APP WEB -> @Controller -> @Service -> @Repository -> BASE DE DATOS.
    */





    // TENEMOS QUE IMPORTAR EL '@Service' DE TAREAS.
    @Autowired
    private TareaService tareaService;

    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView();
        tareaService.list();
        return mv;
    }



}
