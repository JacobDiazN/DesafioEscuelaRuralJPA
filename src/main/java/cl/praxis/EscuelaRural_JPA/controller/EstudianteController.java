package cl.praxis.EscuelaRural_JPA.controller;

import cl.praxis.EscuelaRural_JPA.model.entities.Estudiante;
import cl.praxis.EscuelaRural_JPA.model.service.CursoService;
import cl.praxis.EscuelaRural_JPA.model.service.EstudianteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class EstudianteController {

    private final EstudianteService service;
    private final CursoService cursoService;

    public EstudianteController(EstudianteService service, CursoService cursoService) {
        this.service = service;
        this.cursoService = cursoService;
    }

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("students", service.findAll());
        return "studentsList";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable("id") int id, Model model){
        model.addAttribute("student", service.findOne(id));
        model.addAttribute("cursos", cursoService.findAll());
        return "studentEdit";
    }

    @GetMapping("student/{id}")
    public String findOneP(@PathVariable("id") int id, Model model){
        model.addAttribute("student", service.findOne(id));
        return "studentOneList";
    }

    @PostMapping
    public String update(@ModelAttribute Estudiante student){
        boolean result = service.update(student);
        return "redirect:/students";
    }

    @GetMapping("/new")
    public String toCreate(Model model){
        model.addAttribute("student", new Estudiante());
        model.addAttribute("cursos", cursoService.findAll());
        return "studentNew";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute Estudiante student){
        boolean result = service.create(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/del")
    public String delete(@PathVariable("id") int id){
        boolean result = service.delete(id);
        return "redirect:/students";
    }
}
