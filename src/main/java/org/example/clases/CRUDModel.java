package org.example.clases;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.io.IOException;
import java.util.*;
import static com.mongodb.client.model.Filters.eq;

public class CRUDModel {



    //METODOS PARA LOS COMPONENTES

    public Iterator obtenerComponentes(MongoDatabase database){
        MongoCollection<Document> collection = database.getCollection("Componente");
        FindIterable<Document> iterDoc = collection.find();

        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        return it;


    }
    public String obtenerComponentePorId(MongoDatabase database, String codigo){
        MongoCollection<Document> collection = database.getCollection("Componente");
        Document myDoc = collection.find(eq("codigoComponente", codigo)).first();
        if(myDoc == null){
            return null;
        }
        return myDoc.toJson();
    }

    public void insertarDocumentoComponente(MongoDatabase database, Componente cmp) throws IOException{
        MongoCollection<Document> componente = database.getCollection("Componente");

        if(obtenerComponentePorId(database, cmp.getCodigoComponente()) == null){
            // Preparar los documentos y subdocumentos que serán insertados.
            Document docComponente = new Document();
            Document docAlmacenes = new Document();

            docComponente.append("codigoComponente", cmp.getCodigoComponente());
            docComponente.append("descripcion", cmp.getDescripcion());
            docComponente.append("unidad", cmp.getUnidad());
            docComponente.append("inventarioMinimo", cmp.getInventarioMinimo());

            HashMap<String, Object> datosAlmacenes = new HashMap<>();

            datosAlmacenes.put("codigoAlmacen", cmp.getAlmacenes().get(0));
            //datosAlmacenes.put("balance", cmp.getAlmacenes().get(1));

            docAlmacenes.putAll(datosAlmacenes);

            docComponente.put("Almacenes", docAlmacenes);
            componente.insertOne(docComponente);


        }
        else {
            throw new IOException("Ya existe un componente con dicho codigo");
        }
    }

    //METODOS PARA LOS SUPLIDORES

