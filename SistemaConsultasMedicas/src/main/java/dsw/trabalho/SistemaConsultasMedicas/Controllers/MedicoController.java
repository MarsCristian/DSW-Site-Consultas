package dsw.trabalho.SistemaConsultasMedicas.Controllers;


import dsw.trabalho.SistemaConsultasMedicas.Dtos.MedicoRecordDto;
import dsw.trabalho.SistemaConsultasMedicas.Models.Entities.MedicoModel;
import dsw.trabalho.SistemaConsultasMedicas.Repositories.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicoController {

    @Autowired
    MedicoRepository medicoRepository;//ponto de injecaom

    @PostMapping("/medicos") //create
    public ResponseEntity<MedicoModel> saveMedico(@RequestBody  @Valid MedicoRecordDto medicoRecordDto){
        var medicoModel = new MedicoModel();
        BeanUtils.copyProperties(medicoRecordDto,medicoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoRepository.save(medicoModel));//uso do http 201
    }

    @GetMapping("/medicos")
    public ResponseEntity<List<MedicoModel>> getAllMedicos(){
        return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.findAll());
    }
}
