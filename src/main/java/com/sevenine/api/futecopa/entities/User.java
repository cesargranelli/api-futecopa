package com.sevenine.api.futecopa.entities;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
public class User {
    private String uid;
    private String nickname;
    private String slug;
    private String name;
    private String email;
    private String foto;
    private Integer position;
    private Integer round;
    private Integer total;

    public void setSlug(String nickname) {
        this.slug = StringUtils.lowerCase(StringUtils.replace(nickname, " ", "-"));
    }
}
