package com.julioramos.cursomc.domain;

import javax.persistence.Entity;

import com.julioramos.cursomc.enums.EstadoPagamento;

/**
 * Definição da Entidade PagamentoCartao.
 */
@Entity
public class PagamentoCartao extends Pagamento {
	
	private static final long serialVersionUID = 1L;

	private Integer numeroParcelas;

	public PagamentoCartao() {
	}

	public PagamentoCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroParcelas) {
		super(id, estado, pedido);
		this.numeroParcelas = numeroParcelas;
	}

	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}
}
