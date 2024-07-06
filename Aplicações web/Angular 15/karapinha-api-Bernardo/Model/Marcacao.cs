using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Model;

[Table("Marcacao")]
public class Marcacao
{
    [Key]
    public int IdMarcacao { get; set; }
    [ForeignKey("IdCliente")]
    public int IdCliente { get; set; }
    [Column(TypeName = "decimal(18,2)")]
    public decimal Preco { get; set; }
    public string Observacao { get; set; } = string.Empty;
    public int Estado { get; set; } = 0;
    public List<Agendamento> Marcacoes { get; set; } = new List<Agendamento>();
    public DateTime CreatedOn { get; set; } = DateTime.Now;
    public DateTime UpdatedOn { get; set; } = DateTime.Now;
    
}