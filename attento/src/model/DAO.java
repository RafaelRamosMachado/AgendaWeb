package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	
	/**  Módulo de conexão *. */
	// Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda_atento?useTimezone=true&serverTimezone=UTC";
	
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "";
	
	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	// Método de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 *  CRUD CREATE *.
	 *
	 * @param contato the contato
	 */
	public void inserirContato(JavaBeans contato) {
		String create = "insert into atendimentos(nome_cliente,telefone_cliente,fisio,local_hospital,\r\n"
				+ "nome_cirurgiao,procedimento_cirurgia,cor_tape,data_avaliacao,data_cirurgia,horario_cirurgia) values(?,?,?,?,?,?,?,?,?,?)";
		try {
			//SimpleDateFormat formatador = new SimpleDateFormat(“dd-MM-yyyy”);
			// Abrir a conexao
			Connection con = conectar();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parametros (?) pelo conteúdo das variaveis JavaBeans
			
			pst.setString(1, contato.getNome_cliente());
			pst.setString(2, contato.getTelefone_cliente());
			pst.setString(3, contato.getfisio());
			pst.setString(4, contato.getLocal_hospital());
			pst.setString(5, contato.getNome_cirurgiao());
			pst.setString(6, contato.getProcedimento_cirurgia());
			pst.setString(7, contato.getCor_tape());
			pst.setDate(8, contato.getData_avaliacao());
			pst.setDate(9, contato.getData_cirurgia());
			pst.setString(10, contato.getHorario_cirurgia());
			// Executar a query
			pst.executeUpdate();
			// Encerrar a conexão com banco de dados
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/** CRUD READ **/
	public ArrayList<JavaBeans> listarContatos() {
		// Criando um objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String read = "select * from atendimentos";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// O laço abaixo será executado enquanto houver contatos
			while (rs.next()) {
				//Variáveis de apoio que recebem os dados do banco
				String id_atendimento = rs.getString(1);
				String nome_cliente = rs.getString(2);
				String telefone_cliente = rs.getString(3);
				String fisio = rs.getString(4);
				String local_hospital = rs.getString(5);
				String nome_cirurgiao = rs.getString(6);
				String procedimento_cirurgia = rs.getString(7);
				String cor_tape = rs.getString(8);
				java.sql.Date data_avaliacao = rs.getDate(9);
				java.sql.Date data_cirurgia = rs.getDate(10);
				String horario_cirurgia = rs.getString(11);	
				// Populando o ArrayList
				contatos.add(new JavaBeans(id_atendimento,nome_cliente,telefone_cliente,fisio,local_hospital,nome_cirurgiao,procedimento_cirurgia,cor_tape,data_avaliacao,data_cirurgia,horario_cirurgia));
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/** CRUD UPDATE **/
	// Selecionar o contato
	public void selecionarContato(JavaBeans contato) {
		String read2 = "select * from atendimentos where id_atendimento=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, contato.getId_atendimento());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// Setar as variaveis JavaBeans
				contato.setId_atendimento(rs.getString(1));
				contato.setNome_cliente(rs.getString(2));
				contato.setTelefone_cliente(rs.getString(3));
				contato.setfisio(rs.getString(4));
				contato.setLocal_hospital(rs.getString(5));
				contato.setNome_cirurgiao(rs.getString(6));
				contato.setProcedimento_cirurgia(rs.getString(7));
				contato.setCor_tape(rs.getString(8));
				contato.setData_avaliacao(rs.getDate(9));
				contato.setData_cirurgia(rs.getDate(10));
				contato.setHorario_cirurgia(rs.getString(11));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);;
		}
	}
	// Editar o contato
	public void alterarContato(JavaBeans contato) {
		String update = "update atendimentos set nome_cliente=?,telefone_cliente=?,fisio=?,local_hospital=?,\r\n"
				+ "nome_cirurgiao=?,procedimento_cirurgia=?,cor_tape=?,data_avaliacao=?,data_cirurgia=?,horario_cirurgia=? where id_atendimento=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, contato.getNome_cliente());
			pst.setString(2, contato.getTelefone_cliente());
			pst.setString(3, contato.getfisio());
			pst.setString(4, contato.getLocal_hospital());
			pst.setString(5, contato.getNome_cirurgiao());
			pst.setString(6, contato.getProcedimento_cirurgia());
			pst.setString(7, contato.getCor_tape());
			pst.setDate(8,contato.getData_avaliacao());
			pst.setDate(9, contato.getData_cirurgia());
			pst.setString(10, contato.getHorario_cirurgia());
			pst.setString(11, contato.getId_atendimento());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void deletarContato(JavaBeans contato) {
		String delete = "delete from atendimentos where id_atendimento=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, contato.getId_atendimento());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
