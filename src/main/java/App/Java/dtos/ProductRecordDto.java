package App.Java.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRecordDto(@NotBlank String productName,
                               @NotBlank String productOrigin,
                               @NotNull double productPrice,
                               @NotNull int productQuantity) {
}
