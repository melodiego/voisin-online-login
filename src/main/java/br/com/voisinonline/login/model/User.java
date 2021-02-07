package br.com.voisinonline.login.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(value = "user")
public class User implements Serializable {
    private static final long serialVersionUID = -4078215116959398051L;

    @Id
    private String id;
    @Indexed
    private String mail;
    @Indexed
    private String name;
    @Indexed
    private String phone;
    private boolean active;
    private Credential credential;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;
}