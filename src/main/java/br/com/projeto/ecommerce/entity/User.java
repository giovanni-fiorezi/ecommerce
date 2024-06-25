//package br.com.projeto.ecommerce.entity;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import javax.persistence.*;
//import java.io.Serial;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.Objects;
//
//@Entity
//@Table(name = "user")
//public class User implements UserDetails, Serializable {
//
//    @Serial
//    private static final long serialVersionUID = -4515260278004885748L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "user_name", unique = true)
//    private String userName;
//
//    @Column(name = "full_name")
//    private String fullName;
//
//    @Column(name = "password")
//    private String password;
//
//    @Column(name = "account_non_expired")
//    private Boolean accountNonExpired;
//
//    @Column(name = "account_non_locked")
//    private Boolean accountNonLocked;
//
//    @Column(name = "credentials_non_expired")
//    private Boolean credentialsNonExpired;
//
//    @Column(name = "enabled")
//    private Boolean enabled;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "user_permission", joinColumns = {@JoinColumn (name = "id_users")},
//     inverseJoinColumns = {@JoinColumn (name = "id_permission")})
//    private List<Permission> permissions;
//
//    private List<String> getRoles() {
//        List<String> roles = new ArrayList<>();
//        permissions.forEach(permission -> roles.add(permission.getDescricao()));
//        return roles;
//    }
//
//    public User() {
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return this.permissions;
//    }
//
//    @Override
//    public String getPassword() {
//        return this.password;
//    }
//
//    @Override
//    public String getUsername() {
//        return this.userName;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return this.accountNonExpired;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return this.accountNonLocked;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return this.credentialsNonExpired;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return this.enabled;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getFullName() {
//        return fullName;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Boolean getAccountNonExpired() {
//        return accountNonExpired;
//    }
//
//    public void setAccountNonExpired(Boolean accountNonExpired) {
//        this.accountNonExpired = accountNonExpired;
//    }
//
//    public Boolean getAccountNonLocked() {
//        return accountNonLocked;
//    }
//
//    public void setAccountNonLocked(Boolean accountNonLocked) {
//        this.accountNonLocked = accountNonLocked;
//    }
//
//    public Boolean getCredentialsNonExpired() {
//        return credentialsNonExpired;
//    }
//
//    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
//        this.credentialsNonExpired = credentialsNonExpired;
//    }
//
//    public Boolean getEnabled() {
//        return enabled;
//    }
//
//    public void setEnabled(Boolean enabled) {
//        this.enabled = enabled;
//    }
//
//    public List<Permission> getPermissions() {
//        return permissions;
//    }
//
//    public void setPermissions(List<Permission> permissions) {
//        this.permissions = permissions;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User users = (User) o;
//        return Objects.equals(id, users.id) && Objects.equals(userName, users.userName) && Objects.equals(fullName, users.fullName) && Objects.equals(password, users.password) && Objects.equals(accountNonExpired, users.accountNonExpired) && Objects.equals(accountNonLocked, users.accountNonLocked) && Objects.equals(credentialsNonExpired, users.credentialsNonExpired) && Objects.equals(enabled, users.enabled) && Objects.equals(permissions, users.permissions);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, userName, fullName, password, accountNonExpired, accountNonLocked, credentialsNonExpired, enabled, permissions);
//    }
//}
