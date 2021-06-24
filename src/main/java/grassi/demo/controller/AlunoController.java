package grassi.demo.controller;

import grassi.demo.model.Aluno;
import grassi.demo.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/v1")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @GetMapping("/aluno")
    public ResponseEntity<List<Aluno>> consultar() {
        List<Aluno> alunosNoBanco = alunoService.consultarAluno();
        return ResponseEntity.status(HttpStatus.OK).body(alunosNoBanco);
    }

    @PostMapping("/aluno")
    public ResponseEntity escrever(@RequestBody Aluno aluno) {
        alunoService.gravarAluno(aluno);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    
    @GetMapping("/web/teste")
    public String teste() {
        return "teste";
    }

    @GetMapping("/web/aluno")
    public ModelAndView renderizarAluno() {

        List<Aluno> alunosNoBanco = alunoService.consultarAluno();

        Map<String, Object> map = new HashMap<>();
        map.put("alunos", alunosNoBanco);

        return new ModelAndView("tabela", map);
    }

}
