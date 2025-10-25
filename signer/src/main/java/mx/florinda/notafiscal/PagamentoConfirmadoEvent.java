package mx.florinda.notafiscal;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class PagamentoConfirmadoEvent {

  public UUID eventId;
  public LocalDateTime eventTimestamp;

  public Long pagamentoId;
  public Long pedidoId;
  public BigDecimal valor;

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
