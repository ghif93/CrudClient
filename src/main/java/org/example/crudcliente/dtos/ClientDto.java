package org.example.crudcliente.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.example.crudcliente.entities.Client;

import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link org.example.crudcliente.entities.Client}
 */
public class ClientDto {
    private Long id;
    @Size(min = 3, max = 80, message = "Deve ter entre 3 e 80 caracteres")
    @NotBlank(message = "Campo requerido")
    private String name;
    private String cpf;
    private Double income;
    private LocalDate birthDate;
    @Positive(message = "Deve ser um valor positivo")
    private Integer children;
    
    // Adicionar um construtor padrão para o Jackson
    public ClientDto() {
    }
    
    public ClientDto(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClientDto(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.cpf = client.getCpf();
        this.income = client.getIncome();
        this.birthDate = client.getBirthDate();
        this.children = client.getChildren();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ClientDto entity = (ClientDto) o;
        return Objects.equals(this.id, entity.id) &&
            Objects.equals(this.name, entity.name) &&
            Objects.equals(this.cpf, entity.cpf) &&
            Objects.equals(this.income, entity.income) &&
            Objects.equals(this.birthDate, entity.birthDate) &&
            Objects.equals(this.children, entity.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cpf, income, birthDate, children);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
            "id = " + id + ", " +
            "name = " + name + ", " +
            "cpf = " + cpf + ", " +
            "income = " + income + ", " +
            "birthDate = " + birthDate + ", " +
            "children = " + children + ")";
    }
}