package br.com.xyinc.localizador.service;

import java.util.List;

import javax.inject.Inject;
import br.com.xyinc.localizador.dao.CoordenadaDao;
import br.com.xyinc.localizador.modelagem.Coordenada;


public class CoordenadaService {

	private CoordenadaDao dao;
	private final int VALORMAXIMODISTANCIA = 10;

        public CoordenadaService(){
            this(null);
        }
        
        @Inject
        public CoordenadaService(CoordenadaDao dao){
        this.dao = dao;
        }
        
	public List<Coordenada> buscarLista() {
		List<Coordenada> lista = dao.buscar();
		return lista;
	}

	public List<Coordenada> buscarAproximacao(int x, int y) {
		List<Coordenada> lista = dao.buscarPorAproximacao(x-VALORMAXIMODISTANCIA, x+VALORMAXIMODISTANCIA, y-VALORMAXIMODISTANCIA, y+VALORMAXIMODISTANCIA);
		return lista;
	}

	public void salvarCoordenada(Coordenada coordenada)throws Exception{
                //Evitando dois estabelecimentos na mesma localização. Só adiciona se não exister a posição no banco.
                Coordenada existente = dao.buscarPonto(coordenada.getPosicaoX(), coordenada.getPosicaoY());
                if(existente==null){
		dao.salvar(coordenada);
                }else{
                throw new Exception("Ponto já cadastrado no sistema.");
                }
	}


}
