package com.julioramos.cursomc.enums;

/**
 * Enum que define os tipos de Contato suportados pelo sistema.
 */
public enum TipoContato {

	TIPO_EMAIL(1, "E-mail"),
	TIPO_TELEFONE(2, "Telefone"),
	TIPO_CELULAR(3, "Celular");
	
	private int codigo;
	
	private String tipoContato;
	
	private TipoContato(int codigo, String tipoContato) {
		this.codigo = codigo;
		this.tipoContato = tipoContato;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getTipoContato() {
		return tipoContato;
	}
	
	public static TipoContato toEnum(Integer codigo) {
		if (codigo == null) {
			return null;
		}
		
		for (TipoContato tipoContato : TipoContato.values()) {
			if (codigo.equals(tipoContato.getCodigo())) {
				return tipoContato;
			}
		}
		
		throw new IllegalArgumentException("Código inválido para TipoContato: " + codigo);
	}
}
