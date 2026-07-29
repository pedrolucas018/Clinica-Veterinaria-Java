package funcionalidades;

import java.util.Map;
import java.util.HashMap;
import modelos.Veterinario;

public class VeterinarioService {
	private Map<String, Veterinario> listaDeVeterinarios = new HashMap<>();
	
	public void cadastrarVeterinario (String nome, String cpf, String especialidade) {
		if (listaDeVeterinarios.containsKey(cpf)) {
			throw new IllegalArgumentException("Veterinário já cadastrado!");
		} 
		listaDeVeterinarios.put(cpf, new Veterinario(nome, cpf, especialidade));
		
	}
	
	public Veterinario buscarVeterinarioPorCpf (String cpf) {
		return listaDeVeterinarios.get(cpf);
	}
	
	public void listarVeterinarios() {
	    int i = 1;
	    for (Veterinario vet : listaDeVeterinarios.values()) {
	        System.out.printf("Veterinario %d: %s%n", i, vet.getNomePessoa());
	        i++;
	    }
	}
	
}
