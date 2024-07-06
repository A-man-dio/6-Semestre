using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace KSL_API.Models;

[Table("ItensMarcacoes")]
public class ItenMarcacao
{
    [Key]
    [DatabaseGenerated(DatabaseGeneratedOption.Identity)] //AUTOINCREMENT
    public int IdIten { get; set; }
    
    [ForeignKey("Profissional")]
    public int IdProfissional{ get; set; }
    
    [ForeignKey("Servico")]
    public int IdServico{ get; set; }

}