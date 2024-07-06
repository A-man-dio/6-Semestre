using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace KSL_API.Models
{
    [Table("Profissionais")]
    public class Profissional
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int IdProfissional { get; set; }

        [Required] 
        [MaxLength(100)] 
        public string Nome { get; set; }

        [Required] 
        [ForeignKey("Servico")] 
        public int IdServico { get; set; }

        [Required] 
        [EmailAddress] 
        public string Email { get; set; }

        public string Foto { get; set; } // Caminho para a foto

        [Required] 
        [MaxLength(20)] 
        public string BI { get; set; }

        [Required] 
        [Phone] 
        public string Telemovel { get; set; }
        
        [Required]
        public List<Horario> Horarios { get; set; } //lista com id dos horarios do profissional
    }
}