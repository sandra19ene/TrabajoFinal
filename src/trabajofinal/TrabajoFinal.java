
package trabajofinal;

import accesoADatos.CompraData;
import accesoADatos.DetalleCompraData;
import accesoADatos.ProductoData;
import accesoADatos.ProveedorData;
import entidades.DetalleCompra;
import entidades.Producto;
import entidades.Proveedor;
import java.time.LocalDate;
import java.time.Month;

public class TrabajoFinal {

    public static void main(String[] args) {
   //     ProductoData proData = new ProductoData();    
  //      Producto prod = new Producto("Smart TV 32", "TV Smart 32", 99000.55, 400, true);
  //      proData.guardarProducto(prod);
//        proData.actualizarProducto(prod);
//        proData.eliminarProducto(prod);

       // ProveedorData provData = new ProveedorData();
       // Proveedor prov = new Proveedor(2,"Fábrica Aire Acond", "Av. La Plata 1900", "114444777");
//        provData.guardarProveedor(prov);
//        provData.actualizarProveedor(prov);
//        provData.eliminarProveedor(prov);
// ProductoData pro = new ProductoData();
// Producto producto = new Producto("Samsung Smart TV 50", "TV Smart 50 pulgadas Android SO", 99000.55, 400, true);
//       
//        pro.actualizarProducto(producto);

//Producto prod = new Producto( 8,"nom", "des", 333333, 25, true);
//        
//ProductoData proData = new ProductoData();
//        
//        proData.actualizarProducto(prod)

       // Proveedor pro = new Proveedor();
       
//        ProveedorData pro = new ProveedorData();
//         for (Proveedor p: pro.listaProveedores()) {
//             System.out.println(p.getIdProveedor());
//             System.out.println(p.getRazonSocial());
//             System.out.println(p.getDomicilio());
//         
//         
//         
//         }

//            CompraData c=new CompraData();
//            
//            c.realizarCompra(5, LocalDate.of(2023, Month.MARCH, 2));
//
//       CompraData c=new CompraData();
//       
//       for(Compra co: c. ){
       
       

// ProductoData prod = new ProductoData();
// String nom="TV LED";
// 
//        System.out.println( prod.buscarProducto(nom));

    DetalleCompraData d = new DetalleCompraData();
        System.out.println(d.obtenerDetalleCompraFull(1));
       
       }
                

    //}
    
}
