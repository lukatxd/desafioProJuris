package br.com.projuris;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class MyCalculoTest {

	private static final String ESTAGIÁRIO = "Estagiário";
	private static final String DIRETOR = "Diretor";
	private static final String GERENTE = "Gerente";
	private static final String ASSISTENTE = "Assistente";
	private static final String JURÍDICO = "Jurídico";
	private static final String FINANCEIRO = "Financeiro";
	private static final String ADMINISTRATIVO = "Administrativo";

	private static List<Funcionario> listaFuncionario;
	private static Calculo calculo;

	@BeforeClass
	public static void setUp() {

		calculo = new MyCalculo();

		// Funcionarios constructors receive a BigDecimal(String)
		// instead of BigDecimal(double) because of decimal precision
		Funcionario funcionario1 = new Funcionario(ASSISTENTE, ADMINISTRATIVO, new BigDecimal("1000.0"));
		Funcionario funcionario2 = new Funcionario(GERENTE, ADMINISTRATIVO, new BigDecimal("7000.70"));
		Funcionario funcionario3 = new Funcionario(DIRETOR, ADMINISTRATIVO, new BigDecimal("10000.45"));
		Funcionario funcionario4 = new Funcionario(ASSISTENTE, FINANCEIRO, new BigDecimal("1300.9"));
		Funcionario funcionario5 = new Funcionario(GERENTE, FINANCEIRO, new BigDecimal("7500"));
		Funcionario funcionario6 = new Funcionario(DIRETOR, FINANCEIRO, new BigDecimal("11000.0"));
		Funcionario funcionario7 = new Funcionario(ESTAGIÁRIO, JURÍDICO, new BigDecimal("700.4"));
		Funcionario funcionario8 = new Funcionario(ASSISTENTE, JURÍDICO, new BigDecimal("1800.90"));
		Funcionario funcionario9 = new Funcionario(GERENTE, JURÍDICO, new BigDecimal("9500.50"));
		Funcionario funcionario10 = new Funcionario(DIRETOR, JURÍDICO, new BigDecimal("13000.0"));

		listaFuncionario = new ArrayList<>();
		listaFuncionario.add(funcionario1);
		listaFuncionario.add(funcionario2);
		listaFuncionario.add(funcionario3);
		listaFuncionario.add(funcionario4);
		listaFuncionario.add(funcionario5);
		listaFuncionario.add(funcionario6);
		listaFuncionario.add(funcionario7);
		listaFuncionario.add(funcionario8);
		listaFuncionario.add(funcionario9);
		listaFuncionario.add(funcionario10);
	}

	@Test
	public void custoPorCargoTest() {
		BigDecimal custoEstagiario = new BigDecimal("700.40");
		BigDecimal custoAssistente = new BigDecimal("4101.80");
		BigDecimal custoGerente = new BigDecimal("24001.20");
		BigDecimal custoDiretor = new BigDecimal("34000.45");

		final List<CustoCargo> custoCargoList = calculo.custoPorCargo(listaFuncionario);
		if (custoCargoList.size() == 0) {
			fail();
		}
		for (CustoCargo custoCargo : custoCargoList) {
			if (custoCargo.getNome().equals(ESTAGIÁRIO)) {
				assertEquals(custoEstagiario, custoCargo.getCusto());
			} else if (custoCargo.getNome().equals(ASSISTENTE)) {
				assertEquals(custoAssistente, custoCargo.getCusto());
			} else if (custoCargo.getNome().equals(GERENTE)) {
				assertEquals(custoGerente, custoCargo.getCusto());
			} else if (custoCargo.getNome().equals(DIRETOR)) {
				assertEquals(custoDiretor, custoCargo.getCusto());
			}
		}

	}

	@Test
	public void custoPorDepartamentoTest() {
		BigDecimal custoAdministrativo = new BigDecimal("18001.15");
		BigDecimal custoFinanceiro = new BigDecimal("19800.90");
		BigDecimal custoJuridico = new BigDecimal("25001.80");
		final List<CustoDepartamento> custoDepartamentoList = calculo.custoPorDepartamento(listaFuncionario);
		if (custoDepartamentoList.size() == 0) {
			fail();
		}
		for (CustoDepartamento custoDepartamento : custoDepartamentoList) {
			if (custoDepartamento.getNome().equals(ADMINISTRATIVO)) {
				assertEquals(custoAdministrativo, custoDepartamento.getCusto());
			} else if (custoDepartamento.getNome().equals(FINANCEIRO)) {
				assertEquals(custoFinanceiro, custoDepartamento.getCusto());
			} else if (custoDepartamento.getNome().equals(JURÍDICO)) {
				assertEquals(custoJuridico, custoDepartamento.getCusto());
			}
		}
	}

}
