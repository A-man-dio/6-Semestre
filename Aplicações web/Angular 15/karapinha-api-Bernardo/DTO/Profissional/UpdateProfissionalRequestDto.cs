using System.ComponentModel.DataAnnotations;

namespace DTO.Profissional;

public class UpdateProfissionalRequestDto
{
    [Required, MaxLength(25, ErrorMessage = "a categoria selecionada excede 25 caracteres")]
    public string Categoria { get; set; } = string.Empty;
    
    [Required, MaxLength(100, ErrorMessage = "o nome selecionado excede 25 caracteres")]
    public string Nome { get; set; } = string.Empty;
    
    [Required, EmailAddress(ErrorMessage = "o email fornecio«do não é um email válido")]
    public string Email { get; set; } = string.Empty;
    
    [Required, MaxLength(13, ErrorMessage = "o númeoro de telefone excede 13 caracteres")]
    public string Telemovel { get; set; } = string.Empty;
    
    [Required, MaxLength(25, ErrorMessage = "o número do bilhete excede 14 caracteres")]
    public string Bi { get; set; } = string.Empty;

    [Required] public int Estado { get; set; } = 0;
}