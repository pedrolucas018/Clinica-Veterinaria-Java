package modelos;

public class Passaro extends Animal {
	private String especie;
	
	public Passaro(String nomeAnimal, int idadeAnimal, float pesoAnimal, String especie) {
		super(nomeAnimal, idadeAnimal, pesoAnimal);
		this.setEspecie(especie);
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
			System.out.println("Especie invalida.");
		}
		else {
			this.especie = especie;
		}
	}

}
