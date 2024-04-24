package br.com.fiap.main;

import javax.swing.JOptionPane;

import br.com.fiap.bean.Vendedor;
import br.com.fiap.bean.VigiaNoturno;

public class Pagamento {

	public static void main(String[] args) {
		
		String aux, nome, escolha = "sim";
		float salario, valorHoraTrabalho, comissao, adicionalNoturno;
		int opcao;
		
		while(escolha.equalsIgnoreCase("sim")) {
			try {
				aux = JOptionPane.showInputDialog("Qual funcionário você quer calcular o salário?"
						+ "\n(1)Vendedor \n(2)Vigia noturno");
				opcao = Integer.parseInt(aux);
				switch(opcao) {
				case 1: 
					Vendedor vend;
					aux = JOptionPane.showInputDialog("Qual é o nome do vendedor?");
					nome = aux;
					aux = JOptionPane.showInputDialog("Qual é o valor da hora do vendedor?");
					valorHoraTrabalho = Float.parseFloat(aux);
					aux = JOptionPane.showInputDialog("Qual será a comissão do(a) " + nome + "?");
					comissao = Float.parseFloat(aux);
					vend = new Vendedor(nome, valorHoraTrabalho, comissao);
					salario = vend.calculaSalario();
					JOptionPane.showMessageDialog(null, nome + " teve uma comissão de: R$ " 
							+ comissao + "\nTotalizando um salário de: R$ " + salario);
					break;
				case 2:
					VigiaNoturno vigia;
					aux = JOptionPane.showInputDialog("Qual é o nome do vigia?");
					nome = aux;
					aux = JOptionPane.showInputDialog("Qual é o valor da hora do vigia?");
					valorHoraTrabalho = Float.parseFloat(aux);
					aux = JOptionPane.showInputDialog("Qual é o adicional do vigia noturno? ");
					adicionalNoturno = Float.parseFloat(aux);
					vigia = new VigiaNoturno(nome, valorHoraTrabalho, adicionalNoturno);
					salario = vigia.calculaSalario();
					JOptionPane.showMessageDialog(null, nome + " teve um adicional de: R$ " 
							+ adicionalNoturno + "\nTotalizando um salário de: R$ " + salario);
					break;
				default:
					throw new IllegalArgumentException("Valor incorreto");
				}
				escolha = JOptionPane.showInputDialog("Deseja continuar?");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		JOptionPane.showMessageDialog(null, "Fim do programa obrigado!");
	}

}
