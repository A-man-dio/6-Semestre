using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace KSL_API.Models
{
    [Table("Marcacoes")]
    public class Marcacao
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int IdMarcacao { get; set; }
        
        [ForeignKey("Utilizador")]
        public int IdUtilizador { get; set; }
        
        [ForeignKey("Categoria")]
        public int IdCategoria { get; set; }

        [Required]
        public List<ItenMarcacao> ServicosMarcados { get; set; } //lista com os idItens dos pedidos
        
        [Required]
        public DateTime Data { get; set; }

        [Required]
        public TimeSpan Hora { get; set; }

        [Required]
        public int Estado { get; set; } // Pendente: 0, Confirmado: 1
    }
}