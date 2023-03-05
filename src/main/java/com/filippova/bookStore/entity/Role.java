package com.filippova.bookStore.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
public enum Role implements GrantedAuthority {
    ROLE_USER("role_user"),
    ROLE_ADMIN("role_admin");

    @Getter
    private final String name;

    @Override
    public String getAuthority() {
        return name();
    }
}
