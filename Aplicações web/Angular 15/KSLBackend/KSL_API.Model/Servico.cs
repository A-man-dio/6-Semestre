using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace KSL_API.Models;
[Table("Servicos")]
public class Servico
{   
    [Key]
    [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
    public int IdServico { get; set; }

    [Required]
    public string Nome { get; set; }
    
    [Required]
    [ForeignKey("Categoria")]
    public int IdCategoria{ get; set; }

    [Required]
    public string Descricao { get; set; } = string.Empty;

    [Required]
    [Column(TypeName = "decimal(8,2)")]
    public decimal Preco { get; set; }
    
}