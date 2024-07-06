using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Model;

[Table("Servico")]
public class Servico
{
    [Key]
    public int  IdServico { get; set; }
    public string Categoria { get; set; } = string.Empty;
    public string Designacao { get; set; } = string.Empty;
    public string? Descricao { get; set; } = string.Empty;
    public int Estado { get; set; } = 0;
    [Column(TypeName = "decimal(18,2)")]
    public decimal Preco { get; set; }
    public DateTime CreatedOn { get; set; } = DateTime.Now;
    public DateTime UpdatedOn { get; set; } = DateTime.Now;
}
