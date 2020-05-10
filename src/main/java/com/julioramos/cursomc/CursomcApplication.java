package com.julioramos.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.julioramos.cursomc.domain.Categoria;
import com.julioramos.cursomc.domain.Cidade;
import com.julioramos.cursomc.domain.Cliente;
import com.julioramos.cursomc.domain.Contato;
import com.julioramos.cursomc.domain.Endereco;
import com.julioramos.cursomc.domain.Estado;
import com.julioramos.cursomc.domain.ItemPedido;
import com.julioramos.cursomc.domain.Pagamento;
import com.julioramos.cursomc.domain.PagamentoBoleto;
import com.julioramos.cursomc.domain.PagamentoCartao;
import com.julioramos.cursomc.domain.Pedido;
import com.julioramos.cursomc.domain.Produto;
import com.julioramos.cursomc.enums.EstadoPagamento;
import com.julioramos.cursomc.enums.TipoCliente;
import com.julioramos.cursomc.enums.TipoContato;
import com.julioramos.cursomc.repositories.CategoriaRepository;
import com.julioramos.cursomc.repositories.CidadeRepository;
import com.julioramos.cursomc.repositories.ClienteRepository;
import com.julioramos.cursomc.repositories.ContatoRepository;
import com.julioramos.cursomc.repositories.EnderecoRepository;
import com.julioramos.cursomc.repositories.EstadoRepository;
import com.julioramos.cursomc.repositories.ItemPedidoRepository;
import com.julioramos.cursomc.repositories.PagamentoRepository;
import com.julioramos.cursomc.repositories.PedidoRepository;
import com.julioramos.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ContatoRepository contatoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run(String... args) throws Exception {
		Categoria c1 = new Categoria(null, "Informática");
		Categoria c2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		c1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		c2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(c1));
		p2.getCategorias().addAll(Arrays.asList(c1, c2));
		p3.getCategorias().addAll(Arrays.asList(c1));

		categoriaRepository.saveAll(Arrays.asList(c1, c2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado e1 = new Estado(null, "Minas Gerais");
		Estado e2 = new Estado(null, "São Paulo");

		Cidade cid1 = new Cidade(null, "Uberlândia", e1);
		Cidade cid2 = new Cidade(null, "São Paulo", e2);
		Cidade cid3 = new Cidade(null, "Campinas", e2);

		e1.getCidades().addAll(Arrays.asList(cid1));
		e1.getCidades().addAll(Arrays.asList(cid2, cid3));

		estadoRepository.saveAll(Arrays.asList(e1, e2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

		Cliente cliente = new Cliente(null, "James", "james@gmail.com", "47895465498", TipoCliente.PESSOA_FISICA);
		Contato contato = new Contato(null, "99999-9999", TipoContato.TIPO_CELULAR, cliente);
		Contato contato1 = new Contato(null, "teste@teste.com", TipoContato.TIPO_EMAIL, cliente);

		cliente.getContatos().addAll(Arrays.asList(contato, contato1));

		Endereco end = new Endereco(null, "Rua Flores", "300", "Apto. 303", "Jardim", "384861", cliente, cid1);
		Endereco end1 = new Endereco(null, "Av. Matos", "175", "Teste", "Oito de Abril", "318646", cliente, cid2);

		cliente.getEnderecos().addAll(Arrays.asList(end, end1));

		clienteRepository.saveAll(Arrays.asList(cliente));
		enderecoRepository.saveAll(Arrays.asList(end, end1));
		contatoRepository.saveAll(Arrays.asList(contato, contato1));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cliente, end);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:32"), cliente, end1);

		Pagamento pgto1 = new PagamentoCartao(null, EstadoPagamento.STATUS_QUITADO, ped1, 6);
		ped1.setPagamento(pgto1);
		Pagamento pgto2 = new PagamentoBoleto(null, EstadoPagamento.STATUS_PENDENTE, ped2,
				sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pgto2);

		cliente.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pgto1, pgto2));

		ItemPedido ip = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItens().addAll(Arrays.asList(ip));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip, ip2, ip3));
	}
}
