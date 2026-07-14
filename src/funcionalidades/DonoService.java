package funcionalidades;
import java.util.ArrayList;
import modelos.Dono;

public class DonoService {
	private ArrayList<Dono> listaDeDonos = new ArrayList<>();
	
	public void cadastrarDono (String nome, String cpf) {
		for (Dono dono : listaDeDonos) {
				if (dono.getCpf().equals(cpf)) {
					throw new IllegalArgumentException("CPF já cadastrado!");
				} 
		}
		
		Dono novoDono = new Dono(nome, cpf);
		listaDeDonos.add(novoDono);
		
	}

	
	public Dono buscarDonoPorCpf (String cpf) {
		for (Dono dono: listaDeDonos) {
			if (dono.getCpf().equals(cpf)) {
	            return dono;
	        } 
		}
		return null;
	}
	
	public void listarDonos() {
		for (int i = 0; i < listaDeDonos.size(); i++) {
			System.out.printf("Dono %d: %s%n", i+1, listaDeDonos.get(i).getNomePessoa());
		}
	}
	
}
