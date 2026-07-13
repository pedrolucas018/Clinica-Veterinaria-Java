package modelos;

public class Passaro extends Animal {
	private String especie;
	
	public Passaro(String nomeAnimal, int idadeAnimal, float pesoAnimal, String especie) {
		super(nomeAnimal, idadeAnimal, pesoAnimal);
		setEspecie(especie);
	}

	@Override
	public void emitirSom() {
		System.out.println("Piu-piu!");
	}

	public String getEspecie() {
		return this.especie;
	}

	public void setEspecie(String especie) {
		if (especie == null || especie.isBlank()) {
			throw new IllegalArgumentException("Espécie inserida inválida");
		}
		else {
			this.especie = especie;
		}
	}

}
