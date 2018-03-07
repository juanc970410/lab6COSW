package edu.eci.cosw.samples.model;

// Generated Feb 5, 2013 5:52:11 PM by Hibernate Tools 3.4.0.CR1

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * AlmPedidos generated by hbm2java
 */
@Entity
@Table(name = "ALM_PEDIDOS" )
public class Pedido implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6523093022555468864L;
	private Integer idpedido;
	private Cliente almClientes;
	private Date fechaRadicacion;
	private Set<DetallePedido> almDetallesPedidos = new HashSet<DetallePedido>(0);

	public Pedido() {
	}

	public Pedido(Cliente almClientes, Date fechaRadicacion) {
		this.almClientes = almClientes;
		this.fechaRadicacion = fechaRadicacion;
	}

	public Pedido(Cliente almClientes, Date fechaRadicacion,
			 Set<DetallePedido> almDetallesPedidos) {
		this.almClientes = almClientes;
		this.fechaRadicacion = fechaRadicacion;
		this.almDetallesPedidos = almDetallesPedidos;
	}

	@Id
	@GeneratedValue
	@Column(name = "idpedido", unique = true, nullable = false)
	public Integer getIdpedido() {
		return this.idpedido;
	}

	public void setIdpedido(Integer idpedido) {
		this.idpedido = idpedido;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENTES_idcliente", nullable = false) 
        @Fetch(FetchMode.JOIN)
	public Cliente getCliente() {
		return this.almClientes;
	}

	public void setCliente(Cliente almClientes) {
		this.almClientes = almClientes;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_radicacion", nullable = false, length = 19)
	public Date getFechaRadicacion() {
		return this.fechaRadicacion;
	}

	public void setFechaRadicacion(Date fechaRadicacion) {
		this.fechaRadicacion = fechaRadicacion;
	}


	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)        
	@JoinColumn(name="PEDIDOS_idpedido")
        @Fetch(FetchMode.JOIN)
	public Set<DetallePedido> getDetallesPedidos() {
		return this.almDetallesPedidos;
	}

	public void setDetallesPedidos(Set<DetallePedido> almDetallesPedidos) {
		this.almDetallesPedidos = almDetallesPedidos;
	}

	public void addDetallePedido(DetallePedido dp){
		almDetallesPedidos.add(dp);
	}
	
	
}
