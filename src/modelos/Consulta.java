package modelos;
import java.time.LocalDate;

public class Consulta {
	private LocalDate data;
	private String diagnostico;
	private Veterinario veterinario;
	private double valor;
	
	public Consulta (LocalDate data, String diagnostico, Veterinario veterinario, double valor) {
		setData(data);
		setDiagnostico(diagnostico);
		setVeterinario(veterinario);
		setValor(valor);
	}

	public LocalDate getData() {
		return data;
	}

	public void setData (LocalDate data) {
		if (data == null || data.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("Data inserida inválida");
		} else {
			this.data = data;
		}
	}

	public String getDiagnostico () {
		return diagnostico;
	}

	public void setDiagnostico (String diagnostico) {
		if (diagnostico == null || diagnostico.isBlank()) {
			throw new IllegalArgumentException("Diagnóstico inserido inválido");
		} else {
			this.diagnostico = diagnostico;
		}
	}

	public Veterinario getVeterinario () {
		return veterinario;
	}

	public void setVeterinario (Veterinario veterinario) {
		if (veterinario == null) {
			throw new IllegalArgumentException("Veterinário inserido inválido");
		} else {
			this.veterinario = veterinario;
		}
	}

	public double getValor () {
		return valor;
	}

	public void setValor (double valor) {
		if (valor < 0.0 ) {
			throw new IllegalArgumentException("Valor inserido inválido");
		} 
		else {
			this.valor = valor;
		}
	}

}
