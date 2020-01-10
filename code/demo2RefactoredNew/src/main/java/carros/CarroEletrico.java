package carros; /**
 * Classe que extende a classe veículo e que
 * representa um carro elétrico.
 * 
 */

import utils.ParDatas;

import java.util.List;

public class CarroEletrico extends Veiculo {
    
    /**
     * Construtor por omissão.
     * É criada uma instância da classe CarroEletrico.
     */
    public CarroEletrico(){
        super();
    }
    
    /**
     * Construtor por parâmetro.
     * @param marca       Marca do carro elétrico.
     * @param matricula   Matrícula do carro elétrico.
     * @param nif         NIF do proprietário do carro elétrico.
     * @param disponivel  True se o carro elétrico estiver disponível, false caso contrário.
     * @param classif     Classificação do carro elétrico.
     * @param datasAlugs  Datas dos alugueres do carro a gasolina.
     */
    public CarroEletrico(String marca, String matricula, String nif, DesempenhoVeiculo desempenhoVeiculo,
                         boolean disponivel, int classif, List<ParDatas> datasAlugs){
        super(marca, matricula, nif, desempenhoVeiculo, disponivel, classif, datasAlugs);
    }
    
    /**
     * Construtor por cópia.
     * @param ce Um outro carro elétrico.
     */
    public CarroEletrico(CarroEletrico ce){
        super(ce);       
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
        CarroEletrico ce = (CarroEletrico) obj;
        return(super.equals(ce));
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
        return "***** Carro Elétrico *****\n" + super.toString();
    }
    
    /**
     * Retorna uma cópia da instância.
     * @return CarroEletrico Um novo carro elétrico, que é cópia do this.
     */
    @Override
    public CarroEletrico clone(){
        super.clone();
        return new CarroEletrico(this);
    }  
}