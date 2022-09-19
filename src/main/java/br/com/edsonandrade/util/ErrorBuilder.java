package br.com.edsonandrade.util;

import br.com.edsonandrade.dto.ErrorDTO;
import br.com.edsonandrade.enums.MessageEnum;

public class ErrorBuilder{

    private String message;
    private MessageEnum enumMensagens;
    private String source;
    private int sequential;
    private String[] messageArgs = {""};
    private String[] moreInfoArgs = {""};
    private String[] userHelpArgs = {""};
    private String[] developerMessageArgs = {""};

    public ErrorBuilder (MessageEnum enumErro, String source) {
        this.enumMensagens = enumErro;
        this.source = source;
    }

    public ErrorBuilder (String message, String source) {
        this.message = message;
        this.source = source;
    }

    public ErrorBuilder withFormatedMessage(String... args){
        if(args != null) {
            messageArgs = args;
        }
        return this;
    }

    public ErrorBuilder withSequential(int sequential){
        this.sequential = sequential;
        return this;
    }

    public ErrorBuilder withFormatedMoreInfo(String... args){
        if(args != null) {
            moreInfoArgs = args;
        }
        return this;
    }

    public ErrorBuilder withFormatedUserHelp(String... args){
        if(args != null) {
            userHelpArgs = args;
        }
        return this;
    }

    public ErrorBuilder withFormatedDeveloperMessage(String... args){
        if(args != null) {
            developerMessageArgs = args;
        }
        return this;
    }

    public ErrorDTO build(){

    	ErrorDTO erro;
        if(message != null && message.trim().length() > 0){
            erro = new ErrorDTO(this.message, this.source);
        } else {
            erro = new ErrorDTO(this.enumMensagens, this.source);
        }

        erro.setDeveloperMessage(String.format(erro.getDeveloperMessage(), developerMessageArgs));
        erro.setUserHelp(String.format(erro.getUserHelp(), userHelpArgs));
        erro.setMoreInfo(String.format(erro.getMoreInfo(), moreInfoArgs));
        erro.setSequential(String.valueOf(this.sequential));

        return erro;
    }
}
