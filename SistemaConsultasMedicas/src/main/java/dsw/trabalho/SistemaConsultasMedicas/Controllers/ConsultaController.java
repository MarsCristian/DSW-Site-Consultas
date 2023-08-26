package dsw.trabalho.SistemaConsultasMedicas.Controllers;


import dsw.trabalho.SistemaConsultasMedicas.Dtos.ConsultaRecordDto;
import dsw.trabalho.SistemaConsultasMedicas.Models.Entities.ConsultaModel;
import dsw.trabalho.SistemaConsultasMedicas.Repositories.ConsultaRepository;
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
public class ConsultaController {

    @Autowired
    ConsultaRepository consultaRepository;//ponto de injecaom

    @PostMapping("/consultas") //create
    public ResponseEntity<ConsultaModel> saveConsulta(@RequestBody  @Valid ConsultaRecordDto consultaRecordDto){
        var consultaModel = new ConsultaModel();
        BeanUtils.copyProperties(consultaRecordDto, consultaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaRepository.save(consultaModel));//uso do http 201
    }

    @GetMapping("/consultas")
    public ResponseEntity<List<ConsultaModel>> getAllConsultas(){
        List<ConsultaModel> consultaModelList = consultaRepository.findAll();

        //pra cada produto, obtem o id, .add pra construir link, basicamente usa o getOneConsulta
        for(ConsultaModel consulta : consultaModelList){
            UUID id = consulta.getIdConsulta();
            consulta.add(linkTo(methodOn(ConsultaController.class).getOneConsulta(id)).withSelfRel());
        }
        return ResponseEntity.status(HttpStatus.OK).body(consultaModelList);
    }

    @GetMapping("/consultas/{id}")
    public ResponseEntity<Object> getOneConsulta(@PathVariable(value= "id") UUID id){

        Optional<ConsultaModel> consulta0 = consultaRepository.findById(id);
        if(consulta0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta nao encontrado.");//todo criar mensagem
        }
        consulta0.get().add(linkTo(methodOn(ConsultaController.class).getAllConsultas()).withRel("Consultas List"));
        return ResponseEntity.status(HttpStatus.OK).body(consulta0.get());
    }

    @PutMapping("/consultas/{id}")//upddating
    public ResponseEntity<Object> updateConsulta(@PathVariable(value= "id") UUID id, @RequestBody @Valid ConsultaRecordDto consultaRecordDto) {

        Optional<ConsultaModel> consulta0 = consultaRepository.findById(id);
        if (consulta0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta nao encontrado.");//todo criar mensagem
        }
        var consultaModel = consulta0.get();//pega o antigfo
        BeanUtils.copyProperties(consultaRecordDto, consultaModel);//converte pro novo
        return ResponseEntity.status(HttpStatus.OK).body(consultaRepository.save(consultaModel));//salva
    }

    @DeleteMapping("/consultas/{id}")//deleting
    public ResponseEntity<Object> deleteConsulta(@PathVariable(value= "id") UUID id) {

        Optional<ConsultaModel> consulta0 = consultaRepository.findById(id);
        if (consulta0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta nao encontrado.");//todo criar mensagem
        }
        consultaRepository.delete(consulta0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Deletado corretamente");//salva
    }

}
