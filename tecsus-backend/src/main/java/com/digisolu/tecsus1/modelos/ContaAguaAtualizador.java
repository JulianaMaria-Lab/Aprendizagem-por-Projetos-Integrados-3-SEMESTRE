package com.digisolu.tecsus1.modelos;

import com.digisolu.tecsus1.entidades.ContaAgua;

public class ContaAguaAtualizador {
	
	private void atualizarDados(ContaAgua contaAgua, ContaAgua atualizacao) {
		
		if(!(atualizacao.getN_documento()==null)) {
			contaAgua.setN_documento(atualizacao.getN_documento());
		}
		if(!(atualizacao.getData_emissao()==null)) {
			contaAgua.setData_emissao(atualizacao.getData_emissao());
		}
		if(!(atualizacao.getData_apresentacao()==null)) {
			contaAgua.setData_apresentacao(atualizacao.getData_apresentacao());
		}
		if(!(atualizacao.getProxima_leitura()==null)) {
			contaAgua.setProxima_leitura(atualizacao.getProxima_leitura());
		}
		if(!(atualizacao.getCondicao_leitura()==null)) {
			contaAgua.setCondicao_leitura(atualizacao.getCondicao_leitura());
		}
		if(!(atualizacao.getConsumo_m3()==0)) {
			contaAgua.setConsumo_m3(atualizacao.getConsumo_m3());
		}
		if(!(atualizacao.getPeriodo()==0)) {
			contaAgua.setPeriodo(atualizacao.getPeriodo());
		}
		if(!(atualizacao.getMedia_consumo()==0)) {
			contaAgua.setMedia_consumo(atualizacao.getMedia_consumo());
		}
		if(!(atualizacao.getTotal_agua()==0)) {
			contaAgua.setTotal_agua(atualizacao.getTotal_agua());
		}
		if(!(atualizacao.getTotal_esgoto()==0)) {
			contaAgua.setTotal_esgoto(atualizacao.getTotal_esgoto());
		}
		if(!(atualizacao.getValor_total()==0)) {
			contaAgua.setValor_total(atualizacao.getValor_total());
		}
		if(!(atualizacao.getMulta()==0)) {
			contaAgua.setMulta(atualizacao.getMulta());
		}
		if(!(atualizacao.getAt_monet()==0)) {
			contaAgua.setAt_monet(atualizacao.getAt_monet());
		}
		if(!(atualizacao.getJuros_mora()==0)) {
			contaAgua.setJuros_mora(atualizacao.getJuros_mora());
		}
		if(!(atualizacao.getTaxa_regulacao()==0)) {
			contaAgua.setTaxa_regulacao(atualizacao.getTaxa_regulacao());
		}
		if(!(atualizacao.getData_vencimento()==null)) {
			contaAgua.setData_vencimento(atualizacao.getData_vencimento());
		}
		if(!(atualizacao.getCnpj()==null)) {
			contaAgua.setCnpj(atualizacao.getCnpj());
		}
		if(!(atualizacao.getConcessionaria()==null)) {
			contaAgua.setConcessionaria(atualizacao.getConcessionaria());
		}
		if(!(atualizacao.getN_fornecimento()==null)) {
			contaAgua.setN_fornecimento(atualizacao.getN_fornecimento());
		}
		if(!(atualizacao.getSegmento()==null)) {
			contaAgua.setSegmento(atualizacao.getSegmento());
		}
		if(!(atualizacao.getCnpj_cpf_unidade()==null)) {
			contaAgua.setCnpj_cpf_unidade(atualizacao.getCnpj_cpf_unidade());
		}
		if(!(atualizacao.getNome_unidade()==null)) {
			contaAgua.setNome_unidade(atualizacao.getNome_unidade());
		}
		if(!(atualizacao.getCep()==null)) {
			contaAgua.setCep(atualizacao.getCep());
		}
		if(!(atualizacao.getCodigo_cliente()==null)) {
			contaAgua.setCodigo_cliente(atualizacao.getCodigo_cliente());
		}
		if(!(atualizacao.getPde_rgi()==null)) {
			contaAgua.setPde_rgi(atualizacao.getPde_rgi());
		}

		if(!(atualizacao.getHidrometro()==null)) {
			contaAgua.setHidrometro(atualizacao.getHidrometro());
		}

		if(!(atualizacao.getEconomia()==null)) {
			contaAgua.setEconomia(atualizacao.getEconomia());
		}

		if(!(atualizacao.getTipo_ligacao()==null)) {
			contaAgua.setTipo_ligacao(atualizacao.getTipo_ligacao());
		}
 	}
	public void atualizar(ContaAgua contaAgua, ContaAgua atualizacao) {
		atualizarDados(contaAgua,atualizacao);
	}

}
