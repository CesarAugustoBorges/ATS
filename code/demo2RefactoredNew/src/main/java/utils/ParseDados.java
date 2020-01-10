package utils; /**
 * Classe que contém métodos para efetuar parsing de dados.
 *
 * 
 * 
 * 
 * @version 20190415
 */

import carros.*;
import utilizadores.Cliente;
import utilizadores.Proprietario;

import java.util.GregorianCalendar;
import java.util.Random;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class ParseDados{

    private ParseDados(){}

    public static Proprietario parseProprietario(String linha){
        String nome;
        String nif;
        String email;
        String morada;
        String [] dados = linha.split(",");
        int ano = new Random().ints(1950, 2000).findFirst().getAsInt();
        int mes = new Random().ints(0, 11).findFirst().getAsInt();
        int dia = new Random().ints(0, 30).findFirst().getAsInt();
        GregorianCalendar date = new GregorianCalendar(ano, mes, dia);

        nome = dados[0];
        nif = dados[1];
        email = dados[2];
        morada = dados[3];

        Proprietario prop = new Proprietario(nome, nif, email, nif, morada, date);

        return prop.clone();
    }

    public static Cliente parseCliente(String linha){
        String nome;
        String nif;
        String email;
        String morada;
        String [] dados = linha.split(",");
        int ano = new Random().ints(1950, 2000).findFirst().getAsInt();
        int mes = new Random().ints(1, 12).findFirst().getAsInt();
        int dia = new Random().ints(1, 31).findFirst().getAsInt();
        GregorianCalendar date = new GregorianCalendar(ano, mes, dia);
        double x = 0.0;
        double y = 0.0;


        nome = dados[0];
        nif = dados[1];
        email = dados[2];
        morada = dados[3];

        try {
            x = Double.parseDouble(dados[4]);
            y = Double.parseDouble(dados[5]);
        }
        catch(InputMismatchException exc){
            //Adicionado por César
            return null;
        }

        Coordinate cords = new Coordinate(x,y);

        Cliente cli = new Cliente(nome, nif, email, nif, morada, date, cords, 0, 0, 0.0);

        return cli.clone();

    }

    public static Veiculo parseVeiculo(String linha){
        String [] dados = linha.split(",");

        switch(dados[0]){
            case "Electrico":
                Veiculo ce = parseCarroEletrico(linha);
                return ce.clone();
            case "Hibrido":
                Veiculo ch = parseCarroHibrido(linha);
                return ch.clone();
            case "Gasolina":
                Veiculo cg = parseCarroGasolina(linha);
                return cg.clone();
            default: return new Veiculo();
        }
    }

    private static CarroEletrico parseCarroEletrico(String linha){
        Veiculo veiculo = parseDadosVeiculo(linha);
        if(veiculo == null) return new CarroEletrico();
        DesempenhoVeiculo desempenhoVeiculo = new DesempenhoVeiculo(veiculo.getVelocidade(),
                veiculo.getPreco(), veiculo.getConsumo(), veiculo.getAutonomia(), veiculo.getPosicao());
        return new CarroEletrico(veiculo.getMarca(), veiculo.getMatricula(), veiculo.getNIF(), desempenhoVeiculo ,
                veiculo.getDisponibilidade(), veiculo.getClassificacao(), new ArrayList<>());
    }

    private static CarroGasolina parseCarroGasolina(String linha){
        Veiculo veiculo = parseDadosVeiculo(linha);
        if(veiculo == null) return new CarroGasolina();
        DesempenhoVeiculo desempenhoVeiculo = new DesempenhoVeiculo(veiculo.getVelocidade(),
                veiculo.getPreco(), veiculo.getConsumo(), veiculo.getAutonomia(), veiculo.getPosicao());
        return new CarroGasolina(veiculo.getMarca(), veiculo.getMatricula(), veiculo.getNIF(), desempenhoVeiculo ,
                veiculo.getDisponibilidade(), veiculo.getClassificacao(), new ArrayList<>());
    }

    private static CarroHibrido parseCarroHibrido(String linha){
        Veiculo veiculo = parseDadosVeiculo(linha);
        if(veiculo == null) return new CarroHibrido();
        DesempenhoVeiculo desempenhoVeiculo = new DesempenhoVeiculo(veiculo.getVelocidade(),
                veiculo.getPreco(), veiculo.getConsumo(), veiculo.getAutonomia(), veiculo.getPosicao());
        return new CarroHibrido(veiculo.getMarca(), veiculo.getMatricula(), veiculo.getNIF(), desempenhoVeiculo ,
                veiculo.getDisponibilidade(), veiculo.getClassificacao(), new ArrayList<>());
    }

    private static Veiculo parseDadosVeiculo(String linha){
        String marca;
        String matricula;
        String nif;
        String [] dados = linha.split(",");
        int velocidade;
        int autonomia;
        double x;
        double y;
        double preco;
        double consumo;

        marca = dados[1];
        matricula = dados[2];
        nif = dados[3];

        try {
            velocidade = Integer.parseInt(dados[4]);
            preco = Double.parseDouble(dados[5]);
            consumo = Double.parseDouble(dados[6]);
            autonomia = Integer.parseInt(dados[7]);
            x = Double.parseDouble(dados[8]);
            y = Double.parseDouble(dados[9]);
        }
        catch(InputMismatchException exc){return null;}
        Coordinate cords = new Coordinate(x,y);
        DesempenhoVeiculo desempenhoVeiculo = new DesempenhoVeiculo(velocidade, preco, consumo, autonomia, cords);
        return new Veiculo(marca, matricula, nif, desempenhoVeiculo, true, 0, new ArrayList<>());
    }
}
