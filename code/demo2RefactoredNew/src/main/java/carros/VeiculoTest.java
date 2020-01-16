package carros;

import org.junit.Test;
import utils.ParDatas;
import utils.Weather;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

public class VeiculoTest {

    @Test
    public void getMarca() {
        Coordinate cords = new Coordinate(2,5);
        List<ParDatas> datas = new ArrayList<>();
        Veiculo novo = new Veiculo("opel","12-aa-23","1223214435",2,2.35,4.6,124,cords,true,4,datas);

        String marca = novo.getMarca();

        assertEquals("opel",marca);
    }

    @Test
    public void getMatricula() {
        Coordinate cords = new Coordinate(2,5);
        List<ParDatas> datas = new ArrayList<>();
        Veiculo novo = new Veiculo("opel","12-aa-23","1223214435",2,2.35,4.6,124,cords,true,4,datas);

        String matricula = novo.getMatricula();

        assertEquals("12-aa-23",matricula);
    }

    @Test
    public void getNIF() {
        Coordinate cords = new Coordinate(2,5);
        List<ParDatas> datas = new ArrayList<>();
        Veiculo novo = new Veiculo("opel","12-aa-23","1223214435",2,2.35,4.6,124,cords,true,4,datas);

        String nif = novo.getNIF();

        assertEquals("1223214435",nif);
    }

    @Test
    public void getVelocidade() {
        Coordinate cords = new Coordinate(2,5);
        List<ParDatas> datas = new ArrayList<>();
        Veiculo novo = new Veiculo("opel","12-aa-23","1223214435",2,2.35,4.6,124,cords,true,4,datas);

        int velocidade=novo.getVelocidade();

        assertEquals(2,velocidade);
    }

    @Test
    public void getPreco() {
        Coordinate cords = new Coordinate(2,5);
        List<ParDatas> datas = new ArrayList<>();
        Veiculo novo = new Veiculo("opel","12-aa-23","1223214435",2,2.35,4.6,124,cords,true,4,datas);

        double preco = novo.getPreco();

        assertEquals( 2.35,preco,0.001);
    }

    @Test
    public void getConsumo() {
        Coordinate cords = new Coordinate(2,5);
        List<ParDatas> datas = new ArrayList<>();
        Veiculo novo = new Veiculo("opel","12-aa-23","1223214435",2,2.35,4.6,124,cords,true,4,datas);

        double consumo = novo.getConsumo();

        assertEquals(4.6,consumo,0.001);
    }

    @Test
    public void getAutonomia() {
        Coordinate cords = new Coordinate(2,5);
        List<ParDatas> datas = new ArrayList<>();
        Veiculo novo = new Veiculo("opel","12-aa-23","1223214435",2,2.35,4.6,124,cords,true,4,datas);

        int autonomia = novo.getAutonomia();

        assertEquals(124,autonomia);
    }

    @Test
    public void getPosicao() {
        Coordinate cords = new Coordinate(2,5);
        List<ParDatas> datas = new ArrayList<>();
        Veiculo novo = new Veiculo("opel","12-aa-23","1223214435",2,2.35,4.6,124,cords,true,4,datas);

        Coordinate cordTest = novo.getPosicao();

        assertEquals(cords,cordTest);
    }

    @Test
    public void getDisponibilidade() {
        Coordinate cords = new Coordinate(2,5);
        List<ParDatas> datas = new ArrayList<>();
        Veiculo novo = new Veiculo("opel","12-aa-23","1223214435",2,2.35,4.6,124,cords,true,4,datas);

        boolean disponibilidade = novo.getDisponibilidade();

        assertEquals(true,disponibilidade);
    }

    @Test
    public void getClassificacao() {
        Coordinate cords = new Coordinate(2,5);
        List<ParDatas> datas = new ArrayList<>();
        Veiculo novo = new Veiculo("opel","12-aa-23","1223214435",2,2.35,4.6,124,cords,true,4,datas);

        int classificacao = novo.getClassificacao();

        assertEquals(classificacao, 4);
    }

    @Test
    public void getDatasAlugueres() {
        Veiculo novo = new Veiculo();

        GregorianCalendar g1 = new GregorianCalendar(2018, 6, 25, 16, 16, 47);
        GregorianCalendar g2 = new GregorianCalendar( 2018, 6, 30, 16, 30, 47);
        ParDatas p1 = new ParDatas(g1,g2);

        GregorianCalendar g3 = new GregorianCalendar(2018,7,1,16,46,33);
        GregorianCalendar g4 = new GregorianCalendar(2018, 7,7,16,30,56);
        ParDatas p2 = new ParDatas(g3,g4);

        List<ParDatas> datas = new ArrayList<>(Arrays.asList(p1,p2));
        novo.setDatasAlugueres(datas);

        assertTrue(datas.equals(novo.getDatasAlugueres()));
    }

    @Test
    public void setMarca() {
        Coordinate cords = new Coordinate(2,5);
        List<ParDatas> datas = new ArrayList<>();
        Veiculo novo = new Veiculo("opel","12-aa-23","1223214435",2,2.35,4.6,124,cords,true,4,datas);

        novo.setMarca("renault");

        assertEquals("renault",novo.getMarca());
    }

    @Test
    public void setMatricula() {
        Coordinate cords = new Coordinate(2,5);
        List<ParDatas> datas = new ArrayList<>();
        Veiculo novo = new Veiculo("opel","12-aa-23","1223214435",2,2.35,4.6,124,cords,true,4,datas);

        novo.setMatricula("01-01-aa");

        assertEquals("01-01-aa",novo.getMatricula());
    }

