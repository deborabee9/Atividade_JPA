package atividadejpa;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private String cidade;

    @OneToMany(mappedBy = "editora", cascade = CascadeType.ALL)
    private List<Livro> livros = new ArrayList<>();

 
    public Editora(int id, String nome, String cidade, List<Livro> livros) {
		super();
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
		this.livros = livros;
	}
    
    
	public int getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public String getCidade() {
		return cidade;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cidade, id, livros, nome);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Editora other = (Editora) obj;
		return Objects.equals(cidade, other.cidade) && id == other.id && Objects.equals(livros, other.livros)
				&& Objects.equals(nome, other.nome);
	}


	@Override
	public String toString() {
		return "Editora [id=" + id + ", nome=" + nome + ", cidade=" + cidade + ", livros=" + livros + "]";
	}


	public List<Livro> getLivros() { return livros; }
    public void setLivros(List<Livro> livros) { this.livros = livros; }
}
