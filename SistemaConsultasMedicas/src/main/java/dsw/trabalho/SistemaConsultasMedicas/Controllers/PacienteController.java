package dsw.trabalho.SistemaConsultasMedicas.Controllers;

import dsw.trabalho.SistemaConsultasMedicas.Dtos.PacienteRecordDto;
import dsw.trabalho.SistemaConsultasMedicas.Models.Entities.PacienteModel;
import dsw.trabalho.SistemaConsultasMedicas.Repositories.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;

    @PostMapping("/paciente")
    public ResponseEntity<PacienteModel> savePaciente(@RequestBody @Valid PacienteRecordDto pacienteRecordDto){
        var pacienteModel = new PacienteModel();
        BeanUtils.copyProperties(pacienteModel,pacienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteRepository.save(pacienteModel));//uso do http 201
    }


    @GetMapping("/paciente")
    public ResponseEntity<List<PacienteModel>> getAllPacientes(){

        List<PacienteModel> pacienteModelList = pacienteRepository.findAll();

        for(PacienteModel paciente : pacienteModelList){
            UUID id = paciente.getIdPaciente();
            paciente.add(linkTo(methodOn(PacienteController.class).getOnePaciente(id)).withSelfRel());
        }

        return ResponseEntity.status(HttpStatus.OK).body(pacienteModelList);
    }

    //todo internacionalizar mensagens
    @GetMapping("/paciente/{id}")
    public ResponseEntity<Object> getOnePaciente(@PathVariable(value= "id") UUID id){

        Optional<PacienteModel> paciente0 = pacienteRepository.findById(id);

        if(paciente0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente nao encontrado.");
        }

        paciente0.get().add(linkTo(methodOn(PacienteController.class).getAllPacientes()).withRel("Lista Paciente"));
        return ResponseEntity.status(HttpStatus.OK).body(paciente0.get());
    }

    @PutMapping("/paciente/{id}")//upddating
    public ResponseEntity<Object> updatePaciente(@PathVariable(value= "id") UUID id, @RequestBody @Valid PacienteRecordDto pacienteRecordDto) {

        Optional<PacienteModel> paciente0 = pacienteRepository.findById(id);

        if (paciente0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente nao encontrado.");
        }

        var medicoModel = paciente0.get();//pega o antigfo
        BeanUtils.copyProperties(pacienteRecordDto, medicoModel);//converte pro novo
        return ResponseEntity.status(HttpStatus.OK).body(pacienteRepository.save(medicoModel));//salva
    }

    @DeleteMapping("/paciente/{id}")//deleting
    public ResponseEntity<Object> deletePaciente(@PathVariable(value= "id") UUID id) {

        Optional<PacienteModel> paciente0 = pacienteRepository.findById(id);

        if (paciente0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente nao encontrado.");
        }

        pacienteRepository.delete(paciente0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Deletado corretamente");
    }
}
