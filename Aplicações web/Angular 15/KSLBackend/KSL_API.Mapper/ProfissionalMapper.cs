using KSL_API.DTO.Profissional;
using KSL_API.Models;

namespace KSL_API.Mapper;

public static class ProfissionalMapper
{
    public static Profissional ToProfissionalFromCreatedDTO(this CreateProfissionalDTO profissionalDTO)
    {
        return new Profissional
        {
            Nome = profissionalDTO.Nome,
            IdServico = profissionalDTO.IdServico,
            Email = profissionalDTO.Email,
            BI = profissionalDTO.BI,
            Telemovel = profissionalDTO.Telemovel 
        };
    }
}