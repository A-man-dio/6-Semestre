using DTO.Servico;
using Model;

namespace Mappers;

public static class ServicoMapper
{
    public static ServicoDto ToServicoDto(this Servico servicoModel)
    {
        return new ServicoDto()
        {
            IdServico = servicoModel.IdServico,
            Designacao = servicoModel.Designacao,
            Descricao = servicoModel.Descricao,
            Estado = servicoModel.Estado,
            Categoria = servicoModel.Categoria,
            Preco = servicoModel.Preco,
            CreatedOn = servicoModel.CreatedOn,
            UpdatedOn = servicoModel.UpdatedOn
        };
    }
    
    public static Servico ToCreateServicoDto(this CreateServicoRequestDto servicoRequestDto)
    {
        return new Servico()
        {
            Designacao = servicoRequestDto.Designacao,
            Descricao = servicoRequestDto.Descricao,
            Estado = 0,
            Categoria = servicoRequestDto.Categoria,
            Preco = servicoRequestDto.Preco,
        };
    }
    
    
}