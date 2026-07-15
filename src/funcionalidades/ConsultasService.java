package funcionalidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import modelos.Consulta;
import modelos.Veterinario;
import modelos.Animal;

public class ConsultasService {
	private AnimalService animalService;
	private VeterinarioService veterinarioService;
	
	//construtor com duas dependências de injeção 
	public ConsultasService (AnimalService animalService, VeterinarioService veterinarioService){
		this.animalService = animalService;
		this.veterinarioService = veterinarioService;
	}
	
	public void registrarConsulta (String cpfDoDono, String nomeDoAnimal, String cpfDoVeterinario, LocalDate data, 
								   String diagnostico, double valor){
		
		Animal animalParaRegistro = animalService.buscarAnimalPorNome(cpfDoDono, nomeDoAnimal);
		if (animalParaRegistro == null) {
			throw new IllegalArgumentException("Animal não registrado!");
		}
		
		Veterinario veterinarioParaRegistro = veterinarioService.buscarVeterinarioPorCpf(cpfDoVeterinario);
		if (veterinarioParaRegistro == null) {
			throw new IllegalArgumentException("Veterinario não encontrado!");
		}
		
		Consulta consulta = new Consulta(data, diagnostico, veterinarioParaRegistro, valor);
		animalParaRegistro.adicionarConsulta(consulta);
		
	}
	
	public void exibirHistorico (String cpfDoDono, String nomeDoAnimal) {
		Animal animal = animalService.buscarAnimalPorNome(cpfDoDono, nomeDoAnimal);
		if (animal == null) {
			throw new IllegalArgumentException("Animal não registrado!");
		}
		
		int i = 1;
		for (Consulta consulta : animal.getHistoricoDeConsultasDoAnimal()) {
			
			DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
			System.out.printf("Consulta %d:%n%n", i++);
			System.out.println(" - Data: " + consulta.getData().format(formatador));
			System.out.println(" - Diagnóstico: " + consulta.getDiagnostico());
			System.out.println(" - Veterinário: " + consulta.getVeterinario().getNomePessoa());
		
		}
	}
	
}
