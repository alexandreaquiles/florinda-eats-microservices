package mx.florinda.pedido;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class PagamentoConfirmadoConsumer {

  @Incoming("pagamentosConfirmados")
  public Uni<Void> consome(PagamentoConfirmadoEvent evento) {
    System.out.println(evento);
    return Panache.withTransaction(() ->
            Pedido.<Pedido>findById(evento.pedidoId)
                    .onItem().ifNotNull().invoke(pedido -> {
                      System.out.println("Vai atualizar o pedido: %s".formatted(pedido));
                      pedido.status = StatusPedido.PAGO;
                    })).replaceWithVoid();
  }

}
