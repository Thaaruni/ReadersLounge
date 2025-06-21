package com.thaaru.book_network.role;

import com.thaaru.book_network.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@Entity
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Role {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime lastLogin;
    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;

}
