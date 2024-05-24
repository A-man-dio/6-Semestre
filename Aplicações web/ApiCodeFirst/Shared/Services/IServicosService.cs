using DTO;
using Model;
using System.Collections.Generic;

namespace Shared.Services
{
    public interface IServicosService
    {
        IEnumerable<ServicoDto> GetServicos();
        ServicoDto GetServico(int servicoId);
        bool Save(ServicoDto servico);
    }
}
