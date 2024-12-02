package pro.sky.HW_2._3.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundExection extends RuntimeException {
    public EmployeeNotFoundExection() {
    }

    public EmployeeNotFoundExection(String message) {
        super(message);
    }

    public EmployeeNotFoundExection(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeNotFoundExection(Throwable cause) {
        super(cause);
    }

    public EmployeeNotFoundExection(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
