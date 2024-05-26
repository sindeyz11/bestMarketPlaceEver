package com.example.project.util;

import com.example.project.common.Code;
import com.example.project.exception.CommonException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Slf4j
@Component
@RequiredArgsConstructor
@AllArgsConstructor
public class ValidationUtils {

    private Validator validator;

    public <T> void validationRequest(T req) {
        if (req != null) {
            Set<ConstraintViolation<T>> result = validator.validate(req);
            if (!result.isEmpty()) {
                int numErrors = result.size(); // Количество ошибок валидации
                List<ConstraintViolation<T>> errorList = new ArrayList<>(result);
                String resultValidations = errorList.stream()
                        .map(ConstraintViolation::getMessage)
                        .reduce((s1, s2) -> s1 + ". " + s2)
                        .orElse("");

                log.error("Переданный в запросе json не валиден, ошибки валидации: {}", resultValidations);

                throw CommonException.builder()
                        .code(Code.REQUEST_VALIDATION_ERROR)
                        .techMessage(resultValidations)
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .build();
            }
        }
    }
}