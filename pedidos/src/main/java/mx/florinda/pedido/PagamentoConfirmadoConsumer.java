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
                      System.out.printf("Vai atualizar o pedido: %s %n", pedido);
                      pedido.status = StatusPedido.PAGO;
                    })).replaceWithVoid();
  }

}
