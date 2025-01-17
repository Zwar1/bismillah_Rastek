package Rastek_fix.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;

    @Column(name = "username" , unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column (name = "email")
    private String email;

    @Column(name = "is_active")
    private boolean is_active = true;

    @Column(name = "is_deleted")
    private boolean is_deleted = false;

    @Version
    @Column(name = "version")
    private Integer version;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "update_by")
    private String update_by;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            uniqueConstraints = {
                @UniqueConstraint(name = "user_role_unique", columnNames = { "id_user", "id_role" })
            },
            joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "id_role")
    )
    private List<RoleEntity> roles = new ArrayList<>();
}
