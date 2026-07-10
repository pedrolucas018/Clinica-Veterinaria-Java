package modelos;

public class Cachorro extends Animal {
	private String raca;
	
	public Cachorro(String nomeAnimal, int idadeAnimal, float pesoAnimal, String raca){
		super(nomeAnimal, idadeAnimal, pesoAnimal);
		this.setRaca(raca);
		
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
			System.out.println("Raça invalida");
		}
		else {
			this.raca = raca;
		}
	}

}