package com.dmvirtualstore.domain.enuns;

public enum EstadoPagamento {

	PENDENTE(0,"pending_payment"),//aberto
	CANCELADO(1,"refunded"),//fechado
	QUITADO(2,"paid"),//aberto
	PREPARACAO(3,"preparing_purchase"),//aberto
	ENVIADO(4,"shipping"),//aberto
	ENTREGUE(5,"delivered");//fechado


	private int cod; 
	private String descricao; 

	private EstadoPagamento(int cod, String descricao) { 
		 this.cod = cod; 
		 this.descricao = descricao; 
	 } 

	public int getCod() { 
	 return cod; 
	} 

	public String getDescricao() { 
	 return descricao; 
	 	} 

	public static EstadoPagamento toEnum(Integer id) { 

		 if (id == null) { 
		 return null; 
		 	} 

		 for (EstadoPagamento x : EstadoPagamento.values()) { 
			 if (id.equals(x.getCod())) { 
			 return x; 
			 } 
		 } 
		 throw new IllegalArgumentException("Id inválido " + id); 
	 }

}