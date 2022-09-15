package com.dmvirtualstore;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dmvirtualstore.domain.Categoria;
import com.dmvirtualstore.domain.Cidade;
import com.dmvirtualstore.domain.Cliente;
import com.dmvirtualstore.domain.Endereco;
import com.dmvirtualstore.domain.Estado;
import com.dmvirtualstore.domain.ItemPedido;
import com.dmvirtualstore.domain.Pagamento;
import com.dmvirtualstore.domain.PagamentoComBoleto;
import com.dmvirtualstore.domain.PagamentoComCartao;
import com.dmvirtualstore.domain.Pedido;
import com.dmvirtualstore.domain.Produto;
import com.dmvirtualstore.domain.enuns.EstadoPagamento;
import com.dmvirtualstore.domain.enuns.TipoCliente;
import com.dmvirtualstore.repositories.CategoriaRepository;
import com.dmvirtualstore.repositories.CidadeRepository;
import com.dmvirtualstore.repositories.ClienteRepository;
import com.dmvirtualstore.repositories.EnderecoRepository;
import com.dmvirtualstore.repositories.EstadoRepository;
import com.dmvirtualstore.repositories.ItemPedidoRepository;
import com.dmvirtualstore.repositories.PagamentoRepository;
import com.dmvirtualstore.repositories.PedidoRepository;
import com.dmvirtualstore.repositories.ProdutoRepository;

@SpringBootApplication
public class DmVirtualStoreApplication implements CommandLineRunner {

	

	
	public static void main(String[] args) {
		SpringApplication.run(DmVirtualStoreApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {

		


	}

}
