package Controllers;


import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.xyinc.localizador.controller.CoordenadaController;
import br.com.xyinc.localizador.modelagem.Coordenada;
import br.com.xyinc.localizador.service.CoordenadaService;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author raone
 */
public class CoordenadaControllerTest {

    private CoordenadaController coordenadaController;
    private @Spy Result result;
    private @Mock CoordenadaService coordenadaService;
    private @Mock Coordenada teste;
    
    @Before
    public void setUp() throws Exception {
        result = new MockResult();
        MockitoAnnotations.initMocks(this);
        coordenadaController = new CoordenadaController(coordenadaService, result);
    }

    @Test()
    public void salvar() throws Exception {
        teste = new Coordenada();
        teste.setNome("teste");
        teste.setPosicaoX(10);
        teste.setPosicaoY(20);
        coordenadaController.cadastrarPOI(teste);
        assertTrue("Teste realizado com sucesso!", result.included().containsKey("success"));

    }

    @Test()
    public void buscarProximos() throws Exception {
        coordenadaController.buscarProximos(20, 30);
        assertTrue("Teste realizado com sucesso!", result.included().containsKey("success"));

    }

    @Test()
    public void buscarLista() throws Exception {
        coordenadaController.buscarLista();
        assertTrue("Teste realizado com sucesso!", result.included().containsKey("success"));

    }

}
