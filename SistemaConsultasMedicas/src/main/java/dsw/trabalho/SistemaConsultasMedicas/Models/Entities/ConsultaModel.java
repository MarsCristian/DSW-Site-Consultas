package dsw.trabalho.SistemaConsultasMedicas.Models.Entities;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_Consulta")
public class ConsultaModel extends RepresentationModel<ConsultaModel> implements Serializable {
    //todo colocar aqui: id de medico crm, id de paciente cpf, data e hora da consulta
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String crmMedico;
    private String cpfPaciente;
    private String dataConsulta;
    private String horarioConsulta;

    public UUID getIdConsulta() {return id;}

    public void setIdConsulta(UUID id) {this.id = id;}

    public String getCrmMedico() {return crmMedico;}

    public void setCrmMedico(String crmMedico) {this.crmMedico = crmMedico;}

    public String getCpfPaciente() {return cpfPaciente;}

    public void setCpfPaciente(String cpfPaciente) {this.cpfPaciente = cpfPaciente;}

    public String getDataConsulta() {return dataConsulta;}

    public void setDataConsulta(String dataConsulta) {this.dataConsulta = dataConsulta;}

    public String getHorarioConsulta() {return horarioConsulta;}

    public void setHorarioConsulta(String horarioConsulta) {this.horarioConsulta = horarioConsulta;}
}
