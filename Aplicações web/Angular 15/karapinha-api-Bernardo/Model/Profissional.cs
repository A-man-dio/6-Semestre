using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Model
{
    [Table("Profissional")]
    public class Profissional
    {
        [Key] 
        public int IdProfissional { get; set; }
        public string Categoria { get; set; } = string.Empty;
        public string Nome { get; set; } = string.Empty;
        public string Email { get; set; } = string.Empty;
        public string Telemovel { get; set; } = string.Empty;
        public string Bi { get; set; } = string.Empty;
        public string? Foto { get; set; } = string.Empty;
        public List<ProfissionalHorario> Horarios { get; set; } = new List<ProfissionalHorario>();
        public int Estado { get; set; } = 0;
        public DateTime CreatedOn { get; set; } = DateTime.Now;
        public DateTime UpdatedOn { get; set; } = DateTime.Now;
    }
}

