package org.magalhaes.entity;


import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.json.bind.annotation.JsonbProperty;


@RegisterForReflection
public class Brand {
    @JsonbProperty("nome")
    private String name;
    @JsonbProperty("codigo")
    private String code;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "{code: " + getCode() + ", " + "name: " + getName() + "}";
    }
}
