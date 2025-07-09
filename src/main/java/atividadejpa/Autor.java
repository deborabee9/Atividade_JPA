package atividadejpa;


import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private String nacionalidade;

    @ManyToMany(mappedBy = "autores")
    private List<Livro> livros;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

	@Override
	public int hashCode() {
		return Objects.hash(id, livros, nacionalidade, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return id == other.id && Objects.equals(livros, other.livros)
				&& Objects.equals(nacionalidade, other.nacionalidade) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", nacionalidade=" + nacionalidade + ", livros=" + livros + "]";
	}
    
    
}
