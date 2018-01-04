package br.com.xyinc.localizador.modelagem;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name = "tb_coordenada")
public class Coordenada implements Serializable{

	 private static final long serialVersionUID = 2806421523585360625L;

	    @Id
            @GeneratedValue
	    private Integer id_coordenada;
	    private String nome;
	    @Column(columnDefinition = "INT(11) unsigned")
	    private Integer posicaoX;
	    @Column(columnDefinition = "INT(11) unsigned")
	    private Integer posicaoY;
	    
		public Integer getId_coordenada() {
			return id_coordenada;
		}
		public void setId_coordenada(Integer id_coordenada) {
			this.id_coordenada = id_coordenada;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public Integer getPosicaoX() {
			return posicaoX;
		}
		public void setPosicaoX(Integer posicaoX) {
			this.posicaoX = posicaoX;
		}
		public Integer getPosicaoY() {
			return posicaoY;
		}
		public void setPosicaoY(Integer posicaoY) {
			this.posicaoY = posicaoY;
		}
	    
	    
	
	
}
