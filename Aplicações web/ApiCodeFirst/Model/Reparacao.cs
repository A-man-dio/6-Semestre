using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Model
{
    [Table("Reparacao")]
    public class Reparacao
    {
        [Key]
        public int ReparacaoId {get ; set;}
        public int ServicoId { get; set; }
        public string Descricao { get; set; }
        public decimal Preco { get; set; }
         
        
    }
}
