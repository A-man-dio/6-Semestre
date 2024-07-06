using System.ComponentModel.DataAnnotations;

namespace DTO.Cliente;

public class CreateClienteRequestDto
{
    
    [Required, MaxLength(100, ErrorMessage = "O nome excede 100 caracteres")]
    public string Nome { get; set; } = string.Empty;
    [Required, EmailAddress(ErrorMessage = "o email fornecio«do não é um email válido")]
    public string Email { get; set; } = string.Empty;
    [Required, MaxLength(13, ErrorMessage = "o númeoro de telefone excede 13 caracteres")]
    public string Telemovel { get; set; } = string.Empty;
    [Required, MaxLength(14, ErrorMessage = "o número do bilhete excede 14 caracteres")]
    public string Bi { get; set; } = string.Empty;
    public string? Foto { get; set; } = string.Empty;
    [Required, MaxLength(25, ErrorMessage = "o usernamre excede 50 caracteres")]
    public string Username { get; set; } = string.Empty;
    public string Password { get; set; } = string.Empty;
    
}