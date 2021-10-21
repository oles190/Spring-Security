package com.oles.spring.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER(Set.of(Permission.DEVELOPERS_READ)),
    ADMIN(Set.of(Permission.DEVELOPERS_WRITE,Permission.DEVELOPERS_READ));


    private final Set<Permission> permissionSet;

    public Set<Permission> getPermissions() {
        return permissionSet;
    }

    Role(Set<Permission> permissionSet) {
        this.permissionSet = permissionSet;
    }



    public Set<SimpleGrantedAuthority>getAuthorities(){
        return getPermissions().stream().map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }





}



