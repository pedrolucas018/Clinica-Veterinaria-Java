package modelos;

public class Veterinario extends Pessoa {
	private String especialidade; 
	
	public Veterinario(String nome, String cpf, String especialidade) {
		super(nome, cpf);
		this.setEspecialidade(especialidade);
		
	}
	
	public String getEspecialidade () {
		return this.especialidade;
		
	}
	
	public void setEspecialidade (String especialidade) {
		if (especialidade == null || especialidade.isBlank()){
	        System.out.println("A especialidade inserida eh invalida");
	    }
	    else {
	        this.especialidade = especialidade;
	    }
	}
	
	
	@Override
	public void exibirInfo() {
		System.out.println("Nome: " + getNomePessoa());
		System.out.println("CPF: " + getCpf());
		System.out.println("Especialidade: " + getEspecialidade());

	}

}
