package com.dmvirtualstore.domain.enuns;

public enum FormaPagamento {

	PIX(0,"Pix"),
	CARTAO(1,"Cartao");
	

	private int cod; 
	private String descricao; 

	private FormaPagamento(int cod, String descricao) { 
		 this.cod = cod; 
		 this.descricao = descricao; 
	 } 

	public int getCod() { 
	 return cod; 
	} 

	public String getDescricao() { 
	 return descricao; 
	 	} 

	public static FormaPagamento toEnum(Integer id) { 

		 if (id == null) { 
		 return null; 
		 	} 

		 for (FormaPagamento x : FormaPagamento.values()) { 
			 if (id.equals(x.getCod())) { 
			 return x; 
			 } 
		 } 
		 throw new IllegalArgumentException("Id inválido " + id); 
	 }

}