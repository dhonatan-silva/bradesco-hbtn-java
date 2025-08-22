import java.util.ArrayList;
import java.util.HashMap;
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
		listaPosts.add(post);
	}

	public Set<String> obterTodosAutores() {
		Set<String> listaAutores = new HashSet<String>();

		for (Post post : listaPosts) {
			listaAutores.add(post.getAutor());
		}

		return new TreeSet<>(listaAutores);
	}

	public Map<String, Integer> obterContagemPorCategoria() {
		Map<String, Integer> contageCategoria = new HashMap<>();

		for (Post post : listaPosts) {
			List<Post> categorias = listaPosts.stream()
					.filter(n -> n.getCategoria().equals(post.getCategoria()))
					.collect(Collectors.toList());
			contageCategoria.put(categorias.get(0).getCategoria(), categorias.size());
		}

		return new TreeMap<>(contageCategoria);

	}

	public List<Post> getListaPosts() {
		return listaPosts;
	}

	public void setListaPosts(List<Post> listaPosts) {
		this.listaPosts = listaPosts;
	}

}
