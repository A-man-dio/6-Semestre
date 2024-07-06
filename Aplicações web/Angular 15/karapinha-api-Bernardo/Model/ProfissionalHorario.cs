using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Model
{
    [Table("ProfissionalHorario")]
    public class ProfissionalHorario
    {
        [Key] 
        public int IdProfissionalHorario { get; set; }
        [ForeignKey("IdProfissional")]
        public int IdProfissional { get; set; }
        public Profissional? Profissional { get; set; }
        public string Horario { get; set; } = string.Empty;
    }
}

