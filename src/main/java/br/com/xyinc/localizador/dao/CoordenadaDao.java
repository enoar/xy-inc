package br.com.xyinc.localizador.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import br.com.xyinc.localizador.modelagem.Coordenada;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class CoordenadaDao {

    private Session session;

    @Inject
    public CoordenadaDao(Session session) {
        this.session = session;

    }

    public CoordenadaDao() {
        this(null);
    }

    public List<Coordenada> buscarPorAproximacao(int xInicial, int xFinal, int yInicial, int yFinal) {
        Criterion criterionX = Restrictions.between("posicaoX", xInicial, xFinal);
        Criterion criterionY = Restrictions.between("posicaoY", yInicial, yFinal);
        List<Coordenada> lista = session.createCriteria(Coordenada.class).add(criterionY).add(criterionX).list();
        return lista;
    }
    
      public Coordenada buscarPonto(int x, int y) {
        Criterion criterionX = Restrictions.eq("posicaoX",x);
        Criterion criterionY = Restrictions.eq("posicaoY", y);
        Coordenada ponto = (Coordenada) session.createCriteria(Coordenada.class).add(criterionY).add(criterionX).uniqueResult();
        return ponto;
    }

    public void salvar(Object object) {
        session.saveOrUpdate(object);
    }

    public List buscar() {
        List lista = session.createCriteria(Coordenada.class).list();
        return lista;
    }
}
