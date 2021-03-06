package nl.craftsmen.exceptionhandling;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiError implements Serializable {

	private static final long serialVersionUID = -7206808194632076169L;

	private String errorMessage;

	@Singular("validationMessage")
	private List<String> validationMessages;
}
