package carros; /**
 * Classe que extende a classe veículo e que
 * representa um carro a gasolina.
 * 
 */

import utils.ParDatas;

import java.util.List;

public class CarroGasolina extends Veiculo {
    
    /**
     * Construtor por omissão.
     * É criada uma instância da classe CarroGasolina.
     */
    public CarroGasolina(){
        super();
    }
    
    /**
     * Construtor por parâmetro.
     * @param marca       Marca do carro a gasolina.
     * @param matricula   Matrícula do carro a gasolina.
     * @param nif         NIF do proprietário do carro a gasolina.
     * @param disponivel  True se o carro a gasolina estiver disponível, false caso contrário.
     * @param classif     Classificação do carro a gasolina.
     * @param datasAlugs  Datas dos alugueres do carro a gasolina.
     */
    public CarroGasolina(String marca, String matricula, String nif, DesempenhoVeiculo desempenhoVeiculo,
                         boolean disponivel, int classif, List<ParDatas> datasAlugs){
        super(marca, matricula, nif, desempenhoVeiculo, disponivel, classif, datasAlugs);
    }
    
    /**
     * Construtor por cópia.
     * @param cg
     */
    public CarroGasolina(CarroGasolina cg){
        super(cg);       
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
        CarroGasolina cg = (CarroGasolina) obj;
        return(super.equals(cg));
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
        return "***** Carro a Gasolina *****\n" + super.toString();
    }
    
    /**
     * Retorna uma cópia da instância.
     * @return CarroGasolina Um novo carro a gasolina, que é cópia do this.
     */
    @Override
    public CarroGasolina clone(){
        super.clone();
        return new CarroGasolina(this);
    }  
}
