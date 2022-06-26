package com.example.rookie_review_tool.security;

import com.example.rookie_review_tool.infrastructure.dto.response.FindUserResponse;
import com.example.rookie_review_tool.infrastructure.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || "".equals(username)) {
            throw new UsernameNotFoundException("Username is empty");
        }

        FindUserResponse user = userMapper.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        // ログインユーザーへユーザー権限を付与, 管理者権限についてはこのアプリでは必要なさそう。
        Collection<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList("ROLE_USER");

        return new UserDetailsImpl(user, authorityList);
    }
}
