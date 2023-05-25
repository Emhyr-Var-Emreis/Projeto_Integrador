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


	public class PainelCadastrarOrdemServico extends JPanel {
		public PainelCadastrarOrdemServico() {
			setSize(1040,768);
			setBackground(new Color(109, 110, 114));
			setLayout(null);
			
	      //Criando texto na tela 
			
	       Titulo lblCadastroServico = new Titulo(81,32,878,60,"Cadastro de Ordens de Serviço");
	       LabelsTexto lblStatus = new LabelsTexto(155,127,85,29,"Status");
	       LabelsTexto lblVeiculo = new LabelsTexto(139,180,85,29,"Veiculo");
	       LabelsTexto lblDataExecucao = new LabelsTexto(480,124,203,29,"Data de Execução");
	       LabelsTexto lblFuncionario = new LabelsTexto(546,181,134,29,"Funcionario");
	       LabelsTexto lblServico = new LabelsTexto(21,319,92,29,"Serviços");
	       LabelsTexto lblProdutos = new LabelsTexto(11,500,102,29,"Produtos");
	       LabelsTexto lblValorServico = new LabelsTexto(78, 635, 149, 29, "Valor Serviços");
	       LabelsTexto lblValorProduto = new LabelsTexto(377,635,169,29,"Valor Produtos");
	       LabelsTexto lblValorTotal = new LabelsTexto(676,635,120,29,"Valor Total");
	       


	        
	     //Criando inputs texto na tela
	       CamposTexto txtStatus = new CamposTexto(260,127,195,29);
	       CamposTexto txtVeiculo = new CamposTexto(260,180,195,29);
	       CamposTexto txtDataExecucao = new CamposTexto(715,127,195,29);
	       CamposTexto txtFuncionario = new CamposTexto(715,180,195,29);
	       CamposTexto txtValorServico = new CamposTexto(260,635,82,29);
	       CamposTexto txtValorProduto = new CamposTexto(556,635,82,29);
	       CamposTexto txtValorTotal = new CamposTexto(828,635,82,29);

	       
	       //Criando botoes da tela
	       BotaoSalvar btnSalvar = new BotaoSalvar("Salvar");
	       BotaoLimpar btnLimpar = new BotaoLimpar("Limpar");
	       
	        //Adicionando elementos a tela
	        add(lblCadastroServico);
	        add(lblStatus);
	        add(lblVeiculo);
	        add(lblDataExecucao);
	        add(lblFuncionario);
	        add(lblServico);
	        add(lblProdutos);
	        add(lblValorServico);
	        add(lblValorProduto);
	        add(lblValorTotal);
	        add(lblFuncionario);
	        add(txtStatus);
	        add(txtVeiculo);
	        add(txtDataExecucao);
	        add(txtFuncionario);
	        add(txtValorServico);
	        add(txtValorProduto);
	        add(txtValorTotal);
	        add(btnSalvar);
	        add(btnLimpar);
	}}