    @Test
    public void setNIF() {
        Coordinate cords = new Coordinate(2,5);
        List<ParDatas> datas = new ArrayList<>();
        Veiculo novo = new Veiculo("opel","12-aa-23","1223214435",2,2.35,4.6,124,cords,true,4,datas);

        novo.setNIF("1111111111111");

        assertEquals("1111111111111",novo.getNIF());
    }

    @Test
    public void setVelocidade() {
        Coordinate cords = new Coordinate(2,5);
        List<ParDatas> datas = new ArrayList<>();
        Veiculo novo = new Veiculo("opel","12-aa-23","1223214435",2,2.35,4.6,124,cords,true,4,datas);

        novo.setVelocidade(4);

        assertEquals(4,novo.getVelocidade());
    }

    @Test
    public void setPreco() {
        Coordinate cords = new Coordinate(2,5);
        List<ParDatas> datas = new ArrayList<>();
        Veiculo novo = new Veiculo("opel","12-aa-23","1223214435",2,2.35,4.6,124,cords,true,4,datas);

        novo.setPreco(22.22);

        assertEquals(22.22,novo.getPreco(),0.001);
    }

    @Test
    public void setConsumo() {
        Coordinate cords = new Coordinate(2,5);
        List<ParDatas> datas = new ArrayList<>();
        Veiculo novo = new Veiculo("opel","12-aa-23","1223214435",2,2.35,4.6,124,cords,true,4,datas);

        novo.setConsumo(8.8);

        assertEquals(8.8,novo.getConsumo(),0.001);

    }

    @Test
    public void setAutonomia() {
        Coordinate cords = new Coordinate(2,5);
        List<ParDatas> datas = new ArrayList<>();
        Veiculo novo = new Veiculo("opel","12-aa-23","1223214435",2,2.35,4.6,124,cords,true,4,datas);

        novo.setAutonomia(12);

        assertEquals(12,novo.getAutonomia());
    }

    @Test
    public void setPosicao() {
        Coordinate cords = new Coordinate(2,5);
        Veiculo novo = new Veiculo();

        novo.setPosicao(cords);

        assertEquals(cords,novo.getPosicao());
    }

    @Test
    public void setDisponibilidade() {
        Coordinate cords = new Coordinate(2,5);
        List<ParDatas> datas = new ArrayList<>();
        Veiculo novo = new Veiculo("opel","12-aa-23","1223214435",2,2.35,4.6,124,cords,true,4,datas);

        novo.setDisponibilidade(false);

        assertFalse(novo.getDisponibilidade());
    }

    @Test
    public void setClassificacao() {
        Coordinate cords = new Coordinate(2,5);
        List<ParDatas> datas = new ArrayList<>();
        Veiculo novo = new Veiculo("opel","12-aa-23","1223214435",2,2.35,4.6,124,cords,true,4,datas);

        novo.setClassificacao(1);

        assertEquals(1,novo.getClassificacao());
    }

    @Test
    public void tempoAteVeiculoPe() {
        Veiculo novo = new Veiculo();

        Coordinate c1 = new Coordinate(4,3);
        Coordinate c2 = new Coordinate(0,0);

        novo.setPosicao(c1);

        double dist = c2.getDistancia(novo.getPosicao());
        long tempo = Math.round((dist*60)/4 * Weather.getPercentage(4,3));

        assertEquals(tempo,novo.tempoAteVeiculoPe(c2));
    }

    @Test
    public void tempoViagemCarro() {
        Veiculo novo = new Veiculo();

        Coordinate c1 = new Coordinate(4,3);
        Coordinate c2 = new Coordinate(0,0);

        novo.setPosicao(c1);

        double dist = c2.getDistancia(novo.getPosicao());
        long tempo = Math.round((dist*60)/70 * Weather.getPercentage(4,3));

        assertEquals(tempo,novo.tempoViagemCarro(c2));
    }

    @Test
    public void tempoAteVeiculoPeJa() {
        Veiculo novo = new Veiculo();

        Coordinate c1 = new Coordinate(4,3);
        Coordinate c2 = new Coordinate(0,0);

        novo.setPosicao(c1);

        double dist = c2.getDistancia(novo.getPosicao());
        long tempo = Math.round((dist*60)/4);

        assertEquals(tempo,novo.tempoAteVeiculoPeJa(c2));
    }

    @Test
    public void tempoViagemCarroJa() {
        Veiculo novo = new Veiculo();

        Coordinate c1 = new Coordinate(4,3);
        Coordinate c2 = new Coordinate(0,0);

        novo.setPosicao(c1);

        double dist = c2.getDistancia(novo.getPosicao());
        long tempo = Math.round((dist*60));

        assertEquals(tempo,novo.tempoAteVeiculoPe(c2));
    }

    @Test
    public void custoViagem() {
        Coordinate cords = new Coordinate(2,5);
        List<ParDatas> datas = new ArrayList<>();
        Veiculo novo = new Veiculo("opel","12-aa-23","1223214435",2,2.35,4.6,124,cords,true,4,datas);

        double testPreco = novo.custoViagem(55.5);
        double actual = 55.5*2.35;

        assertEquals(actual,testPreco,0.0001);
    }

    @Test
    public void verificaAutonomia() {
        Coordinate cords= new Coordinate(2,5);
        List<ParDatas> datas= new ArrayList<>();
        Veiculo novo= new Veiculo("opel","12-aa-23","1223214435",2,2.35,4.6,124,cords,true,4,datas);

        boolean a= novo.verificaAutonomia(100,200);

        assertTrue(a);
    }

}