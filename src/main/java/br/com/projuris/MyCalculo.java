package br.com.projuris;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyCalculo implements Calculo {

	@Override
	public List<CustoCargo> custoPorCargo(List<Funcionario> funcionarios) {
		Map<String, CustoCargo> cargoMap = new HashMap<>();
		for(Funcionario funcionario : funcionarios) {
			CustoCargo custoCargo = cargoMap.get(funcionario.getCargo());
			if(custoCargo == null) {
				custoCargo = new CustoCargo(funcionario.getCargo());
				cargoMap.put(funcionario.getCargo(), custoCargo);
			}
			custoCargo.somaCusto(funcionario.getSalario());
		}
		return new ArrayList<CustoCargo>(cargoMap.values());
	}

	@Override
	public List<CustoDepartamento> custoPorDepartamento(List<Funcionario> funcionarios) {
		Map<String, CustoDepartamento> departamentoMap = new HashMap<>();
		for(Funcionario funcionario : funcionarios) {
			CustoDepartamento custoDepartamento = departamentoMap.get(funcionario.getDepartamento());
			if(custoDepartamento == null) {
				custoDepartamento = new CustoDepartamento(funcionario.getDepartamento());
				departamentoMap.put(funcionario.getDepartamento(), custoDepartamento);
			}
			custoDepartamento.somaCusto(funcionario.getSalario());
		}
		return new ArrayList<CustoDepartamento>(departamentoMap.values());
	}

}
