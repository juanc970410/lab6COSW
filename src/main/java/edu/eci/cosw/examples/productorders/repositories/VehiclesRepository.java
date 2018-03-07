/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.examples.productorders.repositories;

import edu.eci.cosw.examples.productorders.services.ServicesException;
import edu.eci.cosw.samples.model.Vehiculo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/**
 *
 * @author JuanHerrera
 */
public interface VehiclesRepository extends JpaRepository<Vehiculo, String>{
    @Query("select d.vehiculo.placa from Despacho d inner join d.pedidos as ped inner join ped.detallesPedidos as detallesP inner join detallesP.producto as prod with prod.id = ?1")
    public List<Vehiculo> getVehiclesByProductId(Integer id) throws ServicesException;
}
