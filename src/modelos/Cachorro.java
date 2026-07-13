package modelos;

public class Cachorro extends Animal {
	private String raca;
	
	public Cachorro(String nomeAnimal, int idadeAnimal, float pesoAnimal, String raca){
		super(nomeAnimal, idadeAnimal, pesoAnimal);
		setRaca(raca);
	}
	
	@Override
	public void emitirSom() {
		System.out.println("Au Au!");
	}

	public String getRaca() {
		return this.raca;
	}

	public void setRaca(String raca) {
		if (raca == null || raca.isBlank()) {
			throw new IllegalArgumentException("Raça inserida inválida");
		}
		else {
			this.raca = raca;
		}
	}

}