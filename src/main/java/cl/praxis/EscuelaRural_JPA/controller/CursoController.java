package cl.praxis.EscuelaRural_JPA.controller;

import cl.praxis.EscuelaRural_JPA.model.entities.Curso;
import cl.praxis.EscuelaRural_JPA.model.service.CursoService;
import cl.praxis.EscuelaRural_JPA.model.service.EstudianteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CursoController {

    private final CursoService service;
    private final EstudianteService estudianteService;

    public CursoController(CursoService service, EstudianteService estudianteService) {
        this.service = service;
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("courses", service.findAll());
        return "coursesList";
    }

    @GetMapping("/{id}")
    public String findOne(@PathVariable("id") int id, Model model){
        model.addAttribute("course", service.findOne(id));
        return "courseEdit";
    }

    @GetMapping("/{id}/students")
    public String findStudentsByCourse(@PathVariable("id") int id, Model model){
        Curso curso = service.findOne(id);
        model.addAttribute("course", curso);
        model.addAttribute("students", estudianteService.findByCurso(curso));
        return "studentsByCourse";
    }

    @GetMapping("film/{id}")
    public String findOneP(@PathVariable("id") int id, Model model){
        model.addAttribute("course", service.findOne(id));
        return "courseOneList";
    }

    @PostMapping
    public String update(@ModelAttribute Curso course){
        boolean result = service.update(course);
        return "redirect:/courses";
    }

    @GetMapping("/new")
    public String toCreate(Model model){
        return "courseNew";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute Curso course){
        boolean result = service.create(course);
        return "redirect:/courses";
    }

    @GetMapping("/{id}/del")
    public String delete(@PathVariable("id") int id){
        boolean result = service.delete(id);
        return "redirect:/courses";
    }
}
