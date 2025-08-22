import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Blog {

	private List<Post> listaPosts;

	public Blog() {
		listaPosts = new ArrayList<>();
	}

	public void adicionarPostagem(Post post) {
		for (Post pst : listaPosts) {
			if (pst.getAutor().equals(post.getAutor()) && pst.getTitulo().equals(post.getTitulo())) {
				throw new IllegalArgumentException("Postagem jah existente");
			}
		}
		listaPosts.add(post);
	}

	// ok
	public Set<Autor> obterTodosAutores() {
		List<Autor> listaAutores = new ArrayList<>();

		for (Post post : listaPosts) {
			listaAutores.add(post.getAutor());
		}
		return new TreeSet<>(listaAutores);
	}

	// ok
	public Map<Categorias, Integer> obterContagemPorCategoria() {
		Map<Categorias, Integer> contageCategoria = new TreeMap<>();

		for (Post post : listaPosts) {
			List<Post> categorias = listaPosts.stream().filter(n -> n.getCategoria().equals(post.getCategoria()))
					.collect(Collectors.toList());
			contageCategoria.put(categorias.get(0).getCategoria(), categorias.size());
		}

		return contageCategoria;

	}

	public Set<Post> obterPostsPorAutor(Autor autor) {
		List<Post> postsDoAutor = listaPosts.stream().filter(n -> n.getAutor().getNome().equals(autor.getNome()))
				.collect(Collectors.toList());
		Collections.sort(postsDoAutor);
		return new TreeSet<>(postsDoAutor);
	}

	public Set<Post> obterPostsPorCategoria(Categorias categoria) {
		List<Post> postsPorCategoria = listaPosts.stream().filter(n -> n.getCategoria().equals(categoria))
				.collect(Collectors.toList());
		return new TreeSet<>(postsPorCategoria);

	}

	public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
		Map<Categorias, Set<Post>> todosPosts = new TreeMap<>();

		for (Post post : listaPosts) {
			todosPosts.put(post.getCategoria(), obterPostsPorCategoria(post.getCategoria()));
		}
		return todosPosts;

	}

	public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
		Map<Autor, Set<Post>> resultado = new TreeMap<>();

		for (Post post : listaPosts) {
			if (resultado.containsKey(post.getAutor())) {
				resultado.get(post.getAutor()).add(post);
			} else {
				resultado.put(post.getAutor(), new TreeSet<>(Arrays.asList(post)));
			}
		}

		return resultado;

	}

	public List<Post> getListaPosts() {
		return listaPosts;
	}

	public void setListaPosts(List<Post> listaPosts) {
		this.listaPosts = listaPosts;
	}

}
