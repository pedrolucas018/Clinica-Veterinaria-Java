package modelos;

public abstract class Pessoa {
	private String nomePessoa, cpf;
	
	public abstract void exibirInfo();
	
	public Pessoa (String nome, String cpf) {
		this.nomePessoa = nome;
		this.cpf = cpf;
		
	}
	
	public String getNomePessoa() {
		return this.nomePessoa;
	}
	
	public void setNomePessoa(String nomePessoa) {
		if (nomePessoa == null || nomePessoa.isBlank()){
			System.out.println("O nome inserido é invalido");
		} 
		else {
			this.nomePessoa = nomePessoa;
		}
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	//decidi retirar o setCpf para que não seja possível editar o cpf de alguem 
	
}
