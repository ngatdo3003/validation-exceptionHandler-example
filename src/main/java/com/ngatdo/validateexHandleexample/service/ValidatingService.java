package com.ngatdo.validateexHandleexample.service;

import com.ngatdo.validateexHandleexample.entity.UserEnt;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.naming.InvalidNameException;
import javax.validation.Valid;

/**
 * Service validate dữ liệu dựa trên annotation @NotNull @NotBlank @Size @Min @Max...
 */
@Service("ValidatingService")
@Validated
public class ValidatingService {
    /**
     * Hàm validate theo các Annotation
     * @param input
     */
    public void validate(@Valid Object input){
    }

    /**
     * Hàm validate theo Annotation và thêm điều kiện là userID phải bắt đầu bằng ABC
     * @param user
     * @return
     */
    public void customizedValidate(@Valid UserEnt user) throws InvalidNameException {
        if(!(user.getUserid()).startsWith("ABC")) throw new InvalidNameException(user.getUserid() + " is invalid");
    }
}
