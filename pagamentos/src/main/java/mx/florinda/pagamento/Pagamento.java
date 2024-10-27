package mx.florinda.pagamento;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Pagamento extends PanacheEntity {

  public BigDecimal valor;

  @Enumerated(EnumType.STRING)
  public StatusPagamento status;


  @Override
  public String toString() {
    return "Pedido{" +
            "id=" + id +
            ", status=" + status +
            '}';
  }
}
