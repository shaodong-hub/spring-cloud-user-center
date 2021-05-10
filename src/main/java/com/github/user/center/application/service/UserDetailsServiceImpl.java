package com.github.user.center.application.service;

import com.github.user.center.domain.aggregate.SystemUserAgg;
import com.github.user.center.domain.repository.ISystemUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * TODO
 * <p>
 * create in 2021/5/8 11:17 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final ISystemUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SystemUserAgg> optional = userRepository.findByUsername(username);
        if (optional.isEmpty()) {
            throw new UsernameNotFoundException("Username Not Found");
        }
        return optional.get();
    }

    public UserDetails loadUserByPhone(String phone) {
        Optional<SystemUserAgg> optional = userRepository.findByPhone(phone);
        if (optional.isEmpty()) {
            throw new UsernameNotFoundException("Username Not Found");
        }
        return optional.get();
    }


}