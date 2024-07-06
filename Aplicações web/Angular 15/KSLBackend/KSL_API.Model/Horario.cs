using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace KSL_API.Models;

[Table("Horarios")]
public class Horario
{
    [Key]
    [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
    public int IdHorario { get; set; }
    
    [Required]
    public TimeSpan Hora { get; set; }
    //tabela fixa com horarios de 9h até 19:30, cada id do horario varia 30 min a mais  
    
}