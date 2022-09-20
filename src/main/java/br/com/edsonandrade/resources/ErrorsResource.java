package br.com.edsonandrade.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.com.edsonandrade.dto.ErrorDTO;
import br.com.edsonandrade.dto.ListErrorDTO;
import br.com.edsonandrade.enums.MessageEnum;

@Produces(MediaType.APPLICATION_JSON)
@Path("/errors")
public class ErrorsResource{

    @GET
    @Operation(summary = "Lista de Erros", description = "Retorna uma lista de erros sem formatação que a aplicação pode lançar.")
    @APIResponse(description = "Lista de Erros.", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ListErrorDTO.class))})
    public Response errors(){
        List<ErrorDTO> listaErros = new ArrayList<>();

        for (MessageEnum msg : MessageEnum.values()){
            listaErros.add(new ErrorDTO(msg));
        }
        
        ListErrorDTO listaError = new ListErrorDTO(listaErros);

        return Response.status(Response.Status.OK).entity(listaError).build();
    }
}
