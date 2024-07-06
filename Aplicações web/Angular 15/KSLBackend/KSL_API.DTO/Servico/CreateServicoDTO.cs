namespace KSL_API.DTO.Servico;

public class CreateServicoDTO
{   //itens a serem requisitados na criação da instancia 
    public string Nome { get; set; }
    public int IdCategoria{ get; set; }
    public string Descricao { get; set; }
    public decimal Preco { get; set; }
}