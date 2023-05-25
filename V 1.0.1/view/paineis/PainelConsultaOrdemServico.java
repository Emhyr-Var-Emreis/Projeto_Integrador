	package view.paineis;

	import java.awt.BorderLayout;
	import java.awt.Color;

	import javax.swing.JFrame;
	import javax.swing.JPanel;

	import view.estilos.BotaoEditar;
	import view.estilos.BotaoLimpar;
	import view.estilos.BotaoPesquisar;
	import view.estilos.BotaoSalvar;
	import view.estilos.CamposTexto;
	import view.estilos.LabelsTexto;
	import view.estilos.Titulo;


	public class PainelConsultaOrdemServico extends JPanel {
		public PainelConsultaOrdemServico() {
			setSize(1040,768);
			setBackground(new Color(109, 110, 114));
			setLayout(null);
			
	      //Criando texto na tela 
			
	       Titulo lblCadastroServico = new Titulo(81,32,878,60,"Consulta de Ordens de Serviço");
	       LabelsTexto lblCodOs = new LabelsTexto(141,125,85,29,"Cod OS");
	       LabelsTexto lblStatus = new LabelsTexto(143,177,85,29,"Status");
	       LabelsTexto lblVeiculo = new LabelsTexto(139,231,85,29,"Veiculo");
	       LabelsTexto lblDataExecucao = new LabelsTexto(480,124,203,29,"Data de Execução");
	       LabelsTexto lblDataCriacao = new LabelsTexto(509,232,203,29, "Data de Criação");
	       LabelsTexto lblFuncionario = new LabelsTexto(546,181,134,29,"Funcionario");
	       LabelsTexto lblServico = new LabelsTexto(21,319,92,29,"Serviços");
	       LabelsTexto lblProdutos = new LabelsTexto(11,500,102,29,"Produtos");
	       LabelsTexto lblValorServico = new LabelsTexto(78, 635, 149, 29, "Valor Serviços");
	       LabelsTexto lblValorProduto = new LabelsTexto(377,635,169,29,"Valor Produtos");
	       LabelsTexto lblValorTotal = new LabelsTexto(676,635,120,29,"Valor Total");
	       


	        
	     //Criando inputs texto na tela
	       CamposTexto txtCodOs = new CamposTexto(260,125,81,29);
	       CamposTexto txtStatus = new CamposTexto(260,177,195,29);
	       CamposTexto txtVeiculo = new CamposTexto(260,231,195,29);
	       CamposTexto txtDataExecucao = new CamposTexto(715,127,195,29);
	       CamposTexto txtFuncionario = new CamposTexto(715,180,195,29);
	       CamposTexto txtDataCriacao = new CamposTexto(715,234,195,29);
	       CamposTexto txtValorServico = new CamposTexto(260,635,82,29);
	       CamposTexto txtValorProduto = new CamposTexto(556,635,82,29);
	       CamposTexto txtValorTotal = new CamposTexto(828,635,82,29);

	       
	       //Criando botoes da tela
	       BotaoSalvar btnSalvar = new BotaoSalvar("Salvar");
	       BotaoEditar btnEditar = new BotaoEditar("Editar");
	       BotaoPesquisar btnPesquisar = new BotaoPesquisar("Pesquisar");
	       
	        //Adicionando elementos a tela
	       	add(lblCodOs);
	        add(lblCadastroServico);
	        add(lblStatus);
	        add(lblVeiculo);
	        add(lblDataExecucao);
	        add(lblFuncionario);
	        add(lblDataCriacao);
	        add(lblServico);
	        add(lblProdutos);
	        add(lblValorServico);
	        add(lblValorProduto);
	        add(lblValorTotal);
	        add(lblFuncionario);
	        add(txtCodOs);
	        add(txtStatus);
	        add(txtVeiculo);
	        add(txtDataExecucao);
	        add(txtFuncionario);
	        add(txtDataCriacao);
	        add(txtValorServico);
	        add(txtValorProduto);
	        add(txtValorTotal);
	        add(btnSalvar);
	        add(btnEditar);
	        add(btnPesquisar);
	}}


