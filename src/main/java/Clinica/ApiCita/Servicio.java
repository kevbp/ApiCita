package Clinica.ApiCita;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Servicio {
    
    @Autowired
    private Repositorio repo;

    public Cita grabar(Cita cit) {
        return repo.save(cit);
    }

    public Cita buscar(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Cita> listar() {
        return repo.findAll();
    }

    public Cita actualizar(Long id, Cita cit) {
        return repo.findById(id).map(existing -> {
            existing.setIdSlo(cit.getIdSlo());
            existing.setIdPac(cit.getIdPac());
            existing.setIdEsp(cit.getIdEsp());
            existing.setIdMed(cit.getIdMed());
            existing.setFec(cit.getFec());
            existing.setHor(cit.getHor());
            existing.setPre(cit.getPre());
            existing.setEstPag(cit.getEstPag());
            existing.setIdEmp(cit.getIdEmp());
            existing.setEstCit(cit.getEstCit());
            return repo.save(existing);
        }).orElse(null);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

}
