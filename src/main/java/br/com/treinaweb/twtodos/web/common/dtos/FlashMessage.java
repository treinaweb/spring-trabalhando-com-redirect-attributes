package br.com.treinaweb.twtodos.web.common.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlashMessage {

    private String message;

    private Type type;

    public static FlashMessage success(String message) {
        return new FlashMessage(message, Type.SUCCESS);
    }

    public static FlashMessage error(String message) {
        return new FlashMessage(message, Type.ERROR);
    }

    public enum Type {
        SUCCESS, ERROR
    }
    
}
