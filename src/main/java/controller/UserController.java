package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// ESTE 'RequestMapping' LO QUE HACE ES ESTABLECER '/user' COMO LA RUTA PRINCIPAL PARA ESTE '@Controller'.
@RequestMapping("/user")
public class UserController {
}
