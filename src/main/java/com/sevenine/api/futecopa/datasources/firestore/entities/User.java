package com.sevenine.api.futecopa.datasources.firestore.entities;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gcp.data.firestore.Document;

@Getter
@Setter
@Document(collectionName = "users")
public class User {

    @DocumentId
    private String id;

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
        id = slug;
    }

}
