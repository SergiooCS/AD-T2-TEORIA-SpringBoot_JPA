package controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/denegado")
    public String denegado(){
        return "denegado";
    }

    @RequestMapping("/")
    public ModelAndView index(Authentication auth){
        ModelAndView mv = new ModelAndView();
        if(auth==null){
            mv.addObject("usuario", "No se ha iniciado sesion");
        }else{
            mv.addObject("usuario", auth.getName());
        }
        return mv;
    }

    @RequestMapping("/logout")
    public String logout(){
        return "logout";
    }

}
