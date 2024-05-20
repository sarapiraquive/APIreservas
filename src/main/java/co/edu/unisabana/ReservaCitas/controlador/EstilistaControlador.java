package co.edu.unisabana.ReservaCitas.controlador;

import co.edu.unisabana.ReservaCitas.entidades.Estilista;
import co.edu.unisabana.ReservaCitas.services.EstilistaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/estilistas")
@Api(tags = "Estilista", description = "Operaciones de estilista")
public class EstilistaControlador {

    private final EstilistaService estilistaService;

    public EstilistaControlador(EstilistaService estilistaService) {
        this.estilistaService = estilistaService;
    }
    @ApiOperation("Obtener todos los estilistas")
    @GetMapping
    public List<Estilista> getAllEstilistas()
    {
        return estilistaService.getAllEstilistas();
    }

    @ApiOperation("Crear nuevo estilista")
    @PostMapping("/crear")
    public ResponseEntity<Estilista> crearEstilista(@RequestBody Estilista estilista) {
        Estilista estilistaCreado = estilistaService.crearEstilista(estilista);
        return new ResponseEntity<>(estilistaCreado, HttpStatus.CREATED);
    }
    @DeleteMapping("/eliminar/{estilistaId}")
    public ResponseEntity<Void> eliminarEstilista(@PathVariable Long estilistaId) {
        estilistaService.eliminarEstilista(estilistaId);
        return ResponseEntity.noContent().build();
    }
}