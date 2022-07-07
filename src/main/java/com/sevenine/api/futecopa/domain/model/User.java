package com.sevenine.api.futecopa.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class User {

    private String uid;
    private String name;
    private String nickname;
    private String slug;
    private String email;
    private String photo;
    private Long position;
    private Long round;
    private Long total;

    public void setSlug(String nickname) {
        slug = StringUtils.lowerCase(StringUtils.replace(nickname, " ", "-"));
    }

}
