using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Model
{
    [Table("Agendamento")]
    public class Agendamento
    {
        [Key]
        public int IdAgendamento { get; set; }
        [ForeignKey("IdProfissional")]
        public int IdProfissional { get; set; }
        [ForeignKey("IdServico")]
        public int IdServico { get; set; }
        public TimeOnly Hora { get; set; }
        public DateOnly Data { get; set; }
    }
}
