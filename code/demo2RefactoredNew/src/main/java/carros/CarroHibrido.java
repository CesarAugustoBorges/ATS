package carros; /**
 * Classe que extende a classe veículo e que
 * representa um carro híbrido.
 * 
 */

import utils.ParDatas;

import java.util.List;

public class CarroHibrido extends Veiculo {
    
    /**
     * Construtor por omissão.
     * É criada uma instância da classe CarroHibrido.
     */
    public CarroHibrido(){
        super();
    }
    
    /**
     * Construtor por parâmetro.
     * @param marca       Marca do carro híbrido.
     * @param matricula   Matrícula do carro híbrido.
     * @param nif         NIF do proprietário do carro híbrido.
     * @param disponivel  True se o carro híbrido estiver disponível, false caso contrário.
     * @param classif     Classificação do carro híbrido.
     * @param datasAlugs  Datas dos alugueres do carro híbrido.
     */
    public CarroHibrido(String marca, String matricula, String nif, DesempenhoVeiculo desempenhoVeiculo,
                        boolean disponivel, int classif, List<ParDatas> datasAlugs){
        super(marca, matricula, nif, desempenhoVeiculo, disponivel, classif, datasAlugs);
    }
    
    /**
     * Construtor por cópia.
     * @param ch Um outro carro híbrido.
     */
    public CarroHibrido(CarroHibrido ch){
        super(ch);       
    }
        
    /**
     * Compara a igualdade com outro objeto.
     * @param obj O objeto a comparar.
     * @return true se forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if(obj==this) return true;
        if(obj==null || obj.getClass()!=this.getClass()) return false;
        CarroHibrido ch = (CarroHibrido) obj;
        return(super.equals(ch));
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    
    /** 
     * Devolve uma representação do objeto em formato textual.
     * @return String Representa o objeto em formato textual.
     */
    @Override
    public String toString() {
        return "***** Carro Híbrido *****\n" + super.toString();
    }
    
    /**
     * Retorna uma cópia da instância.
     * @return CarroHibrido Um novo carro híbrido, que é cópia do this.
     */
    @Override
    public CarroHibrido clone(){
        super.clone();
        return new CarroHibrido(this);
    }  
}