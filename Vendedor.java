package br.com.fiap.bean;

public class Vendedor extends Funcionario{
	
	private float comissao;

	public Vendedor() {}

	public Vendedor(String nome, float valorHoraTrabalho, float comissao) {
		super.setNome(nome);
		super.setValorHoraTrabalho(valorHoraTrabalho);
		this.comissao = comissao;
	}

	public float getComissao() {
		return comissao;
	}

	public void setComissao(float comissao) {
		this.comissao = comissao;
	}

	public float calculaSalario() {
		float salario = ((super.getValorHoraTrabalho() * 40) * 4 + (1 + comissao/100));
		return salario;
	}
	
}
