package mx.florinda.pagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class PagamentoConfirmadoEvent {

  public UUID eventId;
  public LocalDateTime eventTimestamp;

  public Long pagamentoId;
  public Long pedidoId;
  public BigDecimal valor;

  public PagamentoConfirmadoEvent(Long pagamentoId, Long pedidoId, BigDecimal valor) {
    this.eventId = UUID.randomUUID();
    this.eventTimestamp = LocalDateTime.now();
    this.pagamentoId = pagamentoId;
    this.pedidoId = pedidoId;
    this.valor = valor;
  }

  @Override
  public String toString() {
    return "PagamentoConfirmadoEvent{" +
        "eventId=" + eventId +
        ", eventTimestamp=" + eventTimestamp +
        ", pagamentoId=" + pagamentoId +
        ", pedidoId=" + pedidoId +
        ", valor=" + valor +
        '}';
  }
}
