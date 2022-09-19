package br.com.edsonandrade.dto;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.openapi.annotations.media.Schema;


@Schema(name="Lista de Erros", description="Lista com os Erros.")
public class ListErrorDTO {

    private List<ErrorDTO> errors;

    public ListErrorDTO() {
        this.errors = new ArrayList<>();
    }

	public ListErrorDTO(List<ErrorDTO> errors) {
        this.errors = errors;
    }

    public ListErrorDTO(ErrorDTO error) {
        this.errors = new ArrayList<>();
        this.errors.add(error);
    }

    public List<ErrorDTO> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorDTO> errors) {
        this.errors = errors;
    }
}
