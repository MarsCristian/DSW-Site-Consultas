package dsw.trabalho.SistemaConsultasMedicas.Models.ValueObjects;

import dsw.trabalho.SistemaConsultasMedicas.Models.Exceptions.CPFParsingException;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

@Value
@Schema(implementation = String.class, description = "Email")
public class Cpf {
    String valor;
    int[] PESO_CPF = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };

    public Cpf(String valor){
        this.valor = validarCPF(valor);

    }


    private  String validarCPF(String cpf) {
        try{
            String cpfSomenteDigitos = cpf.replaceAll("\\D", "");

            if ((cpfSomenteDigitos == null) || (cpfSomenteDigitos.length() != 11) || cpfSomenteDigitos.equals("00000000000")
                    || cpfSomenteDigitos.equals("11111111111") || cpfSomenteDigitos.equals("22222222222")
                    || cpfSomenteDigitos.equals("33333333333") || cpfSomenteDigitos.equals("44444444444")
                    || cpfSomenteDigitos.equals("55555555555") || cpfSomenteDigitos.equals("66666666666")
                    || cpfSomenteDigitos.equals("77777777777") || cpfSomenteDigitos.equals("88888888888")
                    || cpfSomenteDigitos.equals("99999999999")) {

                throw new CPFParsingException("CPF INVALIDO"+cpf);//todo implementar Exception do cpf
            }

            int digito1 = calcularDigito(cpfSomenteDigitos.substring(0, 9), PESO_CPF);
            int digito2 = calcularDigito(cpfSomenteDigitos.substring(0, 9) + digito1, PESO_CPF);

            if(!cpfSomenteDigitos.equals(cpfSomenteDigitos.substring(0, 9) + digito1 + digito2)){
                throw new CPFParsingException("CPF INVALIDO"+cpf);//todo implementar Exception do cpf
            }

            return cpfSomenteDigitos;

        }catch (NumberFormatException e) { //invalid number
            throw new CPFParsingException("cpf is invalid: " + valor, e);//todo criar mensagem de telefone invalido
        }

    }

    private int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }


}
