package execucao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import funcionalidades.DonoService;
import funcionalidades.AnimalService;
import funcionalidades.VeterinarioService;
import funcionalidades.ConsultasService;
import modelos.Dono;
import modelos.Animal;

public class Main {
	public static void main(String[] args) {
		DonoService donoService = new DonoService();
		VeterinarioService veterinarioService = new VeterinarioService();
		AnimalService animalService = new AnimalService(donoService);
		ConsultasService consultaService = new ConsultasService(animalService, veterinarioService);
		Scanner sc = new Scanner(System.in);
		
		int opcao = 1;
		
		while (opcao != 0){
			System.out.printf("%n======= CLÍNICA VETERINÁRIA =======%n%n");
			System.out.println("1. Cadastrar dono");
			System.out.println("2. Cadastrar animal para um dono");
			System.out.println("3. Listar animais de um dono");
			System.out.println("4. Registrar consulta");
			System.out.println("5. Ver histórico de consultas de um animal");
			System.out.println("6. Remover animal");
			System.out.println("7. Cadastrar veterinário");
			System.out.println("0. Sair");
			System.out.println();
			System.out.print("Escolha uma opção: ");
			opcao = sc.nextInt();
			
			//limpa o buffer
			sc.nextLine();
			
			switch (opcao) {
				case 1: //Cadastrar dono
					System.out.print("Digite o nome do dono a ser cadastrado: ");
					String nomeDono = sc.nextLine();
					System.out.println();
					System.out.print("Digite o CPF do dono a ser cadastrado: ");
					String cpfNovoDono = sc.nextLine(); 
					
					try {
						donoService.cadastrarDono(nomeDono, cpfNovoDono);
					} catch (IllegalArgumentException e) {
						System.out.println("Error: " + e.getMessage());
						break;
					}
					
					System.out.println("Dono cadastrado com sucesso!");
					
					break;
					
				case 2: //Cadastrar animal para um dono
					int temp;
					System.out.println("Qual é o animal?");
					System.out.println("Digite 1 para cachorro: ");
					System.out.println("Digite 2 para gato: ");
					System.out.println("Digite 3 para pássaro: ");
					temp = sc.nextInt();
					sc.nextLine();
					
					if (temp == 1){
						System.out.print("Digite o CPF do dono: ");
						String cpfDono = sc.nextLine();
						System.out.println();
						System.out.print("Digite o nome do cachorro: ");
						String nomeDoCachorro = sc.nextLine();
						System.out.println();
						System.out.print("Digite a idade atual do cachorro: ");
						int idadeDoCachorro = sc.nextInt();
						sc.nextLine();
						System.out.println();
						System.out.print("Digite o peso atual do cachorro: ");
						float pesoDoCachorro = sc.nextFloat();
						sc.nextLine();
						System.out.println();
						System.out.print("Digite a raça do cachorro: ");
						String raca = sc.nextLine();
						System.out.println();
						
						try {
							animalService.cadastrarCachorro(cpfDono, nomeDoCachorro, idadeDoCachorro, pesoDoCachorro, raca);
							System.out.println("Animal cadastrado com sucesso!");
						} catch (IllegalArgumentException e) {
							System.out.println("Error: " + e.getMessage());
							break;
						}
												
						
					} else if (temp == 2){
						System.out.print("Digite o CPF do dono:  ");
						String cpfDono = sc.nextLine();
						System.out.print("Digite o nome do gato: ");
						String nomeDoGato = sc.nextLine();
						System.out.print("Digite a idade atual do gato: ");
						int idadeDoGato = sc.nextInt();
						sc.nextLine();
						System.out.print("Digite o peso atual do gato: ");
						float pesoDoGato = sc.nextFloat();
						sc.nextLine();
						System.out.println("Digite true or false para validar se o gato é castrado: ");
						boolean castrado = false;
						if (sc.hasNextBoolean()) {
						    castrado = sc.nextBoolean();
						} else {
						    System.out.println("Valor inválido para castração!");
						    sc.nextLine();
						}
						
						try {
							animalService.cadastrarGato(cpfDono, nomeDoGato, idadeDoGato, pesoDoGato, castrado);
							System.out.println("Animal cadastrado com sucesso!");
						} catch (IllegalArgumentException e) {
							System.out.println("Error: " + e.getMessage());
							break;
						}
						
					} else { 
						System.out.print("Digite o CPF do dono:  ");
						String cpfDono = sc.nextLine();
						System.out.print("Digite o nome do pássaro: ");
						String nomeDaAve = sc.nextLine();
						System.out.print("Digite a idade atual do pássaro: ");
						int idadeDaAve = sc.nextInt();
						sc.nextLine();
						System.out.print("Digite o peso atual do pássaro: ");
						float pesoDaAve = sc.nextFloat();
						sc.nextLine();
						System.out.print("Digite a espécie do pássaro: ");
						String especie = sc.nextLine();
						try {
							animalService.cadastrarPassaro(cpfDono, nomeDaAve, idadeDaAve, pesoDaAve, especie);
							System.out.println("Animal cadastrado com sucesso!");
						} catch (IllegalArgumentException e) {
							System.out.println("Error: " + e.getMessage());
							break;
						}
					}
					
					break;
					
				case 3: //Listar animais de um dono
					System.out.print("Digite o CPF do dono: ");
				    String cpfParaListar = sc.nextLine();
				    Dono donoEncontrado = donoService.buscarDonoPorCpf(cpfParaListar);
				    
				    int i = 0;
				    if (donoEncontrado == null) {
				        System.out.println("CPF não encontrado.");
				    } else {
				        for (Animal animalDoDono : donoEncontrado.getListaDeAnimaisDoDono()) {
				        	System.out.printf("Animal %d:%n%n", ++i);
				        	System.out.printf("Nome: %s%n", animalDoDono.getNomeAnimal());
				        	System.out.printf("Idade: %d%n", animalDoDono.getIdadeAnimal());
				        	System.out.printf("Peso: %.2f%n", animalDoDono.getPesoAnimal());				        	
				        }
				    }
				    
					break;
					
				case 4: //Registrar consulta
					System.out.print("Digite o CPF do dono: ");
				    String cpfDoDono = sc.nextLine();
				    System.out.println();
				    System.out.print("Digite o nome do animal: ");
					String nomeAnimal = sc.nextLine();
					System.out.println();
					System.out.print("Digite o CPF do veterinário que realizou o atendimento: ");
					String cpfVeterinario = sc.nextLine();
					System.out.println();
					System.out.println("Digite a data da consulta (formato dd/MM/yyyy): ");
					DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate data = null;
					try {
					    data = LocalDate.parse(sc.nextLine(), formatador);
					} catch (DateTimeParseException e) {
					    System.out.println("Data inválida! Consulta não registrada.");
					    break;
					}
					
					System.out.print("Insira o diagnóstico: ");
					String diagnostico = sc.nextLine();
					System.out.println();
					System.out.print("Digite o valor da consulta: ");
					double valor = sc.nextDouble();
					sc.nextLine();
					System.out.println();
					
					try {
					    consultaService.registrarConsulta(cpfDoDono, nomeAnimal, cpfVeterinario, data, diagnostico, valor);
					    System.out.println("Consulta registrada com sucesso!");
					} catch (IllegalArgumentException e) {
					    System.out.println("Erro: " + e.getMessage());
					    break;
					}
					
					break;
					
				case 5: //Ver histórico de consultas de um animal
					System.out.print("Digite o CPF do dono: ");
				    String cpfDono = sc.nextLine();
				    System.out.println();
				    System.out.print("Digite o nome do animal: ");
					String nomeDoAnimal = sc.nextLine();
					try {
						consultaService.exibirHistorico(cpfDono, nomeDoAnimal);
					} catch (IllegalArgumentException e) {
					    System.out.println("Erro: " + e.getMessage());
					}
					break;
					
				case 6: //Remover animal
				    System.out.print("Digite o CPF do dono: ");
				    String cpfDonoAnimal = sc.nextLine();
				    System.out.print("Digite o nome do animal: ");
				    String nomeAnimalRemocao = sc.nextLine();

				    Dono donoParaRemocao = donoService.buscarDonoPorCpf(cpfDonoAnimal);
				    if (donoParaRemocao == null) {
				        System.out.println("Dono não encontrado.");
				        break;
				    }

				    Animal animalRemocao = animalService.buscarAnimalPorNome(cpfDonoAnimal, nomeAnimalRemocao);
				    if (animalRemocao == null) {
				        System.out.println("Animal não encontrado.");
				        break;
				    }

				    donoParaRemocao.getListaDeAnimaisDoDono().remove(animalRemocao);
				    System.out.println("Animal removido com sucesso!");

				    break;
				
				case 7: //Cadastrar veterinário
					
					
					System.out.print("Digite o nome do Veterinário para cadastro: ");
				    String nomeVeterinarioCadastro = sc.nextLine();
					System.out.print("Digite o CPF do Veterinário para cadastro: ");
				    String cpfVeterinarioCadastro = sc.nextLine();
				    System.out.print("Digite a especialidade do Veterinário para cadastro: ");
				    String especialidadeVeterinarioCadastro = sc.nextLine();
				    
				    try {
				    	veterinarioService.cadastrarVeterinario(nomeVeterinarioCadastro, cpfVeterinarioCadastro, especialidadeVeterinarioCadastro);
				    	System.out.println("Veterinário cadastrado com sucesso!");
				    } catch (IllegalArgumentException e) {
				    	System.out.println("Error: " + e.getMessage());
				    	break;
				    }
					break;
	
				case 0: //Sair do programa
					System.out.println("Obrigado por usar nossos serviços!");
					opcao = 0;
					break;
					
				default:
					System.out.println("Opção inválida!");
					continue;
			}
			
		
		}
		
		sc.close();
	}
}
