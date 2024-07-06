using KSL_API.DTO.Servico;
using KSL_API.Models;

namespace KSL_API.Mapper;

public static class ServicoMapper
{
    //De DTO para oq realmente vai na bd, pode atribuir valores a parametros n passados
    public static Servico ToServicoFromCreatedDTO(this CreateServicoDTO servicoDTO)
    {
        return new Servico
        {
            Nome = servicoDTO.Nome,
            IdCategoria = servicoDTO.IdCategoria,
            Descricao = servicoDTO.Descricao,
            Preco = servicoDTO.Preco
            
            
        };
    }
}