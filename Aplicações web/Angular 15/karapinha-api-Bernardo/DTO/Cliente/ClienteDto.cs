namespace DTO.Cliente;

public class ClienteDto
{
    public int IdCliente { get; set; }
    
    public string Nome { get; set; } = string.Empty;
    
    public string Email { get; set; } = string.Empty;
    
    public string Telemovel { get; set; } = string.Empty;
    
    public string Bi { get; set; } = string.Empty;
    
    public string? Foto { get; set; } = string.Empty;
    
    public string Username { get; set; } = string.Empty;
    
    public string Password { get; set; } = string.Empty;
    
    public int Estado { get; set; } = 0;
    
    public DateTime CreatedOn { get; set; } = DateTime.Now;
    
    public DateTime UpdatedOn { get; set; } = DateTime.Now;
}