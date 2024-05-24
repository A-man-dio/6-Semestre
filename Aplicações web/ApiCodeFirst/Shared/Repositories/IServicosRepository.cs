using DTO;
using Model;
using System;
using System.Collections.Generic;

namespace Shared.Repositories
{
    public interface IServicosRepository
    {
        IEnumerable<ServicoDto> GetServicos();
        ServicoDto GetServico(int servicoId);
        bool Save(Servico servico);
    }
}
