package com.julioramos.cursomc.enums;

/**
 * Enum que define os Estados de Pagamento suportados pelo sistema.
 */
public enum EstadoPagamento {

	STATUS_PENDENTE(1, "Pendente"), STATUS_QUITADO(2, "Quitado"), STATUS_CANCELADO(3, "Cancelado");

	private int codigo;

	private String descricao;

	private EstadoPagamento(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static EstadoPagamento toEnum(Integer codigo) {
		if (codigo == null) {
			return null;
		}

		for (EstadoPagamento estadoPagamento : EstadoPagamento.values()) {
			if (codigo.equals(estadoPagamento.getCodigo())) {
				return estadoPagamento;
			}
		}

		throw new IllegalArgumentException("Código inválido para EstadoPagamento: " + codigo);
	}
}
