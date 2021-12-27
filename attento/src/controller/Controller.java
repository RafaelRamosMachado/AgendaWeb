package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.swing.text.Document;

//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import model.JavaBeans;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete", "/report" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/** The dao. */
	DAO dao = new DAO();
	
	/** The contato. */
	JavaBeans contato = new JavaBeans();

	/**
	 * Instantiates a new controller.
	 */
    public Controller() {
        super();

    }
    /**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/insert")) {
			adicionarContato(request, response);
		} else if (action.equals("/select")) {
			listarContato(request, response);
		} else if (action.equals("/update")) {
			editarContato(request, response);
		} else if (action.equals("/delete")) {
			removerContato(request, response);
//		} else if (action.equals("/report")) {
//			gerarRelatorio(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}
	// Listar Agendamento
	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que irá receber os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarContatos();
		// Encaminhar a lista ao documento agenda.jsp
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
//		// Teste de recebimento da lista
//		for (int i = 0; i < lista.size(); i++) {
//			System.out.println(lista.get(i).getId_atendimento());
//			System.out.println(lista.get(i).getNome_cliente());
//			System.out.println(lista.get(i).getTelefone_cliente());
//			System.out.println(lista.get(i).getfisio());
//			System.out.println(lista.get(i).getLocal_hospital());
//			System.out.println(lista.get(i).getNome_cirurgiao());
//			System.out.println(lista.get(i).getProcedimento_cirurgia());
//			System.out.println(lista.get(i).getCor_tape());
//			System.out.println(lista.get(i).getData_avaliacao());
//			System.out.println(lista.get(i).getData_cirurgia());
//			System.out.println(lista.get(i).getHorario_cirurgia()); 
//		}
	}

	// Novo Agendamento
	protected void adicionarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// setar as variaveis JavaBeans
		contato.setNome_cliente(request.getParameter("nome"));
		contato.setTelefone_cliente(request.getParameter("fone"));
		contato.setfisio(request.getParameter("fisio"));
		contato.setLocal_hospital(request.getParameter("hospital"));
		contato.setNome_cirurgiao(request.getParameter("cirurgiao"));
		contato.setProcedimento_cirurgia(request.getParameter("procedimento"));
		contato.setCor_tape(request.getParameter("cor_tape"));
		contato.setData_avaliacao(Date.valueOf(request.getParameter("data_avaliacao")));
		contato.setData_cirurgia(Date.valueOf(request.getParameter("data_cirurgia")));
		contato.setHorario_cirurgia(request.getParameter("horario"));

		// invocar o método inserirContato passando o objeto contato
		dao.inserirContato(contato);
		// redirecionar para o documento agenda.jsp
		response.sendRedirect("main");
	}

	// Editar Contato
	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebimento do ID do contato que será editado
		//String id_atendimento = request.getParameter("id_atendimento");
		// Setar a variavel JavaBeans
		contato.setId_atendimento(request.getParameter("id_atendimento"));
		// Executar o método selecionarContato (DAO)
		dao.selecionarContato(contato);
		// Setar os atributos do formulário com o conteúdo JavaBeans
		request.setAttribute("id_atendimento", contato.getId_atendimento());
		request.setAttribute("nome_cliente", contato.getNome_cliente());
		request.setAttribute("telefone_cliente", contato.getTelefone_cliente());
		request.setAttribute("fisio", contato.getfisio());
		request.setAttribute("local_hospital", contato.getLocal_hospital());
		request.setAttribute("nome_cirurgiao", contato.getNome_cirurgiao());
		request.setAttribute("procedimento", contato.getProcedimento_cirurgia());
		request.setAttribute("cor_tape", contato.getCor_tape());
		request.setAttribute("data_avaliacao", contato.getData_avaliacao());
		request.setAttribute("data_cirurgia", contato.getData_cirurgia());
		request.setAttribute("horario_cirurgia", contato.getHorario_cirurgia());
		// Encaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
		// Teste de recebimento
//		System.out.println(contato.getId_atendimento());
//		System.out.println(contato.getNome_cliente());
//		System.out.println(contato.getTelefone_cliente());
//		System.out.println(contato.getfisio());
//		System.out.println(contato.getLocal_hospital());
//		System.out.println(contato.getNome_cirurgiao());
//		System.out.println(contato.getProcedimento_cirurgia());
//		System.out.println(contato.getCor_tape());
//		System.out.println(contato.getData_avaliacao());
//		System.out.println(contato.getData_cirurgia());
//		System.out.println(contato.getHorario_cirurgia()); 
	}

	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Setar as variaveis JavaBeans
		contato.setId_atendimento(request.getParameter("id_atendimento"));
		contato.setNome_cliente(request.getParameter("nome_cliente"));
		contato.setTelefone_cliente(request.getParameter("telefone_cliente"));
		contato.setfisio(request.getParameter("fisio"));
		contato.setLocal_hospital(request.getParameter("local_hospital"));
		contato.setNome_cirurgiao(request.getParameter("nome_cirurgiao"));
		contato.setProcedimento_cirurgia(request.getParameter("procedimento_cirurgia"));
		contato.setCor_tape(request.getParameter("cor_tape"));
		contato.setData_avaliacao(Date.valueOf(request.getParameter("data_avaliacao")));
		contato.setData_cirurgia(Date.valueOf(request.getParameter("data_cirurgia")));
		contato.setHorario_cirurgia(request.getParameter("horario_cirurgia"));
		// Executar o metodo alterarContato
		dao.alterarContato(contato);
		// Redirecionar para o documento agenda.jsp (atualizando as alterações)
		response.sendRedirect("main");
		// Teste de recebimento
//		try {
//			System.out.println("Erro");
//			System.out.println(request.getParameter("id"));
//			System.out.println(request.getParameter("nome"));
//			System.out.println(request.getParameter("fone"));
//			System.out.println(request.getParameter("fisio"));
//			System.out.println(request.getParameter("hospital"));
//			System.out.println(request.getParameter("nome_cirurgiao"));
//			System.out.println(request.getParameter("procedimento"));
//			System.out.println(request.getParameter("cor_tape"));
//			System.out.println(request.getParameter("data_avaliacao"));
//			System.out.println(request.getParameter("data_cirurgia"));
//			System.out.println(request.getParameter("horario_cirurgia"));
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		System.out.println("Erro");
//		System.out.println(request.getParameter("id"));
//		System.out.println(request.getParameter("nome"));
//		System.out.println(request.getParameter("fone"));
//		System.out.println(request.getParameter("fisio"));
//		System.out.println(request.getParameter("hospital"));
//		System.out.println(request.getParameter("nome_cirurgiao"));
//		System.out.println(request.getParameter("procedimento"));
//		System.out.println(request.getParameter("cor_tape"));
//		System.out.println(request.getParameter("data_avaliacao"));
//		System.out.println(request.getParameter("data_cirurgia"));
//		System.out.println(request.getParameter("horario_cirurgia"));
	}

	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setId_atendimento(request.getParameter("id_atendimento"));
		dao.deletarContato(contato);
		response.sendRedirect("main");
	}
	
//	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		Document documento = new Docum();
//		try {
//			response.setContentType("apllication/pdf");
//			response.addHeader("Content-Disposition", "inline; filename=" + "contatos.pdf");
//			PdfWriter.getInstance(documento, response.getOutputStream());
//			documento.open();
//			documento.add(new Paragraph("Lista de contatos:"));
//			documento.add(new Paragraph(" "));
//			PdfPTable tabela = new PdfPTable(3);
//			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
//			PdfPCell col2 = new PdfPCell(new Paragraph("Fone"));
//			PdfPCell col3 = new PdfPCell(new Paragraph("E-mail"));
//			tabela.addCell(col1);
//			tabela.addCell(col2);
//			tabela.addCell(col3);
//			ArrayList<JavaBeans> lista = dao.listarContatos();
//			for (int i = 0; i < lista.size(); i++) {
//				tabela.addCell(lista.get(i).getNome());
//				tabela.addCell(lista.get(i).getFone());
//				tabela.addCell(lista.get(i).getEmail());
//			}
//			documento.add(tabela);
//			documento.close();
//		} catch (Exception e) {
//			System.out.println(e);
//			documento.close();
//		}
//	}
	
}
