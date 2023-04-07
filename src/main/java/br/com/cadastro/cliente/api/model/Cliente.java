package br.com.cadastro.cliente.api.model;

import br.com.cadastro.cliente.api.dto.CriaClienteRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Table(name = "clientes")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String nome;

    @Column(nullable = false)
    Integer idade;

    @Column(nullable = false)
    String email;

    public void atualizaDados(CriaClienteRequest novosDados) {
        this.nome = novosDados.nome();
        this.idade = novosDados.idade();
        this.email = novosDados.email();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(getId(), cliente.getId()) && Objects.equals(getNome(), cliente.getNome()) && Objects.equals(getIdade(), cliente.getIdade()) && Objects.equals(getEmail(), cliente.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getIdade(), getEmail());
    }
}
