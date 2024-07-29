package uz.com.demorender.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
@EqualsAndHashCode(callSuper = true)
public class AppException extends RuntimeException{
    private final String message;

    private HttpStatus status = HttpStatus.BAD_REQUEST;

    private AppException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }

    private AppException(String message) {
        super(message);
        this.message = message;
    }


    public static AppException appThrow(String message) {
        return new AppException(message);
    }

    public static AppException appThrow(String message, HttpStatus status) {
        return new AppException(message, status);
    }
}
