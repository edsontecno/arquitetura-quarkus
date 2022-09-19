package br.com.edsonandrade.enums;

public enum MessageEnum {
    ERRO_APLICACAO("000","Erro ao executar", 500, "%s", "%s", "%s"),
    ERRO_BUSINESS("000","Erro de regra de negócio", 402, "%s", "%s", "%s"),
    ERRO_AUTHORIZATION("000","Sem autorização", 401, "%s", "%s", "%s");

    String mensagem;
    String codigo;
    int status;

    String userHelp;
    String developerMessage;
    String moreInfo;

    MessageEnum(String codigo, String mensagem, int status, String userHelp, String developerMessage, String moreInfo) {
    	this.mensagem = mensagem;
        this.codigo = codigo;
        this.status = status;
        this.userHelp = userHelp;
        this.developerMessage = developerMessage;
        this.moreInfo = moreInfo;
    }

    public int getStatus() {
		return status;
	}

	public String getCodigo() {
        return codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getUserHelp() { return userHelp; }

    public String getDeveloperMessage() { return developerMessage; }

    public String getMoreInfo() { return moreInfo; }
}
