package grassi.demo.service;

import grassi.demo.model.Aluno;
import grassi.demo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository repo;

    public List<Aluno> consultarAluno(){
        return repo.findAll();
    }

    public void gravarAluno(Aluno aluno){
        repo.save(aluno);
    }

}
