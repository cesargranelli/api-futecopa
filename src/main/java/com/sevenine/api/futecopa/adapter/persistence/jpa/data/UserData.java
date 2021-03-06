package com.sevenine.api.futecopa.adapter.persistence.jpa.data;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "User")
@Table(name = "users")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "users_id_seq")
    private Long id;

    private String uid;
    private String name;
    private String nickname;
    private String slug;
    private String email;
    private String photo;
    private Integer position;
    private Integer round;
    private Integer total;

    public void setSlug(String nickname) {
        slug = StringUtils.lowerCase(StringUtils.replace(nickname, " ", "-"));
    }

}
