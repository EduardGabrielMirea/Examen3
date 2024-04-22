package examen3.controller;

import examen3.entity.Cliente;
import examen3.entity.Factura;
import examen3.repository.ClienteRepository;
import examen3.repository.FacturaRepository;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

@Component
public class FacturaController {

    private final FacturaRepository facturaRepository;
    private final ClienteRepository clienteRepository;

    public FacturaController(FacturaRepository facturaRepository, ClienteRepository clienteRepository) {
        this.facturaRepository = facturaRepository;
        this.clienteRepository = clienteRepository;
    }

    public void crearFactura() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el id del cliente :");
        Long v = 0L;
        try {
        v = Long.parseLong(scanner.nextLine());
        }catch (Exception e){
            System.out.printf(" peta ");
        }
        Cliente cliente = clienteRepository.findById(v).orElse(null);
        if (cliente == null){
            System.out.println("No existe el id del cliente");
            return;
        }
        Factura factura = new Factura(cliente);
        System.out.println("Ingrese el nombre de la factura: ");
        factura.setNombre(scanner.nextLine());
        System.out.println("Ingrese la cantidad: ");
        factura.setCantidad(scanner.nextInt());
        facturaRepository.save(factura);
    }

    public void listarFacturasId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el id del cliente :");
        Long v = 0L;
        try {
            v = Long.parseLong(scanner.nextLine());
        }catch (Exception e){
            System.out.printf(" peta ");
        }
        Cliente cliente = clienteRepository.findById(v).orElse(null);
        if (cliente == null){
            System.out.println("No existe el id del cliente");
            return;
        }
        System.out.println(cliente.getFacturas());
    }
    public void listarFacturasNombre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del cliente :");
        String nombre = scanner.nextLine();
        List<Cliente> cliente = clienteRepository.findByNombreIs(nombre);
        if (cliente == null){
            System.out.println("No existe el nombre del cliente");
            return;
        }
         cliente.forEach(res -> System.out.println(res.getFacturas()));
    }

    public void listarFacturaImporte(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Determina el importe tope: ");
        Integer v = 0;
        try {
            v = Integer.parseInt(scanner.nextLine());
        }catch (Exception e){
            System.out.printf(" peta ");
        }
        List<Factura> factura = facturaRepository.findByCantidadGreaterThan(v);
        factura.forEach(System.out::println);
    }
}
