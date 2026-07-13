package modelos;
import java.util.ArrayList;
// optei por usar uma ArrayList no lugar de um simples array devido a alocação dinamica de 
// memoria, assim, poderei adicionar ou remover animais a um dono sem me preocupar com 
// o estouro do array

public class Dono extends Pessoa implements Exibivel {
	private ArrayList<Animal> listaDeAnimaisDoDono = new ArrayList<>();
	
	public Dono(String nome, String cpf){
		super(nome, cpf);
		//o arraylist deve nascer vazio, pois ele so sera acrescentado quando
		//adicionarmos um animal, portanto n faz sentido instanciar um dono
		//já com uma lista de animal
		
	}

	public ArrayList<Animal> getListaDeAnimaisDoDono() {
		return this.listaDeAnimaisDoDono;
	}

	public int getQuantidadeDeAnimais() {
	    return this.listaDeAnimaisDoDono.size();
	}
	
	public void adicionarAnimal(Animal animal) {
		this.listaDeAnimaisDoDono.add(animal);
	}
	
	@Override
	public void exibirInfo() {
		System.out.println("Nome: " + getNomePessoa());
		System.out.println("CPF: " + getCpf());
		System.out.println("Quantidade de animais: " + getQuantidadeDeAnimais());
	}
	
	
	
	
}
