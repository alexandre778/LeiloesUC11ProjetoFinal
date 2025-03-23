

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class ProdutosDAO {

    private Connection conn;
    private PreparedStatement prep;
    private ResultSet resultset;
    private ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    // Método para cadastrar um novo produto no banco de dados
    public void cadastrarProduto(ProdutosDTO produto) {
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";

        try {
            conn = new DBConnection().getConnection(); // Estabelece a conexão com o banco
            prep = conn.prepareStatement(sql);

            // Preenche os parâmetros da query
            prep.setString(1, produto.getNome());
            prep.setDouble(2, produto.getValor());
            prep.setString(3, produto.getStatus());

            // Executa a atualização no banco
            int resultado = prep.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar o produto.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o produto: " + e.getMessage());
            e.printStackTrace();  // Para exibir o stack trace no console caso necessário
        } finally {
            // Fechando os recursos
            fecharRecursos();
        }
    }

    // Método para listar todos os produtos do banco de dados
    public ArrayList<ProdutosDTO> listarProdutos() {
        String sql = "SELECT * FROM produtos";
        listagem.clear(); // Limpa a lista antes de carregar os novos dados

        try {
            conn = new DBConnection().getConnection(); // Estabelece a conexão com o banco
            prep = conn.prepareStatement(sql);
            resultset = prep.executeQuery();

            // Preenche a lista de produtos a partir do banco de dados
            while (resultset.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(resultset.getInt("id"));
                produto.setNome(resultset.getString("nome"));
                produto.setValor(resultset.getInt("valor")); // Corrigido para getDouble()
                produto.setStatus(resultset.getString("status"));

                listagem.add(produto);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e.getMessage());
            e.printStackTrace();  // Para exibir o stack trace no console
        } finally {
            // Fechando os recursos
            fecharRecursos();
        }
        return listagem;
    }

    // Método para vender o produto (atualiza o status do produto)
    public void venderProduto(int produtoId) {
        String sql = "UPDATE produtos SET status = ? WHERE id = ?";

        try {
            conn = new DBConnection().getConnection(); // Estabelece a conexão com o banco
            prep = conn.prepareStatement(sql);

            // Atualiza o status para "Vendendo"
            prep.setString(1, "Vendido");
            prep.setInt(2, produtoId);

            // Executa a atualização no banco
            int resultado = prep.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Produto em processo de venda!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao vender o produto.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao vender o produto: " + e.getMessage());
            e.printStackTrace();  // Para exibir o stack trace no console caso necessário
        } finally {
            // Fechando os recursos
            fecharRecursos();
        }
    }

    // Método auxiliar para fechar os recursos de forma segura
    private void fecharRecursos() {
        try {
            if (resultset != null) resultset.close();
            if (prep != null) prep.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar os recursos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    

    

    

// Método para listar todos os produtos vendidos
public ArrayList<ProdutosDTO> listarProdutosVendidos() {
    String sql = "SELECT id, nome, valor, status FROM produtos WHERE status = 'Vendido'";  // Corrigido a consulta SQL
    ArrayList<ProdutosDTO> produtosVendidos = new ArrayList<>(); // Lista para armazenar produtos vendidos

    try {
        conn = new DBConnection().getConnection(); // Estabelece a conexão com o banco
        prep = conn.prepareStatement(sql);
        resultset = prep.executeQuery();

        // Preenche a lista de produtos vendidos a partir do banco de dados
        while (resultset.next()) {
            ProdutosDTO produto = new ProdutosDTO();
            produto.setId(resultset.getInt("id"));
            produto.setNome(resultset.getString("nome"));
            produto.setValor(resultset.getInt("valor")); // Usando getInt() para valor inteiro
            produto.setStatus(resultset.getString("status"));

            produtosVendidos.add(produto); // Adiciona o produto vendido à lista
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao listar produtos vendidos: " + e.getMessage());
        e.printStackTrace();  // Para exibir o stack trace no console
    } finally {
        // Fechando os recursos
        fecharRecursos();
    }
    return produtosVendidos;
}

}