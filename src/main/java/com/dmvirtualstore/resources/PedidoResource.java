package com.dmvirtualstore.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dmvirtualstore.domain.APIResponse;
import com.dmvirtualstore.domain.Cliente;
import com.dmvirtualstore.domain.NotificacaoMercadoPago;
import com.dmvirtualstore.domain.Pedido;
import com.dmvirtualstore.dto.PedidoDTO;
import com.dmvirtualstore.security.UserSS;
import com.dmvirtualstore.services.ClienteService;
import com.dmvirtualstore.services.PedidoService;
import com.dmvirtualstore.services.UserService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService service;
	
	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<APIResponse> find(@PathVariable Integer id) {

		Pedido obj = service.find(id);
		
		APIResponse result = new APIResponse(obj);

		return ResponseEntity.ok().body(result);
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<PedidoDTO> insert(@Valid @RequestBody Pedido obj) {
		System.out.println("<< 0>> ");
		Pedido p = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		PedidoDTO pedidoDto = new PedidoDTO(p);
		
		//return ResponseEntity.created(uri).build();
		return ResponseEntity.ok().body(pedidoDto);

	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PedidoDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="instante") String orderBy, 
			@RequestParam(value="direction", defaultValue="DESC") String direction) {
		
		Page<Pedido> listPedidos = service.findPage(page, linesPerPage, orderBy, direction);
		ArrayList<PedidoDTO> list = new ArrayList<>();
		
		 for(Pedido pedido : listPedidos){
	            list.add(new PedidoDTO(pedido));
	        }
		
				
		//APIResponse result = new APIResponse(list);
		
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> estorno(@PathVariable Integer id) {
	
		//Valida se o cliente autenticado é o mesmo do pedido
		UserSS user = UserService.authenticated();
		Cliente cliente = clienteService.findByEmail(user.getUsername());
		
		if(service.estornarPagamento(id,cliente)) {
			
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.badRequest().build();	
		}
		
		
	}
	
	
	@RequestMapping(value = "/notification", method=RequestMethod.POST)
	public void notificacaoPagamentoPix(@RequestBody NotificacaoMercadoPago obj) {

		service.pixNotificacao(obj);
		
		
	}

}
