package br.com.fiap.main;

import javax.swing.JOptionPane;

import br.com.fiap.bean.Funcionario;
import br.com.fiap.bean.Vendedor;
import br.com.fiap.bean.VigiaNoturno;

public class Pagamento {

	public static void main(String[] args) {
		String aux, nome, exibe, escolha = "sim";
		float salario, valorHora;
		while (escolha.equalsIgnoreCase("sim")) { 
			try {
				nome = JOptionPane.showInputDialog("Digite seu nome"); 

				aux = JOptionPane.showInputDialog("Digite valor da hora de trabalho"); 
				valorHora = Float.parseFloat(aux);
				
				aux = JOptionPane.showInputDialog("Qual o tipo de funcionario?" 
						+ "\n(1) Normal \n(2) Vigia noturno \n(3) Vendedor");
				int opcao = Integer.parseInt(aux);
				
				switch (opcao) {
				case 1:
					Funcionario normal = new Funcionario(nome, valorHora); 
					salario = normal.calculaSalario(); 
					exibe = "Exibindo os dados: \nNome: " + normal.getNome()
							+ "\nSalario: R$ " + salario;
					break;
				case 2:
					aux = JOptionPane.showInputDialog("Qual valor do adicional noturno mensal?");
					float adicional = Float.parseFloat(aux);
					VigiaNoturno vigia = new VigiaNoturno(nome, valorHora, adicional); 
					salario = vigia.calculaSalario(); 
					exibe = "Exibindo os dados: \nNome: " + vigia.getNome()
							+ "\nSalario: R$ " + salario;
					break;
				case 3:
					aux = JOptionPane.showInputDialog("Qual a porcetagem da comissao?"); 
					float comissao = Float.parseFloat(aux);
					Vendedor vend = new Vendedor(nome, valorHora, comissao); 
					salario = vend.calculaSalario(); 
					exibe = "Exibindo os dados: \nNome: " + vend.getNome()
							+ "\nSalario: R$ " + salario;
					break;
				default:
					throw new Exception("Escolha incorreta!");
				}
				JOptionPane.showMessageDialog(null, exibe);
				escolha = JOptionPane.showInputDialog("Deseja continuar?");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		JOptionPane.showMessageDialog(null, "Fim de programa. Volte sempre!");
	}
}
