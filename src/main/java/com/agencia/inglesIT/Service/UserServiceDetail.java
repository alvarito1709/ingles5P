package com.agencia.inglesIT.Service;


import com.agencia.inglesIT.Dao.UserDao;
import com.agencia.inglesIT.entities.User;
import com.agencia.inglesIT.repository.UserRepository;
import com.agencia.inglesIT.util.PasswordEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("userDetailsService")
@Slf4j
public class UserServiceDetail implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    private Model model;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
    if(user == null){
        throw new UsernameNotFoundException(username);
    }

        var roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority(user.getRol()));
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(true);
        session.setAttribute("usuariosession", user);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
    }
}
