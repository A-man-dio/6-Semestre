using DTO;
using Model;
using Shared.Repositories;
using System.Collections.Generic;
using System.Linq;

namespace DAL.Repositories
{
    public class ServicosRepository : IServicosRepository
    {
        private readonly AppDbContext context;

        public ServicosRepository()
        {
            context = new AppDbContext();

        }

        public ServicoDto GetServico(int servicoId)
        {
            return this.context.Servicos.Where(svc => svc.ServicoId == servicoId).Select(svc => new ServicoDto()
            {
                ServicoId = svc.ServicoId,
                Descricao = svc.Descricao,
                Preco = svc.Preco

            }).FirstOrDefault();
        }

        public IEnumerable<ServicoDto> GetServicos()
        {
            return context.Servicos.Select(svc => new ServicoDto()
            {

                ServicoId = svc.ServicoId,
                Descricao = svc.Descricao,
                Preco = svc.Preco

            });
        }

        public bool Save(Servico servico)
        {
            if (servico.ServicoId.Equals(0))
            {
                context.Servicos.Add(servico);
            }
            else
            {
                context.Servicos.Attach(servico);
                context.Entry(servico).Property(svc => svc.Descricao).IsModified = true;
                context.Entry(servico).Property(svc => svc.Preco).IsModified = true;
            }
            bool result = context.SaveChanges() != 0;
            return result;
        }
    }
}
