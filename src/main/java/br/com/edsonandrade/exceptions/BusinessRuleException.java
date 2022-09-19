package br.com.edsonandrade.exceptions;

import br.com.edsonandrade.dto.ErrorDTO;
import br.com.edsonandrade.enums.MessageEnum;
import br.com.edsonandrade.util.ErrorBuilder;

@SuppressWarnings("serial")
public class BusinessRuleException extends Exception {

    static final String LINHA = " - linha: ";
    static final String PONTO = " .";
    private final String[] args;
    private final MessageEnum enumMensagem;

    protected BusinessRuleException(String message){
        super(message);
        this.args = new String[]{""};
        this.enumMensagem = null;
    }

    protected BusinessRuleException(String message, Throwable cause){
        super(message, cause);
        this.args = new String[]{""};
        this.enumMensagem = null;
    }

    public BusinessRuleException(MessageEnum enumMensagem) {
        super(enumMensagem.getMensagem());
        this.enumMensagem = enumMensagem;
        args = new String[]{""};
    }

    public BusinessRuleException(MessageEnum enumMensagem, String... args) {
        super(enumMensagem.getMensagem());
        this.args = args;
        this.enumMensagem = enumMensagem;
    }

    public BusinessRuleException(MessageEnum enumMensagem, Throwable cause) {
        super(enumMensagem.getMensagem(), cause);
        this.enumMensagem = enumMensagem;
        args = new String[]{""};
    }

    public BusinessRuleException(MessageEnum enumMensagem,Throwable cause, String... args) {
        super(enumMensagem.getMensagem(), cause);
        this.enumMensagem = enumMensagem;
        this.args = args;
    }


    private String getSourceFromStackTrace() {
        StackTraceElement stackTrace = this.getStackTrace()[0];
        return stackTrace.getClassName() + LINHA + stackTrace.getLineNumber() + PONTO;
    }

    public ErrorDTO getErro() {
        if(this.enumMensagem != null){
            return new ErrorBuilder(this.enumMensagem, getSourceFromStackTrace()).withFormatedMessage(this.args).build();
        } else {
            return new ErrorBuilder(this.getMessage(), getSourceFromStackTrace()).withFormatedMessage(this.args).build();
        }
    }
}
