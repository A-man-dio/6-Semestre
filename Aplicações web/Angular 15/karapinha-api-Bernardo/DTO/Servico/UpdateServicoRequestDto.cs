using System.ComponentModel.DataAnnotations;

namespace DTO.Servico;

public class UpdateServicoRequestDto
{
    [Required, MaxLength(25, ErrorMessage = "a categoria selecionada excede 25 caracteres")]
    public string Categoria { get; set; } = string.Empty;
    [Required, MaxLength(100, ErrorMessage = "a designação do serviço excede 100 caracteres")]
    public string Designacao { get; set; } = string.Empty;
    [Required, MaxLength(250, ErrorMessage = "a descrição do serviço excede 250 caracteres")]
    public string? Descricao { get; set; } = string.Empty;
    [Required(ErrorMessage = "o estado do serviço é obrigatorio")]
    public int Estado { get; set; } = 0;
    [Required(ErrorMessage = "o preço do serviço é obrigatorio")]
    public decimal Preco { get; set; }
}