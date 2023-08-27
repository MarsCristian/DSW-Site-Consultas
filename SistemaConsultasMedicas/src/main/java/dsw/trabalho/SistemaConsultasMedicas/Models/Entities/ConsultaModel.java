package dsw.trabalho.SistemaConsultasMedicas.Models.Entities;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_CONSULTA")
public class ConsultaModel extends RepresentationModel<ConsultaModel> implements Serializable {
    //todo colocar aqui: id de medico crm, id de paciente cpf, data e hora da consulta
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "id_medico")
    private MedicoModel medico;
    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private PacienteModel paciente;
    private String dataConsulta;
    private String horarioConsulta;

    public UUID getIdConsulta() {return id;}

    public void setIdConsulta(UUID id) {this.id = id;}

    public MedicoModel getMedico() {return medico;}

    public void setMedico(MedicoModel medico) {this.medico = medico;}

    public PacienteModel getPaciente() {return paciente;}

    public void setPaciente(PacienteModel paciente) {this.paciente = paciente;}

    public String getDataConsulta() {return dataConsulta;}

    public void setDataConsulta(String dataConsulta) {this.dataConsulta = dataConsulta;}

    public String getHorarioConsulta() {return horarioConsulta;}

    public void setHorarioConsulta(String horarioConsulta) {this.horarioConsulta = horarioConsulta;}
}