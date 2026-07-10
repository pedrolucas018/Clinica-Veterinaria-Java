package modelos;
import java.util.ArrayList;

//classe-mae: todo animal tera essas caracteristicas

public abstract class Animal {
	private String nomeAnimal;
	private int idadeAnimal;
	private float pesoAnimal;
	private ArrayList<Consulta> historicoDeConsultasDoAnimal = new ArrayList<>();
	
	public abstract void emitirSom();
	
	public void adicionarConsulta (Consulta consulta) {
		historicoDeConsultasDoAnimal.add(consulta);
	}
	
	//construtor
	public Animal (String nomeAnimal, int idadeAnimal, float pesoAnimal) {
		this.nomeAnimal = nomeAnimal;
		this.idadeAnimal = idadeAnimal;
		this.pesoAnimal = pesoAnimal;
	}
	
	public String getNomeAnimal() {
		return this.nomeAnimal;
	
	}
	
	public void setNomeAnimal (String nomeAnimal) {
		if (nomeAnimal == null || nomeAnimal.isBlank()) {
			System.out.println("String inválida");
		}
		else {
			this.nomeAnimal = nomeAnimal;
		}
	}
	
	public int getIdadeAnimal() {
		return this.idadeAnimal;
		
	}
	
	public void setIdadeAnimal(int idadeAnimal){
		if (idadeAnimal < 0) {
			System.out.println("Idade inválida");
		} 
		else {
			this.idadeAnimal = idadeAnimal;
		}
	}
	
	public float getPesoAnimal() {
		return this.pesoAnimal;
	}
	
	public void setPesoAnimal(float pesoAnimal) {
		if (pesoAnimal < 0.01F) {
			System.out.println("Peso inválido");
		}
		else {
			this.pesoAnimal = pesoAnimal;
		}
	}
	
	public ArrayList<Consulta> getHistoricoDeConsultasDoAnimal(){
		return this.historicoDeConsultasDoAnimal;
		
	}
}
