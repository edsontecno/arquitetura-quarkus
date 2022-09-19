package br.com.edsonandrade.filters;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.edsonandrade.dto.ErrorDTO;
import br.com.edsonandrade.enums.MessageEnum;
import br.com.edsonandrade.exceptions.AuthorizationException;
import br.com.edsonandrade.exceptions.BusinessRuleException;
import br.com.edsonandrade.util.ErrorBuilder;

@Provider
public class ExceptionsFilter implements ExceptionMapper<Exception> {

    protected static final String LINHA = " - linha: ";
    protected static final String PONTO = ".";
    protected static final String PACKAGE_NAME = "br.com.edsonandrade";

    @Override
    public Response toResponse(Exception e) {
    	
    	if (e instanceof BusinessRuleException) {
    		return businessResponse((BusinessRuleException) e);
    	}
    	
    	if (e instanceof AuthorizationException) {
    		return defaultResponse(MessageEnum.ERRO_AUTHORIZATION, e);
    	}
    	
        return defaultResponse(MessageEnum.ERRO_APLICACAO, e);
    }
    
    private Response businessResponse(BusinessRuleException exception) {
        System.out.println("Error with exception log " +  exception);
        
        return mountResponse(exception.getErro().getStatus(), exception.getErro());
    }
    
	private Response defaultResponse(MessageEnum messageEnum, Exception e) {
		String source = "";
        String reason = e.getMessage();

        for(StackTraceElement stackTraceElement : e.getStackTrace()){
            //Pega a primeiro ocorrencia elemento da lista de stackTrace caso nao encontre dentro do stack
            if(source.length() == 0){
                source = stackTraceElement.getClassName() + LINHA + stackTraceElement.getLineNumber() + PONTO;
            }
            //Pega a primeira ocorrencia de erro dentro do codigo do projeto pelo package name
            if(stackTraceElement.getClassName().contains(PACKAGE_NAME)){
                source = stackTraceElement.getClassName() + LINHA + stackTraceElement.getLineNumber() + PONTO;
                break;
            }
        }

        ErrorDTO erro = new ErrorBuilder(messageEnum, source).withFormatedDeveloperMessage(reason).build();
        return mountResponse(messageEnum.getStatus(), erro);
	}
	
	private Response mountResponse(int status, ErrorDTO error) {
    	 return Response
                 .status(status)
                 .type(MediaType.APPLICATION_JSON_TYPE)
                 .entity(error)
                 .build();
    }
}