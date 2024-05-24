using DAL.Repositories;
using DTO;
using Model;
using Shared.Services;
using System.Collections.Generic;

namespace Services
{
    public class ServicoService : IServicosService
    {

        private ServicosRepository servicosRepository;

        public ServicoService()
        {
            servicosRepository = new ServicosRepository();
        }

        public ServicoDto GetServico(int servicoId)
        {
            return this.servicosRepository.GetServico(servicoId);
        }

        public IEnumerable<ServicoDto> GetServicos()
        {
            return this.servicosRepository.GetServicos();
        }

        public bool Save(ServicoDto servicoDto)
        {
            Servico servico = new Servico
            {
                 Descricao = servicoDto.Descricao,
                  Preco = servicoDto.Preco
            };

            return this.servicosRepository.Save(servico);

        }
    }
}
