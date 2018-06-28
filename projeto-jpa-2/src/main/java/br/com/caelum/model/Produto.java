package br.com.caelum.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)

/*
 * A estratégia READ_ONLY deve ser utilizada quando uma entidade não deve ser
 * modificada.
 * 
 * A estratégia READ_WRITE deve ser utilizada quando uma entidade pode ser
 * modificada e há grandes chances que modificações em seu estado ocorram
 * simultaneamente. Essa estratégia é a que mais consome recursos.
 * 
 * A estratégia NONSTRICT_READ_WRITE deve ser utilizada quando uma entidade pode
 * ser modificada, mas é incomum que as alterações ocorram ao mesmo tempo. Ela
 * consome menos recursos que a estratégia READ_WRITE e é ideal quando não há
 * problemas de dados inconsistentes serem lidos quando ocorrem alterações
 * simultâneas.
 * 
 * A estratégia TRANSACTIONAL deve ser utilizada em ambientes JTA, como por
 * exemplo em servidores de aplicação. Como utilizamos Tomcat com Spring (sem
 * JTA) essa opção não funcionará.
 */
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Version   //lock otimista  bloqueio
	private int version;
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String linkDaFoto;

	@NotEmpty
	@Column(columnDefinition = "TEXT")
	private String descricao;

	@Min(20)
	private double preco;

	@ManyToMany
	@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private List<Categoria> categorias = new ArrayList<>();

	@Valid
	@ManyToOne
	private Loja loja;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void adicionarCategorias(Categoria... categorias) {
		for (Categoria categoria : categorias) {
			this.categorias.add(categoria);
		}
	}

	public String getLinkDaFoto() {
		return linkDaFoto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setLinkDaFoto(String linkDaFoto) {
		this.linkDaFoto = linkDaFoto;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Loja getLoja() {
		return loja;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
