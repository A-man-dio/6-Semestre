using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace KSL_API.Models
{
    [Table("Utilizadores")]
    public class Utilizador
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public int IdUtilizador { get; set; }

        [Required]
        [MaxLength(100)]
        public string NomeCompleto { get; set; }

        [Required]
        [EmailAddress]
        public string Email { get; set; }

        [Required]
        [Phone]
        public string Telemovel { get; set; }

        public string? Foto { get; set; } // Caminho para a foto

        [Required]
        [MaxLength(20)]
        public string BI { get; set; }

        [Required]
        [MaxLength(50)]
        public string Username { get; set; }

        [Required]
        [MaxLength(100)]
        public string Password { get; set; }
        
        public int Tipo { get; set; } // 0: registado, 1: administrativo, 2:administrador
    }
}
