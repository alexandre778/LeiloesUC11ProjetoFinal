import java.sql.*;
import java.util.ArrayList;

public class ProdutosVendasDAO {

    private Connection connection;

    public ProdutosVendasDAO() throws SQLException {
        this.connection = DBConnection.getConnection(); // A conexão com o banco de dados
    }

    public ArrayList<ProdutosDTO> listarProdutosVendidos() {
        ArrayList<ProdutosDTO> produtosVendidos = new ArrayList<>();
        
        // Consulta SQL para listar produtos vendidos
        String query = "SELECT p.id, p.nome, p.valor, v.status FROM produtos p " +
                       "INNER JOIN vendas v ON p.id = v.produto_id"; // Aqui assumimos que a tabela "vendas" tem um campo "status"
        
        try (PreparedStatement pst = connection.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {
            
            while (rs.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getInt("valor")); // Agora, "valor" é um Integer
                produto.setStatus(rs.getString("status")); // Agora, o status vem diretamente do banco
                
                produtosVendidos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return produtosVendidos;
    }
}
