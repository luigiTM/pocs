package com.lughtech.validator;

import com.lughtech.validator.model.User;
import com.lughtech.validator.validators.ObjectValidator;

public class Main {

    static void main() {
        User user = new User(null, "");
        ObjectValidator objectValidator = new ObjectValidator();
        var result = objectValidator.validate(user);
        System.out.println(result);
    }

}
