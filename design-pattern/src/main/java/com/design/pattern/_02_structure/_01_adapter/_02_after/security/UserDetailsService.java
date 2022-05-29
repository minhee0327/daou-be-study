package com.design.pattern._02_structure._01_adapter._02_after.security;

public interface UserDetailsService {

    UserDetails loadUser(String username);

}
