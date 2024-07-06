namespace KSL_API.DTO.Profissional;

public class CreateProfissionalDTO
{
    public string Nome { get; set; }
    public int IdServico { get; set; }
    public string Email { get; set; }
    public string BI { get; set; }
    public string Telemovel { get; set; }
    //falta lista de horarios e path foto
}