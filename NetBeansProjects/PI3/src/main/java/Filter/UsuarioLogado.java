package Filter;

import Classes.Funcionario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "UsuarioLogado", servletNames = {"ClienteAlterar", "ClienteConsultar", "ClienteExcluir", "FinalizarVenda", "FuncionarioAlterar", "FuncionarioConsultar", "FuncionarioExcluir", "ItemPedido", "MenuPrincipal", "ProdutoAlterar", "ProdutoConsultar", "ProdutoExcluir", "Vender", "formularioCliente", "formularioFuncionario", "formularioProduto"})
public class UsuarioLogado implements Filter {

    private String contextPath;

    public UsuarioLogado() {
    }

    @Override
    public void doFilter(ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        if (session.getAttribute("usuarioLogado") == null) {
            session.invalidate();
            res.sendRedirect(req.getContextPath() + "/Login");
            return;
        }

        Funcionario funcionario = (Funcionario) session.getAttribute("usuarioLogado");

        if (verificarAutorizacao(funcionario, req)) {
            // Usuario pode acessar a URL
            chain.doFilter(request, response);
        } else {
            // Usuario não tem permissao necessaria -> Mostra msg de erro.
            res.sendRedirect(req.getContextPath() + "/erro-nao-autorizado.jsp");
        }

    }

    private boolean verificarAutorizacao(
            Funcionario funcionario,
            HttpServletRequest httpRequest) {
        String urlAcessada = httpRequest.getRequestURI();
        if (urlAcessada.endsWith("/Login") || (urlAcessada.endsWith("/creditos"))) {
            return true;
        } else if ((urlAcessada.endsWith("/livraria/formularioProduto") || (urlAcessada.endsWith("/livraria/ProdutoAlterar")) || (urlAcessada.endsWith("/livraria/ProdutoConsultar")) || (urlAcessada.endsWith("/livraria/ProdutoExcluir")))
                && (funcionario.getCargo().equals("Backoffice") || funcionario.getCargo().equals("Analista"))) {
            return true;
        } else if ((urlAcessada.endsWith("/livraria/formularioFuncionario") || (urlAcessada.endsWith("/livraria/FuncionarioAlterar")) || (urlAcessada.endsWith("/livraria/FuncionarioConsultar")) || (urlAcessada.endsWith("/livraria/FuncionarioExcluir")))
                && funcionario.getCargo().equals("Analista")) {
            return true;
        } else if ((urlAcessada.endsWith("/livraria/cliente") || (urlAcessada.endsWith("/livraria/ClienteAlterar")) || (urlAcessada.endsWith("/livraria/ConsultaCliente")) || (urlAcessada.endsWith("/livraria/ClienteExcluir")))
                && (funcionario.getCargo().equals("Backoffice") || funcionario.getCargo().equals("Analista"))) {
            return true;
        } else if (urlAcessada.endsWith("/livraria/Vender") && (funcionario.getCargo().equals("Vendedor") || funcionario.getCargo().equals("Analista"))) {
            return true;
        } else if (urlAcessada.endsWith("/menu-principal")) {
            return true;
        }
        return false;
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

}
