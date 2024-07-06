using KSL_API.DTO.Marcacao;
using KSL_API.Models;

namespace KSL_API.Mapper;

public static class MarcacaoMapper
{
    public static Marcacao ToMarcacaoFromCreatedDTO(this CreateMarcacaoDTO marcacaoDTO)
    {
        return new Marcacao
        {
            Data = marcacaoDTO.Data,
            Estado = 0,
            Hora = marcacaoDTO.Hora,
            IdCategoria = marcacaoDTO.IdCategoria,
            IdUtilizador = marcacaoDTO.IdUtilizador
            //ServicosMarcados = 

        };
    }
}