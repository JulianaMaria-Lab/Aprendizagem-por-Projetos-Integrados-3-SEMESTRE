package com.digisolu.tecsus1.controles;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.digisolu.tecsus1.adaptadores.AdaptadorArquivo;
import com.digisolu.tecsus1.adaptadores.servicos.ArmazemArquivo;
import com.digisolu.tecsus1.modelos.AdicionadorLinkAdaptadorArquivo;
import com.digisolu.tecsus1.populador.PopuladorAdaptadorArquivo;



@CrossOrigin
@RestController
public class ArquivoControle {
	@Autowired
	private AdicionadorLinkAdaptadorArquivo adicionadorLink;
	@Autowired
	private ArmazemArquivo armazem;

	@PostMapping("/arquivo/enviar")
	public ResponseEntity<String> receberArquivo(@RequestParam("file") MultipartFile arquivoEnviado)
			throws IOException {
		AdaptadorArquivo adaptadorArquivo = new AdaptadorArquivo();
		adaptadorArquivo.setBytes(arquivoEnviado.getBytes());
		adaptadorArquivo.setNome(arquivoEnviado.getOriginalFilename());
		Long tamanho = arquivoEnviado.getSize();
		adaptadorArquivo.setTamanho(tamanho.toString());
		adaptadorArquivo.setTipo(arquivoEnviado.getContentType());
		armazem.armazenarAdaptadorArquivo(adaptadorArquivo);
		return new ResponseEntity<String>("arquivo enviado", HttpStatus.ACCEPTED);
	}

	@GetMapping("/arquivos")
	public ResponseEntity<List<AdaptadorArquivo>> obterAdaptadorArquivos() {
		List<AdaptadorArquivo> adaptadorArquivos = armazem.obterAdaptadorArquivos();
		PopuladorAdaptadorArquivo populador = new PopuladorAdaptadorArquivo(adaptadorArquivos);
		List<AdaptadorArquivo> adaptadores = populador.adaptadores();

		if (adaptadorArquivos.isEmpty()) {
			ResponseEntity<List<AdaptadorArquivo>> resposta = new ResponseEntity<>(adaptadores, HttpStatus.NOT_FOUND);
			return resposta;
		} else {
			adicionadorLink.adicionarLink(adaptadores);
			ResponseEntity<List<AdaptadorArquivo>> resposta = new ResponseEntity<>(adaptadores, HttpStatus.FOUND);
			return resposta;
		}
	}

	@GetMapping("/arquivo/{id}")
	public ResponseEntity<Resource> obterAdaptadorArquivo(@PathVariable long id) {
		Resource recurso = armazem.obterAdaptadorArquivoComoRecurso(id);
		if (recurso == null) {
			ResponseEntity<Resource> resposta = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return resposta;
		} else {
			AdaptadorArquivo adaptadorArquivo = armazem.obterAdaptadorArquivo(id);
			MediaType tipoAdaptadorArquivo = MediaType.parseMediaType(adaptadorArquivo.getTipo());
			ResponseEntity<Resource> resposta = ResponseEntity.ok().contentType(tipoAdaptadorArquivo).body(recurso);
			return resposta;
		}
	}

	@DeleteMapping("/arquivo/excluir")
	public ResponseEntity<String> excluirAdaptadorArquivo(@RequestBody AdaptadorArquivo adaptadorArquivo) {
		AdaptadorArquivo alvo = armazem.obterAdaptadorArquivo(adaptadorArquivo.getAdaptadorArquivo_id());
		if (!(alvo == null)) {
			armazem.excluirAdaptadorArquivo(alvo);
			ResponseEntity<String> resposta = new ResponseEntity<String>(HttpStatus.ACCEPTED);
			return resposta;
		} else {
			ResponseEntity<String> resposta = new ResponseEntity<String>("Arquivo não encontrado para exclusão",
					HttpStatus.BAD_REQUEST);
			return resposta;
		}

	}
}