package br.com.projuris;

import java.math.BigDecimal;

public abstract class AbstractCusto {
	private String nome;
	private BigDecimal custo;

	public AbstractCusto(String nome) {
		this.nome = nome;
		this.custo = BigDecimal.ZERO.setScale(2);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

	public void somaCusto(BigDecimal salario) {
		this.custo = this.custo.add(salario);
	}

}
