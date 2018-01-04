package br.com.xyinc.localizador.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.xyinc.localizador.modelagem.Coordenada;
import br.com.xyinc.localizador.service.CoordenadaService;

@Controller
public class CoordenadaController {

    private CoordenadaService servicoCoordenada;
    private Result result;

    public CoordenadaController() {
        this(null, null);
    }

    @Inject
    public CoordenadaController(CoordenadaService servicoCoordenada, Result result) {
        this.servicoCoordenada = servicoCoordenada;
        this.result = result;
    }

    @Path("/todosPoi")
    public void buscarLista() {
        try {
            List<Coordenada> lista = servicoCoordenada.buscarLista();
            result.use(Results.json()).from(lista).serialize();
            result.include("success", "Incluído com sucesso.");
        } catch (Exception ex) {
            result.use(Results.http()).sendError(500);
        }
    }

    @Get("/estabelecimentosProximos")
    public void buscarProximos(int x, int y) {
        try {
            List<Coordenada> lista = servicoCoordenada.buscarAproximacao(x, y);
            result.use(Results.json()).from(lista).serialize();
            result.include("success", "Incluído com sucesso.");
        } catch (Exception ex) {
            result.use(Results.http()).sendError(500);
        }
    }

    @Post("/cadastrarPoi")
    public void cadastrarPOI(Coordenada coordenada) {
        try {
            servicoCoordenada.salvarCoordenada(coordenada);
            result.include("success", "Incluído com sucesso.");
        }catch (Exception ex) {
            result.use(Results.http()).sendError(500);
        }
    }
}
