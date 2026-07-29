/*
 * Receber os dados do animal 
 * Receber de quem é esse animal 
 * Buscar esse dono 
 * Criar o animal e adicionar na lista de animais daquele dono específico
 */
package funcionalidades;

import modelos.Animal;
import modelos.Dono;
import modelos.Cachorro;
import modelos.Gato;
import modelos.Passaro;

public class AnimalService {
    private DonoService donoService;

    public AnimalService(DonoService donoService) {
        this.donoService = donoService;
    }
    
    public Animal buscarAnimalPorNome(String cpfDono, String nomeAnimal) {

        Dono dono = donoService.buscarDonoPorCpf(cpfDono);
        if (dono == null) {
            throw new IllegalArgumentException("Dono não encontrado!");
        }

        return dono.getListaDeAnimaisDoDono()
                   .stream()
                   .filter(animal -> animal.getNomeAnimal().equalsIgnoreCase(nomeAnimal))
                   .findFirst()
                   .orElse(null);
    }

    public void cadastrarCachorro(String cpfDono, String nomeAnimal, int idade, float peso, String raca) {
        Dono dono = donoService.buscarDonoPorCpf(cpfDono);

        if (dono == null) {
            throw new IllegalArgumentException("Dono não encontrado!");
        }

        Cachorro novoCachorro = new Cachorro(nomeAnimal, idade, peso, raca);
        dono.adicionarAnimal(novoCachorro);
    }
    
    public void cadastrarGato(String cpfDono, String nomeAnimal, int idade, float peso, boolean ehCastrado ) {
    	Dono dono = donoService.buscarDonoPorCpf(cpfDono);
    	
    	if (dono == null) {
            throw new IllegalArgumentException("Dono não encontrado!");
        }
    	
    	Gato novoGato = new Gato(nomeAnimal, idade, peso, ehCastrado);
    	dono.adicionarAnimal(novoGato);
    }
    
    public void cadastrarPassaro(String cpfDono, String nomeAnimal, int idade, float peso, String especie ) {
    	Dono dono = donoService.buscarDonoPorCpf(cpfDono);
    	
    	if (dono == null) {
            throw new IllegalArgumentException("Dono não encontrado!");
        }
    	
    	Passaro novoPassaro = new Passaro(nomeAnimal, idade, peso, especie);
    	dono.adicionarAnimal(novoPassaro);
    	
    }
}