    public void obtenerSuplidores(MongoDatabase database){
        MongoCollection<Document> collection = database.getCollection("Suplidor");
        FindIterable<Document> iterDoc = collection.find();
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

    public String obtenerSuplidorPorId(MongoDatabase database, String codigo){
        MongoCollection<Document> collection = database.getCollection("Suplidor");
        Document myDoc = collection.find(eq("codigoSuplidor", codigo)).first();
        if(myDoc == null){
            return null;
        }
        return myDoc.toJson();
    }


    public void insertarDocumentoSuplidor(MongoDatabase database, Suplidor sp) throws IOException{
        MongoCollection<Document> suplidor = database.getCollection("Suplidor");

        if(obtenerSuplidorPorId(database, sp.getCodigoSuplidor()) == null){
            // Preparar los documentos y subdocumentos que serán insertados.
            Document docsuplidor = new Document();


            docsuplidor.append("codigoSuplidor", sp.getCodigoSuplidor());
            docsuplidor.append("nombre", sp.getNombre());
            docsuplidor.append("rnc", sp.getRnc());
            docsuplidor.append("ciudad", sp.getCiudad());
            docsuplidor.append("direccion", sp.getDireccion());
            suplidor.insertOne(docsuplidor);

        }
        else {
            throw new IOException("Ya existe un suplidor con dicho codigo");
        }
    }


    //METODOS PARA LOS TIEMPOS DE ENTREGA

    public void insertarDocumentoTiempoEntrega(MongoDatabase database, TiempoEntrega te){
        MongoCollection<Document> tiempoEntrega = database.getCollection("TiempoEntregaSuplidor");

            // Preparar los documentos y subdocumentos que serán insertados.
            Document docTiempoEntrega = new Document();

            docTiempoEntrega.append("codigoSuplidor", te.getCodigoSuplidor());
            docTiempoEntrega.append("codigoComponente", te.getCodigoComponente());
            docTiempoEntrega.append("tiempoEntrega", te.getTiempoEntrega());
            docTiempoEntrega.append("precio", te.getTiempoEntrega());
            docTiempoEntrega.append("descuento", te.getDescuento());
            docTiempoEntrega.append("activo", te.getActivo());
            tiempoEntrega.insertOne(docTiempoEntrega);

    }

    public void obtenerTiemposEntrega(MongoDatabase database){
        MongoCollection<Document> collection = database.getCollection("TiempoEntregaSuplidor");
        FindIterable<Document> iterDoc = collection.find();
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

    //METODOS PARA LOS MOVIMIENTOS

    public void insertarDocumentoMovimiento(MongoDatabase database, MovimientoInventario mv){
        MongoCollection<Document> movimiento = database.getCollection("MovimientoInventario");

            // Preparar los documentos y subdocumentos que serán insertados.
            Document docMovimiento = new Document();
            Document docDetalles = new Document();


            docMovimiento.append("codigoMovimiento", mv.getCodigoMovimiento());
            docMovimiento.append("fechaMovimiento", mv.getFechaMovimiento());
            docMovimiento.append("codigoAlmacen", mv.getCodigoAlmacen());
            docMovimiento.append("tipoMovimiento", mv.getTipoMovimiento());

            HashMap<String, Object> datos = new HashMap<>();

            datos.put("codigoComponente", mv.getDetalle().get(0));
            datos.put("cantidadMovimiento", mv.getDetalle().get(1));
            datos.put("unidad", mv.getDetalle().get(2));

            docDetalles.putAll(datos);

            docMovimiento.put("detalle", docDetalles);
            movimiento.insertOne(docMovimiento);

    }

    public void obtenerMovimientos(MongoDatabase database){
        MongoCollection<Document> collection = database.getCollection("MovimientoInventario");
        FindIterable<Document> iterDoc = collection.find();
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }






















    private void registrarMovimiento(MongoDatabase database, MovimientoInventario movimiento){
        MongoCollection<Document> movimientosCollection = database.getCollection("Componente");

        // Creación del documento para el nuevo movimiento
        Document nuevoMovimiento = new Document()
                .append("tipo", movimiento.getCodigoMovimiento())
                .append("fecha", movimiento.getFechaMovimiento())
                .append("almacen", movimiento.getCodigoAlmacen())
                .append("componente", movimiento.getDetalle().get(0))
                .append("cantidad", movimiento.getCantidad());

        //ARREGLAR PARA AGREGAR A LA COLECCION
        //movimientosCollection.append(nuevoMovimiento);

        // Actualizar el balance del componente en la colección "componentes"
        MongoCollection<Document> componentesCollection = database.getCollection("componentes");
        Bson filtro = Filters.eq("_id", movimiento.getDetalle().get(0));
        Bson update;

        if (movimiento.getCodigoMovimiento().equals("entrada")) {
            update = Updates.inc("cantidad", movimiento.getCantidad());
        } else {
            update = Updates.inc("cantidad", -movimiento.getCantidad());
        }

        componentesCollection.updateOne(filtro, update);
    }

    public List<OrdenCompra> generarOrdenCompraAutomatica(MongoDatabase database,List<Componente> componentes, Date fechaObjetivo) {
        List<OrdenCompra> ordenesCompra = new ArrayList<>();
        MongoCollection<Document> componentesCollection = database.getCollection("componentes");
        MongoCollection<Document> proveedoresCollection = database.getCollection("proveedores");

        // Recorrer la coleccion de componentes
        for (Componente componente : componentes) {
            // Verificar si el componente tiene cantidad por debajo del nivel objetivo
            if (componente.getInventarioMinimo() < componente.getInventarioMinimo()) {

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
                ordenCompra.agregarComponente(componente);
                ordenesCompra.add(ordenCompra);
            }
        }

        return ordenesCompra;
    }






}
