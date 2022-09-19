package br.com.edsonandrade.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import br.com.edsonandrade.enums.MessageEnum;

@Schema(name = "Erro", description = "Informações sobre o erro que ocorreu.")
public class ErrorDTO {

	private String code;
	private String message;
	private String source;
	private int status;
	private String userHelp;
	private String developerMessage;
	private String moreInfo;

	private String sequential;

	public ErrorDTO() {
		this.code = "";
		this.message = "";
		this.source = "";
		this.sequential = "0";
	}

	public ErrorDTO(String mensagem, String source) {
		this.code = "";
		this.message = mensagem;
		this.source = source;
		this.sequential = "0";
	}

	public ErrorDTO(MessageEnum msg, String source) {
		this(msg);
		this.source = source;
	}

	public ErrorDTO(MessageEnum msg) {
		this.code = msg.getCodigo();
		this.status = msg.getStatus();
		this.message = msg.getMensagem();
		this.userHelp = msg.getUserHelp();
		this.moreInfo = msg.getMoreInfo();
		this.developerMessage = msg.getDeveloperMessage();
		this.source = "";
		this.sequential = "0";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getUserHelp() {
		return userHelp;
	}

	public void setUserHelp(String userHelp) {
		this.userHelp = userHelp;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}

	public void setSequential(String sequential) {
		this.sequential = sequential;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getSequential() {
		return sequential;
	}
}
