package org.example;

import com.mongodb.client.MongoClients;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.example.clases.Componente;
import org.example.clases.MovimientoInventario;
import org.example.clases.OrdenCompra;

import java.util.*;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Main {
    MongoDatabase database;
    MongoClient mongoClient;

    public static void main(String[] args) {
        String connectionString = "mongodb://localhost:27017/"; //CAMBIAR
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            //CAMBIAR BASE DE DATOS
            MongoDatabase database = mongoClient.getDatabase("ordenAutomatica");
            //Obtener objeto de un Collection
            MongoCollection<org.bson.Document> collection = database.getCollection("Suplidor");
            long countDocuments = collection.countDocuments();
            System.out.println("\n\n\nCantidad Documentos Colección Componente==> " + countDocuments + "\n\n");
        }
    }

    private void registrarMovimiento(MovimientoInventario movimiento){
        MongoCollection<Document> movimientosCollection = database.getCollection("Componente");

        // Creación del documento para el nuevo movimiento
        Document nuevoMovimiento = new Document()
                .append("tipo", movimiento.getCodigoMovimiento())
                .append("fecha", movimiento.getFechaMovimiento())
                .append("almacen", movimiento.getCodigoAlmacen())
                .append("componente", movimiento.getComponente().getCodigoComponente())
                .append("cantidad", movimiento.getCantidad());

        //ARREGLAR PARA AGREGAR A LA COLECCION
        //movimientosCollection.append(nuevoMovimiento);

        // Actualizar el balance del componente en la colección "componentes"
        MongoCollection<Document> componentesCollection = database.getCollection("componentes");
        Bson filtro = Filters.eq("_id", movimiento.getComponente().getCodigoComponente());
        Bson update;

        if (movimiento.getCodigoMovimiento().equals("entrada")) {
            update = Updates.inc("cantidad", movimiento.getCantidad());
        } else {
            update = Updates.inc("cantidad", -movimiento.getCantidad());
        }

        componentesCollection.updateOne(filtro, update);
    }

    public List<OrdenCompra> generarOrdenCompraAutomatica(List<Componente> componentes, Date fechaObjetivo) {
        List<OrdenCompra> ordenesCompra = new ArrayList<>();
        MongoCollection<Document> componentesCollection = database.getCollection("componentes");
        MongoCollection<Document> proveedoresCollection = database.getCollection("proveedores");

        // Recorrer la coleccion de componentes
        for (Componente componente : componentes) {
            // Verificar si el componente tiene cantidad por debajo del nivel objetivo
            if (componente.getUnidad() < componente.getInventarioMinimo()) {

                Bson proveedoresFiltro = Filters.and(
                        Filters.eq("componenteId", componente.getCodigoComponente()),
                        Filters.eq("activo", true)
                );
                List<Document> proveedoresDocs = proveedoresCollection.find(proveedoresFiltro).into(new ArrayList<>());

                // Ordenar los proveedores por fecha de entrega ascendente y precio ascendente
                Collections.sort(proveedoresDocs, Comparator.comparing(d -> d.getDate("tiempoEntrega")));

                // Obtener el proveedor con la fecha de entrega más temprana y/o menor costo
                Document proveedorSeleccionado = proveedoresDocs.get(0);

                // Generar la orden de compra para el proveedor seleccionado
                OrdenCompra ordenCompra = new OrdenCompra();
                ordenCompra.setNumeroOrden((String) proveedorSeleccionado.get("nombre"));
                ordenCompra.setFechaOrden(new Date());
                componente.setUnidad(componente.getInventarioMinimo() - componente.getUnidad());
                ordenCompra.agregarComponente(componente);
                ordenesCompra.add(ordenCompra);
            }
        }

        return ordenesCompra;
    }

}
