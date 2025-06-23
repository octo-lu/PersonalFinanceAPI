package com.personal.finance.user.model;

import lombok.Data;

@Data
public class UpdateUserCommand {

    private Integer id;
    private CustomUser customUser;

    public UpdateUserCommand(Integer id, CustomUser customUser) {
        this.id = id;
        this.customUser = customUser;
    }
}
