package testes;

import java.util.Date;

import modelo.Endereco;
import modelo.PessoaJuridica;

public class TestaPessoaJuridica {
	
	public static void main(String[] args) {
		
		PessoaJuridica pj = new PessoaJuridica();
		
		Endereco e = new Endereco();
		
		e.setBairro("centro");
		e.setCep(990909877);
		e.setCidade("Pomerode");
		e.setComplemento("posto de saude");
		e.setNumero(987);
		e.setRua("Hozorio Pessoa");
		e.setUf("SC");
		
		pj.setCnpj("889898989");
		pj.setDataCadastro(new Date());
		pj.setEmail("empresa@email.com");
		pj.setEndereco(e);
		pj.setRazaoSocial("Razao social 123");
		pj.setResponsavel("Leandro");
		pj.setSenha("123");
		pj.setTelefone("3344556643");		
		
		System.out.println(pj.toJson());
		
	}

}
