package com.Fresh.ProyectoFormativo.Service.EspecialistaVCIMPL;

import com.Fresh.ProyectoFormativo.Documents.Comentarios;
import com.Fresh.ProyectoFormativo.Documents.EspecialistaVC;
import com.Fresh.ProyectoFormativo.Repository.EspecialistaVCRepo;
import com.Fresh.ProyectoFormativo.Service.EspecialistaVCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialistaVCIMPL implements EspecialistaVCService {
    private EspecialistaVCRepo repo;

    @Autowired
    public EspecialistaVCIMPL(EspecialistaVCRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<EspecialistaVC> getAllEspecialist() {
        return this.repo.findAll();
    }

    @Override
    public EspecialistaVC createEspecialst(EspecialistaVC newEspecialist) {
        return this.repo.save(newEspecialist);
    }

    @Override
    public void deleteEspecialst(String id) {
        this.repo.deleteById(id);
    }

    @Override
    public EspecialistaVC comentEspecialist(Comentarios newComent, String id) {
        EspecialistaVC oldEspecialist = this.repo.findById(id).get();
        List<Comentarios> oldComents = oldEspecialist.getComentarios();
        oldComents.add(newComent);
        oldEspecialist.setComentarios(oldComents);
        return this.repo.save(oldEspecialist);
    }

    @Override
    public EspecialistaVC voteEspecialist(Number vote, String id) {
        EspecialistaVC especialistasForVote = this.repo.findById(id).get();
        List<Number> actualVotes = especialistasForVote.getVotos();
        actualVotes.add(vote);
        var voteWrapper = new Object(){ Number voteCount = 0; };
        actualVotes.forEach(singleVote -> voteWrapper.voteCount = (int)singleVote + (int)voteWrapper.voteCount );
        voteWrapper.voteCount = (int)voteWrapper.voteCount / actualVotes.size();
        especialistasForVote.setVotos(actualVotes);
        especialistasForVote.setValoracion(voteWrapper.voteCount.doubleValue());
        return this.repo.save(especialistasForVote);
    }
}
