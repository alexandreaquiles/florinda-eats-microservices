package mx.florinda.pedido;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("/pedidos")
public class PedidoResource {

  @GET
  public Uni<List<Pedido>> lista() {
    return Pedido.listAll();
  }

  @GET
  @Path("/{id}")
  public Uni<Pedido> porId(Long id) {
    return Pedido.findById(id);
  }

}
