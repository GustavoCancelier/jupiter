package br.com.gustavo.jupiter.model;

public abstract class PessoaModel {
	private String documento;

	public PessoaModel (String documento) {
		this.documento = documento;
	}

	public abstract Boolean isDocumentoValido();
	public abstract String getGerarDocumento();
	public abstract String getFormatarDocumeno();

	public String getDocumento() {
		return documento;
	}
}
