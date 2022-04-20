package co.edu.uniquindio.unitravel;

import co.edu.uniquindio.unitravel.entidades.Cliente;
import co.edu.uniquindio.unitravel.repositorios.ClienteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    public void registar(){
        Cliente cliente = new Cliente("12193336","carlos","carlos@gmail.com","12345");
        Cliente clienteGuardado = clienteRepo.save(cliente);

        Assertions.assertNotNull(clienteGuardado);
    }

    @Test
    public void eliminar(){
        Cliente cliente = new Cliente("12193336","carlos","carlos@gmail.com","12345");
        Cliente clienteGuardado = clienteRepo.save(cliente);

        clienteRepo.delete(clienteGuardado);

        Cliente clienteBuscado = clienteRepo.findById("12193336").orElse(null);
        Assertions.assertNull(clienteBuscado);
    }

    @Test
    public void actualizar(){
        Cliente cliente = new Cliente("12193336","carlos","carlos@gmail.com","12345");

        Cliente clienteGuardado = clienteRepo.save(cliente);
        clienteGuardado.setPassword("carlos123");

        clienteRepo.save(clienteGuardado);

        Cliente clienteBuscado = clienteRepo.findById("12193336").orElse(null);
        Assertions.assertEquals("carlos123",clienteBuscado.getPassword());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Cliente> clientes = clienteRepo.findAll();
        System.out.println(clientes);
    }
}
