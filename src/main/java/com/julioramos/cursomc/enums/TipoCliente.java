package com.julioramos.cursomc.enums;

/**
 * Enum que define os tipos de Pessoa suportados pelo sistema.
 */
public enum TipoCliente {

	PESSOA_FISICA(1, "Pessoa Física"),
	PESSOA_JURIDICA(2, "Pessoa Jurídica");
	
	private int codigo;
	
	private String descricao;
	
	private TipoCliente(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static TipoCliente toEnum(Integer codigo) {
		if (codigo == null) {
			return null;
		}
		
		for (TipoCliente tipoCliente : TipoCliente.values()) {
			if (codigo.equals(tipoCliente.getCodigo())) {
				return tipoCliente;
			}
		}
		
		throw new IllegalArgumentException("Código inválido para TipoCliente: " + codigo);
	}
}
