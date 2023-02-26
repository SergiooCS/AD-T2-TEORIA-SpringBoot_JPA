package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// ESTE 'RequestMapping' LO QUE HACE ES ESTABLECER '/admin' COMO LA RUTA PRINCIPAL PARA ESTE '@Controller'.
@RequestMapping("/admin")
public class AdministradorController {
}
