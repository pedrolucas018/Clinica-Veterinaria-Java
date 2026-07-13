package modelos;

public class Veterinario extends Pessoa implements Exibivel {
	private String especialidade; 
	
	public Veterinario(String nome, String cpf, String especialidade) {
		super(nome, cpf);
		setEspecialidade(especialidade);
		
	}
	
	public String getEspecialidade () {
		return this.especialidade;
		
	}
	
	public void setEspecialidade (String especialidade) {
		if (especialidade == null || especialidade.isBlank()){
			throw new IllegalArgumentException("A especialidade inserida é invalida");
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
