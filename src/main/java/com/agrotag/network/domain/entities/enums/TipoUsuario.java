package com.agrotag.network.domain.entities.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoUsuario {

    ADMIN(0, "Usuário com permissão total"),
    NORMAL_USER(1, "Usuário com acesso a suas informações");

    private final int codigo;
    private final String descricao;

    @JsonValue
    public int getCodigo() {
        return codigo;
    }

    @JsonCreator
    public static TipoUsuario fromCodigo(int codigo) {
        for (TipoUsuario tipo : TipoUsuario.values()) {
            if (tipo.codigo == codigo) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Código inválido: " + codigo);
    }

    public static TipoUsuario fromDescricao(String descricao) {
        for (TipoUsuario tipo : TipoUsuario.values()) {
            if (tipo.descricao.equalsIgnoreCase(descricao)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Descrição inválida: " + descricao);
    }
}