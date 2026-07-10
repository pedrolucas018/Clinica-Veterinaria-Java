package modelos;

public class Gato extends Animal {
	private boolean ehCastrado;
	
	public Gato(String nomeAnimal, int idadeAnimal, float pesoAnimal, boolean ehCastrado) {
		super(nomeAnimal, idadeAnimal, pesoAnimal);
		this.setEhCastrado(ehCastrado);
	}

	@Override
	public void emitirSom() {
		System.out.println("Miau!");

	}

	public boolean isEhCastrado() {
		return this.ehCastrado;
	}

	public void setEhCastrado(boolean ehCastrado) {
		this.ehCastrado = ehCastrado;
	}

}
