using Model;

namespace DTO.Profissional;

public class ProfissionalDto
{
    public int IdProfissional { get; set; }
    
    public string Categoria { get; set; } = string.Empty;
    
    public string Nome { get; set; } = string.Empty;
    
    public string Email { get; set; } = string.Empty;
    
    public string Telemovel { get; set; } = string.Empty;
    
    public string Bi { get; set; } = string.Empty;
    
    public string? Foto { get; set; } = string.Empty;
    
    public int Estado { get; set; } = 0;
    
    public DateTime CreatedOn { get; set; } = DateTime.Now;
    
    public DateTime UpdatedOn { get; set; } = DateTime.Now;
    
    // public List<ProfissionalHorario> Horarios { get; set; } = new List<ProfissionalHorario>();
}