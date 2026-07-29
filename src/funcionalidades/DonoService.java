package funcionalidades;
import java.util.Map;
import java.util.HashMap;
import modelos.Dono;

public class DonoService {
	private Map<String, Dono> listaDeDonos = new HashMap<>();
	
	public void cadastrarDono(String nome, String cpf) {
	    if (listaDeDonos.containsKey(cpf)) {
	        throw new IllegalArgumentException("CPF já cadastrado!");
	    }

	    listaDeDonos.put(cpf, new Dono(nome, cpf));
	}

	
	public Dono buscarDonoPorCpf (String cpf) {
		return listaDeDonos.get(cpf);
	}

	public void listarDonos() {
	    int i = 1;
	    for (Dono dono : listaDeDonos.values()) {
	        System.out.printf("Dono %d: %s%n", i, dono.getNomePessoa());
	        i++;
	    }
	}
	
}
