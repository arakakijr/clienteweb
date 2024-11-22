

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<Cliente> listaClientes = new ArrayList<Cliente>();
       
    
    public FirstServlet() {
        System.out.println("Contruindo Servlet...");
    }
    
    @Override
    public void init() throws ServletException {
    	System.out.println("Inicializando Servlet...");
    	super.init();
    }
    
    @Override
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
    	System.out.println("Chamando o service...");
    	super.service(arg0, arg1);
    }
    
    @Override
    public void destroy() {
    	System.out.println("Servlet sendo destruido...");
    	super.destroy();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	RequestDispatcher dispatcher = request.getRequestDispatcher("cliente.jsp");
    	
    	String texto = "teste2";
  
    	request.setAttribute("lista", listaClientes);
    	request.setAttribute("texto", texto);
    	
    	dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		Cliente cliente = new Cliente();
		cliente.setEmail(email);
		
		listaClientes.add(cliente);
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print("Chamou pelo método POST enviando e-mail: " + email);
		System.out.println("Chamou pelo método POST enviando e-mail: " + email);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("Chamou pelo método DELETE");;
		System.out.println("Chamou pelo método DELETE");
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("Chamou pelo método PUT");;
		System.out.println("Chamou pelo método P");
	}

}
