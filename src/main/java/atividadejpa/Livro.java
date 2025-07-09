package atividadejpa;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;

    private int anoPublicacao;

    private String isbn;

    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    private TipoPublicacao tipo;

    @ManyToOne
    @JoinColumn(name = "editora_id")
    private Editora editora;

    @ManyToMany
    @JoinTable(
        name = "livro_autor",
        joinColumns = @JoinColumn(name = "livro_id"),
        inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autores;


    public Livro(int id, String titulo, int anoPublicacao, String isbn, BigDecimal preco, TipoPublicacao tipo,
			Editora editora, List<Autor> autores) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.anoPublicacao = anoPublicacao;
		this.isbn = isbn;
		this.preco = preco;
		this.tipo = tipo;
		this.editora = editora;
		this.autores = autores;
	}
    
    

	public int getId() {
		return id;
	}



	public String getTitulo() {
		return titulo;
	}



	public int getAnoPublicacao() {
		return anoPublicacao;
	}



	public String getIsbn() {
		return isbn;
	}



	public BigDecimal getPreco() {
		return preco;
	}



	public TipoPublicacao getTipo() {
		return tipo;
	}



	public Editora getEditora() {
		return editora;
	}


	public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }



	@Override
	public int hashCode() {
		return Objects.hash(anoPublicacao, autores, editora, id, isbn, preco, tipo, titulo);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return anoPublicacao == other.anoPublicacao && Objects.equals(autores, other.autores)
				&& Objects.equals(editora, other.editora) && id == other.id && Objects.equals(isbn, other.isbn)
				&& Objects.equals(preco, other.preco) && tipo == other.tipo && Objects.equals(titulo, other.titulo);
	}



	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", anoPublicacao=" + anoPublicacao + ", isbn=" + isbn
				+ ", preco=" + preco + ", tipo=" + tipo + ", editora=" + editora + ", autores=" + autores + "]";
	}
    
    
}
