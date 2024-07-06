using DTO.Profissional;
using Model;

namespace Mappers;

public static class ProfissionalMapper
{
    public static ProfissionalDto ToProfissionalDto(this Profissional profissionalModel)
    {
        return new ProfissionalDto()
        {
            IdProfissional = profissionalModel.IdProfissional,
            Categoria = profissionalModel.Categoria,
            Nome = profissionalModel.Nome,
            Email = profissionalModel.Email,
            Telemovel = profissionalModel.Telemovel,
            Bi = profissionalModel.Bi,
            Foto = profissionalModel.Foto,
            Estado = profissionalModel.Estado,
        };
    }
    
    public static Profissional ToCreateProfissional(this CreateProfissionalRequestDto profissionalModel)
    {
        return new Profissional()
        {
            Categoria = profissionalModel.Categoria,
            Nome = profissionalModel.Nome,
            Email = profissionalModel.Email,
            Telemovel = profissionalModel.Telemovel,
            Bi = profissionalModel.Bi,
            Foto = profissionalModel.Foto,
        };
    }
    
}