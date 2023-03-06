package com.filippova.bookStore.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;


@AllArgsConstructor
public enum Role implements GrantedAuthority {
    //fixed set of constants
    ROLE_USER("role_user"),
    ROLE_ADMIN("role_admin");

   // used from Project Lombok to automatically generate the getter method for the name field.
    @Getter
    private final String name;

    @Override
    public String getAuthority() {
        return name();
    }
}
