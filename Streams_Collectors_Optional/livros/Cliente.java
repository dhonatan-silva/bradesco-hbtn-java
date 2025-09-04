public class Cliente {
	private int codigo;
	private String nom;
	private boolean premium;

	public Cliente(int codigo, String nom, boolean premium) {
		this.codigo = codigo;
		this.nom = nom;
		this.premium = premium;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

}
