package Clinica.ApiCita;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/cita")
public class Control {
    
    @Autowired
    private final Servicio serv;

    public Control(Servicio servicio) {
        this.serv = servicio;
    }

    @PostMapping("/grabar")
    public Cita grabar(@RequestBody Cita cit) {
        return serv.grabar(cit);
    }

    @GetMapping("/buscar/{id}")
    public Cita buscar(@PathVariable Long id) {
        return serv.buscar(id);
    }

    @GetMapping("/listar")
    public List<Cita> listar() {
        return serv.listar();
    }

    @PutMapping("/actualizar/{id}")
    public Cita actualizar(@PathVariable Long id, @RequestBody Cita cit) {
        return serv.actualizar(id, cit);
    }
}
