package com.design.pattern._02_structure._01_adapter._01_before.security;

public interface UserDetailsService {

    UserDetails loadUser(String username);

}
