package com.agrotag.network.infrastructure.security;

import com.agrotag.network.domain.entities.Usuario;
import com.agrotag.network.domain.entities.enums.TipoUsuario;
import com.agrotag.network.domain.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuth2UserServiceImpl extends DefaultOAuth2UserService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String email = oAuth2User.getAttribute("email");
        String nome = oAuth2User.getAttribute("name");

        usuarioRepository.findByUsername(email)
                .orElseGet(() -> {
                    Usuario novoUsuario = Usuario.builder()
                            .email(email)
                            .nome(nome)
                            .senha("")
                            .endereco("")
                            .ativo(true)
                            .tipoUsuario(TipoUsuario.NORMAL_USER)
                            .build();
                    return usuarioRepository.save(novoUsuario).orElseThrow();
                });

        return oAuth2User;
    }
}