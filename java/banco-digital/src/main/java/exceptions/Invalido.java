package exceptions;

import lombok.Data;

@Data
public class Invalido extends Exception {

    public Invalido(String error) {
        super(error);
    }

}
