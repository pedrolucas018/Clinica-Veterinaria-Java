package funcionalidades;
import java.util.ArrayList;
import modelos.Veterinario;

public class VeterinarioService {
	private ArrayList<Veterinario> listaDeVeterinarios = new ArrayList<>();
	
	public void cadastrarVeterinario (String nome, String cpf, String especialidade) {
		for (Veterinario vet : listaDeVeterinarios) {
				if (vet.getCpf().equals(cpf)) {
					throw new IllegalArgumentException("CPF já cadastrado!");
				} 
		}
		
		Veterinario novoVeterinario = new Veterinario(nome, cpf, especialidade);
		listaDeVeterinarios.add(novoVeterinario);
		
	}

	
	public Veterinario buscarVeterinarioPorCpf (String cpf) {
		for (Veterinario vet: listaDeVeterinarios) {
			if (vet.getCpf().equals(cpf)) {
	            return vet;
	        } 
		}
		return null;
	}
	
	public void listarVeterinarios() {
		for (int i = 0; i < listaDeVeterinarios.size(); i++) {
			System.out.printf("Veterinário %d: %s%n", i+1, listaDeVeterinarios.get(i).getNomePessoa());
		}
	}
	
}
