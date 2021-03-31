package fr.gino.lsftranslate.auth.User;

import fr.gino.lsftranslate.auth.Autority.Autority;
import fr.gino.lsftranslate.auth.Role.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String username;

    String password;

    Boolean isEnabled;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn( name = "user_id" ),
            inverseJoinColumns = @JoinColumn( name = "role_id" ) )
    Set<Role> roles;

    @ManyToMany
    @JoinTable(name = "user_autority",
            joinColumns = @JoinColumn( name = "user_id" ),
            inverseJoinColumns = @JoinColumn( name = "autority_id" ) )
    Set<Autority> autorities;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }
}
